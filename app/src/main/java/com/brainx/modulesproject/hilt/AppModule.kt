package com.brainx.modulesproject.hilt

import android.content.Context
import com.brainx.modulesproject.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    @Named("string1")
    fun provideString1(
        @ApplicationContext context: Context,
        @Named("string2") string2: String
    ) =
        "${context.getString(R.string.string_to_inject)} - $string2"
}
