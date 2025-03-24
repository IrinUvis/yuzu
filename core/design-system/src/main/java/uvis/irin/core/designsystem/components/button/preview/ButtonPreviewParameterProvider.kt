package uvis.irin.core.designsystem.components.button.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import uvis.irin.core.designsystem.icons.YuzuIcon

internal class ButtonPreviewParameterProvider : PreviewParameterProvider<ButtonPreviewParameterProvider.ButtonSpec> {
    override val values: Sequence<ButtonSpec>
        get() = sequenceOf(
            ButtonSpec(),
            ButtonSpec(enabled = false),
            ButtonSpec(icon = YuzuIcon.AiFeature),
            ButtonSpec(icon = YuzuIcon.AiFeature, enabled = false),
            ButtonSpec(text = "Lorem ipsum dolor sit amet"),
            ButtonSpec(icon = YuzuIcon.AiFeature, text = "Lorem ipsum dolor sit amet"),
            ButtonSpec(icon = YuzuIcon.AiFeature, text = "Lorem ipsum dolor sit amet", enabled = false),
        )

    data class ButtonSpec(
        val icon: YuzuIcon? = null,
        val text: String = "Click me!",
        val enabled: Boolean = true,
    )
}
