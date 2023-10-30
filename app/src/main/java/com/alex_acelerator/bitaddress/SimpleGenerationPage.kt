package com.alex_acelerator.bitaddress

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnrememberedMutableState")
@Composable
fun SimpleGenerationPage(
    navController: NavController
) {
    Column {
        Text(
            text = "New Address",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        var temp by remember {mutableStateOf(false)}
        Checkbox(checked = temp, onCheckedChange = {value -> temp = value})

    }
}

@Preview(showBackground = true)
@Composable
fun SimpleGenerationPagePreview() {
    SimpleGenerationPage(navController = rememberNavController())
}




