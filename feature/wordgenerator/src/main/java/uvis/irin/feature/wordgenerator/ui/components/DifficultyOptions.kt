package uvis.irin.feature.wordgenerator.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.components.checkbox.YuzuCheckboxOption
import uvis.irin.core.designsystem.components.section.SectionHeader
import uvis.irin.core.designsystem.components.text.HeaderWithSubtitle
import uvis.irin.core.designsystem.preview.YuzuPreview
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
            text = "Word difficulty",
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
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        DifficultyCheckbox(
            difficulty = GenerationDifficulty.CommonlyUsed,
            checked = GenerationDifficulty.CommonlyUsed in selectedDifficulty,
            onClick = onClick,
        )
        DifficultyCheckbox(
            difficulty = GenerationDifficulty.LessCommonlyUsed,
            checked = GenerationDifficulty.LessCommonlyUsed in selectedDifficulty,
            onClick = onClick,
        )
        DifficultyCheckbox(
            difficulty = GenerationDifficulty.RarelyUsed,
            checked = GenerationDifficulty.RarelyUsed in selectedDifficulty,
            onClick = onClick,
        )
    }
}

@Composable
private fun DifficultyCheckbox(
    modifier: Modifier = Modifier,
    difficulty: GenerationDifficulty,
    checked: Boolean,
    onClick: (GenerationDifficulty) -> Unit,
) {
    YuzuCheckboxOption(
        modifier = modifier.clickable { onClick(difficulty) }.padding(horizontal = 16.dp),
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
    GenerationDifficulty.CommonlyUsed -> "Commonly used"
    GenerationDifficulty.LessCommonlyUsed -> "Less commonly used"
    GenerationDifficulty.RarelyUsed -> "Rarely used"
}

@Composable
private fun subtitleForDifficulty(difficulty: GenerationDifficulty) = when (difficulty) {
    GenerationDifficulty.CommonlyUsed ->
        "Generate words that are used relatively commonly used.\n" +
            "Examples: chair, idea, freedom, building, street"
    GenerationDifficulty.LessCommonlyUsed ->
        "Generate words that are commonly known but less commonly used.\n" +
            "Examples: accommodation, oxygen, dilemma, nostalgia, aroma"
    GenerationDifficulty.RarelyUsed ->
        "Generate difficult and rarely used words.\n" +
            "Examples: apotheosis, kaleidoscope, paucity, impute, assemble"
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun DifficultyOptionsPreview() {
    YuzuPreview {
        DifficultyOptions(
            modifier = Modifier.padding(4.dp),
            selectedDifficulty = setOf(GenerationDifficulty.CommonlyUsed, GenerationDifficulty.LessCommonlyUsed),
            onClick = {},
        )
    }
}
