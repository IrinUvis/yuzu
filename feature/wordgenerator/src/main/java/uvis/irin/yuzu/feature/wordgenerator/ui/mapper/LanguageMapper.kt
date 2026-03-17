package uvis.irin.yuzu.feature.wordgenerator.ui.mapper

import uvis.irin.yuzu.domain.wordgeneration.model.LanguageDto
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiLanguage
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiLanguage.English
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiLanguage.Polish

internal fun UiLanguage.toDomain(): LanguageDto = when (this) {
    English -> LanguageDto.English
    Polish -> LanguageDto.Polish
}

internal fun LanguageDto.toUiModel(): UiLanguage = when (this) {
    LanguageDto.English -> UiLanguage.English
    LanguageDto.Polish -> UiLanguage.Polish
}
