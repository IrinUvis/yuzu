package uvis.irin.yuzu.data.wordgeneration.model

import kotlinx.collections.immutable.PersistentSet
import kotlinx.serialization.Serializable

@Serializable
data class WordGenerationSettingsModel(
    val language: LanguageModel,
    val partsOfSpeech: PersistentSet<PartOfSpeechModel>,
    val difficulties: PersistentSet<DifficultyModel>,
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
