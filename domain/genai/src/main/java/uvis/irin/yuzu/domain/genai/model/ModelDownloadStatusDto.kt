package uvis.irin.yuzu.domain.genai.model

sealed interface ModelDownloadStatusDto {
    data class DownloadStarted(
        val bytesToDownload: Long,
    ) : ModelDownloadStatusDto

    data class DownloadProgress(
        val bytesDownloaded: Long,

        /**
         * Completion progress as a value between 0.0 and 1.0.
         */
        val completionProgress: Float,
    ) : ModelDownloadStatusDto

    data object DownloadCompleted : ModelDownloadStatusDto

    data class DownloadFailed(
        val exception: Throwable,
    ) : ModelDownloadStatusDto
}
