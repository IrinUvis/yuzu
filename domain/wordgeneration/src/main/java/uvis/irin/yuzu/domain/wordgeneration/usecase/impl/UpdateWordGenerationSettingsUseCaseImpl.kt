package uvis.irin.yuzu.domain.wordgeneration.usecase.impl

import uvis.irin.yuzu.data.wordgeneration.repository.WordGeneratorSettingsRepository
import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettingsModel
import uvis.irin.yuzu.domain.wordgeneration.usecase.UpdateWordGenerationSettingsUseCase

internal class UpdateWordGenerationSettingsUseCaseImpl(
    private val wordGeneratorSettingsRepository: WordGeneratorSettingsRepository,
) : UpdateWordGenerationSettingsUseCase {
    override suspend operator fun invoke(settings: WordGenerationSettingsModel) {
        wordGeneratorSettingsRepository.storeGenerationSettings(
            generationSettingsPreferences = settings.toModel(),
        )
    }
}
