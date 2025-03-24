package uvis.irin.core.designsystem.components.checkbox.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import uvis.irin.core.designsystem.preview.LongLoremIpsumText

internal class CheckboxOptionParameterProvider : PreviewParameterProvider<CheckboxOptionParameterProvider.OptionSpec> {
    override val values: Sequence<OptionSpec>
        get() = sequenceOf(
            OptionSpec(checked = false, header = "Header", subtitle = "Subtitle"),
            OptionSpec(checked = true, header = "Header", subtitle = "Subtitle"),
            OptionSpec(
                checked = false,
                header = "Header",
                subtitle = LongLoremIpsumText,
            ),
            OptionSpec(
                checked = true,
                header = "Header",
                subtitle = LongLoremIpsumText,
            ),
            OptionSpec(
                checked = false,
                header = "A very long header to test how it displays in the UI",
                subtitle = LongLoremIpsumText,
            ),
            OptionSpec(
                checked = true,
                header = "A very long header to test how it displays in the UI",
                subtitle = LongLoremIpsumText,
            ),
            OptionSpec(checked = false, header = "Header", subtitle = null),
            OptionSpec(checked = true, header = "Header", subtitle = null),

        )

    data class OptionSpec(
        val checked: Boolean,
        val header: String,
        val subtitle: String?,
    )
}
