package uvis.irin.feature.wordgenerator.ui

import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import uvis.irin.core.designsystem.components.animation.AnimatedNullableVisibility
import uvis.irin.core.designsystem.components.divider.YuzuExpandableDivider
import uvis.irin.core.designsystem.components.topbar.YuzuTopBar
import uvis.irin.core.designsystem.icons.YuzuIcon
import uvis.irin.core.designsystem.preview.YuzuPreview
import uvis.irin.feature.wordgenerator.ui.components.DifficultyOptions
import uvis.irin.feature.wordgenerator.ui.components.GenerateWordButton
import uvis.irin.feature.wordgenerator.ui.components.GeneratedWordSection
import uvis.irin.feature.wordgenerator.ui.components.LanguageOptions
import uvis.irin.feature.wordgenerator.ui.components.PartsOfSpeechOptions
import uvis.irin.feature.wordgenerator.ui.model.GenerationDifficulty
import uvis.irin.feature.wordgenerator.ui.model.Language
import uvis.irin.feature.wordgenerator.ui.model.PartOfSpeech

@Composable
fun WordGeneratorScreen(
    modifier: Modifier = Modifier,
    viewModel: WordGeneratorViewModel = koinViewModel(),
) {
    val wordGenerationState = viewModel.wordGenerationState.collectAsStateWithLifecycle()

    WordGeneratorScreenRoot(
        modifier = modifier,
        wordGenerationState = wordGenerationState.value,
        onGenerateWordClick = viewModel::generateWord,
        onCopyClick = viewModel::copyGeneratedWord,
        onExplainMeaningClick = viewModel::explainGeneratedWord,
    )
}

@Composable
private fun WordGeneratorScreenRoot(
    modifier: Modifier = Modifier,
    wordGenerationState: WordGenerationState,
    onGenerateWordClick: () -> Unit,
    onCopyClick: () -> Unit,
    onExplainMeaningClick: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            YuzuTopBar(
                title = "Word generator",
                onNavigationIconClick = { },
                actions = {
                    IconButton(
                        modifier = modifier,
                        onClick = {},
                    ) {
                        YuzuIcon(icon = YuzuIcon.Help)
                    }
                },
            )
        },
    ) { contentPadding ->
        WordGeneratorContent(
            modifier = Modifier.padding(contentPadding),
            wordGenerationState = wordGenerationState,
            onGenerateWordClick = onGenerateWordClick,
            onCopyClick = onCopyClick,
            onExplainMeaningClick = onExplainMeaningClick,
        )
    }
}

@Composable
private fun WordGeneratorContent(
    modifier: Modifier = Modifier,
    wordGenerationState: WordGenerationState,
    onGenerateWordClick: () -> Unit,
    onCopyClick: () -> Unit,
    onExplainMeaningClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(top = 8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        WordGeneratorActions(
            wordGenerationState = wordGenerationState,
            onGenerateWordClick = onGenerateWordClick,
            onCopyClick = onCopyClick,
            onExplainMeaningClick = onExplainMeaningClick,
        )
        WordGenerationSettings()
    }
}

@Composable
private fun WordGeneratorActions(
    modifier: Modifier = Modifier,
    wordGenerationState: WordGenerationState,
    onGenerateWordClick: () -> Unit,
    onCopyClick: () -> Unit,
    onExplainMeaningClick: () -> Unit,
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GenerateWordButton(
            modifier = Modifier.padding(horizontal = 16.dp),
            isWordGenerating = wordGenerationState.isWordGenerating,
            isExplanationGenerating = wordGenerationState.isExplanationGenerating,
            onClick = onGenerateWordClick,
        )
        AnimatedNullableVisibility(
            value = wordGenerationState.generatedWord,
            enterTransition = fadeIn() + expandVertically(),
            exitTransition = fadeOut() + shrinkVertically(),
        ) { generatedWord ->
            GeneratedWordSection(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                generatedWord = generatedWord,
                isWordGenerating = wordGenerationState.isWordGenerating,
                generatedWordExplanation = wordGenerationState.generatedWordExplanation,
                isExplanationGenerating = wordGenerationState.isExplanationGenerating,
                onCopyClick = onCopyClick,
                onExplainMeaningClick = onExplainMeaningClick,
            )
        }
    }
}

@Composable
private fun WordGenerationSettings(modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(true) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        YuzuExpandableDivider(
            label = "Configure word generation",
            isExpanded = isExpanded,
            onClick = { isExpanded = !isExpanded },
        )
        if (isExpanded) {
            LanguageOptions(
                selectedLanguage = Language.English,
                onClick = { },
            )
            PartsOfSpeechOptions(
                selectedPartsOfSpeech = setOf(PartOfSpeech.Noun, PartOfSpeech.Verb),
                onClick = { },
            )
            DifficultyOptions(
                selectedDifficulty = setOf(GenerationDifficulty.CommonlyUsed),
                onClick = { },
            )
        }
    }
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun WordGeneratorScreenPreview() {
    YuzuPreview {
        WordGeneratorScreen()
    }
}
