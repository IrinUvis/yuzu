package uvis.irin.yuzu.domain.genai.usecase.impl

import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.core.genai.repository.LlmRepository
import uvis.irin.yuzu.domain.genai.mapper.toDto
import uvis.irin.yuzu.domain.genai.model.ModelDownloadStatusDto
import uvis.irin.yuzu.domain.genai.usecase.DownloadGenAiModelUseCase

internal class DownloadGenAiModelUseCaseImpl(
    private val llmRepository: LlmRepository,
) : DownloadGenAiModelUseCase {
    override fun invoke(): Flow<ModelDownloadStatusDto> {
        return llmRepository.downloadModel().toDto()
    }
}
