@file:OptIn(ExperimentalMaterial3Api::class)

package uvis.irin.feature.wordgenerator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.components.button.YuzuIconButton
import uvis.irin.core.designsystem.components.topbar.YuzuTopBar
import uvis.irin.core.designsystem.icons.YuzuIcon
import uvis.irin.core.designsystem.preview.YuzuPreview
import uvis.irin.feature.wordgenerator.ui.components.GenerateWordButton
import uvis.irin.feature.wordgenerator.ui.components.GeneratedWordSection

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
        GeneratedWordSection()
    }
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
