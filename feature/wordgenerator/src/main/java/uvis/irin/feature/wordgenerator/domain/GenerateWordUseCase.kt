package uvis.irin.feature.wordgenerator.domain

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

internal class GenerateWordUseCaseImpl : GenerateWordUseCase {
    override suspend fun invoke(): Result<String> {
        delay(3.seconds)
        return Result.success("cockroach")
    }
}

interface GenerateWordUseCase {
    suspend operator fun invoke(): Result<String>
}
