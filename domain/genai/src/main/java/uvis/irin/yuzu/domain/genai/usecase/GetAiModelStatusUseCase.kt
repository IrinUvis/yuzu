package uvis.irin.yuzu.domain.genai.usecase

import uvis.irin.yuzu.domain.genai.model.ModelStatusDto

interface GetAiModelStatusUseCase {
    suspend fun invoke(): ModelStatusDto
}
