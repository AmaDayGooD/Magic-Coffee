package com.example.magiccoffe.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.magiccoffe.R
import com.example.magiccoffe.screens.ui.theme.backcard
import com.example.magiccoffe.screens.ui.theme.border


@Composable
@Preview(showBackground = true)
fun OrderScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "back",
                modifier = Modifier.size(width = 24.dp, height = 24.dp)
            )
            Text(
                text = "Заказ",
                style = TextStyle
                    (
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 16.sp,
                )
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.basket),
                contentDescription = "Shoping",
                modifier = Modifier.size(width = 24.dp, height = 24.dp)
                //modifier = Modifier.clickable(onClick = onClick)
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            backgroundColor = backcard,
            elevation = 0.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.mugcoffee),
                contentDescription = "coffee",
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 50.dp, height = 60.dp)
                .padding(end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Капучино",
                style = TextStyle
                    (
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 14.sp,
                )
            )
            Card(
                modifier = Modifier
                    .size(width = 73.dp, height = 30.dp), shape = RoundedCornerShape(50.dp),
                border = BorderStroke(1.dp, color = border)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Remove,
                        contentDescription = "stepper",
                        Modifier.size(16.dp)
                    )
                    Text(text = "1")
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "stepper",
                        Modifier.size(16.dp)
                    )
                }
            }

        }
        Divider(color = border)
        //Ристретто
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 50.dp, height = 60.dp)
                .padding(end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Ристретто",
                style = TextStyle
                    (
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 14.sp,
                )
            )
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Card(
                    modifier = Modifier
                        .size(width = 73.dp, height = 30.dp)
                        .padding(end = 10.dp), shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = border)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                    ) {
                        Text(text = "Один")
                    }
                }
                Card(
                    modifier = Modifier
                        .size(width = 73.dp, height = 30.dp), shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = border)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 5.dp, end = 5.dp),

                        ) {
                        Text(
                            text = "Два"
                        )
                    }
                }

            }
        }
        Divider(color = border)
        //На месте / навынос
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 50.dp, height = 60.dp)
                .padding(end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "На месте / навынос",
                style = TextStyle
                    (
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 14.sp,
                )
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector
                        .vectorResource(id = R.drawable.nameste),
                    contentDescription = "на_вынос",
                    modifier = Modifier.padding(end = 20.dp)
                )
                Icon(
                    imageVector = ImageVector
                        .vectorResource(id = R.drawable.navinos),
                    contentDescription = "с_собой"
                )
            }
        }
        Divider(color = border)
        //Объем, мл
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.size(width = 50.dp, height = 70.dp)
                .padding(top = 10.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Объем, мл",
                style = TextStyle
                    (
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 14.sp,
                )
            )
            Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom) {
               Column(horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.SpaceBetween) {
                   Icon(imageVector = ImageVector
                       .vectorResource(id = R.drawable.volumesvg),
                       contentDescription = "volume",
                       modifier = Modifier.size(22.dp)

                       )
                   Text(text = "250", modifier = Modifier.padding(top=5.dp))
               }
                Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                ,horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(imageVector = ImageVector
                        .vectorResource(id = R.drawable.volumesvg),
                        contentDescription = "volume",
                    modifier = Modifier.size(31.dp)
                        )
                    Text(text = "350", modifier = Modifier.padding(top=5.dp))
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(imageVector = ImageVector
                        .vectorResource(id = R.drawable.volumesvg),
                        contentDescription = "volume",
                        modifier = Modifier.size(38.dp)
                            //.padding(bottom = 10.dp)
                    )
                    Text(text = "450", modifier = Modifier.padding(top=5.dp))
                }
            }
        }
        Divider(color = border)
        //определённое время
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.size(width = 50.dp, height = 70.dp)
                .padding(top = 10.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
        Text(text = "Приготовить к определенному \n" +
                "времени сегодня?")

            var switchCheckedState by remember { mutableStateOf(false) }
            Switch(
                modifier = Modifier.scale(scale = 1.5f),
                checked = switchCheckedState,
                onCheckedChange = { switchCheckedState = it },

                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color.Green,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.LightGray,
            )
            )
        }

        Row(horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()) {
            Card(modifier = Modifier.background(color = backcard)) {
                Text(text = "18 : 10", modifier = Modifier.padding(10.dp))
                
            }
        }
    }

}


