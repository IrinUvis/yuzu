package uvis.irin.yuzu.domain.genai.usecase.impl

import uvis.irin.yuzu.core.genai.repository.LlmRepository
import uvis.irin.yuzu.core.logger.YuzuLogger
import uvis.irin.yuzu.domain.genai.mapper.toDomain
import uvis.irin.yuzu.domain.genai.model.ModelStatusDto
import uvis.irin.yuzu.domain.genai.usecase.GetAiModelStatusUseCase

internal class GetAiModelStatusUseCaseImpl(
    private val llmRepository: LlmRepository,
    private val logger: YuzuLogger,
) : GetAiModelStatusUseCase {
    override suspend fun invoke(): ModelStatusDto {
        val modelStatus = llmRepository.getModelStatus().toDomain()

        logger.logDebug(TAG, "model status: $modelStatus")

        return modelStatus
    }

    companion object {
        private val TAG = GetAiModelStatusUseCaseImpl::class.simpleName!!
    }
}
