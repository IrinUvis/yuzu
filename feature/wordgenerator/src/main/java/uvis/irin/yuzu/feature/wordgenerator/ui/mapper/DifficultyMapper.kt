package uvis.irin.yuzu.feature.wordgenerator.ui.mapper

import uvis.irin.yuzu.domain.wordgeneration.model.DifficultyDto
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiDifficulty
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiDifficulty.CommonlyUsed
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiDifficulty.LessCommonlyUsed
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiDifficulty.RarelyUsed

internal fun UiDifficulty.toDomain() = when (this) {
    CommonlyUsed -> DifficultyDto.CommonlyUsed
    LessCommonlyUsed -> DifficultyDto.LessCommonlyUsed
    RarelyUsed -> DifficultyDto.RarelyUsed
}

internal fun DifficultyDto.toUiModel() = when (this) {
    DifficultyDto.CommonlyUsed -> UiDifficulty.CommonlyUsed
    DifficultyDto.LessCommonlyUsed -> UiDifficulty.LessCommonlyUsed
    DifficultyDto.RarelyUsed -> UiDifficulty.RarelyUsed
}
