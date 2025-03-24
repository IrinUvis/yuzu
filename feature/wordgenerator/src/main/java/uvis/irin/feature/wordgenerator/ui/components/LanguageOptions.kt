package uvis.irin.feature.wordgenerator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.components.radio.YuzuRadioOption
import uvis.irin.core.designsystem.components.section.SectionHeader
import uvis.irin.core.designsystem.components.text.HeaderWithSubtitle
import uvis.irin.core.designsystem.preview.YuzuPreview
import uvis.irin.feature.wordgenerator.ui.model.Language

@Composable
fun LanguageOptions(
    modifier: Modifier = Modifier,
    selectedLanguage: Language,
    onClick: (Language) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SectionHeader(text = "Language")
        LanguageOptionRadioGroup(
            selectedLanguage = selectedLanguage,
            onClick = onClick,
        )
    }
}

@Composable
private fun LanguageOptionRadioGroup(
    modifier: Modifier = Modifier,
    selectedLanguage: Language,
    onClick: (Language) -> Unit,
) {
    Column(modifier = modifier.selectableGroup()) {
        LanguageRadioButton(
            language = Language.English,
            selected = selectedLanguage == Language.English,
            onClick = onClick,
        )
        LanguageRadioButton(
            language = Language.Polish,
            selected = selectedLanguage == Language.Polish,
            onClick = onClick,
        )
    }
}

@Composable
private fun LanguageRadioButton(
    modifier: Modifier = Modifier,
    language: Language,
    selected: Boolean,
    onClick: (Language) -> Unit,
) {
    YuzuRadioOption(
        modifier = modifier,
        selected = selected,
        onClick = { onClick(language) },
    ) {
        HeaderWithSubtitle(
            header = headerForLanguage(language),
            subtitle = subtitleForLanguage(language),
        )
    }
}

@Composable
private fun headerForLanguage(language: Language) = when (language) {
    Language.English -> "English"
    Language.Polish -> "Polish"
}

@Composable
private fun subtitleForLanguage(language: Language) = when (language) {
    Language.English -> "Generate words in English language"
    Language.Polish -> "Generate words in Polish language"
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun LanguageOptionsPreview() {
    YuzuPreview {
        LanguageOptions(
            modifier = Modifier.padding(4.dp),
            selectedLanguage = Language.English,
            onClick = {},
        )
    }
}
