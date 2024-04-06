package com.amadiyawa.feature_base.common.res

import androidx.compose.ui.unit.dp

/**
 * Contains dimension values that are used across the application.
 */
object Dimen {
    // Spacing dimensions
    object Spacing {
        val small = 4.dp
        val medium = 8.dp
        val large = 16.dp
        val extraLarge = 32.dp
        val extraExtraLarge = 64.dp
    }

    // Padding dimensions
    object Padding {
        val screenContent = Spacing.large
    }

    // Image dimensions
    object Image {
        val size = 100.dp
    }

    // Picture dimensions
    object Picture {
        val smallSize = 48.dp
        val mediumSize = 72.dp
    }
}
