package uvis.irin.yuzu.domain.wordgeneration.model

import uvis.irin.yuzu.data.wordgeneration.model.LanguageModel

enum class Language {
    English,
    Polish,
    ;

    fun toModel(): LanguageModel = when (this) {
        English -> LanguageModel.English
        Polish -> LanguageModel.Polish
    }
}

fun LanguageModel.toDomain() = when (this) {
    LanguageModel.English -> Language.English
    LanguageModel.Polish -> Language.Polish
}
