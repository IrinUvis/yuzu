package uvis.irin.yuzu.domain.wordgeneration.usecase.impl

import uvis.irin.yuzu.data.wordgeneration.repository.WordGeneratorSettingsRepository
import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettingsDto
import uvis.irin.yuzu.domain.wordgeneration.usecase.UpdateWordGenerationSettingsUseCase

internal class UpdateWordGenerationSettingsUseCaseImpl(
    private val wordGeneratorSettingsRepository: WordGeneratorSettingsRepository,
) : UpdateWordGenerationSettingsUseCase {
    override suspend operator fun invoke(settings: WordGenerationSettingsDto) {
        wordGeneratorSettingsRepository.storeGenerationSettings(
            generationSettingsPreferences = settings.toModel(),
        )
    }
}
