package uvis.irin.yuzu.domain.genai.mapper

import uvis.irin.yuzu.core.genai.model.ModelStatus
import uvis.irin.yuzu.domain.genai.model.ModelStatusDto

internal fun ModelStatus.toDomain(): ModelStatusDto = when (this) {
    ModelStatus.Unavailable -> ModelStatusDto.Unavailable
    ModelStatus.Downloadable -> ModelStatusDto.Downloadable
    ModelStatus.Downloading -> ModelStatusDto.Downloading
    ModelStatus.Available -> ModelStatusDto.Available
    ModelStatus.Unknown -> ModelStatusDto.Unknown
}
