package uvis.irin.yuzu.domain.wordgeneration.usecase

import uvis.irin.yuzu.data.wordgeneration.repository.WordGeneratorSettingsRepository
import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettings

internal class UpdateWordGenerationSettingsUseCaseImpl(
    private val wordGeneratorSettingsRepository: WordGeneratorSettingsRepository,
) {
    suspend operator fun invoke(settings: WordGenerationSettings) {
        wordGeneratorSettingsRepository.storeGenerationSettings(
            generationSettingsPreferences = settings.toModel(),
        )
    }
}
