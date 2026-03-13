package uvis.irin.yuzu.core.designsystem.icons

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uvis.irin.yuzu.core.designsystem.R
import uvis.irin.yuzu.core.designsystem.preview.YuzuPreview

enum class YuzuIcon(
    @param:DrawableRes val iconRes: Int,
    val contentDescription: String,
) {
    AiFeature(R.drawable.ai_feature, "AI Feature"),
    ArrowBack(R.drawable.arrow_back, "Arrow Back"),
    ContentCopy(R.drawable.content_copy, "Content Copy"),
    ExpandMore(R.drawable.expand_more, "Expand More"),
    Explain(R.drawable.explain, "Explain"),
    Help(R.drawable.help, "Help"),
}

@Composable
fun YuzuIcon(
    modifier: Modifier = Modifier,
    icon: YuzuIcon,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(icon.iconRes),
        contentDescription = icon.contentDescription,
    )
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun YuzuIconPreview() {
    YuzuPreview {
        YuzuIcon(icon = YuzuIcon.AiFeature)
    }
}
