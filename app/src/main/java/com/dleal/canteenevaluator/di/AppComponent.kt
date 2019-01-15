package com.dleal.canteenevaluator.di

import android.app.Application
import com.dleal.canteenevaluator.CanteenApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(application: CanteenApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}