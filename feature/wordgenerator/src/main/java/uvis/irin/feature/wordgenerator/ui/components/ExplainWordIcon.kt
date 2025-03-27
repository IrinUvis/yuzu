package uvis.irin.feature.wordgenerator.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.icons.YuzuIcon

@Composable
internal fun ExplainWordIcon(
    modifier: Modifier = Modifier,
    isExplanationGenerating: Boolean,
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier,
        enabled = !isExplanationGenerating,
        onClick = onClick,
    ) {
        AnimatedContent(isExplanationGenerating) { isExplanationGenerating ->
            if (isExplanationGenerating) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp,
                )
            } else {
                YuzuIcon(icon = YuzuIcon.Explain)
            }
        }
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Explain meaning")
    }
}
