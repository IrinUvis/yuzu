package uvis.irin.yuzu.feature.wordgenerator.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uvis.irin.yuzu.core.designsystem.components.checkbox.YuzuCheckboxOption
import uvis.irin.yuzu.core.designsystem.components.section.SectionHeader
import uvis.irin.yuzu.core.designsystem.components.text.HeaderWithSubtitle
import uvis.irin.yuzu.core.designsystem.preview.YuzuPreview
import uvis.irin.yuzu.feature.wordgenerator.R
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiDifficulty

@Composable
internal fun DifficultyOptions(
    modifier: Modifier = Modifier,
    selectedDifficulties: Set<UiDifficulty>,
    onClick: (UiDifficulty) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SectionHeader(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = stringResource(R.string.word_difficulty_settings_header),
        )
        DifficultyCheckboxGroup(
            selectedDifficulty = selectedDifficulties,
            onClick = onClick,
        )
    }
}

@Composable
private fun DifficultyCheckboxGroup(
    modifier: Modifier = Modifier,
    selectedDifficulty: Set<UiDifficulty>,
    onClick: (UiDifficulty) -> Unit,
) {
    Column(modifier = modifier) {
        DifficultyCheckbox(
            modifier = Modifier.difficultyModifier(
                difficulty = UiDifficulty.CommonlyUsed,
                onClick = onClick,
            ),
            difficulty = UiDifficulty.CommonlyUsed,
            checked = UiDifficulty.CommonlyUsed in selectedDifficulty,
            onClick = onClick,
        )
        DifficultyCheckbox(
            modifier = Modifier.difficultyModifier(
                difficulty = UiDifficulty.LessCommonlyUsed,
                onClick = onClick,
            ),
            difficulty = UiDifficulty.LessCommonlyUsed,
            checked = UiDifficulty.LessCommonlyUsed in selectedDifficulty,
            onClick = onClick,
        )
        DifficultyCheckbox(
            modifier = Modifier.difficultyModifier(
                difficulty = UiDifficulty.RarelyUsed,
                onClick = onClick,
            ),
            difficulty = UiDifficulty.RarelyUsed,
            checked = UiDifficulty.RarelyUsed in selectedDifficulty,
            onClick = onClick,
        )
    }
}

@Composable
private fun Modifier.difficultyModifier(
    difficulty: UiDifficulty,
    onClick: (UiDifficulty) -> Unit,
) = this
    .clickable { onClick(difficulty) }
    .padding(vertical = 4.dp, horizontal = 16.dp)

@Composable
private fun DifficultyCheckbox(
    modifier: Modifier = Modifier,
    difficulty: UiDifficulty,
    checked: Boolean,
    onClick: (UiDifficulty) -> Unit,
) {
    YuzuCheckboxOption(
        modifier = modifier,
        checked = checked,
        onCheckedChange = { onClick(difficulty) },
    ) {
        HeaderWithSubtitle(
            header = headerForDifficulty(difficulty),
            subtitle = subtitleForDifficulty(difficulty),
        )
    }
}

@Composable
private fun headerForDifficulty(difficulty: UiDifficulty) = when (difficulty) {
    UiDifficulty.CommonlyUsed -> stringResource(R.string.commonly_used_difficulty_header)
    UiDifficulty.LessCommonlyUsed -> stringResource(R.string.less_commonly_used_difficulty_header)
    UiDifficulty.RarelyUsed -> stringResource(R.string.rarely_used_difficulty_header)
}

@Composable
private fun subtitleForDifficulty(difficulty: UiDifficulty) = when (difficulty) {
    UiDifficulty.CommonlyUsed -> stringResource(R.string.commonly_used_difficulty_subtitle)
    UiDifficulty.LessCommonlyUsed -> stringResource(R.string.less_commonly_used_difficulty_subtitle)
    UiDifficulty.RarelyUsed -> stringResource(R.string.rarely_used_difficulty_subtitle)
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun DifficultyOptionsPreview() {
    YuzuPreview {
        DifficultyOptions(
            selectedDifficulties = setOf(UiDifficulty.CommonlyUsed, UiDifficulty.LessCommonlyUsed),
            onClick = {},
        )
    }
}
