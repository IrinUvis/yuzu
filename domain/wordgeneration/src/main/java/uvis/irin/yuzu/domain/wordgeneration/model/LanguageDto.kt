package uvis.irin.yuzu.domain.wordgeneration.model

import uvis.irin.yuzu.data.wordgeneration.model.Language

enum class LanguageDto {
    English,
    Polish,
    ;

    fun toModel(): Language = when (this) {
        English -> Language.English
        Polish -> Language.Polish
    }
}

fun Language.toDomain(): LanguageDto = when (this) {
    Language.English -> LanguageDto.English
    Language.Polish -> LanguageDto.Polish
}
