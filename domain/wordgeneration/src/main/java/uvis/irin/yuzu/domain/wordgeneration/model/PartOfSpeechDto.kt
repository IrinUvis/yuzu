package uvis.irin.yuzu.domain.wordgeneration.model

import uvis.irin.yuzu.data.wordgeneration.model.PartOfSpeech

enum class PartOfSpeechDto {
    Noun,
    Verb,
    Adjective,
    ;

    fun toModel(): PartOfSpeech = when (this) {
        Noun -> PartOfSpeech.Noun
        Verb -> PartOfSpeech.Verb
        Adjective -> PartOfSpeech.Adjective
    }
}

fun PartOfSpeech.toDomain(): PartOfSpeechDto = when (this) {
    PartOfSpeech.Noun -> PartOfSpeechDto.Noun
    PartOfSpeech.Verb -> PartOfSpeechDto.Verb
    PartOfSpeech.Adjective -> PartOfSpeechDto.Adjective
}
