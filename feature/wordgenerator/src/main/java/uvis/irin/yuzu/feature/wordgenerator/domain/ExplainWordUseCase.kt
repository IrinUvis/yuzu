package uvis.irin.yuzu.feature.wordgenerator.domain

import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

internal class ExplainWordUseCaseImpl : ExplainWordUseCase {
    override suspend fun invoke(word: String): Result<String> {
        delay(2.seconds)
        return Result.success(
            value = if (Random.nextBoolean()) {
                "A cockroach is a hardy insect, often considered a pest, " +
                    "that thrives in human environments, particularly warm and " +
                    "damp places where food is readily available."
            } else {
                "asdsd"
            },
        )
    }
}

interface ExplainWordUseCase {
    suspend operator fun invoke(word: String): Result<String>
}
