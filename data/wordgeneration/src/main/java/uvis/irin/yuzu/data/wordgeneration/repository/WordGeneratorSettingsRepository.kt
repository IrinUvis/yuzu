package uvis.irin.yuzu.data.wordgeneration.repository

import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettings

interface WordGeneratorSettingsRepository {
    suspend fun storeGenerationSettings(generationSettingsPreferences: WordGenerationSettings)

    fun generationSettingsFlow(): Flow<WordGenerationSettings>
}
