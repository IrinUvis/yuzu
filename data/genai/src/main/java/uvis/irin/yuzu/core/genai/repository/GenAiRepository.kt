package uvis.irin.yuzu.core.genai.repository

interface GenAiRepository {
    suspend fun generateResponse(prompt: String): Result<String>
}
