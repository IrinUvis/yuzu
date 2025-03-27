package uvis.irin.feature.wordgenerator.domain

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

internal class ExplainWordUseCaseImpl : ExplainWordUseCase {
    override suspend fun invoke(word: String): Result<String> {
        delay(2.seconds)
        return Result.success(
            "A cockroach is a hardy insect, often considered a pest, " +
                "that thrives in human environments, particularly warm and " +
                "damp places where food is readily available.",
        )
    }
}

interface ExplainWordUseCase {
    suspend operator fun invoke(word: String): Result<String>
}
