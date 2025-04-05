package uvis.irin.yuzu.domain.wordgeneration.usecase

interface GenerateWordUseCase {
    suspend operator fun invoke(): Result<String>
}
