package uvis.irin.core.designsystem.components.button

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.components.button.preview.ButtonPreviewParameterProvider
import uvis.irin.core.designsystem.icons.YuzuIcon
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
fun YuzuTextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    icon: YuzuIcon? = null,
    content: @Composable () -> Unit,
) {
    TextButton(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
    ) {
        if (icon != null) {
            YuzuIcon(icon = icon)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        }
        content()
    }
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun YuzuPrimaryButtonPreview(
    @PreviewParameter(ButtonPreviewParameterProvider::class) spec: ButtonPreviewParameterProvider.ButtonSpec,
) {
    YuzuPreview {
        YuzuTextButton(
            modifier = Modifier.padding(4.dp),
            onClick = {},
            enabled = spec.enabled,
            icon = spec.icon,
            content = { Text(spec.text) },
        )
    }
}
