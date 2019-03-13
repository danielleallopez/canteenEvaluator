package com.dleal.canteenevaluator.ui.studentlist

import androidx.lifecycle.MutableLiveData
import com.dleal.canteenevaluator.domain.Student
import com.dleal.canteenevaluator.domain.StudentGroup
import com.dleal.canteenevaluator.ui.base.BaseViewModel
import com.dleal.canteenevaluator.ui.base.SingleLiveEvent
import com.dleal.canteenevaluator.usecases.StudentUseCase
import com.dleal.canteenevaluator.utils.RxTransformer
import io.reactivex.Single
import javax.inject.Inject

class StudentListViewModel @Inject constructor(
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
