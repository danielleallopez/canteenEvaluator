package com.dleal.canteen.di

import android.app.Application
import com.dleal.canteen.CanteenApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Daniel Leal on 25/2/18.
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class])
interface AppComponent {

    fun inject(application: CanteenApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}