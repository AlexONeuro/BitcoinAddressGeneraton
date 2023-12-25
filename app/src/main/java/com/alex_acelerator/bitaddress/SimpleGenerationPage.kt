package com.alex_acelerator.bitaddress

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alex_acelerator.bitaddress.BitcoinAddressCreator.MainGenerators.EntropyGenerator
import com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.BitcoinAddressGenerator
import com.alex_acelerator.bitaddress.QRCode.QRGContents
import com.alex_acelerator.bitaddress.QRCode.QRGEncoder


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun SimpleGenerationPage(
    navController: NavController
) {
    var privateKeyString by remember { mutableStateOf(privateKeyRandom()) }
    var publicKey = BitcoinAddressGenerator.getPublicKey(privateKeyString)
    var bitcoinAddress = BitcoinAddressGenerator.getBitcoinAddress(publicKey)

    Column {
        Spacer(modifier = Modifier.height(24.dp))
        addressString(text = bitcoinAddress)
        addressString(text = publicKey)
        addressString(text = privateKeyString)

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = privateKeyString, onValueChange = { privateKeyString = it }, modifier = Modifier
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

        Image(
            bitmap = (privateKeyQr(privateKeyString)),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(96.dp))
        Button(
            onClick = {
                     privateKeyString =  privateKeyRandom()
                      }, modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(id = R.string.Button_Text))
        }
    }

}

@Composable
fun addressString(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
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
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun privateKeyQr(privateKey: String): ImageBitmap {
    val qrgEncoder = QRGEncoder("$privateKey + some letters", null, QRGContents.Type.TEXT, 500)
    qrgEncoder.colorBlack = android.graphics.Color.WHITE
    qrgEncoder.colorWhite = android.graphics.Color.BLACK
    return qrgEncoder.bitmap.asImageBitmap()

}
fun privateKeyRandom(): String {
   return BitcoinAddressGenerator.generatePrivateKey(EntropyGenerator().entropy)
}

@Preview(showBackground = true)
@Composable
fun SimpleGenerationPagePreview() {
    SimpleGenerationPage(navController = rememberNavController())
}






