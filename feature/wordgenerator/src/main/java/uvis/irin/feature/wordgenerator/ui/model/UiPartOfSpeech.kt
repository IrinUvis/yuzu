package uvis.irin.feature.wordgenerator.ui.model

import uvis.irin.yuzu.domain.wordgeneration.model.PartOfSpeech

enum class UiPartOfSpeech {
    Noun,
    Verb,
    Adjective,
    ;

    fun toDomain() = when (this) {
        Noun -> PartOfSpeech.Noun
        Verb -> PartOfSpeech.Verb
        Adjective -> PartOfSpeech.Adjective
    }
}

fun PartOfSpeech.toUiModel() = when (this) {
    PartOfSpeech.Noun -> UiPartOfSpeech.Noun
    PartOfSpeech.Verb -> UiPartOfSpeech.Verb
    PartOfSpeech.Adjective -> UiPartOfSpeech.Adjective
}
