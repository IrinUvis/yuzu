package uvis.irin.yuzu.data.wordgeneration.repository

import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettingsDataModel

interface WordGeneratorSettingsRepository {
    suspend fun storeGenerationSettings(generationSettingsPreferences: WordGenerationSettingsDataModel)

    fun generationSettingsFlow(): Flow<WordGenerationSettingsDataModel>
}
