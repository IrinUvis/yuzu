package uvis.irin.yuzu.domain.wordgeneration.usecase.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uvis.irin.yuzu.data.wordgeneration.repository.WordGeneratorSettingsRepository
import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettings
import uvis.irin.yuzu.domain.wordgeneration.model.toDomain
import uvis.irin.yuzu.domain.wordgeneration.usecase.GetWordGenerationSettingsUseCase

internal class GetWordGenerationSettingsUseCaseImpl(
    private val wordGeneratorSettingsRepository: WordGeneratorSettingsRepository,
) : GetWordGenerationSettingsUseCase {
    override suspend operator fun invoke(): Flow<WordGenerationSettings> {
        return wordGeneratorSettingsRepository.generationSettingsFlow().map { it.toDomain() }
    }
}
