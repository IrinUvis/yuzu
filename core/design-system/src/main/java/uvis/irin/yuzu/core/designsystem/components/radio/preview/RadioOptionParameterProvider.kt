package uvis.irin.yuzu.core.designsystem.components.radio.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import uvis.irin.yuzu.core.designsystem.preview.LongLoremIpsumText

internal class RadioOptionParameterProvider :
    PreviewParameterProvider<RadioOptionParameterProvider.OptionSpec> {
    override val values: Sequence<OptionSpec>
        get() = sequenceOf(
            OptionSpec(selected = false, header = "Header", subtitle = "Subtitle"),
            OptionSpec(selected = true, header = "Header", subtitle = "Subtitle"),
            OptionSpec(
                selected = false,
                header = "Header",
                subtitle = LongLoremIpsumText,
            ),
            OptionSpec(
                selected = true,
                header = "Header",
                subtitle = LongLoremIpsumText,
            ),
            OptionSpec(
                selected = false,
                header = "A very long header to test how it displays in the UI",
                subtitle = LongLoremIpsumText,
            ),
            OptionSpec(
                selected = true,
                header = "A very long header to test how it displays in the UI",
                subtitle = LongLoremIpsumText,
            ),
            OptionSpec(selected = false, header = "Header", subtitle = null),
            OptionSpec(selected = true, header = "Header", subtitle = null),

        )

    data class OptionSpec(
        val selected: Boolean,
        val header: String,
        val subtitle: String?,
    )
}
