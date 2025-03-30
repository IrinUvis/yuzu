package uvis.irin.yuzu.data.wordgenerator.model

import kotlinx.collections.immutable.PersistentSet
import kotlinx.serialization.Serializable

@Serializable
data class WordGenerationSettings(
    val language: Language,
    val partsOfSpeech: PersistentSet<PartOfSpeech>,
    val difficulties: PersistentSet<Difficulty>,
)

enum class Language {
    English,
    Polish,
}

enum class PartOfSpeech {
    Noun,
    Verb,
    Adjective,
}

enum class Difficulty {
    CommonlyUsed,
    LessCommonlyUsed,
    RarelyUsed,
}
