package uvis.irin.core.designsystem.components.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.Ref

@Composable
inline fun <T> AnimatedNullableVisibility(
    value: T?,
    modifier: Modifier = Modifier,
    enterTransition: EnterTransition = fadeIn() + expandIn(),
    exitTransition: ExitTransition = shrinkOut() + fadeOut(),
    crossinline content: @Composable AnimatedVisibilityScope.(value: T) -> Unit,
) {
    val ref = remember { Ref<T>() }
    ref.value = value ?: ref.value

    AnimatedVisibility(
        modifier = modifier,
        visible = value != null,
        enter = enterTransition,
        exit = exitTransition,
    ) {
        ref.value?.let { value ->
            content(value)
        }
    }
}
