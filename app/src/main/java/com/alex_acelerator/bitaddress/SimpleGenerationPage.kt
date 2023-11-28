package com.alex_acelerator.bitaddress

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun SimpleGenerationPage(
    navController: NavController
) {
    Column {
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.Address),
                modifier = Modifier
                    .height(32.dp)
                    .width(300.dp)
                    .padding(8.dp)
                    .background(color = Color.Gray)
                    .weight(1f)
            )
            Icon(
                modifier = Modifier
                    .background(Color.LightGray)
                    .size(32.dp),
                imageVector = Icons.Default.Share,
                contentDescription = null
            )

        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(  modifier = Modifier
            .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.Legacy_Address),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .padding(8.dp)
                    .background(color = Color.Gray)
                    .weight(1f)
            )
            Icon(
                modifier = Modifier
                    .background(Color.LightGray)
                    .size(32.dp),
                imageVector = Icons.Default.Share,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row( modifier = Modifier
            .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.PublicKey),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .padding(8.dp)
                    .background(color = Color.Gray)
                    .weight(1f)
            )
            Icon(
                modifier = Modifier
                    .background(Color.LightGray)
                    .size(32.dp),
                imageVector = Icons.Default.Share,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        var privateKey by remember { mutableStateOf("Some PrivateKey") }
        OutlinedTextField(
            value = privateKey, onValueChange = { privateKey = it }, modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.Memo_PrivateKey),
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .padding(8.dp)
                .background(color = Color.Gray)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Icon(
            modifier = Modifier
                .background(Color.LightGray)
                .size(250.dp)
                .align(Alignment.CenterHorizontally),
            imageVector = Icons.Default.Refresh,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(96.dp))
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(id = R.string.Button_Text))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SimpleGenerationPagePreview() {
    SimpleGenerationPage(navController = rememberNavController())
}




