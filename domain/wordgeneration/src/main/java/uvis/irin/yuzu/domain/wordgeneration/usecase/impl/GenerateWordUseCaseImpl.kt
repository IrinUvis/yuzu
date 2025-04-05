package uvis.irin.yuzu.domain.wordgeneration.usecase.impl

import kotlinx.coroutines.delay
import uvis.irin.yuzu.domain.wordgeneration.usecase.GenerateWordUseCase
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

internal class GenerateWordUseCaseImpl : GenerateWordUseCase {
    override suspend fun invoke(): Result<String> {
        delay(1.seconds)
        return Result.success(value = if (Random.nextBoolean()) "cockroach" else "ladybug")
    }
}
