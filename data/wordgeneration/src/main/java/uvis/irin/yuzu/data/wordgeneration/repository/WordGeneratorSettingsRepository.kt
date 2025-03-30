package uvis.irin.yuzu.data.wordgeneration.repository

import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettingsModel

interface WordGeneratorSettingsRepository {
    suspend fun storeGenerationSettings(generationSettingsPreferences: WordGenerationSettingsModel)

    suspend fun generationSettingsFlow(): Flow<WordGenerationSettingsModel>
}
