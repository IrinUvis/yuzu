package uvis.irin.yuzu.domain.wordgeneration.model

import kotlinx.collections.immutable.toPersistentSet
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettingsModel

data class WordGenerationSettings(
    val language: Language,
    val partsOfSpeech: Set<PartOfSpeech>,
    val difficulties: Set<Difficulty>,
) {
    fun toModel(): WordGenerationSettingsModel = WordGenerationSettingsModel(
        language = language.toModel(),
        partsOfSpeech = partsOfSpeech.map { it.toModel() }.toPersistentSet(),
        difficulties = difficulties.map { it.toModel() }.toPersistentSet(),
    )
}

fun WordGenerationSettingsModel.toDomain(): WordGenerationSettings = WordGenerationSettings(
    language = language.toDomain(),
    partsOfSpeech = partsOfSpeech.map { it.toDomain() }.toSet(),
    difficulties = difficulties.map { it.toDomain() }.toSet(),
)
