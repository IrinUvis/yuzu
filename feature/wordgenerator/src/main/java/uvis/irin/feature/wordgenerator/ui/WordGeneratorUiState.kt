package uvis.irin.feature.wordgenerator.ui

import uvis.irin.core.common.toggleElement
import uvis.irin.feature.wordgenerator.ui.model.UiDifficulty
import uvis.irin.feature.wordgenerator.ui.model.UiLanguage
import uvis.irin.feature.wordgenerator.ui.model.UiPartOfSpeech
import uvis.irin.feature.wordgenerator.ui.model.UiWordGenerationSettings

data class WordGeneratorUiState(
    val wordGeneration: Generation = Generation(),
    val wordExplanationGeneration: Generation = Generation(),
    val wordGenerationAvailable: Boolean = false,
    val generationSettings: GenerationSettings = GenerationSettings(),
    val helpVisible: Boolean = false,
)

data class Generation(
    val generation: String? = null,
    val isGenerating: Boolean = false,
)

data class GenerationSettings(
    val isSettingsExpanded: Boolean = false,
    val selectedLanguage: UiLanguage = UiLanguage.English,
    val selectedPartsOfSpeech: Set<UiPartOfSpeech> = setOf(UiPartOfSpeech.Noun),
    val selectedDifficulties: Set<UiDifficulty> = setOf(UiDifficulty.CommonlyUsed),
) {
    fun withToggledSetting(
        language: UiLanguage? = null,
        partOfSpeech: UiPartOfSpeech? = null,
        difficulty: UiDifficulty? = null,
    ) = copy(
        selectedLanguage = language ?: selectedLanguage,
        selectedPartsOfSpeech = partOfSpeech?.let {
            selectedPartsOfSpeech.toMutableSet().apply { toggleElement(it) }
        } ?: selectedPartsOfSpeech,
        selectedDifficulties = difficulty?.let {
            selectedDifficulties.toMutableSet().apply { toggleElement(it) }
        } ?: selectedDifficulties,
    )

    fun toUiModel() = UiWordGenerationSettings(
        language = selectedLanguage,
        partsOfSpeech = selectedPartsOfSpeech,
        difficulties = selectedDifficulties,
    )
}
