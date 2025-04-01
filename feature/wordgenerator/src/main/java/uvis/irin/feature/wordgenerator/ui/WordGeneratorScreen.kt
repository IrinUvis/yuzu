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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
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
import uvis.irin.feature.wordgenerator.R
import uvis.irin.feature.wordgenerator.ui.components.DifficultyOptions
import uvis.irin.feature.wordgenerator.ui.components.GenerateWordButton
import uvis.irin.feature.wordgenerator.ui.components.GeneratedWordSection
import uvis.irin.feature.wordgenerator.ui.components.HelpBottomSheetContent
import uvis.irin.feature.wordgenerator.ui.components.LanguageOptions
import uvis.irin.feature.wordgenerator.ui.components.PartsOfSpeechOptions
import uvis.irin.feature.wordgenerator.ui.model.UiDifficulty
import uvis.irin.feature.wordgenerator.ui.model.UiLanguage
import uvis.irin.feature.wordgenerator.ui.model.UiPartOfSpeech
import uvis.irin.yuzu.core.designsystem.components.animation.AnimatedNullableVisibility
import uvis.irin.yuzu.core.designsystem.components.divider.YuzuExpandableDivider
import uvis.irin.yuzu.core.designsystem.components.topbar.YuzuTopBar
import uvis.irin.yuzu.core.designsystem.icons.YuzuIcon
import uvis.irin.yuzu.core.designsystem.preview.YuzuPreview

@Composable
fun WordGeneratorScreen(
    modifier: Modifier = Modifier,
    viewModel: WordGeneratorViewModel = koinViewModel(),
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    WordGeneratorScreenRoot(
        modifier = modifier,
        wordGeneratorUiState = uiState.value,
        onHelpClick = viewModel::openHelpSheet,
        onHelpSheetDismissed = viewModel::hideHelpSheet,
        onGenerateWordClick = viewModel::generateWord,
        onExplainMeaningClick = viewModel::explainGeneratedWord,
        onSettingsHeaderClick = viewModel::toggleSettingsExpanded,
        onLanguageClick = viewModel::toggleLanguageSetting,
        onPartOfSpeechClick = viewModel::togglePartOfSpeechSetting,
        onGenerationDifficultyClick = viewModel::toggleGenerationDifficultySetting,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WordGeneratorScreenRoot(
    modifier: Modifier = Modifier,
    wordGeneratorUiState: WordGeneratorUiState,
    onHelpClick: () -> Unit,
    onHelpSheetDismissed: () -> Unit,
    onGenerateWordClick: () -> Unit,
    onExplainMeaningClick: () -> Unit,
    onSettingsHeaderClick: () -> Unit,
    onLanguageClick: (UiLanguage) -> Unit,
    onPartOfSpeechClick: (UiPartOfSpeech) -> Unit,
    onGenerationDifficultyClick: (UiDifficulty) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            WordGeneratorTopBar(
                onHelpClick = onHelpClick,
            )
        },
    ) { contentPadding ->
        WordGeneratorContent(
            modifier = Modifier.padding(contentPadding),
            wordGeneratorUiState = wordGeneratorUiState,
            onGenerateWordClick = onGenerateWordClick,
            onExplainMeaningClick = onExplainMeaningClick,
            onSettingsHeaderClick = onSettingsHeaderClick,
            onLanguageClick = onLanguageClick,
            onPartOfSpeechClick = onPartOfSpeechClick,
            onGenerationDifficultyClick = onGenerationDifficultyClick,
        )
        if (wordGeneratorUiState.helpVisible) {
            ModalBottomSheet(onDismissRequest = onHelpSheetDismissed) {
                HelpBottomSheetContent(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                )
            }
        }
    }
}

@Composable
private fun WordGeneratorTopBar(
    modifier: Modifier = Modifier,
    onHelpClick: () -> Unit,
) {
    YuzuTopBar(
        modifier = modifier,
        title = stringResource(R.string.word_generator_top_bar_title),
        onNavigationIconClick = {},
        navigationIcon = {},
        actions = {
            IconButton(
                modifier = modifier,
                onClick = onHelpClick,
            ) {
                YuzuIcon(icon = YuzuIcon.Help)
            }
        },
    )
}

@Composable
private fun WordGeneratorContent(
    modifier: Modifier = Modifier,
    wordGeneratorUiState: WordGeneratorUiState,
    onGenerateWordClick: () -> Unit,
    onExplainMeaningClick: () -> Unit,
    onSettingsHeaderClick: () -> Unit,
    onLanguageClick: (UiLanguage) -> Unit,
    onPartOfSpeechClick: (UiPartOfSpeech) -> Unit,
    onGenerationDifficultyClick: (UiDifficulty) -> Unit,
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
            wordGeneration = wordGeneratorUiState.wordGeneration,
            wordExplanationGeneration = wordGeneratorUiState.wordExplanationGeneration,
            wordGenerationAvailable = wordGeneratorUiState.wordGenerationAvailable,
            onGenerateWordClick = onGenerateWordClick,
            onExplainMeaningClick = onExplainMeaningClick,
        )
        WordGenerationSettings(
            generationSettings = wordGeneratorUiState.generationSettings,
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
    wordGeneration: Generation,
    wordExplanationGeneration: Generation,
    wordGenerationAvailable: Boolean,
    onGenerateWordClick: () -> Unit,
    onExplainMeaningClick: () -> Unit,
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GenerateWordButton(
            modifier = Modifier.padding(horizontal = 16.dp),
            isWordGenerating = wordGeneration.isGenerating,
            wordGenerationAvailable = wordGenerationAvailable,
            onClick = onGenerateWordClick,
        )
        AnimatedNullableVisibility(
            value = wordGeneration.generation,
            enterTransition = fadeIn() + expandVertically(),
            exitTransition = fadeOut() + shrinkVertically(),
        ) { generatedWord ->
            GeneratedWordSection(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                generatedWord = generatedWord,
                isWordGenerating = wordGeneration.isGenerating,
                wordExplanationGeneration = wordExplanationGeneration,
                onExplainMeaningClick = onExplainMeaningClick,
            )
        }
    }
}

@Composable
private fun WordGenerationSettings(
    modifier: Modifier = Modifier,
    generationSettings: GenerationSettings,
    onSettingsHeaderClick: () -> Unit,
    onLanguageClick: (UiLanguage) -> Unit,
    onPartOfSpeechClick: (UiPartOfSpeech) -> Unit,
    onGenerationDifficultyClick: (UiDifficulty) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        YuzuExpandableDivider(
            label = stringResource(R.string.configure_word_generation_settings_header),
            isExpanded = generationSettings.isSettingsExpanded,
            onClick = onSettingsHeaderClick,
        )
        AnimatedVisibility(generationSettings.isSettingsExpanded) {
            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                LanguageOptions(
                    selectedLanguage = generationSettings.selectedLanguage,
                    onClick = onLanguageClick,
                )
                PartsOfSpeechOptions(
                    selectedPartsOfSpeech = generationSettings.selectedPartsOfSpeech,
                    onClick = onPartOfSpeechClick,
                )
                DifficultyOptions(
                    selectedDifficulties = generationSettings.selectedDifficulties,
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
