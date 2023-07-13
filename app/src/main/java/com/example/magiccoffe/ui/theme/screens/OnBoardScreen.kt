package com.example.magiccoffe.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.East
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.magiccoffe.R
import com.example.magiccoffe.ui.theme.screens.ui.theme.border
import com.example.magiccoffe.ui.theme.screens.ui.theme.button
import com.example.magiccoffe.ui.theme.screens.ui.theme.white

@Composable
fun OnBoardScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.4f)
                .background(color = button)
                .padding(top = 60.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logobig),
                contentDescription = "logo",
                alignment = Alignment.BottomCenter,
                //modifier = Modifier.fillMaxSize(2f)
            )
            Text(
                text = "Magic coffee",
                fontSize = 64.sp,
                color = white,
                fontFamily = FontFamily(Font(R.font.reeniebeanie)),
                fontWeight = FontWeight(10),
                //modifier = Modifier.padding(bottom = 110.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight(.4f)
                .padding(top = 20.dp, bottom = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Почувствуй себя",
                fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                fontSize = 28.sp
            )
            Text(
                text = "бариста!",
                fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                fontSize = 28.sp
            )
            Text(
                text = "Волшебный кофе под заказ.",
                fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                fontSize = 18.sp,
                color = border
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(color = white)
        ) {
            Card(
                modifier = Modifier
                    .size(width = 20.dp, height = 10.dp)
                    .padding(end = 10.dp), backgroundColor = button,
                shape = RoundedCornerShape(50.dp)
            ) {}
            Card(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(height = 10.dp, width = 10.dp), backgroundColor = border,
                shape = RoundedCornerShape(50.dp)
            ) {}
            Card(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(height = 10.dp, width = 10.dp), backgroundColor = border,
                shape = RoundedCornerShape(50.dp)
            ) {}
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(.8f)
                .fillMaxHeight(.7f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            Card(
                modifier = Modifier
                    .size(60.dp, 60.dp)
                    .clickable{ navController.navigate("MapScreen") },
                backgroundColor = button,
                elevation = 0.dp,
                shape = RoundedCornerShape(50.dp),

            ) {
                Icon(
                    imageVector = Icons.Rounded.East,
                    contentDescription = "",
                    tint = white,
                    modifier = Modifier.padding(15.dp)

                )
            }
        }
    }
}