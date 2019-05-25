package com.dleal.canteenevaluator.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.dleal.canteenevaluator.BuildConfig
import com.dleal.canteenevaluator.CanteenApplication
import com.dleal.canteenevaluator.data.base.local.AppDatabase
import com.dleal.canteenevaluator.utils.reporting.FabricConfig
import com.dleal.canteenevaluator.utils.reporting.FabricReporter
import com.dleal.canteenevaluator.utils.reporting.Reporter
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(consumerApp: CanteenApplication): Context = consumerApp.applicationContext

    @Provides
    @Singleton
    @Named(FABRIC_ENABLED)
    fun provideFabricEnabled() = BuildConfig.FABRIC_ENABLED

    @Provides
    @Singleton
    fun provideFabricConfig(@Named(FABRIC_ENABLED) fabricEnabled: Boolean,
                            context: Context) = FabricConfig(context, fabricEnabled)

    @Provides
    @Singleton
    fun provideFabricReporter(fabricConfig: FabricConfig): Reporter = FabricReporter(fabricConfig)

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        val databaseBuilder = Room.databaseBuilder(context, AppDatabase::class.java, "canteenDB")
        if (BuildConfig.DEBUG) {
            databaseBuilder.fallbackToDestructiveMigration()
        }

        return databaseBuilder
            .build()
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences(
        PREFERENCES,
        Context.MODE_PRIVATE
    )
}

private const val PREFERENCES = "appPreferences"
private const val FABRIC_ENABLED = "fabricEnabled"