package uvis.irin.yuzu.core.genai.repository

import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.core.genai.model.ContentGenerationParams
import uvis.irin.yuzu.core.genai.model.GenerateContentResult
import uvis.irin.yuzu.core.genai.model.ModelDownloadStatus
import uvis.irin.yuzu.core.genai.model.ModelStatus

interface LlmRepository {
    suspend fun getModelStatus(): ModelStatus

    fun downloadModel(): Flow<ModelDownloadStatus>

    suspend fun generateResponse(
        prompt: String,
        generationParams: ContentGenerationParams,
    ): GenerateContentResult
}
