package uvis.irin.feature.wordgenerator.ui

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
import uvis.irin.feature.wordgenerator.R
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
    val generationSettingsState = viewModel.generationSettingsState.collectAsStateWithLifecycle()

    WordGeneratorScreenRoot(
        modifier = modifier,
        wordGenerationState = wordGenerationState.value,
        generationSettingsState = generationSettingsState.value,
        onGenerateWordClick = viewModel::generateWord,
        onExplainMeaningClick = viewModel::explainGeneratedWord,
        onSettingsHeaderClick = viewModel::toggleSettingsExpanded,
        onLanguageClick = viewModel::toggleLanguageSetting,
        onPartOfSpeechClick = viewModel::togglePartOfSpeechSetting,
        onGenerationDifficultyClick = viewModel::toggleGenerationDifficultySetting,
    )
}

@Composable
private fun WordGeneratorScreenRoot(
    modifier: Modifier = Modifier,
    wordGenerationState: WordGenerationState,
    generationSettingsState: GenerationSettingsState,
    onGenerateWordClick: () -> Unit,
    onExplainMeaningClick: () -> Unit,
    onSettingsHeaderClick: () -> Unit,
    onLanguageClick: (Language) -> Unit,
    onPartOfSpeechClick: (PartOfSpeech) -> Unit,
    onGenerationDifficultyClick: (GenerationDifficulty) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            YuzuTopBar(
                title = stringResource(R.string.word_generator_top_bar_title),
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
            generationSettingsState = generationSettingsState,
            onGenerateWordClick = onGenerateWordClick,
            onExplainMeaningClick = onExplainMeaningClick,
            onSettingsHeaderClick = onSettingsHeaderClick,
            onLanguageClick = onLanguageClick,
            onPartOfSpeechClick = onPartOfSpeechClick,
            onGenerationDifficultyClick = onGenerationDifficultyClick,
        )
    }
}

@Composable
private fun WordGeneratorContent(
    modifier: Modifier = Modifier,
    wordGenerationState: WordGenerationState,
    generationSettingsState: GenerationSettingsState,
    onGenerateWordClick: () -> Unit,
    onExplainMeaningClick: () -> Unit,
    onSettingsHeaderClick: () -> Unit,
    onLanguageClick: (Language) -> Unit,
    onPartOfSpeechClick: (PartOfSpeech) -> Unit,
    onGenerationDifficultyClick: (GenerationDifficulty) -> Unit,
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
            onExplainMeaningClick = onExplainMeaningClick,
        )
        WordGenerationSettings(
            generationSettingsState = generationSettingsState,
            onSettingsHeaderClick = onSettingsHeaderClick,
            onLanguageClick = onLanguageClick,
            onPartOfSpeechClick = onPartOfSpeechClick,
            onGenerationDifficultyClick = onGenerationDifficultyClick,
        )
    }
}

@Composable
private fun WordGeneratorActions(
    modifier: Modifier = Modifier,
    wordGenerationState: WordGenerationState,
    onGenerateWordClick: () -> Unit,
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
                onExplainMeaningClick = onExplainMeaningClick,
            )
        }
    }
}

@Composable
private fun WordGenerationSettings(
    modifier: Modifier = Modifier,
    generationSettingsState: GenerationSettingsState,
    onSettingsHeaderClick: () -> Unit,
    onLanguageClick: (Language) -> Unit,
    onPartOfSpeechClick: (PartOfSpeech) -> Unit,
    onGenerationDifficultyClick: (GenerationDifficulty) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        YuzuExpandableDivider(
            label = stringResource(R.string.configure_word_generation_settings_header),
            isExpanded = generationSettingsState.isSettingsExpanded,
            onClick = onSettingsHeaderClick,
        )
        AnimatedVisibility(generationSettingsState.isSettingsExpanded) {
            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                LanguageOptions(
                    selectedLanguage = generationSettingsState.selectedLanguage,
                    onClick = onLanguageClick,
                )
                PartsOfSpeechOptions(
                    selectedPartsOfSpeech = generationSettingsState.selectedPartsOfSpeech,
                    onClick = onPartOfSpeechClick,
                )
                DifficultyOptions(
                    selectedDifficulties = generationSettingsState.selectedDifficulties,
                    onClick = onGenerationDifficultyClick,
                )
            }
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
