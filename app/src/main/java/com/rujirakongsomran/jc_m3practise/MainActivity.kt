package com.rujirakongsomran.jc_m3practise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    ToggleableSurface()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateSurface() {
    var count by remember { mutableStateOf(0) }
    Surface(
        onClick = {
            count++
        }
    ) {
        Text(text = "Clickable Surface. Count: $count")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectableSurface() {

    var selected by remember { mutableStateOf(false) }
    Surface(
        selected = selected,
        onClick = { selected = !selected }
    ) {
        Text(
            text = if (selected) "Selected" else "Not Selected",
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToggleableSurface() {
    var checked by remember { mutableStateOf(false) }
    Surface(
        checked = checked,
        onCheckedChange = { checked = !checked },
        color = if (checked)
            MaterialTheme.colorScheme.surfaceVariant
        else
            MaterialTheme.colorScheme.surface
    ) {
        Text(text = if (checked) "ON" else "OFF", textAlign = TextAlign.Center)
    }
}

@Composable
fun CreateSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column {
        Text(text = sliderPosition.toString())
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            steps = 4
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateBottomAppBar() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                icons = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Edit, contentDescription = "Localized description")
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Add, contentDescription = "Localized description")
                    }
                }
            )
        }
    ) {

    }
}

@Composable
fun CreateCircleProgressIndicator() {
    var progress by remember { mutableStateOf(0.1f) }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier.size(200.dp),
            strokeWidth = 40.dp
        )
        Spacer(modifier = Modifier.requiredHeight(30.dp))
        OutlinedButton(onClick = {
            if (progress < 1) progress += 0.1f
        }) {
            Text("Increase")
        }
        OutlinedButton(onClick = {
            if (progress > 0.1) progress -= 0.1f
        }) {
            Text("decrease")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopAppBar() {
    var names = listOf("Una Drew", "Nojus Stanley", "Taran Curry")
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Centered TopAppBar") },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val numlist = (0..75).map { it.toString() }
                items(count = numlist.size) {
                    Text(
                        text = numlist[it],
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateCheckBox() {
    val checkState = remember { mutableStateOf(true) }
    Checkbox(
        checked = checkState.value,
        onCheckedChange = { checkState.value = it }
    )
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