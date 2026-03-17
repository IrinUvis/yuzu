package uvis.irin.yuzu.domain.wordgeneration.model

import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettings

data class WordGenerationSettingsDto(
    val language: LanguageDto,
    val partsOfSpeech: Set<PartOfSpeechDto>,
    val difficulties: Set<DifficultyDto>,
) {
    fun toModel(): WordGenerationSettings = WordGenerationSettings(
        language = language.toModel(),
        partsOfSpeech = partsOfSpeech.map { it.toModel() }.toSet(),
        difficulties = difficulties.map { it.toModel() }.toSet(),
    )
}

fun WordGenerationSettings.toDomain(): WordGenerationSettingsDto = WordGenerationSettingsDto(
    language = language.toDomain(),
    partsOfSpeech = partsOfSpeech.map { it.toDomain() }.toSet(),
    difficulties = difficulties.map { it.toDomain() }.toSet(),
)
