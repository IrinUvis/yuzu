package uvis.irin.core.designsystem.preview

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import uvis.irin.core.designsystem.theme.YuzuTheme

@Composable
fun YuzuPreview(content: @Composable () -> Unit) {
    YuzuTheme {
        Surface {
            content()
        }
    }
}
