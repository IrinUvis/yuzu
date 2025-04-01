package uvis.irin.yuzu.feature.wordgenerator.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uvis.irin.feature.wordgenerator.R
import uvis.irin.yuzu.core.designsystem.components.radio.YuzuRadioOption
import uvis.irin.yuzu.core.designsystem.components.section.SectionHeader
import uvis.irin.yuzu.core.designsystem.components.text.HeaderWithSubtitle
import uvis.irin.yuzu.core.designsystem.preview.YuzuPreview
import uvis.irin.yuzu.feature.wordgenerator.ui.model.UiLanguage

@Composable
internal fun LanguageOptions(
    modifier: Modifier = Modifier,
    selectedLanguage: UiLanguage,
    onClick: (UiLanguage) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SectionHeader(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = stringResource(R.string.language_options_header),
        )
        LanguageOptionRadioGroup(
            selectedLanguage = selectedLanguage,
            onClick = onClick,
        )
    }
}

@Composable
private fun LanguageOptionRadioGroup(
    modifier: Modifier = Modifier,
    selectedLanguage: UiLanguage,
    onClick: (UiLanguage) -> Unit,
) {
    Column(modifier = modifier.selectableGroup()) {
        LanguageRadioButton(
            modifier = Modifier.languageOptionModifier(
                language = UiLanguage.English,
                onClick = onClick,
            ),
            language = UiLanguage.English,
            selected = selectedLanguage == UiLanguage.English,
            onClick = onClick,
        )
        LanguageRadioButton(
            modifier = Modifier.languageOptionModifier(
                language = UiLanguage.Polish,
                onClick = onClick,
            ),
            language = UiLanguage.Polish,
            selected = selectedLanguage == UiLanguage.Polish,
            onClick = onClick,
        )
    }
}

@Composable
private fun Modifier.languageOptionModifier(
    language: UiLanguage,
    onClick: (UiLanguage) -> Unit,
) = this
    .clickable { onClick(language) }
    .padding(vertical = 4.dp, horizontal = 16.dp)

@Composable
private fun LanguageRadioButton(
    modifier: Modifier = Modifier,
    language: UiLanguage,
    selected: Boolean,
    onClick: (UiLanguage) -> Unit,
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
private fun headerForLanguage(language: UiLanguage) = when (language) {
    UiLanguage.English -> stringResource(R.string.english_language_header)
    UiLanguage.Polish -> stringResource(R.string.polish_language_header)
}

@Composable
private fun subtitleForLanguage(language: UiLanguage) = when (language) {
    UiLanguage.English -> stringResource(R.string.english_language_subtitle)
    UiLanguage.Polish -> stringResource(R.string.polish_language_subtitle)
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun LanguageOptionsPreview() {
    YuzuPreview {
        LanguageOptions(
            selectedLanguage = UiLanguage.English,
            onClick = {},
        )
    }
}
