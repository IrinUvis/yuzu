package uvis.irin.yuzu.domain.genai.usecase

import kotlinx.coroutines.flow.Flow
import uvis.irin.yuzu.domain.genai.model.ModelDownloadStatusDto

interface DownloadGenAiModelUseCase {
    operator fun invoke(): Flow<ModelDownloadStatusDto>
}
