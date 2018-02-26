package com.dleal.canteen.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by Daniel Leal on 26/2/18.
 */
abstract class BaseActivity<out T : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected val viewModel: T by lazy { provideViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())
    }

    protected abstract fun provideViewModel(): T
}