package uvis.irin.yuzu.domain.wordgeneration.usecase

import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettingsDto

interface GetWordGenerationSettingsUseCase {
    operator fun invoke(): Flow<WordGenerationSettingsDto>
}
