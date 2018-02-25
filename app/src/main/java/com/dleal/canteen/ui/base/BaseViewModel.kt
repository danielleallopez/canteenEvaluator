package com.dleal.canteen.ui.base

import android.arch.lifecycle.ViewModel
import com.dleal.canteen.utils.CLogger
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Daniel Leal on 25/2/18.
 */
abstract class BaseViewModel : ViewModel(), CLogger {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.dispose()
    }

    fun addDisposable(disposable: Disposable) {
        if (compositeDisposable.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable.add(disposable)
    }
}