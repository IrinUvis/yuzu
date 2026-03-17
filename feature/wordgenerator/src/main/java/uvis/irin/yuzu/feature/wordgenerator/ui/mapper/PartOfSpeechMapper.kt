package uvis.irin.yuzu.feature.wordgenerator.ui.mapper

import uvis.irin.yuzu.domain.wordgeneration.model.PartOfSpeechDto
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiPartOfSpeech
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiPartOfSpeech.Adjective
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiPartOfSpeech.Noun
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiPartOfSpeech.Verb

internal fun UiPartOfSpeech.toDomain(): PartOfSpeechDto = when (this) {
    Noun -> PartOfSpeechDto.Noun
    Verb -> PartOfSpeechDto.Verb
    Adjective -> PartOfSpeechDto.Adjective
}

internal fun PartOfSpeechDto.toUiModel(): UiPartOfSpeech = when (this) {
    PartOfSpeechDto.Noun -> UiPartOfSpeech.Noun
    PartOfSpeechDto.Verb -> UiPartOfSpeech.Verb
    PartOfSpeechDto.Adjective -> UiPartOfSpeech.Adjective
}
