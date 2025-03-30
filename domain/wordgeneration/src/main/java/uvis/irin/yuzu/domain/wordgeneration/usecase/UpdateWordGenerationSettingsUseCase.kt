package uvis.irin.yuzu.domain.wordgeneration.usecase

import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettingsModel

interface UpdateWordGenerationSettingsUseCase {
    suspend operator fun invoke(settings: WordGenerationSettingsModel)
}
