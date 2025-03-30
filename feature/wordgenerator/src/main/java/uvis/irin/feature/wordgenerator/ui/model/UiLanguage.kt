package uvis.irin.feature.wordgenerator.ui.model

import uvis.irin.yuzu.domain.wordgeneration.model.Language

enum class UiLanguage {
    English,
    Polish,
    ;

    fun toDomain() = when (this) {
        English -> Language.English
        Polish -> Language.Polish
    }
}

fun Language.toUiModel() = when (this) {
    Language.English -> UiLanguage.English
    Language.Polish -> UiLanguage.Polish
}
