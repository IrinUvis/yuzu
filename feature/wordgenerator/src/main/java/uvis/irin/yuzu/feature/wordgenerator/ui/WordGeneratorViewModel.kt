package uvis.irin.yuzu.feature.wordgenerator.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uvis.irin.yuzu.domain.genai.usecase.GetAiModelStatusUseCase
import uvis.irin.yuzu.domain.wordgeneration.model.GenerateWordsResult
import uvis.irin.yuzu.domain.wordgeneration.usecase.ExplainWordUseCase
import uvis.irin.yuzu.domain.wordgeneration.usecase.GenerateWordsUseCase
import uvis.irin.yuzu.domain.wordgeneration.usecase.GetWordGenerationSettingsUseCase
import uvis.irin.yuzu.domain.wordgeneration.usecase.UpdateWordGenerationSettingsUseCase
import uvis.irin.yuzu.feature.wordgenerator.ui.mapper.toDomainModel
import uvis.irin.yuzu.feature.wordgenerator.ui.mapper.toUiModel
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiDifficulty
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiLanguage
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiPartOfSpeech

@Suppress("TooManyFunctions")
class WordGeneratorViewModel(
    private val getAiModelStatusUseCase: GetAiModelStatusUseCase,
    private val generateWordsUseCase: GenerateWordsUseCase,
    private val explainWordUseCase: ExplainWordUseCase,
    private val updateWordGenerationSettingsUseCase: UpdateWordGenerationSettingsUseCase,
    private val getWordGenerationSettingsUseCase: GetWordGenerationSettingsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(WordGeneratorUiState())
    val uiState = _uiState.asStateFlow()

    init {
        initCollectors()
        loadAiModelStatus()
    }

    private fun initCollectors() {
        viewModelScope.launch {
            collectWordGenerationSettings()
        }
    }

    private suspend fun collectWordGenerationSettings() {
        getWordGenerationSettingsUseCase().collect { wordGenerationSettings ->
            val settings = wordGenerationSettings.toUiModel()

            _uiState.update {
                it.copy(
                    generationSettings = it.generationSettings.copy(
                        selectedLanguage = settings.language,
                        selectedPartsOfSpeech = settings.partsOfSpeech,
                        selectedDifficulties = settings.difficulties,
                    ),
                )
            }
        }
    }

    private fun loadAiModelStatus() {
        viewModelScope.launch {
            val modelStatus = getAiModelStatusUseCase.invoke().toUiModel()

            _uiState.update {
                it.copy(
                    aiModel = it.aiModel.copy(modelStatus = modelStatus),
                )
            }
        }
    }

    fun openHelpSheet() {
        _uiState.update {
            it.copy(
                helpVisible = true,
            )
        }
    }

    fun hideHelpSheet() {
        _uiState.update {
            it.copy(
                helpVisible = false,
            )
        }
    }

    fun generateWord() {
        viewModelScope.launch {
            _uiState.update { it.copy(wordGeneration = it.wordGeneration.copy(isGenerating = true)) }

            when (val result = generateWordsUseCase.invoke()) {
                is GenerateWordsResult.Success -> {
                    _uiState.update {
                        it.copy(
                            wordGeneration = it.wordGeneration.copy(
                                generation = result.generatedWords.first(),
                                isGenerating = false,
                            ),
                            wordExplanationGeneration = it.wordExplanationGeneration.copy(
                                generation = null,
                            ),
                        )
                    }
                }

                GenerateWordsResult.Failure -> {
                    _uiState.update {
                        it.copy(
                            wordGeneration = it.wordGeneration.copy(
                                generation = null,
                                isGenerating = false,
                            ),
                        )
                    }
                }
            }
        }
    }

    fun explainGeneratedWord() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    wordExplanationGeneration = it.wordExplanationGeneration.copy(
                        isGenerating = true,
                    ),
                )
            }

            val generatedWord = _uiState.value.wordGeneration.generation

            if (generatedWord != null) {
                explainWordUseCase(generatedWord).fold(
                    onSuccess = { explanation ->
                        _uiState.update {
                            it.copy(
                                wordExplanationGeneration = it.wordExplanationGeneration.copy(
                                    generation = explanation,
                                    isGenerating = false,
                                ),
                            )
                        }
                    },
                    onFailure = {},
                )
            }
        }
    }

    fun toggleSettingsExpanded() {
        _uiState.update {
            it.copy(
                generationSettings = it.generationSettings.copy(
                    isSettingsExpanded = !it.generationSettings.isSettingsExpanded,
                ),
            )
        }
    }

    fun toggleLanguageSetting(language: UiLanguage) {
        viewModelScope.launch {
            updateWordGenerationSettingsUseCase(
                _uiState.value.generationSettings
                    .withToggledSetting(language = language)
                    .toUiModel()
                    .toDomainModel(),
            )
        }
    }

    fun togglePartOfSpeechSetting(partOfSpeech: UiPartOfSpeech) {
        viewModelScope.launch {
            updateWordGenerationSettingsUseCase(
                _uiState.value.generationSettings
                    .withToggledSetting(partOfSpeech = partOfSpeech)
                    .toUiModel()
                    .toDomainModel(),
            )
        }
    }

    fun toggleGenerationDifficultySetting(difficulty: UiDifficulty) {
        viewModelScope.launch {
            updateWordGenerationSettingsUseCase(
                _uiState.value.generationSettings
                    .withToggledSetting(difficulty = difficulty)
                    .toUiModel()
                    .toDomainModel(),
            )
        }
    }
}
