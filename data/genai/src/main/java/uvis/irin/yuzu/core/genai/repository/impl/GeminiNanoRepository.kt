package uvis.irin.yuzu.core.genai.repository.impl

import com.google.mlkit.common.MlKitException
import com.google.mlkit.genai.common.DownloadStatus
import com.google.mlkit.genai.common.FeatureStatus
import com.google.mlkit.genai.common.GenAiException
import com.google.mlkit.genai.prompt.GenerativeModel
import com.google.mlkit.genai.prompt.TextPart
import com.google.mlkit.genai.prompt.generateContentRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uvis.irin.yuzu.core.genai.model.ContentGenerationParams
import uvis.irin.yuzu.core.genai.model.GenerateContentResult
import uvis.irin.yuzu.core.genai.model.ModelDownloadStatus
import uvis.irin.yuzu.core.genai.model.ModelStatus
import uvis.irin.yuzu.core.genai.repository.LlmRepository
import uvis.irin.yuzu.core.logger.YuzuLogger

internal class GeminiNanoRepository(
    private val generativeModel: GenerativeModel,
    private val logger: YuzuLogger,
) : LlmRepository {
    override suspend fun getModelStatus(): ModelStatus {
        logger.logDebug(TAG, "getModelStatus()")

        return try {
            val modelStatus = when (generativeModel.checkStatus()) {
                FeatureStatus.UNAVAILABLE -> ModelStatus.Unavailable
                FeatureStatus.AVAILABLE -> ModelStatus.Available
                FeatureStatus.DOWNLOADING -> ModelStatus.Downloading
                FeatureStatus.DOWNLOADABLE -> ModelStatus.Downloadable
                else -> ModelStatus.Unknown
            }

            logger.logDebug(TAG, "Retrieved model status: $modelStatus")

            modelStatus
        } catch (e: GenAiException) {
            logger.logError(TAG, "Could not retrieve model status.", e)
            ModelStatus.Unknown
        }
    }

    override fun downloadModel(): Flow<ModelDownloadStatus> {
        logger.logDebug(TAG, "downloadModel()")

        return generativeModel.download().map { status ->
            when (status) {
                is DownloadStatus.DownloadStarted -> {
                    logger.logDebug(TAG, "Model download started.")
                    logger.logDebug(TAG, "Total bytes to download: ${status.bytesToDownload}")
                    ModelDownloadStatus.DownloadStarted(
                        bytesToDownload = status.bytesToDownload,
                    )
                }

                is DownloadStatus.DownloadProgress -> {
                    logger.logDebug(TAG, "Model download started.")
                    logger.logDebug(TAG, "Total bytes downloaded: ${status.totalBytesDownloaded}")
                    ModelDownloadStatus.DownloadProgress(
                        bytesDownloaded = status.totalBytesDownloaded,
                    )
                }

                is DownloadStatus.DownloadCompleted -> {
                    logger.logDebug(TAG, "Model download completed successfully.")
                    ModelDownloadStatus.DownloadCompleted
                }

                is DownloadStatus.DownloadFailed -> {
                    logger.logError(TAG, "Model download failed.", status.e)
                    ModelDownloadStatus.DownloadFailed(
                        exception = status.e,
                    )
                }
            }
        }
    }

    override suspend fun generateResponse(
        prompt: String,
        generationParams: ContentGenerationParams,
    ): GenerateContentResult {
        logger.logDebug(TAG, "generateResponse()")
        logger.logDebug(TAG, "prompt: $prompt")
        logger.logDebug(TAG, "generationParams: $generationParams")

        return try {
            val generateContentResponse = generativeModel.generateContent(
                request = generateContentRequest(
                    text = TextPart(prompt),
                ) {
                    temperature = generationParams.temperature
                    topK = generationParams.topK
                    candidateCount = generationParams.candidateCount
                },
            )

            logger.logDebug(TAG, "Content was generated successfully.")

            GenerateContentResult.Success(
                generatedResponses = generateContentResponse.candidates.map { it.text },
            )
        } catch (e: GenAiException) {
            logger.logError(TAG, "Failure during generateResponse()", e)
            GenerateContentResult.Failure.GenAiFailure
        } catch (e: MlKitException) {
            logger.logError(TAG, "Failure during generateResponse()", e)
            GenerateContentResult.Failure.MlKitFailure
        }
    }

    companion object {
        private val TAG = GeminiNanoRepository::class.simpleName!!
    }
}
