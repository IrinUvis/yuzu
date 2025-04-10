package uvis.irin.yuzu.domain.wordgeneration.usecase.impl

import uvis.irin.yuzu.core.genai.repository.GenAiRepository
import uvis.irin.yuzu.domain.wordgeneration.usecase.GenerateWordUseCase

internal class GenerateWordUseCaseImpl(
    private val genAiRepository: GenAiRepository,
) : GenerateWordUseCase {
    override suspend fun invoke(): Result<String> {
        val result = genAiRepository.generateResponse("Generate one random english word and nothing else").fold(
            onSuccess = { response ->
                val formattedResponse = response.lowercase()
                Result.success(formattedResponse)
            },
            onFailure = { Result.success("Failure") },
        )

        return result
    }
}
