package com.example.basicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicapp.ui.theme.BasicAppTheme

class ChallengesListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val challenges = listOf(
                        "Cross-platform development compatibility",
                        "Optimizing app performance for various devices",
                        "Handling background tasks efficiently",
                        "Implementing effective error handling and debugging",
                        "Ensuring app security and data privacy",
                        "Managing app state and lifecycle effectively",
                        "Implementing responsive and adaptive UI/UX design",
                        "Addressing network-related challenges (offline support, bandwidth optimization)",
                        "Testing across multiple devices and screen sizes",
                        "Integrating and managing third-party libraries and APIs"
                    )

                    ChallengesList(challenges, modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .padding(40.dp, 5.dp, 40.dp, 0.dp))

                }
            }
        }
    }

    @Composable
    fun ChallengesList(challenges: List<String>, modifier: Modifier = Modifier) {
        Column {
            Text(
                text = "Mobile Software Engineering Challenges",
                fontSize = 30.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(30.dp, 30.dp, 30.dp, 0.dp)
            )

            Column (
                modifier = modifier
            ) {
                challenges.forEachIndexed { index, challenge ->
                    val listItem = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontSize = 16.sp)) {
                            append("${index + 1}. ")
                        }
                        append(challenge)
                    }

                    Text(
                        text = listItem,
                        modifier = Modifier
                            .padding(5.dp)
                            .semantics {
                                contentDescription = "challenge-${index+1}"
                            }
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        val challenges = listOf(
            "Cross-platform development compatibility",
            "Optimizing app performance for various devices",
            "Handling background tasks efficiently",
            "Implementing effective error handling and debugging",
            "Ensuring app security and data privacy",
            "Managing app state and lifecycle effectively",
            "Implementing responsive and adaptive UI/UX design",
            "Addressing network-related challenges (offline support, bandwidth optimization)",
            "Testing across multiple devices and screen sizes",
            "Integrating and managing third-party libraries and APIs"
        )

        ChallengesList(challenges, modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopCenter)
            .padding(40.dp, 4.dp, 40.dp, 0.dp))
    }
}