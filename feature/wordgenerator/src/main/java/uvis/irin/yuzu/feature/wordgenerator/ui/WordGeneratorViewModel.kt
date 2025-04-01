package uvis.irin.yuzu.feature.wordgenerator.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uvis.irin.yuzu.domain.wordgeneration.usecase.GetWordGenerationSettingsUseCase
import uvis.irin.yuzu.domain.wordgeneration.usecase.UpdateWordGenerationSettingsUseCase
import uvis.irin.yuzu.feature.wordgenerator.domain.ExplainWordUseCase
import uvis.irin.yuzu.feature.wordgenerator.domain.GenerateWordUseCase
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiDifficulty
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiLanguage
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiPartOfSpeech
import uvis.irin.yuzu.feature.wordgenerator.ui.model.toUiModel

class WordGeneratorViewModel(
    private val generateWordUseCase: GenerateWordUseCase,
    private val explainWordUseCase: ExplainWordUseCase,
    private val updateWordGenerationSettingsUseCase: UpdateWordGenerationSettingsUseCase,
    getWordGenerationSettingsUseCase: GetWordGenerationSettingsUseCase,
) : ViewModel() {
    private val _wordGeneration = MutableStateFlow(Generation())
    private val _explanationGeneration = MutableStateFlow(Generation())
    private val _isSettingsExpanded = MutableStateFlow(false)
    private val _helpVisible = MutableStateFlow(false)

    val uiState: StateFlow<WordGeneratorUiState> = combine(
        _wordGeneration,
        _explanationGeneration,
        _isSettingsExpanded,
        getWordGenerationSettingsUseCase().map { it.toUiModel() },
        _helpVisible,
    ) { wordGeneration, explanationGeneration, isSettingsExpanded, generationSettings, helpVisible ->
        val areSettingsValid = generationSettings.partsOfSpeech.isNotEmpty() &&
            generationSettings.difficulties.isNotEmpty()
        val isWordOrExplanationGenerating = wordGeneration.isGenerating || explanationGeneration.isGenerating

        WordGeneratorUiState(
            wordGeneration = wordGeneration,
            wordExplanationGeneration = explanationGeneration,
            wordGenerationAvailable = areSettingsValid && !isWordOrExplanationGenerating,
            generationSettings = GenerationSettings(
                isSettingsExpanded = isSettingsExpanded,
                selectedLanguage = generationSettings.language,
                selectedPartsOfSpeech = generationSettings.partsOfSpeech,
                selectedDifficulties = generationSettings.difficulties,
            ),
            helpVisible = helpVisible,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
        initialValue = WordGeneratorUiState(),
    )

    fun openHelpSheet() {
        _helpVisible.update { true }
    }

    fun hideHelpSheet() {
        _helpVisible.update { false }
    }

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
        _isSettingsExpanded.update { isSettingsExpanded -> !isSettingsExpanded }
    }

    fun toggleLanguageSetting(language: UiLanguage) {
        viewModelScope.launch {
            updateWordGenerationSettingsUseCase(
                uiState.value.generationSettings
                    .withToggledSetting(language = language)
                    .toUiModel()
                    .toDomainModel(),
            )
        }
    }

    fun togglePartOfSpeechSetting(partOfSpeech: UiPartOfSpeech) {
        viewModelScope.launch {
            updateWordGenerationSettingsUseCase(
                uiState.value.generationSettings
                    .withToggledSetting(partOfSpeech = partOfSpeech)
                    .toUiModel()
                    .toDomainModel(),
            )
        }
    }

    fun toggleGenerationDifficultySetting(difficulty: UiDifficulty) {
        viewModelScope.launch {
            updateWordGenerationSettingsUseCase(
                uiState.value.generationSettings
                    .withToggledSetting(difficulty = difficulty)
                    .toUiModel()
                    .toDomainModel(),
            )
        }
    }
}
