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
import uvis.irin.feature.wordgenerator.ui.model.PartOfSpeech

@Composable
internal fun PartsOfSpeechOptions(
    modifier: Modifier = Modifier,
    selectedPartsOfSpeech: Set<PartOfSpeech>,
    onClick: (PartOfSpeech) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SectionHeader(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Parts of speech",
        )
        PartsOfSpeechCheckboxGroup(
            selectedPartsOfSpeech = selectedPartsOfSpeech,
            onClick = onClick,
        )
    }
}

@Composable
private fun PartsOfSpeechCheckboxGroup(
    modifier: Modifier = Modifier,
    selectedPartsOfSpeech: Set<PartOfSpeech>,
    onClick: (PartOfSpeech) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        PartOfSpeechCheckbox(
            partOfSpeech = PartOfSpeech.Noun,
            checked = PartOfSpeech.Noun in selectedPartsOfSpeech,
            onClick = onClick,
        )
        PartOfSpeechCheckbox(
            partOfSpeech = PartOfSpeech.Verb,
            checked = PartOfSpeech.Verb in selectedPartsOfSpeech,
            onClick = onClick,
        )
        PartOfSpeechCheckbox(
            partOfSpeech = PartOfSpeech.Adjective,
            checked = PartOfSpeech.Adjective in selectedPartsOfSpeech,
            onClick = onClick,
        )
    }
}

@Composable
private fun PartOfSpeechCheckbox(
    modifier: Modifier = Modifier,
    partOfSpeech: PartOfSpeech,
    checked: Boolean,
    onClick: (PartOfSpeech) -> Unit,
) {
    YuzuCheckboxOption(
        modifier = modifier.clickable { onClick(partOfSpeech) }.padding(horizontal = 16.dp),
        checked = checked,
        onCheckedChange = { onClick(partOfSpeech) },
    ) {
        HeaderWithSubtitle(
            header = headerForPartOfSpeech(partOfSpeech),
            subtitle = subtitleForPartOfSpeech(partOfSpeech),
        )
    }
}

@Composable
private fun headerForPartOfSpeech(partOfSpeech: PartOfSpeech) = when (partOfSpeech) {
    PartOfSpeech.Noun -> "Nouns"
    PartOfSpeech.Verb -> "Verbs"
    PartOfSpeech.Adjective -> "Adjectives"
}

@Composable
private fun subtitleForPartOfSpeech(partOfSpeech: PartOfSpeech) = when (partOfSpeech) {
    PartOfSpeech.Verb -> "Verb in infinite form"
    else -> null
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun PartsOfSpeechOptionsPreview() {
    YuzuPreview {
        PartsOfSpeechOptions(
            selectedPartsOfSpeech = setOf(PartOfSpeech.Noun, PartOfSpeech.Verb),
            onClick = {},
        )
    }
}
