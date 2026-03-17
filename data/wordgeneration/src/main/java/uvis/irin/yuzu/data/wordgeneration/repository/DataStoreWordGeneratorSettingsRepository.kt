package uvis.irin.yuzu.data.wordgeneration.repository

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettings

internal class DataStoreWordGeneratorSettingsRepository(
    private val dataStore: DataStore<WordGenerationSettings>,
) : WordGeneratorSettingsRepository {
    override suspend fun storeGenerationSettings(generationSettingsPreferences: WordGenerationSettings) {
        dataStore.updateData { generationSettingsPreferences }
    }

    override fun generationSettingsFlow(): Flow<WordGenerationSettings> {
        return dataStore.data
    }
}
