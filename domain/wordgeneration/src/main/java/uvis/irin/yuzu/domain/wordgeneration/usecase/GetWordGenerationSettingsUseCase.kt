package uvis.irin.yuzu.domain.wordgeneration.usecase

import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettingsModel

interface GetWordGenerationSettingsUseCase {
    operator fun invoke(): Flow<WordGenerationSettingsModel>
}
