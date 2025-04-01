package uvis.irin.yuzu.feature.wordgenerator.ui.model

import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettingsModel

data class UiWordGenerationSettings(
    val language: UiLanguage = UiLanguage.English,
    val partsOfSpeech: Set<UiPartOfSpeech> = setOf(UiPartOfSpeech.Noun, UiPartOfSpeech.Verb),
    val difficulties: Set<UiDifficulty> = setOf(UiDifficulty.CommonlyUsed),
) {
    fun toDomainModel() = WordGenerationSettingsModel(
        language = language.toDomain(),
        partsOfSpeech = partsOfSpeech.map { it.toDomain() }.toSet(),
        difficulties = difficulties.map { it.toDomain() }.toSet(),
    )
}

fun WordGenerationSettingsModel.toUiModel() = UiWordGenerationSettings(
    language = language.toUiModel(),
    partsOfSpeech = partsOfSpeech.map { it.toUiModel() }.toSet(),
    difficulties = difficulties.map { it.toUiModel() }.toSet(),
)
