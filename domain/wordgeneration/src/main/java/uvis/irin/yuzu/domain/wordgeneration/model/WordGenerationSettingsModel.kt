package uvis.irin.yuzu.domain.wordgeneration.model

import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettingsDataModel

data class WordGenerationSettingsModel(
    val language: Language,
    val partsOfSpeech: Set<PartOfSpeech>,
    val difficulties: Set<Difficulty>,
) {
    fun toModel(): WordGenerationSettingsDataModel = WordGenerationSettingsDataModel(
        language = language.toModel(),
        partsOfSpeech = partsOfSpeech.map { it.toModel() }.toSet(),
        difficulties = difficulties.map { it.toModel() }.toSet(),
    )
}

fun WordGenerationSettingsDataModel.toDomain(): WordGenerationSettingsModel = WordGenerationSettingsModel(
    language = language.toDomain(),
    partsOfSpeech = partsOfSpeech.map { it.toDomain() }.toSet(),
    difficulties = difficulties.map { it.toDomain() }.toSet(),
)
