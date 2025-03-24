@file:OptIn(ExperimentalMaterial3Api::class)

package uvis.irin.feature.wordgenerator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.components.button.YuzuFilledButton
import uvis.irin.core.designsystem.components.button.YuzuIconButton
import uvis.irin.core.designsystem.components.button.YuzuOutlinedButton
import uvis.irin.core.designsystem.components.button.YuzuTextButton
import uvis.irin.core.designsystem.components.topbar.YuzuTopBar
import uvis.irin.core.designsystem.icons.YuzuIcon
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
fun WordGeneratorScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            YuzuTopBar(
                title = "Word generator",
                onNavigationIconClick = { },
                actions = {
                    YuzuIconButton(
                        modifier = modifier,
                        onClick = { },
                        icon = YuzuIcon.Help,
                    )
                },
            )
        },
    ) { contentPadding ->
        WordGeneratorContent(modifier = Modifier.padding(contentPadding))
    }
}

@Composable
private fun WordGeneratorContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        WordGeneratorActions()
    }
}

@Composable
private fun WordGeneratorActions(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GenerateWordButton(onClick = {})
        GeneratedWordContent()
    }
}

@Composable
private fun GenerateWordButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    YuzuFilledButton(
        modifier = modifier,
        onClick = onClick,
        icon = YuzuIcon.AiFeature,
    ) {
        Text(text = "Generate a word")
    }
}

@Composable
private fun GeneratedWordContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GeneratedWord()
        GeneratedWordActions()
        GeneratedWordDescription()
    }
}

@Composable
private fun GeneratedWord(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = "cockroach",
        style = MaterialTheme.typography.titleMedium,
    )
}

@Composable
private fun GeneratedWordActions(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        YuzuTextButton(
            onClick = {},
            icon = YuzuIcon.ContentCopy,
        ) {
            Text(text = "Copy")
        }
        YuzuOutlinedButton(
            onClick = {},
            icon = YuzuIcon.Explain,
        ) {
            Text(text = "Explain meaning")
        }
    }
}

@Composable
private fun GeneratedWordDescription(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = "A cockroach is a hardy insect, often considered a pest, " +
            "that thrives in human environments, particularly warm and " +
            "damp places where food is readily available.",
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Preview
@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun WordGeneratorScreenPreview() {
    YuzuPreview {
        WordGeneratorScreen()
    }
}
