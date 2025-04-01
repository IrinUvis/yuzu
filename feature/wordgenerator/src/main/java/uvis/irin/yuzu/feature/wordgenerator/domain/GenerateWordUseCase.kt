package uvis.irin.yuzu.feature.wordgenerator.domain

import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

internal class GenerateWordUseCaseImpl : GenerateWordUseCase {
    override suspend fun invoke(): Result<String> {
        delay(1.seconds)
        return Result.success(value = if (Random.nextBoolean()) "cockroach" else "ladybug")
    }
}

interface GenerateWordUseCase {
    suspend operator fun invoke(): Result<String>
}
