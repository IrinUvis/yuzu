package uvis.irin.yuzu.domain.wordgeneration.usecase.impl

import uvis.irin.yuzu.core.genai.model.ContentGenerationParams
import uvis.irin.yuzu.core.genai.model.GenerateContentResult
import uvis.irin.yuzu.core.genai.repository.LlmRepository
import uvis.irin.yuzu.core.logger.YuzuLogger
import uvis.irin.yuzu.domain.wordgeneration.model.GenerateWordsResult
import uvis.irin.yuzu.domain.wordgeneration.usecase.GenerateWordsUseCase

internal class GenerateWordsUseCaseImpl(
    private val llmRepository: LlmRepository,
    private val logger: YuzuLogger,
) : GenerateWordsUseCase {
    private val generationParams = ContentGenerationParams(
        temperature = 0.8f,
        topK = 10,
        candidateCount = 1,
    )

    override suspend fun invoke(): GenerateWordsResult {
        logger.logDebug(TAG, "invoke()")
        val result = llmRepository.generateResponse(
            prompt = "Generate one random english word and nothing else",
            generationParams = generationParams,
        )

        val finalResult = when (result) {
            GenerateContentResult.Failure.GenAiFailure,
            GenerateContentResult.Failure.MlKitFailure,
            -> {
                GenerateWordsResult.Failure
            }

            is GenerateContentResult.Success -> {
                val formattedResults = result.generatedResponses.map { response ->
                    val formattedResponses = response.lowercase()
                    logger.logDebug(TAG, "formattedResponses: $formattedResponses")
                    formattedResponses
                }

                GenerateWordsResult.Success(
                    generatedWords = formattedResults,
                )
            }
        }

        logger.logDebug(TAG, "final generate words result: $finalResult")

        return finalResult
    }

    companion object {
        private val TAG = GenerateWordsUseCaseImpl::class.simpleName!!
    }
}
