package uvis.irin.yuzu.data.wordgenerator.repository

import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.data.wordgenerator.model.WordGenerationSettings

interface WordGeneratorSettingsRepository {
    suspend fun storeGenerationSettings(generationSettingsPreferences: WordGenerationSettings)

    suspend fun generationSettingsFlow(): Flow<WordGenerationSettings?>
}
