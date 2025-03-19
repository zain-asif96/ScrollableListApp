package com.example.scrollablelistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrollablelistapp.model.DataSource
import com.example.scrollablelistapp.model.FamousLandMark
import com.example.scrollablelistapp.ui.theme.ScrollableListAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableListAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FamousLandMarkApp()
                }
            }
        }
    }
}

@Composable
fun FamousLandMarkApp() {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            ),
    ) {
        LandMarkList(
            landMarkList = DataSource().loadDataSources(),
        )
    }
}


@Composable
fun LandMarkList(landMarkList: List<FamousLandMark>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(landMarkList){landMark ->
            LandMarkCard(
                famousLandMark = landMark,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun LandMarkCard(
    famousLandMark: FamousLandMark,
    modifier:Modifier = Modifier
){
    Card(modifier=modifier) {
        Column {
            Image(
                painter = painterResource(
                    id = famousLandMark.imageID
                ),
                contentDescription = stringResource(id = famousLandMark.titleID),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(famousLandMark.titleID),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = LocalContext.current.getString(famousLandMark.descriptionID),
                modifier = Modifier.padding(12.dp),
                style = MaterialTheme.typography.bodyLarge
            )

        }
    }
}

@Preview
@Composable
private fun LandMarkCardPreview() {
    LandMarkCard(FamousLandMark(R.string.title1, R.string.description1, R.drawable.bigben))
}