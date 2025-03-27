package uvis.irin.feature.wordgenerator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.components.animation.AnimatedNullableVisibility
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
internal fun GeneratedWordSection(
    modifier: Modifier = Modifier,
    generatedWord: String,
    generatedWordExplanation: String?,
    isExplanationGenerating: Boolean,
    onCopyClick: () -> Unit,
    onExplainMeaningClick: () -> Unit,
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GeneratedWord(generatedWord = generatedWord)
        GeneratedWordActions(
            isExplanationGenerating = isExplanationGenerating,
            onCopyClick = onCopyClick,
            onExplainMeaningClick = onExplainMeaningClick,
        )
        AnimatedNullableVisibility(generatedWordExplanation) { generatedWordExplanation ->
            GeneratedWordExplanation(explanation = generatedWordExplanation)
        }
    }
}

@Composable
private fun GeneratedWord(
    modifier: Modifier = Modifier,
    generatedWord: String,
) {
    Text(
        modifier = modifier,
        text = generatedWord,
        style = MaterialTheme.typography.titleMedium,
    )
}

@Composable
private fun GeneratedWordActions(
    modifier: Modifier = Modifier,
    isExplanationGenerating: Boolean,
    onCopyClick: () -> Unit,
    onExplainMeaningClick: () -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CopyWordButton(onClick = onCopyClick)
        ExplainWordIcon(
            isExplanationGenerating = isExplanationGenerating,
            onClick = onExplainMeaningClick,
        )
    }
}

@Composable
private fun GeneratedWordExplanation(
    modifier: Modifier = Modifier,
    explanation: String,
) {
    Text(
        modifier = modifier,
        text = explanation,
        style = MaterialTheme.typography.bodyMedium,
    )
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun GeneratedWordSectionPreview(
    @PreviewParameter(
        GeneratedWordSectionPreviewParameterProvider::class,
    ) spec: GeneratedWordSectionPreviewParameterProvider.GeneratedWordSectionPreviewSpec,
) {
    YuzuPreview {
        GeneratedWordSection(
            generatedWord = spec.generatedWord,
            generatedWordExplanation = spec.generatedWordExplanation,
            isExplanationGenerating = spec.isExplanationGenerating,
            onCopyClick = {},
            onExplainMeaningClick = {},
        )
    }
}

class GeneratedWordSectionPreviewParameterProvider :
    PreviewParameterProvider<GeneratedWordSectionPreviewParameterProvider.GeneratedWordSectionPreviewSpec> {
    override val values: Sequence<GeneratedWordSectionPreviewSpec> = sequenceOf(
        GeneratedWordSectionPreviewSpec(
            generatedWord = "word",
            generatedWordExplanation = null,
            isExplanationGenerating = false,
        ),
        GeneratedWordSectionPreviewSpec(
            generatedWord = "word",
            generatedWordExplanation = null,
            isExplanationGenerating = true,
        ),
        GeneratedWordSectionPreviewSpec(
            generatedWord = "word",
            generatedWordExplanation = "explanation",
            isExplanationGenerating = false,
        ),
        GeneratedWordSectionPreviewSpec(
            generatedWord = "word",
            generatedWordExplanation = "explanation",
            isExplanationGenerating = true,
        ),
    )

    data class GeneratedWordSectionPreviewSpec(
        val generatedWord: String,
        val generatedWordExplanation: String?,
        val isExplanationGenerating: Boolean,
    )
}
