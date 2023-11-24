package org.carlosjgr7.blogweb.pages.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.outline
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.carlosjgr7.blogweb.models.Theme
import org.carlosjgr7.blogweb.util.Constans.FONT_FAMILY
import org.carlosjgr7.blogweb.util.Res
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Input

@Page
@Composable
fun LoginScreen() {
    var errorText by remember { mutableStateOf("") }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .padding(leftRight = 50.px, top = 80.px, bottom = 24.px)
                .backgroundColor(Theme.LightGray.rgb),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier.width(300.px),
                src = Res.Image.LOGO,
                description = "Logo image",
            )
            Input(
                type = InputType.Text,
                attrs = Modifier
                    .width(350.px)
                    .height(54.px)
                    .padding(leftRight = 20.px)
                    .margin(bottom = 6.px)
                    .backgroundColor(Color.white)
                    .fontFamily(FONT_FAMILY)
                    .border(
                        0.px,
                        LineStyle.None,
                    )
                    .outline(
                        style = LineStyle.None,
                    )
                    .toAttrs {
                        placeholder("Username")
                    },
            )

            Input(
                type = InputType.Password,
                attrs = Modifier
                    .width(350.px)
                    .height(54.px)
                    .padding(leftRight = 20.px)
                    .margin(bottom = 6.px)
                    .backgroundColor(Color.white)
                    .fontFamily(FONT_FAMILY)
                    .border(
                        0.px,
                        LineStyle.None,
                    )
                    .outline(
                        style = LineStyle.None,
                    )
                    .toAttrs {
                        placeholder("Password")
                    },
            )
            Button(
                attrs = Modifier
                    .width(350.px)
                    .height(54.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Color.white)
                    .borderRadius(10.px)
                    .border(style = LineStyle.None)
                    .fontWeight(FontWeight.Medium)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(16.px)
                    .margin(bottom = 24.px)
                    .toAttrs(),
            ) {
                SpanText("Sing in")
            }
            SpanText(
                modifier = Modifier
                    .width(350.px)
                    .color(Color.red)
                    .textAlign(TextAlign.Center),
                text = errorText,
            )
        }
    }
}
