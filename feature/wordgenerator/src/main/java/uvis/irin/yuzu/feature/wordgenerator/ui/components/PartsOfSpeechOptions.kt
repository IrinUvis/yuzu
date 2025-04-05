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
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiPartOfSpeech

@Composable
internal fun PartsOfSpeechOptions(
    modifier: Modifier = Modifier,
    selectedPartsOfSpeech: Set<UiPartOfSpeech>,
    onClick: (UiPartOfSpeech) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SectionHeader(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = stringResource(R.string.parts_of_speech_settings_header),
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
    selectedPartsOfSpeech: Set<UiPartOfSpeech>,
    onClick: (UiPartOfSpeech) -> Unit,
) {
    Column(modifier = modifier) {
        PartOfSpeechCheckbox(
            modifier = Modifier.partOfSpeechModifier(
                partOfSpeech = UiPartOfSpeech.Noun,
                onClick = onClick,
            ),
            partOfSpeech = UiPartOfSpeech.Noun,
            checked = UiPartOfSpeech.Noun in selectedPartsOfSpeech,
            onClick = onClick,
        )
        PartOfSpeechCheckbox(
            modifier = Modifier.partOfSpeechModifier(
                partOfSpeech = UiPartOfSpeech.Verb,
                onClick = onClick,
            ),
            partOfSpeech = UiPartOfSpeech.Verb,
            checked = UiPartOfSpeech.Verb in selectedPartsOfSpeech,
            onClick = onClick,
        )
        PartOfSpeechCheckbox(
            modifier = Modifier.partOfSpeechModifier(
                partOfSpeech = UiPartOfSpeech.Adjective,
                onClick = onClick,
            ),
            partOfSpeech = UiPartOfSpeech.Adjective,
            checked = UiPartOfSpeech.Adjective in selectedPartsOfSpeech,
            onClick = onClick,
        )
    }
}

@Composable
private fun Modifier.partOfSpeechModifier(
    partOfSpeech: UiPartOfSpeech,
    onClick: (UiPartOfSpeech) -> Unit,
) = this
    .clickable { onClick(partOfSpeech) }
    .padding(vertical = 4.dp, horizontal = 16.dp)

@Composable
private fun PartOfSpeechCheckbox(
    modifier: Modifier = Modifier,
    partOfSpeech: UiPartOfSpeech,
    checked: Boolean,
    onClick: (UiPartOfSpeech) -> Unit,
) {
    YuzuCheckboxOption(
        modifier = modifier,
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
private fun headerForPartOfSpeech(partOfSpeech: UiPartOfSpeech) = when (partOfSpeech) {
    UiPartOfSpeech.Noun -> stringResource(R.string.noun_part_of_speech_header)
    UiPartOfSpeech.Verb -> stringResource(R.string.verb_part_of_speech_header)
    UiPartOfSpeech.Adjective -> stringResource(R.string.adjective_part_of_speech_header)
}

@Composable
private fun subtitleForPartOfSpeech(partOfSpeech: UiPartOfSpeech) = when (partOfSpeech) {
    UiPartOfSpeech.Verb -> stringResource(R.string.verb_part_of_speech_subtitle)
    else -> null
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun PartsOfSpeechOptionsPreview() {
    YuzuPreview {
        PartsOfSpeechOptions(
            selectedPartsOfSpeech = setOf(UiPartOfSpeech.Noun, UiPartOfSpeech.Verb),
            onClick = {},
        )
    }
}
