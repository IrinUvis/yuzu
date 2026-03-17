package uvis.irin.yuzu.domain.genai.mapper

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.runningFold
import uvis.irin.yuzu.core.genai.model.ModelDownloadStatus
import uvis.irin.yuzu.domain.genai.model.ModelDownloadStatusDto

internal fun Flow<ModelDownloadStatus>.toDto(): Flow<ModelDownloadStatusDto> = this.runningFold(
    initial = DownloadStatusMappingState(),
) { accumulator, status ->
    when (status) {
        is ModelDownloadStatus.DownloadStarted -> {
            DownloadStatusMappingState(
                totalBytes = status.bytesToDownload,
                dto = ModelDownloadStatusDto.DownloadStarted(status.bytesToDownload),
            )
        }

        is ModelDownloadStatus.DownloadProgress -> {
            val progress = if (accumulator.totalBytes > 0) {
                status.bytesDownloaded.toFloat() / accumulator.totalBytes
            } else {
                0f
            }

            accumulator.copy(
                dto = ModelDownloadStatusDto.DownloadProgress(
                    bytesDownloaded = status.bytesDownloaded,
                    completionProgress = progress.coerceIn(0f, 1f),
                ),
            )
        }

        is ModelDownloadStatus.DownloadCompleted -> {
            accumulator.copy(dto = ModelDownloadStatusDto.DownloadCompleted)
        }

        is ModelDownloadStatus.DownloadFailed -> {
            accumulator.copy(dto = ModelDownloadStatusDto.DownloadFailed(status.exception))
        }
    }
}.mapNotNull { it.dto }

private data class DownloadStatusMappingState(
    val totalBytes: Long = 0L,
    val dto: ModelDownloadStatusDto? = null,
)
