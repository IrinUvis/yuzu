package uvis.irin.yuzu.feature.wordgenerator.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import uvis.irin.yuzu.core.designsystem.icons.YuzuIcon
import uvis.irin.yuzu.core.designsystem.preview.YuzuPreview
import uvis.irin.yuzu.feature.wordgenerator.R

@Composable
internal fun GenerateWordButton(
    modifier: Modifier = Modifier,
    isWordGenerating: Boolean,
    wordGenerationAvailable: Boolean,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = wordGenerationAvailable,
    ) {
        AnimatedContent(isWordGenerating) { isWordGenerating ->
            if (isWordGenerating) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp,
                )
            } else {
                YuzuIcon(icon = YuzuIcon.AiFeature)
            }
        }
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = stringResource(R.string.generate_word_button_label))
    }
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun GenerateWordButtonPreview(
    @PreviewParameter(
        GenerateWordButtonPreviewParameterProvider::class,
    ) spec: GenerateWordButtonPreviewParameterProvider.GenerateWordPreviewSpec,
) {
    YuzuPreview {
        GenerateWordButton(
            isWordGenerating = spec.isWordGenerating,
            wordGenerationAvailable = spec.wordGenerationAvailable,
            onClick = {},
        )
    }
}

private class GenerateWordButtonPreviewParameterProvider :
    PreviewParameterProvider<GenerateWordButtonPreviewParameterProvider.GenerateWordPreviewSpec> {
    override val values: Sequence<GenerateWordPreviewSpec> = sequenceOf(
        GenerateWordPreviewSpec(isWordGenerating = false, wordGenerationAvailable = false),
        GenerateWordPreviewSpec(isWordGenerating = false, wordGenerationAvailable = true),
        GenerateWordPreviewSpec(isWordGenerating = true, wordGenerationAvailable = false),
        GenerateWordPreviewSpec(isWordGenerating = true, wordGenerationAvailable = true),
    )

    data class GenerateWordPreviewSpec(
        val isWordGenerating: Boolean,
        val wordGenerationAvailable: Boolean,
    )
}
