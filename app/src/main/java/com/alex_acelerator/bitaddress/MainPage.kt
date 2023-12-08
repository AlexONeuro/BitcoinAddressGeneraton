package com.alex_acelerator.bitaddress

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainPage(
    navController: NavController
) {

    Column {

        Spacer(modifier = Modifier.height(48.dp))
        Box() {
            CardElement(
                navController = navController,
                route = stringResource(id = R.string.SimpleGenerationPage),
                imageVector = Icons.Default.Lock,
                title = "Generation",
                explainingText = "Use this to generate new address"
            )
            var checkedState by remember { mutableStateOf(false) }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.align(Alignment.BottomStart)) {
                Checkbox(
                    checked = checkedState, onCheckedChange = { checkedState = it },
                    modifier = Modifier.size(48.dp)
                )
                Text(text = "Advanced address creation", modifier = Modifier.align(CenterVertically))
            }

        }

        Spacer(modifier = Modifier.height(24.dp))

        CardElement(
            navController = navController,
            route = "",
            imageVector = Icons.Default.Settings,
            title = "Convertation",
            explainingText = "Use this to convert private address to list of words and vise versa"
        )

        Spacer(modifier = Modifier.height(24.dp))

        CardElement(
            navController = navController,
            route = "",
            imageVector = Icons.Default.Phone,
            title = "Connection",
            explainingText = "Check your balance!"
        )
    }
}

@Preview
@Composable
fun MainPagePreview() {
    MainPage(navController = rememberNavController())
}

@Composable
fun CardElement(
    navController: NavController,
    route: String,
    imageVector: ImageVector,
    title: String,
    explainingText: String
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { navController.navigate(route) })
            .height(170.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                modifier = Modifier
                    .size(120.dp)
                    .background(color = Color.Gray),

                imageVector = imageVector,
                contentDescription = "Sample1"
            )
            Column() {
                Text(
                    text = title,
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 32.sp
                )
                Text(
                    text = explainingText,
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 12.sp
                )
            }

        }
    }
}

