package com.dleal.studentcreation.ui.studentlist

import androidx.lifecycle.MutableLiveData
import com.dleal.core.utils.RxTransformer
import com.dleal.studentcreation.domain.Student
import com.dleal.studentcreation.domain.StudentGroup
import com.dleal.studentcreation.usecase.StudentUseCase
import com.dleal.ui.base.BaseViewModel
import com.dleal.ui.base.SingleLiveEvent
import io.reactivex.Single

class StudentListViewModel(
    private val studentUseCase: StudentUseCase,
    override val rxTransformer: RxTransformer
) : BaseViewModel() {

    val studentGroupUiModel: MutableLiveData<StudentListUiModel> = MutableLiveData()
    val createStudentNavigationEvent: SingleLiveEvent<StudentListUiModel> = SingleLiveEvent()

    private lateinit var studentList: StudentGroup

    fun start() {
        addDisposable(
            studentUseCase.getStudentList()
                .flatMap { studentList: List<Student> ->
                    this.studentList = studentList
                    Single.just(StudentListUiModel(false, studentList))
                }
                .toFlowable()
                .compose(rxTransformer.applyIoSchedulerToFlow())
                .startWith(StudentListUiModel(showProgress = true))
                .subscribe(
                    { studentListUiModel: StudentListUiModel -> studentGroupUiModel.value = studentListUiModel },
                    { TODO("Must implement error case") }
                )
        )
    }

    fun onAddUserClick() {
        createStudentNavigationEvent.call()
    }
}
