package uvis.irin.yuzu.data.wordgeneration.di

import androidx.datastore.core.DataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import uvis.irin.yuzu.core.logger.di.loggerModule
import uvis.irin.yuzu.data.wordgeneration.datastore.createWordGenerationSettingsDatastore
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettingsDataModel
import uvis.irin.yuzu.data.wordgeneration.repository.DataStoreWordGeneratorSettingsRepository
import uvis.irin.yuzu.data.wordgeneration.repository.WordGeneratorSettingsRepository

val wordGeneratorDataModule = module {
    single<DataStore<WordGenerationSettingsDataModel>> {
        createWordGenerationSettingsDatastore(androidContext(), get())
    }

    single<WordGeneratorSettingsRepository> { DataStoreWordGeneratorSettingsRepository(get()) }

    includes(loggerModule)
}
