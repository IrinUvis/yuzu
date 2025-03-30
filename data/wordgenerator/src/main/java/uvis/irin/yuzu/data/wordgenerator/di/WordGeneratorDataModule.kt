package uvis.irin.yuzu.data.wordgenerator.di

import androidx.datastore.core.DataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import uvis.irin.yuzu.data.wordgenerator.datastore.createWordGenerationSettingsDatastore
import uvis.irin.yuzu.data.wordgenerator.model.WordGenerationSettings
import uvis.irin.yuzu.data.wordgenerator.repository.DataStoreWordGeneratorSettingsRepository
import uvis.irin.yuzu.data.wordgenerator.repository.WordGeneratorSettingsRepository

val wordGeneratorDataModule = module {
    single<DataStore<WordGenerationSettings>> {
        createWordGenerationSettingsDatastore(androidContext())
    }

    single<WordGeneratorSettingsRepository> { DataStoreWordGeneratorSettingsRepository(get()) }
}
