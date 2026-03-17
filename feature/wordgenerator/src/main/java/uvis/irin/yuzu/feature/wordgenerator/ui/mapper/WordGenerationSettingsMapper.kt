package uvis.irin.yuzu.feature.wordgenerator.ui.mapper

import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettingsDto
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiWordGenerationSettings

internal fun UiWordGenerationSettings.toDomainModel(): WordGenerationSettingsDto = WordGenerationSettingsDto(
    language = language.toDomain(),
    partsOfSpeech = partsOfSpeech.map { it.toDomain() }.toSet(),
    difficulties = difficulties.map { it.toDomain() }.toSet(),
)

internal fun WordGenerationSettingsDto.toUiModel(): UiWordGenerationSettings = UiWordGenerationSettings(
    language = language.toUiModel(),
    partsOfSpeech = partsOfSpeech.map { it.toUiModel() }.toSet(),
    difficulties = difficulties.map { it.toUiModel() }.toSet(),
)
