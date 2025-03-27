package uvis.irin.feature.wordgenerator.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.icons.YuzuIcon
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
internal fun ExplainWordButton(
    modifier: Modifier = Modifier,
    isWordGenerating: Boolean,
    isExplanationGenerating: Boolean,
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier,
        enabled = !(isExplanationGenerating || isWordGenerating),
        onClick = onClick,
    ) {
        AnimatedContent(isExplanationGenerating) { isExplanationGenerating ->
            if (isExplanationGenerating) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp,
                )
            } else {
                YuzuIcon(icon = YuzuIcon.Explain)
            }
        }
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Explain meaning")
    }
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun GenerateWordButtonPreview(
    @PreviewParameter(
        ExplainWordButtonPreviewParameterProvider::class,
    ) spec: ExplainWordButtonPreviewParameterProvider.ExplainWordPreviewSpec,
) {
    YuzuPreview {
        ExplainWordButton(
            isWordGenerating = spec.isWordGenerating,
            isExplanationGenerating = spec.isExplanationGenerating,
            onClick = {},
        )
    }
}

private class ExplainWordButtonPreviewParameterProvider :
    PreviewParameterProvider<ExplainWordButtonPreviewParameterProvider.ExplainWordPreviewSpec> {
    override val values: Sequence<ExplainWordPreviewSpec> = sequenceOf(
        ExplainWordPreviewSpec(isWordGenerating = false, isExplanationGenerating = false),
        ExplainWordPreviewSpec(isWordGenerating = false, isExplanationGenerating = true),
        ExplainWordPreviewSpec(isWordGenerating = true, isExplanationGenerating = false),
        ExplainWordPreviewSpec(isWordGenerating = true, isExplanationGenerating = true),
    )

    data class ExplainWordPreviewSpec(
        val isWordGenerating: Boolean,
        val isExplanationGenerating: Boolean,
    )
}
