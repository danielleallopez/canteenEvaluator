package com.dleal.canteenevaluator.di

import com.dleal.canteenevaluator.CanteenApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        BuildersModule::class,
        ViewModelModule::class]
)
interface AppComponent {

    fun inject(application: CanteenApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: CanteenApplication): Builder

        fun build(): AppComponent
    }
}