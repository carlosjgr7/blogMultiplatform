package org.carlosjgr7.blogweb.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue,
) {
    Primary(
        hex = "#00A2FF",
        rgb = rgb(r = 0, g = 162, b = 255),
    ),
    LightGray(
        hex = "#F5F5F5",
        rgb = rgb(r = 245, g = 245, b = 245),
    ),
}
