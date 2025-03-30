package uvis.irin.yuzu.domain.wordgeneration.usecase.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uvis.irin.yuzu.data.wordgeneration.repository.WordGeneratorSettingsRepository
import uvis.irin.yuzu.domain.wordgeneration.model.WordGenerationSettingsModel
import uvis.irin.yuzu.domain.wordgeneration.model.toDomain
import uvis.irin.yuzu.domain.wordgeneration.usecase.GetWordGenerationSettingsUseCase

internal class GetWordGenerationSettingsUseCaseImpl(
    private val wordGeneratorSettingsRepository: WordGeneratorSettingsRepository,
) : GetWordGenerationSettingsUseCase {
    override operator fun invoke(): Flow<WordGenerationSettingsModel> {
        return wordGeneratorSettingsRepository.generationSettingsFlow().map { it.toDomain() }
    }
}
