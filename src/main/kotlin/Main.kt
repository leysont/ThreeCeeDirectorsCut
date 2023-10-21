import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.mayakapps.compose.windowstyler.WindowBackdrop
import com.mayakapps.compose.windowstyler.WindowStyle


@Composable
@Preview
fun App() {
    val model = remember { VehicleViewModel() }

    MaterialTheme(
        colors = darkColors(
            onSurface = darkColors().onSurface.copy(0.6f)
        ),
        typography = typoMavenPro()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Sidebar(
                width = 250.dp,
                model = model
            )
            S(12.dp)
            MainPage(model)
        }

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        WindowStyle(
            isDarkTheme = true,
            backdropType = WindowBackdrop.Mica
        )
        App()
    }
}

val mavenProFontFamily = FontFamily(
    Font(resource = "font/MavenPro-Black.ttf", weight = FontWeight.Black),
    Font(resource = "font/MavenPro-Bold.ttf", weight = FontWeight.Bold),
    Font(resource = "font/MavenPro-ExtraBold.ttf", weight = FontWeight.ExtraBold),
    Font(resource = "font/MavenPro-Medium.ttf", weight = FontWeight.Medium),
    Font(resource = "font/MavenPro-Regular.ttf", weight = FontWeight.Normal),
    Font(resource = "font/MavenPro-SemiBold.ttf", weight = FontWeight.SemiBold),
)

@Composable
fun typoMavenPro() = Typography(
    defaultFontFamily = mavenProFontFamily,
    h1 = MaterialTheme.typography.h1.copy(fontFamily = mavenProFontFamily),
    h2 = MaterialTheme.typography.h2.copy(fontFamily = mavenProFontFamily),
    h3 = MaterialTheme.typography.h3.copy(fontFamily = mavenProFontFamily),
    h4 = MaterialTheme.typography.h4.copy(fontFamily = mavenProFontFamily),
    h5 = MaterialTheme.typography.h5.copy(fontFamily = mavenProFontFamily),
    h6 = MaterialTheme.typography.h6.copy(fontFamily = mavenProFontFamily),
    subtitle1 = MaterialTheme.typography.subtitle1.copy(fontFamily = mavenProFontFamily),
    subtitle2 = MaterialTheme.typography.subtitle2.copy(fontFamily = mavenProFontFamily),
    body1 = MaterialTheme.typography.body1.copy(fontFamily = mavenProFontFamily),
    body2 = MaterialTheme.typography.body2.copy(fontFamily = mavenProFontFamily),
    button = MaterialTheme.typography.button.copy(fontFamily = mavenProFontFamily),
    caption = MaterialTheme.typography.caption.copy(fontFamily = mavenProFontFamily),
    overline = MaterialTheme.typography.overline.copy(fontFamily = mavenProFontFamily),
)