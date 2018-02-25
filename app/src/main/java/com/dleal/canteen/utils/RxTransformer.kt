package com.dleal.canteen.utils

import com.dleal.canteen.BuildConfig
import com.dleal.canteen.utils.reporting.FabricReporter
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Daniel Leal on 25/2/18.
 */
class RxTransformer @Inject constructor(private val fabricReporter: FabricReporter){

    private val IO_SCHEDULER: Scheduler by lazy { Schedulers.io() }
    private val COMPUTATION_SCHEDULER: Scheduler by lazy { Schedulers.computation() }
    private val MAIN_THREAD_SCHEDULER: Scheduler by lazy { AndroidSchedulers.mainThread() }

    fun <T> applyIoScheduler(): SingleTransformer<T, T> = apply(IO_SCHEDULER)

    fun <T> applyComputationScheduler(): SingleTransformer<T, T> = apply(COMPUTATION_SCHEDULER)

    private fun <T> apply(scheduler: Scheduler): SingleTransformer<T, T> = SingleTransformer { single : Single<T> ->
        single
                .subscribeOn(scheduler)
                .observeOn(MAIN_THREAD_SCHEDULER)
                .doOnError { logError(it) }
    }

    //Generic error treatment
    private fun logError(throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            throwable.printStackTrace()
        }

        fabricReporter.logException(throwable)
    }
}