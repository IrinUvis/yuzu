package uvis.irin.yuzu.data.wordgenerator.repository

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.data.wordgenerator.model.WordGenerationSettings

class DataStoreWordGeneratorSettingsRepository(
    private val dataStore: DataStore<WordGenerationSettings>,
) : WordGeneratorSettingsRepository {
    override suspend fun storeGenerationSettings(generationSettingsPreferences: WordGenerationSettings) {
        dataStore.updateData { generationSettingsPreferences }
    }

    override suspend fun generationSettingsFlow(): Flow<WordGenerationSettings?> {
        return dataStore.data
    }
}
