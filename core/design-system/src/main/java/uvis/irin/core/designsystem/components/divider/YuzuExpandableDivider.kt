package uvis.irin.core.designsystem.components.divider

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.components.divider.preview.ExpandableDividerPreviewParameterProvider
import uvis.irin.core.designsystem.icons.YuzuIcon
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
fun YuzuExpandableDivider(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    label: String,
    onClick: () -> Unit,
    isExpanded: Boolean,
) {
    Column(
        modifier = modifier.clickable(onClick = onClick).padding(contentPadding),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        YuzuHorizontalDivider()
        DividerContent(
            label = label,
            onClick = onClick,
            isExpanded = isExpanded,
        )
    }
}

@Composable
private fun DividerContent(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    isExpanded: Boolean,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Header(modifier = Modifier.weight(1f), label = label)
        ExpandIcon(onClick = onClick, isExpanded = isExpanded)
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier,
    label: String,
) {
    Text(
        modifier = modifier,
        text = label,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        style = MaterialTheme.typography.titleSmall,
    )
}

@Composable
private fun ExpandIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isExpanded: Boolean,
) {
    val iconRotation by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
    )

    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        YuzuIcon(
            modifier = modifier.graphicsLayer { rotationZ = iconRotation },
            icon = YuzuIcon.ExpandMore,
        )
    }
}

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
            onClick = { },
        )
    }
}
