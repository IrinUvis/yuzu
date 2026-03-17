package uvis.irin.yuzu.data.wordgeneration.model

import kotlinx.serialization.Serializable

@Serializable
data class WordGenerationSettings(
    val language: Language,
    val partsOfSpeech: Set<PartOfSpeech>,
    val difficulties: Set<Difficulty>,
)
