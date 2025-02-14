package com.dovoh.materingcicd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dovoh.materingcicd.ui.theme.MateringCICDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MateringCICDTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingWithInputAndButton(
                        name = "CI/CD World!",
                        onButtonClick = {},
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun GreetingWithInputAndButton(name: String, onButtonClick: (String) -> Unit,modifier: Modifier = Modifier) {
    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter your message") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Button(
            onClick = { onButtonClick(inputText) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Submit")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MateringCICDTheme {
        GreetingWithInputAndButton(name = "CI/CD World!", onButtonClick = {})
    }
}