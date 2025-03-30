package uvis.irin.yuzu.domain.wordgeneration.usecase

import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettings

interface GetWordGenerationSettingsUseCase {
    suspend operator fun invoke(): Flow<WordGenerationSettings>
}
