package uvis.irin.feature.wordgenerator.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uvis.irin.feature.wordgenerator.domain.ExplainWordUseCase
import uvis.irin.feature.wordgenerator.domain.GenerateWordUseCase

class WordGeneratorViewModel(
    private val generateWordUseCase: GenerateWordUseCase,
    private val explainWordUseCase: ExplainWordUseCase,
) : ViewModel() {
    private val _wordGenerationState = MutableStateFlow(WordGenerationState())
    val wordGenerationState = _wordGenerationState.asStateFlow()

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
}

data class WordGenerationState(
    val generatedWord: String? = null,
    val isWordGenerating: Boolean = false,
    val generatedWordExplanation: String? = null,
    val isExplanationGenerating: Boolean = false,
)
