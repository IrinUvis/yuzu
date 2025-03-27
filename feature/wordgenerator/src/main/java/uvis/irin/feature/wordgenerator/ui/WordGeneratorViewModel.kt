package uvis.irin.feature.wordgenerator.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uvis.irin.feature.wordgenerator.domain.GenerateWordUseCase

class WordGeneratorViewModel(
    private val generateWordUseCase: GenerateWordUseCase,
) : ViewModel() {
    private val _wordGenerationState = MutableStateFlow(WordGenerationState())
    val wordGenerationState = _wordGenerationState.asStateFlow()

    fun generateWord() {
        viewModelScope.launch {
            _wordGenerationState.update { it.copy(isWordGenerating = true) }
            generateWordUseCase().fold(
                onSuccess = { word ->
                    _wordGenerationState.update { it.copy(generatedWord = word) }
                },
                onFailure = {},
            )
            _wordGenerationState.update { it.copy(isWordGenerating = false) }
        }
    }

    fun copyGeneratedWord() = Unit

    fun explainGeneratedWord() = Unit
}

data class WordGenerationState(
    val generatedWord: String? = null,
    val isWordGenerating: Boolean = false,
    val generatedWordDescription: String? = null,
    val isDescriptionGenerating: Boolean = false,
)
