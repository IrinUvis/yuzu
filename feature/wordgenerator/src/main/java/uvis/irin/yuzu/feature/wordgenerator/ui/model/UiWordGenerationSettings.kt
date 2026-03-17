package uvis.irin.yuzu.feature.wordgenerator.ui.model

data class UiWordGenerationSettings(
    val language: UiLanguage = UiLanguage.English,
    val partsOfSpeech: Set<UiPartOfSpeech> = setOf(UiPartOfSpeech.Noun, UiPartOfSpeech.Verb),
    val difficulties: Set<UiDifficulty> = setOf(UiDifficulty.CommonlyUsed),
)
