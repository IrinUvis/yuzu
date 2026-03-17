package uvis.irin.yuzu.domain.wordgeneration.model

interface GenerateWordsResult {
    data class Success(val generatedWords: List<String>) : GenerateWordsResult

    data object Failure : GenerateWordsResult
}
