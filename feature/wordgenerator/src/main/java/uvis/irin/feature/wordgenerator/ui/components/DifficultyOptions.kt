package uvis.irin.feature.wordgenerator.ui.components

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
import uvis.irin.core.designsystem.components.checkbox.YuzuCheckboxOption
import uvis.irin.core.designsystem.components.section.SectionHeader
import uvis.irin.core.designsystem.components.text.HeaderWithSubtitle
import uvis.irin.core.designsystem.preview.YuzuPreview
import uvis.irin.feature.wordgenerator.R
import uvis.irin.feature.wordgenerator.ui.model.GenerationDifficulty

@Composable
internal fun DifficultyOptions(
    modifier: Modifier = Modifier,
    selectedDifficulty: Set<GenerationDifficulty>,
    onClick: (GenerationDifficulty) -> Unit,
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
            selectedDifficulty = selectedDifficulty,
            onClick = onClick,
        )
    }
}

@Composable
private fun DifficultyCheckboxGroup(
    modifier: Modifier = Modifier,
    selectedDifficulty: Set<GenerationDifficulty>,
    onClick: (GenerationDifficulty) -> Unit,
) {
    Column(modifier = modifier) {
        DifficultyCheckbox(
            modifier = Modifier.difficultyModifier(
                difficulty = GenerationDifficulty.CommonlyUsed,
                onClick = onClick,
            ),
            difficulty = GenerationDifficulty.CommonlyUsed,
            checked = GenerationDifficulty.CommonlyUsed in selectedDifficulty,
            onClick = onClick,
        )
        DifficultyCheckbox(
            modifier = Modifier.difficultyModifier(
                difficulty = GenerationDifficulty.LessCommonlyUsed,
                onClick = onClick,
            ),
            difficulty = GenerationDifficulty.LessCommonlyUsed,
            checked = GenerationDifficulty.LessCommonlyUsed in selectedDifficulty,
            onClick = onClick,
        )
        DifficultyCheckbox(
            modifier = Modifier.difficultyModifier(
                difficulty = GenerationDifficulty.RarelyUsed,
                onClick = onClick,
            ),
            difficulty = GenerationDifficulty.RarelyUsed,
            checked = GenerationDifficulty.RarelyUsed in selectedDifficulty,
            onClick = onClick,
        )
    }
}

@Composable
private fun Modifier.difficultyModifier(
    difficulty: GenerationDifficulty,
    onClick: (GenerationDifficulty) -> Unit,
) = this
    .clickable { onClick(difficulty) }
    .padding(vertical = 4.dp, horizontal = 16.dp)

@Composable
private fun DifficultyCheckbox(
    modifier: Modifier = Modifier,
    difficulty: GenerationDifficulty,
    checked: Boolean,
    onClick: (GenerationDifficulty) -> Unit,
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
private fun headerForDifficulty(difficulty: GenerationDifficulty) = when (difficulty) {
    GenerationDifficulty.CommonlyUsed -> stringResource(R.string.commonly_used_difficulty_header)
    GenerationDifficulty.LessCommonlyUsed -> stringResource(R.string.less_commonly_used_difficulty_header)
    GenerationDifficulty.RarelyUsed -> stringResource(R.string.rarely_used_difficulty_header)
}

@Composable
private fun subtitleForDifficulty(difficulty: GenerationDifficulty) = when (difficulty) {
    GenerationDifficulty.CommonlyUsed -> stringResource(R.string.commonly_used_difficulty_subtitle)
    GenerationDifficulty.LessCommonlyUsed -> stringResource(R.string.less_commonly_used_difficulty_subtitle)
    GenerationDifficulty.RarelyUsed -> stringResource(R.string.rarely_used_difficulty_subtitle)
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun DifficultyOptionsPreview() {
    YuzuPreview {
        DifficultyOptions(
            selectedDifficulty = setOf(GenerationDifficulty.CommonlyUsed, GenerationDifficulty.LessCommonlyUsed),
            onClick = {},
        )
    }
}
