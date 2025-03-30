package uvis.irin.yuzu.data.wordgeneration.di

import androidx.datastore.core.DataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import uvis.irin.yuzu.data.wordgeneration.datastore.createWordGenerationSettingsDatastore
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettingsModel
import uvis.irin.yuzu.data.wordgeneration.repository.DataStoreWordGeneratorSettingsRepository
import uvis.irin.yuzu.data.wordgeneration.repository.WordGeneratorSettingsRepository

val wordGeneratorDataModule = module {
    single<DataStore<WordGenerationSettingsModel>> {
        createWordGenerationSettingsDatastore(androidContext())
    }

    single<WordGeneratorSettingsRepository> { DataStoreWordGeneratorSettingsRepository(get()) }
}
