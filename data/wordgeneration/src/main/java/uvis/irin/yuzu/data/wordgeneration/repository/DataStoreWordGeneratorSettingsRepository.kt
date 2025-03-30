package uvis.irin.yuzu.data.wordgeneration.repository

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettingsDataModel

class DataStoreWordGeneratorSettingsRepository(
    private val dataStore: DataStore<WordGenerationSettingsDataModel>,
) : WordGeneratorSettingsRepository {
    override suspend fun storeGenerationSettings(generationSettingsPreferences: WordGenerationSettingsDataModel) {
        dataStore.updateData { generationSettingsPreferences }
    }

    override fun generationSettingsFlow(): Flow<WordGenerationSettingsDataModel> {
        return dataStore.data
    }
}
