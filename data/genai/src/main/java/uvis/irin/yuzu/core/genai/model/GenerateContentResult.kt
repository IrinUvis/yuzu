package uvis.irin.yuzu.core.genai.model

sealed interface GenerateContentResult {
    data class Success(val generatedResponses: List<String>) : GenerateContentResult

    sealed interface Failure : GenerateContentResult {
        data object GenAiFailure : Failure

        data object MlKitFailure : Failure
    }
}
