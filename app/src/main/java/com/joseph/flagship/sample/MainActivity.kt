package com.joseph.flagship.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joseph.flagship.sample.ui.theme.MyApplicationTheme
import com.thinkflagship.shorts.core.domain.usecase.setExternalId
import com.thinkflagship.shorts.core.type.EntryPointSize
import com.thinkflagship.shorts.core.type.EntryPointType
import com.thinkflagship.shorts.presentation.entrypoint.model.EntryPointInput
import com.thinkflagship.shorts.presentation.entrypoint.ui.ShortsEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setExternalId("test13134")
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        ShortsEntryPoint(
                            input = EntryPointInput.Code("#805367"),
                            placeholderType = EntryPointType.CIRCLE,
                            placeholderSize = EntryPointSize.STANDARD,
                            refreshTrigger = mutableStateOf(false),
                            modifier = Modifier.padding(bottom = 14.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}