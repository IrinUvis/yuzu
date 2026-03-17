package uvis.irin.yuzu.feature.wordgenerator.ui.mapper

import uvis.irin.yuzu.domain.genai.model.ModelStatusDto
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiModelStatus

internal fun UiModelStatus.toDomain(): ModelStatusDto = when (this) {
    UiModelStatus.Unavailable -> ModelStatusDto.Unavailable
    UiModelStatus.Downloadable -> ModelStatusDto.Downloadable
    UiModelStatus.Downloading -> ModelStatusDto.Downloading
    UiModelStatus.Available -> ModelStatusDto.Available
    UiModelStatus.Unknown -> ModelStatusDto.Unknown
}

internal fun ModelStatusDto.toUiModel(): UiModelStatus = when (this) {
    ModelStatusDto.Unavailable -> UiModelStatus.Unavailable
    ModelStatusDto.Downloadable -> UiModelStatus.Downloadable
    ModelStatusDto.Downloading -> UiModelStatus.Downloading
    ModelStatusDto.Available -> UiModelStatus.Available
    ModelStatusDto.Unknown -> UiModelStatus.Unknown
}
