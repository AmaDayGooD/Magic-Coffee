package com.example.magiccoffe.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.magiccoffe.R

//@Preview(showBackground = true)
@Composable
fun MainScreen(){
    Image(painter = painterResource(id = R.drawable.backgroundlogo),
        contentDescription = "img", modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
        )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(29, 35, 53, 94)),
        contentAlignment = Alignment.Center,

    ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                alignment = Alignment.BottomCenter,
                modifier = Modifier.padding(bottom = 200.dp)
            )
        Text(
            text = "Magic coffee",
            fontSize = 64.sp,
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.reeniebeanie)),
            fontWeight = FontWeight(10),
            modifier = Modifier.padding(bottom = 110.dp)
        )

    }
}