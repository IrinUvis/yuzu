package uvis.irin.yuzu.core.genai.model

data class ContentGenerationParams(
    val temperature: Float,
    val topK: Int,
    val candidateCount: Int,
)
