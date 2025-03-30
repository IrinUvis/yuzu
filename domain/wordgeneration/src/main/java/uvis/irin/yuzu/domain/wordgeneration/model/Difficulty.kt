package uvis.irin.yuzu.domain.wordgeneration.model

import uvis.irin.yuzu.data.wordgeneration.model.DifficultyModel

enum class Difficulty {
    CommonlyUsed,
    LessCommonlyUsed,
    RarelyUsed,
    ;

    fun toModel(): DifficultyModel = when (this) {
        CommonlyUsed -> DifficultyModel.CommonlyUsed
        LessCommonlyUsed -> DifficultyModel.LessCommonlyUsed
        RarelyUsed -> DifficultyModel.RarelyUsed
    }
}

fun DifficultyModel.toDomain() = when (this) {
    DifficultyModel.CommonlyUsed -> Difficulty.CommonlyUsed
    DifficultyModel.LessCommonlyUsed -> Difficulty.LessCommonlyUsed
    DifficultyModel.RarelyUsed -> Difficulty.RarelyUsed
}
