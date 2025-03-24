package uvis.irin.core.designsystem.components.radio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.components.radio.preview.RadioOptionParameterProvider
import uvis.irin.core.designsystem.components.text.HeaderWithSubtitle
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
fun YuzuRadioOption(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
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
        RadioButton(
            selected = selected,
            onClick = onClick,
        )
    }
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun YuzuRadioOptionPreview(
    @PreviewParameter(RadioOptionParameterProvider::class) spec: RadioOptionParameterProvider.OptionSpec,
) {
    YuzuPreview {
        YuzuRadioOption(
            selected = spec.selected,
            onClick = { },
        ) {
            HeaderWithSubtitle(
                header = spec.header,
                subtitle = spec.subtitle,
            )
        }
    }
}
