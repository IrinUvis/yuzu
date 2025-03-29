package uvis.irin.feature.wordgenerator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.preview.YuzuPreview
import uvis.irin.feature.wordgenerator.R

@Composable
internal fun HelpBottomSheetContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        HelpTitle()
        HelpDescription()
    }
}

@Composable
private fun HelpTitle(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.word_generator_help_title),
        style = MaterialTheme.typography.headlineMedium,
    )
}

@Composable
private fun HelpDescription(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = stringResource(R.string.word_generator_help_description_1),
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            text = stringResource(R.string.word_generator_help_description_2),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun HelpBottomSheetPreview() {
    YuzuPreview {
        HelpBottomSheetContent()
    }
}
