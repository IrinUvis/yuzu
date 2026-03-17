package uvis.irin.yuzu.domain.wordgeneration.usecase

import uvis.irin.yuzu.domain.wordgeneration.model.GenerateWordsResult

interface GenerateWordsUseCase {
    suspend operator fun invoke(): GenerateWordsResult
}
