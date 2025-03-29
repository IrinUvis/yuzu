package uvis.irin.feature.wordgenerator.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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
    private val _wordGenerationState = MutableStateFlow(WordGenerationState())
    val wordGenerationState = _wordGenerationState.asStateFlow()

    private val _generationSettingsState = MutableStateFlow(GenerationSettingsState())
    val generationSettingsState = _generationSettingsState.asStateFlow()

    val wordGenerationAvailable: StateFlow<Boolean> = combine(
        _wordGenerationState,
        _generationSettingsState,
    ) { wordGenerationState, generationSettingsState ->
        val areSettingsValid = generationSettingsState.selectedPartsOfSpeech.isNotEmpty() &&
            generationSettingsState.selectedDifficulties.isNotEmpty()
        val isWordOrExplanationGenerating = wordGenerationState.isWordGenerating ||
            wordGenerationState.isExplanationGenerating

        areSettingsValid && !isWordOrExplanationGenerating
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
        initialValue = false,
    )

    fun generateWord() {
        viewModelScope.launch {
            _wordGenerationState.update { it.copy(isWordGenerating = true) }
            generateWordUseCase().fold(
                onSuccess = { word ->
                    _wordGenerationState.update {
                        it.copy(
                            generatedWord = word,
                            generatedWordExplanation = null,
                        )
                    }
                },
                onFailure = {},
            )
            _wordGenerationState.update { it.copy(isWordGenerating = false) }
        }
    }

    fun explainGeneratedWord() {
        viewModelScope.launch {
            _wordGenerationState.update { it.copy(isExplanationGenerating = true) }
            wordGenerationState.value.generatedWord?.let { generatedWord ->
                explainWordUseCase(generatedWord).fold(
                    onSuccess = { explanation ->
                        _wordGenerationState.update { it.copy(generatedWordExplanation = explanation) }
                    },
                    onFailure = {},
                )
            }
            _wordGenerationState.update { it.copy(isExplanationGenerating = false) }
        }
    }

    fun toggleSettingsExpanded() {
        _generationSettingsState.update { it.copy(isSettingsExpanded = !it.isSettingsExpanded) }
    }

    fun toggleLanguageSetting(language: Language) {
        _generationSettingsState.update { it.copy(selectedLanguage = language) }
    }

    fun togglePartOfSpeechSetting(partOfSpeech: PartOfSpeech) {
        _generationSettingsState.update {
            it.copy(
                selectedPartsOfSpeech = it.selectedPartsOfSpeech.toMutableSet().apply {
                    toggleElement(partOfSpeech)
                },
            )
        }
    }

    fun toggleGenerationDifficultySetting(generationDifficulty: GenerationDifficulty) {
        _generationSettingsState.update {
            it.copy(
                selectedDifficulties = it.selectedDifficulties.toMutableSet().apply {
                    toggleElement(generationDifficulty)
                },
            )
        }
    }
}

data class WordGenerationState(
    val generatedWord: String? = null,
    val isWordGenerating: Boolean = false,
    val generatedWordExplanation: String? = null,
    val isExplanationGenerating: Boolean = false,
)

data class GenerationSettingsState(
    val isSettingsExpanded: Boolean = false,
    val selectedLanguage: Language = Language.English,
    val selectedPartsOfSpeech: Set<PartOfSpeech> = setOf(PartOfSpeech.Noun),
    val selectedDifficulties: Set<GenerationDifficulty> = setOf(GenerationDifficulty.CommonlyUsed),
)
