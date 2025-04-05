package uvis.irin.yuzu.core.genai.repository.impl

import android.content.Context
import uvis.irin.yuzu.core.genai.repository.GenAiRepository

class LlmRepository(
    private val context: Context,
) : GenAiRepository {
    override suspend fun generateResponse(prompt: String): Result<String> {
        context.assets
        return Result.success("Generated response")
    }
}
