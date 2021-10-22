package com.brainx.modulesproject.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object MainModule {

    @Singleton
    @Provides
    @Named("string2")
    fun provideString2() = "Providing strings from app module as well"
}
