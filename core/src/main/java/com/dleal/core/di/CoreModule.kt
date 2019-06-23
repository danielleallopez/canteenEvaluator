package com.dleal.core.di

import com.dleal.core.utils.RxTransformer
import org.koin.dsl.module

/**
 * Created by Daniel Leal on 2019-06-17.
 */
val coreModule = module {
    //RxTransformer
    single { RxTransformer(get()) }
}