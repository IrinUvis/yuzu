package uvis.irin.yuzu.domain.wordgeneration.model

import uvis.irin.yuzu.data.wordgeneration.model.PartOfSpeechModel

enum class PartOfSpeech {
    Noun,
    Verb,
    Adjective,
    ;

    fun toModel(): PartOfSpeechModel = when (this) {
        Noun -> PartOfSpeechModel.Noun
        Verb -> PartOfSpeechModel.Verb
        Adjective -> PartOfSpeechModel.Adjective
    }
}

fun PartOfSpeechModel.toDomain() = when (this) {
    PartOfSpeechModel.Noun -> PartOfSpeech.Noun
    PartOfSpeechModel.Verb -> PartOfSpeech.Verb
    PartOfSpeechModel.Adjective -> PartOfSpeech.Adjective
}
