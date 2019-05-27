package com.dleal.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.dleal.core.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<ViewModel : BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected abstract val clazz: Class<ViewModel>

    protected val viewModel: ViewModel by lazy { provideViewModel() }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

        provideViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(getLayoutId(), container, false)

    private fun provideViewModel(): ViewModel = ViewModelProviders.of(this, viewModelFactory).get(clazz)
}