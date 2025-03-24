package uvis.irin.core.designsystem.components.checkbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.components.checkbox.preview.CheckboxOptionParameterProvider
import uvis.irin.core.designsystem.components.text.HeaderWithSubtitle
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
fun YuzuCheckboxOption(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    option: @Composable () -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(modifier = Modifier.weight(1f)) {
            option()
        }
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
        )
    }
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun YuzuCheckboxOptionPreview(
    @PreviewParameter(CheckboxOptionParameterProvider::class) spec: CheckboxOptionParameterProvider.OptionSpec,
) {
    YuzuPreview {
        YuzuCheckboxOption(
            checked = spec.checked,
            onCheckedChange = { },
        ) {
            HeaderWithSubtitle(
                header = spec.header,
                subtitle = spec.subtitle,
            )
        }
    }
}
