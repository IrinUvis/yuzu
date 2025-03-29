package uvis.irin.feature.wordgenerator.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uvis.irin.core.common.toggleElement
import uvis.irin.feature.wordgenerator.domain.ExplainWordUseCase
import uvis.irin.feature.wordgenerator.domain.GenerateWordUseCase
import uvis.irin.feature.wordgenerator.ui.model.GenerationDifficulty
import uvis.irin.feature.wordgenerator.ui.model.Language
import uvis.irin.feature.wordgenerator.ui.model.PartOfSpeech

class WordGeneratorViewModel(
    private val generateWordUseCase: GenerateWordUseCase,
    private val explainWordUseCase: ExplainWordUseCase,
) : ViewModel() {
    private val _wordGeneration = MutableStateFlow(Generation())
    private val _explanationGeneration = MutableStateFlow(Generation())
    private val _generationSettings = MutableStateFlow(GenerationSettings())

    val uiState: StateFlow<WordGeneratorUiState> = combine(
        _wordGeneration,
        _explanationGeneration,
        _generationSettings,
    ) { wordGeneration, explanationGeneration, generationSettings ->
        val areSettingsValid = generationSettings.selectedPartsOfSpeech.isNotEmpty() &&
            generationSettings.selectedDifficulties.isNotEmpty()
        val isWordOrExplanationGenerating = wordGeneration.isGenerating || explanationGeneration.isGenerating

        WordGeneratorUiState(
            wordGeneration = wordGeneration,
            wordExplanationGeneration = explanationGeneration,
            wordGenerationAvailable = areSettingsValid && !isWordOrExplanationGenerating,
            generationSettings = generationSettings,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
        initialValue = WordGeneratorUiState(),
    )

    fun generateWord() {
        viewModelScope.launch {
            _wordGeneration.update { it.copy(isGenerating = true) }
            generateWordUseCase().fold(
                onSuccess = { word ->
                    _wordGeneration.update {
                        it.copy(generation = word, isGenerating = false)
                    }
                    _explanationGeneration.update { it.copy(generation = null) }
                },
                onFailure = {},
            )
        }
    }

    fun explainGeneratedWord() {
        viewModelScope.launch {
            _explanationGeneration.update { it.copy(isGenerating = true) }
            _wordGeneration.value.generation?.let { generatedWord ->
                explainWordUseCase(generatedWord).fold(
                    onSuccess = { explanation ->
                        _explanationGeneration.update { it.copy(generation = explanation, isGenerating = false) }
                    },
                    onFailure = {},
                )
            }
        }
    }

    fun toggleSettingsExpanded() {
        _generationSettings.update { it.copy(isSettingsExpanded = !it.isSettingsExpanded) }
    }

    fun toggleLanguageSetting(language: Language) {
        _generationSettings.update { it.copy(selectedLanguage = language) }
    }

    fun togglePartOfSpeechSetting(partOfSpeech: PartOfSpeech) {
        _generationSettings.update {
            it.copy(
                selectedPartsOfSpeech = it.selectedPartsOfSpeech.toMutableSet().apply {
                    toggleElement(partOfSpeech)
                },
            )
        }
    }

    fun toggleGenerationDifficultySetting(generationDifficulty: GenerationDifficulty) {
        _generationSettings.update {
            it.copy(
                selectedDifficulties = it.selectedDifficulties.toMutableSet().apply {
                    toggleElement(generationDifficulty)
                },
            )
        }
    }
}

data class WordGeneratorUiState(
    val wordGeneration: Generation = Generation(),
    val wordExplanationGeneration: Generation = Generation(),
    val wordGenerationAvailable: Boolean = false,
    val generationSettings: GenerationSettings = GenerationSettings(),
)

data class Generation(
    val generation: String? = null,
    val isGenerating: Boolean = false,
)

data class GenerationSettings(
    val isSettingsExpanded: Boolean = false,
    val selectedLanguage: Language = Language.English,
    val selectedPartsOfSpeech: Set<PartOfSpeech> = setOf(PartOfSpeech.Noun),
    val selectedDifficulties: Set<GenerationDifficulty> = setOf(GenerationDifficulty.CommonlyUsed),
)
