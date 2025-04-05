package uvis.irin.yuzu.domain.wordgeneration.usecase

interface ExplainWordUseCase {
    suspend operator fun invoke(word: String): Result<String>
}
