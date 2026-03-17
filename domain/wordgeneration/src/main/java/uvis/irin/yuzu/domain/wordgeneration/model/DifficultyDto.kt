package uvis.irin.yuzu.domain.wordgeneration.model

import uvis.irin.yuzu.data.wordgeneration.model.Difficulty

enum class DifficultyDto {
    CommonlyUsed,
    LessCommonlyUsed,
    RarelyUsed,
    ;

    fun toModel(): Difficulty = when (this) {
        CommonlyUsed -> Difficulty.CommonlyUsed
        LessCommonlyUsed -> Difficulty.LessCommonlyUsed
        RarelyUsed -> Difficulty.RarelyUsed
    }
}

fun Difficulty.toDomain(): DifficultyDto = when (this) {
    Difficulty.CommonlyUsed -> DifficultyDto.CommonlyUsed
    Difficulty.LessCommonlyUsed -> DifficultyDto.LessCommonlyUsed
    Difficulty.RarelyUsed -> DifficultyDto.RarelyUsed
}
