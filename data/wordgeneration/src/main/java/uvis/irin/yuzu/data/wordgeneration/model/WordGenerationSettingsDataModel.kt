package uvis.irin.yuzu.data.wordgeneration.model

import kotlinx.serialization.Serializable

@Serializable
data class WordGenerationSettingsDataModel(
    val language: LanguageModel,
    val partsOfSpeech: Set<PartOfSpeechModel>,
    val difficulties: Set<DifficultyModel>,
)

enum class LanguageModel {
    English,
    Polish,
}

enum class PartOfSpeechModel {
    Noun,
    Verb,
    Adjective,
}

enum class DifficultyModel {
    CommonlyUsed,
    LessCommonlyUsed,
    RarelyUsed,
}
