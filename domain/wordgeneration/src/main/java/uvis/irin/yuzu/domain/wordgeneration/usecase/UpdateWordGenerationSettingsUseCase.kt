package uvis.irin.yuzu.domain.wordgeneration.usecase

import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettingsDto

interface UpdateWordGenerationSettingsUseCase {
    suspend operator fun invoke(settings: WordGenerationSettingsDto)
}
