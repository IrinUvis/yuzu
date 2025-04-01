package uvis.irin.yuzu.core.designsystem.components.divider.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import uvis.irin.yuzu.core.designsystem.preview.LongLoremIpsumText

internal class ExpandableDividerPreviewParameterProvider :
    PreviewParameterProvider<ExpandableDividerPreviewParameterProvider.ExpandableDividerSpec> {

    data class ExpandableDividerSpec(
        val label: String = "Settings",
        val isExpanded: Boolean = false,
    )

    override val values: Sequence<ExpandableDividerSpec>
        get() = sequenceOf(
            ExpandableDividerSpec(),
            ExpandableDividerSpec(isExpanded = true),
            ExpandableDividerSpec(label = LongLoremIpsumText),
            ExpandableDividerSpec(label = LongLoremIpsumText, isExpanded = true),
        )
}
