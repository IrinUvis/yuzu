package uvis.irin.yuzu.core.genai.model

sealed interface ModelDownloadStatus {
    data class DownloadStarted(
        val bytesToDownload: Long,
    ) : ModelDownloadStatus

    data class DownloadProgress(
        val bytesDownloaded: Long,
    ) : ModelDownloadStatus

    data object DownloadCompleted : ModelDownloadStatus

    data class DownloadFailed(
        val exception: Throwable,
    ) : ModelDownloadStatus
}
