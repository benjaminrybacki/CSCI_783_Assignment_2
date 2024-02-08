package com.example.basicapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.basicapp.ui.theme.BasicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BasicApp()
                }
            }
        }
    }
}

@Composable
fun GreetingWithButton(message: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            fontSize = 60.sp,
            lineHeight = 70.sp,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            val implicitIntent = Intent("com.example.basicapp.START_SECOND_ACTIVITY_IMPLICITLY")
            startActivity(context, implicitIntent, null)
        }) {
            Text(stringResource(R.string.implicit))
        }

        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = {
            val explicitIntent = Intent(context, ChallengesListActivity::class.java)
            startActivity(context, explicitIntent, null)
        }) {
            Text(stringResource(R.string.explicit))
        }

        Spacer(modifier = Modifier.height(100.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun BasicApp() {
    GreetingWithButton("Ben Rybacki\n1294112", modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.BottomCenter))
}

