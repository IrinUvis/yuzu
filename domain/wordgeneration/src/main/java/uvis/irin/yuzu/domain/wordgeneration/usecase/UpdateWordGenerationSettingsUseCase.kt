package uvis.irin.yuzu.domain.wordgeneration.usecase

import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettings

interface UpdateWordGenerationSettingsUseCase {
    suspend operator fun invoke(settings: WordGenerationSettings)
}
