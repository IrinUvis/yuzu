package uvis.irin.core.designsystem.components.divider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.components.button.YuzuIconButton
import uvis.irin.core.designsystem.components.divider.preview.ExpandableDividerPreviewParameterProvider
import uvis.irin.core.designsystem.icons.YuzuIcon
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
fun YuzuExpandableDivider(
    modifier: Modifier = Modifier,
    label: String,
    isExpanded: Boolean,
    onExpandClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        YuzuHorizontalDivider()
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = label,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.titleSmall,
            )

            // Add animation for expansion
            if (isExpanded) {
                YuzuIconButton(
                    onClick = onExpandClick,
                    icon = YuzuIcon.ExpandMore,
                )
            }
        }
    }
}

@Preview
@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun YuzuExpandableDividerPreview(
    @PreviewParameter(
        ExpandableDividerPreviewParameterProvider::class,
    ) spec: ExpandableDividerPreviewParameterProvider.ExpandableDividerSpec,
) {
    YuzuPreview {
        YuzuExpandableDivider(
            modifier = Modifier.padding(4.dp),
            label = spec.label,
            isExpanded = spec.isExpanded,
            onExpandClick = { },
        )
    }
}
