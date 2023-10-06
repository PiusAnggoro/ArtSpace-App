package id.piusanggoro.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.piusanggoro.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var position by remember { mutableStateOf(1) }
    val imageRes = when (position) {
        1 -> R.drawable.villeneuve
        2 -> R.drawable.starrynight
        3 -> R.drawable.persistencememory
        else -> R.drawable.ic_launcher_background
    }
    val artworkTitle = when (position) {
        1 -> R.string.artwork1
        2 -> R.string.artwork2
        3 -> R.string.artwork3
        else -> R.string.artwork1
    }
    val artworkArtist = when (position) {
        1 -> R.string.artist1
        2 -> R.string.artist2
        3 -> R.string.artist3
        else -> R.string.artist1
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .size(height = 500.dp, width = 350.dp)
                .shadow(12.dp, RectangleShape)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .border(BorderStroke(30.dp, SolidColor(Color.White)), RectangleShape)
                    .shadow(12.dp, RectangleShape)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .size(300.dp, 100.dp)
                .scale(1f)
                .padding(15.dp)
                .background(Color.LightGray)
                .wrapContentSize(Alignment.Center)
            ) {
            Text(
                text = stringResource(artworkTitle),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(artworkArtist),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier= Modifier.size(width = 150.dp, height =50.dp),
                onClick = {position = when (position) {1 -> 1 else -> --position }
                }) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(50.dp))
            Button(
                modifier= Modifier.size(width = 150.dp, height =50.dp),
                onClick = {position = when (position) { in 1..2 -> ++position else -> 1}
                }) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}
