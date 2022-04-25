package com.rujirakongsomran.jc_m3practise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rujirakongsomran.jc_m3practise.ui.theme.JC_M3PractiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_M3PractiseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBadgedBox()
                }
            }
        }
    }
}

@Composable
fun CreateDialog() {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            icon = {
                Icon(Icons.Filled.Favorite, contentDescription = null)
            },
            title = {
                Text(text = "Title")
            },
            text = {
                Text(text = "Turned on by default")
            },
            confirmButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text(text = "Dismiss")
                }
            }
        )
    }
}

@Composable
fun CreateBadgedBox() {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                BadgedBox(badge = { Badge { Text(text = "8") } }) {
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = "Favorite"
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JC_M3PractiseTheme {

    }
}