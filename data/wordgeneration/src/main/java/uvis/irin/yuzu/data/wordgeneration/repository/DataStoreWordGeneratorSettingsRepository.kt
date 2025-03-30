package uvis.irin.yuzu.data.wordgeneration.repository

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettingsModel

class DataStoreWordGeneratorSettingsRepository(
    private val dataStore: DataStore<WordGenerationSettingsModel>,
) : WordGeneratorSettingsRepository {
    override suspend fun storeGenerationSettings(generationSettingsPreferences: WordGenerationSettingsModel) {
        dataStore.updateData { generationSettingsPreferences }
    }

    override suspend fun generationSettingsFlow(): Flow<WordGenerationSettingsModel> {
        return dataStore.data
    }
}
