package com.alex_acelerator.bitaddress

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SimpleGenerationPage(
    navController: NavController
) {
    Column {
        Text(text = "New Address")
        Spacer(modifier = Modifier.height(16.dp))
        val textForField = remember {
            mutableSetOf("The sample text")
        }
        CustomizedTextFieldPreview()
    }
}

@Preview
@Composable
fun SimpleGenerationPagePreview() {
    SimpleGenerationPage(navController = rememberNavController())
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CustomizedTextFieldPreview() {
    val textForField = remember { mutableStateOf("Compose! This is CustomizedTextFieldPreview") }
    TextField(
        modifier = Modifier.size(width = 525.dp, height = 95.dp),
        value = textForField.value,
        onValueChange = { newText -> textForField.value = newText },
        singleLine = true,
        shape = MaterialTheme.shapes.large,
        textStyle = TextStyle(fontSize = 35.sp),
        colors = TextFieldDefaults.textFieldColors(textColor = Color.DarkGray, containerColor = Color.LightGray)
    )
}

