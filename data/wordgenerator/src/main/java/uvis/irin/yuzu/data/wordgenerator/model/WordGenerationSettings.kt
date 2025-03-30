package uvis.irin.yuzu.data.wordgenerator.model

import kotlinx.collections.immutable.PersistentList
import kotlinx.serialization.Serializable

@Serializable
data class WordGenerationSettings(
    val language: Language,
    val partsOfSpeech: PersistentList<PartOfSpeech>,
    val difficulties: PersistentList<Difficulty>,
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
