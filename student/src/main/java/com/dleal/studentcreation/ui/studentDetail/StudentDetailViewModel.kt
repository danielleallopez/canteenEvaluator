package com.dleal.studentcreation.ui.studentDetail

import com.dleal.core.utils.RxTransformer
import com.dleal.studentcreation.usecase.StudentUseCase
import com.dleal.ui.base.BaseViewModel

/**
 * Created by Daniel Leal on 2019-06-24.
 */
class StudentDetailViewModel(
    private val studentUseCase: StudentUseCase,
    override val rxTransformer: RxTransformer
) : BaseViewModel() {

}