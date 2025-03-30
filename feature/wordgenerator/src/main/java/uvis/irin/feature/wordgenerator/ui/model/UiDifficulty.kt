package uvis.irin.feature.wordgenerator.ui.model

import uvis.irin.yuzu.domain.wordgeneration.model.Difficulty

enum class UiDifficulty {
    CommonlyUsed,
    LessCommonlyUsed,
    RarelyUsed,
    ;

    fun toDomain() = when (this) {
        CommonlyUsed -> Difficulty.CommonlyUsed
        LessCommonlyUsed -> Difficulty.LessCommonlyUsed
        RarelyUsed -> Difficulty.RarelyUsed
    }
}

fun Difficulty.toUiModel() = when (this) {
    Difficulty.CommonlyUsed -> UiDifficulty.CommonlyUsed
    Difficulty.LessCommonlyUsed -> UiDifficulty.LessCommonlyUsed
    Difficulty.RarelyUsed -> UiDifficulty.RarelyUsed
}
