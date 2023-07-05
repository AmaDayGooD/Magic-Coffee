package com.example.magiccoffe.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
            Text(text = "Заказ",
                style = TextStyle
                    (
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 16.sp,
                        )
                        )

            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shoping",
                modifier = Modifier.size(width = 24.dp, height = 24.dp)
                //modifier = Modifier.clickable(onClick = onClick)
            )
        }
        Card(modifier = Modifier
            .fillMaxWidth(),
            backgroundColor = backcard,
            elevation = 0.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.mugcoffee),
                contentDescription = "coffee",
                modifier = Modifier.padding(top=10.dp, bottom = 10.dp)
                )
            
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .size(width = 50.dp, height = 50.dp)
            .padding(end = 10.dp),
            verticalAlignment  = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Капучино",
                style = TextStyle
                    (
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 14.sp,
                )
            )
            Card(
                modifier = Modifier
                    .size(width = 73.dp, height = 30.dp)
                ,shape = RoundedCornerShape(50.dp),
                border = BorderStroke(1.dp, color = border)
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                ) {
                    Icon(imageVector = Icons.Filled.AddCircle,
                        contentDescription = "stepper",
                    Modifier.size(16.dp))
                    Text(text = "1")
                    Icon(imageVector = Icons.Filled.Add,
                        contentDescription = "stepper",
                    Modifier.size(16.dp))
                }
            }

        }
        Divider(color = border)
        Row(modifier = Modifier
            .fillMaxWidth()
            .size(width = 50.dp, height = 50.dp)
            .padding(end = 10.dp),
            verticalAlignment  = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Ристретто",
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
                    .padding(end = 10.dp)
                ,shape = RoundedCornerShape(50.dp),
                border = BorderStroke(1.dp, color = border)
            ) {
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                ) {
                    Text(text = "Один")
                }
            }
            Card(
                modifier = Modifier
                    .size(width = 73.dp, height = 30.dp)
                ,shape = RoundedCornerShape(50.dp),
                border = BorderStroke(1.dp, color = border)
            ) {
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp),

                ) {
                    Text(text = "Два"
                    )
                }
            }

            }
        }
        Divider(color = border)
        Row(modifier = Modifier
            .fillMaxWidth()
            .size(width = 50.dp, height = 50.dp)
            .padding(end = 10.dp),
            verticalAlignment  = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "На месте / навынос",
                style = TextStyle
                    (
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 14.sp,
                )
            )
            Row(horizontalArrangement = Arrangement.SpaceBetween) {

                        Icon(imageVector = Icons.Filled.Add,
                            contentDescription = "на_вынос",
                            modifier = Modifier.padding(end = 10.dp)
                        )
                        Icon(imageVector = Icons.Filled.Delete,
                            contentDescription = "с_собой")
                    }
            }
        }
        Divider(color = border)
    }
