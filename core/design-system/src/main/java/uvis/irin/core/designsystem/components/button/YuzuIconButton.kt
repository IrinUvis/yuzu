package uvis.irin.core.designsystem.components.button

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import uvis.irin.core.designsystem.icons.YuzuIcon
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
fun YuzuIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: YuzuIcon,
) {
    IconButton(modifier = modifier, onClick = onClick) {
        Icon(
            painter = painterResource(icon.iconRes),
            contentDescription = icon.contentDescription,
        )
    }
}

@Preview
@Composable
private fun YuzuIconButtonPreview() {
    YuzuPreview {
        YuzuIconButton(
            onClick = { },
            icon = YuzuIcon.AiFeature,
        )
    }
}
