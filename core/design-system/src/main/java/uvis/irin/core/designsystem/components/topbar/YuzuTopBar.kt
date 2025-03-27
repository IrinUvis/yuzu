@file:OptIn(ExperimentalMaterial3Api::class)

package uvis.irin.core.designsystem.components.topbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uvis.irin.core.designsystem.icons.YuzuIcon
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
fun YuzuTopBar(
    modifier: Modifier = Modifier,
    title: String,
    onNavigationIconClick: () -> Unit,
    navigationIcon: @Composable () -> Unit = {
        IconButton(onClick = onNavigationIconClick) {
            YuzuIcon(icon = YuzuIcon.ArrowBack)
        }
    },
    actions: @Composable (RowScope.() -> Unit) = {},
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(title) },
        navigationIcon = navigationIcon,
        actions = actions,
    )
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun YuzuTopBarPreview() {
    YuzuPreview {
        YuzuTopBar(
            title = "Top bar",
            onNavigationIconClick = { },
        )
    }
}
