package com.alex_acelerator.bitaddress

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainPage(
    navController: NavController
) {

    Column{

        Spacer(modifier = Modifier.height(48.dp))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { navController.navigate("SimpleGenerationPage") })
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    modifier = Modifier
                        .size(120.dp)
                        .background(color = Color.Gray),

                    imageVector = Icons.Default.Lock,
                    contentDescription = "Sample1"
                )
                Column() {
                    Text(
                        text = "GENERATION",
                        modifier = Modifier
                            .padding(16.dp),
                        fontSize = 32.sp
                    )
                    Text(
                        text = "Use this option to generate new address",
                        modifier = Modifier
                            .padding(16.dp),
                        fontSize = 12.sp
                    )
                }

            }
            Spacer(modifier = Modifier.height(24.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    modifier = Modifier
                        .size(120.dp)
                        .background(color = Color.Gray),

                    imageVector = Icons.Default.Settings,
                    contentDescription = "Sample1"
                )
                Text(
                    text = "СONVERTATION",
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 32.sp
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    modifier = Modifier
                        .size(120.dp)
                        .background(color = Color.Gray),

                    imageVector = Icons.Default.Phone,
                    contentDescription = "Sample1"
                )
                Text(
                    text = "СONNECTION",
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 32.sp
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview
@Composable
fun MainPagePreview() {
    MainPage(navController = rememberNavController())
}