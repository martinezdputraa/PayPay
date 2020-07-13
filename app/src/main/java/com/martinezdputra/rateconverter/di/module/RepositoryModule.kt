package com.martinezdputra.rateconverter.di.module

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.martinezdputra.rateconverter.db.AppDatabase
import com.martinezdputra.rateconverter.db.AppDatabase.Companion.DB_NAME
import com.martinezdputra.rateconverter.repository.ApiService
import com.martinezdputra.rateconverter.repository.AppSharedPreference
import com.martinezdputra.rateconverter.repository.AppSharedPreference.Companion.SHARED_PREFERENCE_FILE_NAME
import com.martinezdputra.rateconverter.repository.datastore.HomepageLocalDataStore
import com.martinezdputra.rateconverter.repository.datastore.HomepageRemoteDataStore
import com.martinezdputra.rateconverter.repository.repository.HomepageRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RepositoryModule {
    @Provides
    fun provideAppDatabase(applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, DB_NAME
        ).build()
    }

    @Provides
    fun provideSharedPreference(context: Context, @Named("SHARED_PREFERENCE_FILE_NAME") fileName: String): SharedPreferences {
        return context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    }

    @Provides
    fun provideAppSharedPreference(sharedPreferences: SharedPreferences) = AppSharedPreference(sharedPreferences)

    @Provides
    @Named("SHARED_PREFERENCE_FILE_NAME")
    fun provideSharedPreferenceFileName() = SHARED_PREFERENCE_FILE_NAME

    @Provides
    fun provideHomepageLocalDataStore(appDatabase: AppDatabase) = HomepageLocalDataStore(appDatabase)

    @Provides
    fun provideHomepageRemoteDataStore(apiService: ApiService) = HomepageRemoteDataStore(apiService)

    @Provides
    fun provideHomepageRepository(localDataStore: HomepageLocalDataStore, remoteDataStore: HomepageRemoteDataStore, appDatabase: AppDatabase, appSharedPreference: AppSharedPreference): HomepageRepository {
        return HomepageRepository(localDataStore, remoteDataStore, appDatabase, appSharedPreference)
    }
}