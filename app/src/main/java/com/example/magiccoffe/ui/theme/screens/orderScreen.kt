package com.example.magiccoffe.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
import com.example.magiccoffe.ui.theme.screens.ui.theme.*
import kotlin.math.roundToInt


@Composable
@Preview(showBackground = true)
fun OrderScreen(
    //onClick: () -> Unit
) {
    val counter = remember { mutableStateOf(1) }
    val cost = remember { mutableStateOf(250.0) }
    val summ = remember { mutableStateOf(cost.value * counter.value) }
    if (summ.value < cost.value) summ.value = cost.value
    Column(
        //verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(color = white.hashCode()))
            .padding(30.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "back",
                modifier = Modifier.size(width = 24.dp, height = 24.dp)
                //.clickable { onClick() }
            )
            Text(
                text = "Заказ", style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 16.sp,
                )
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.basket),
                contentDescription = "Shoping",
                modifier = Modifier.size(width = 24.dp, height = 24.dp)
                //.clickable { onTwoClick() }
            )
        }
        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = backcard,
            elevation = 0.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.mugcoffee),
                contentDescription = "coffee",
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 50.dp, height = 60.dp)
                .padding(end = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Капучино", style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 14.sp,
                )
            )
            Card(
                modifier = Modifier
                    .size(width = 73.dp, height = 30.dp)
                    .background(Color(color = white.hashCode())),
                shape = RoundedCornerShape(50.dp),
                border = BorderStroke(1.dp, color = border)
            ) {
                //val counter = remember { mutableStateOf(1) }
                if (counter.value <= 1) {
                    counter.value = 1
                }
                //if(counter.value >10) counter.value = 10
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                ) {
                    Icon(imageVector = Icons.Filled.Remove,
                        contentDescription = "stepper",
                        Modifier
                            .size(16.dp)
                            .clickable { counter.value--; summ.value = counter.value * cost.value })
                    Text(text = counter.value.toString())
                    Icon(imageVector = Icons.Filled.Add,
                        contentDescription = "stepper",
                        Modifier
                            .size(16.dp)
                            .clickable {
                                counter.value++
                                summ.value = counter.value * cost.value
                            })
                }
            }
        }
        Divider(color = border)
        //Ристретто
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 50.dp, height = 60.dp)
                .padding(end = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Ристретто", style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 14.sp,
                )
            )
            Row(horizontalArrangement = Arrangement.SpaceBetween) {

                val selectedRisetto = remember { mutableStateOf("") }
                val oneColor = remember { mutableStateOf(border) }
                val twoColor = remember { mutableStateOf(black) }
                Card(
                    modifier = Modifier
                        .size(width = 73.dp, height = 30.dp)
                        .background(Color(color = white.hashCode()))
                        .padding(end = 10.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = oneColor.value)
                ) {
                    Row(horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable { selectedRisetto.value = "one" }
                            .padding(start = 5.dp, end = 5.dp)) {
                        Text(text = "Один", color = black)
                    }
                }
                Card(
                    modifier = Modifier
                        .size(width = 73.dp, height = 30.dp)
                        .background(Color(color = white.hashCode()))
                        .clickable { selectedRisetto.value = "two" },
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = twoColor.value)
                ) {
                    Row(horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable { selectedRisetto.value = "two" }
                            .padding(start = 5.dp, end = 5.dp)


                    ) {
                        Text(text = "Два", color = black)
                    }
                    when (selectedRisetto.value) {
                        "one" -> {
                            oneColor.value = black; twoColor.value = border
                        }
                        "two" -> {
                            oneColor.value = border; twoColor.value = black
                        }
                    }
                }

            }
        }
        Divider(color = border)
        //На месте / навынос
        val colorOnTheSpot = remember { mutableStateOf(border) }
        val colorTakeaway = remember { mutableStateOf(black) }
        val state = remember { mutableStateOf("") }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 50.dp, height = 60.dp)
                .padding(end = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "На месте / навынос", style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 14.sp,
                )
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.nameste),
                    contentDescription = "на_вынос",
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable { state.value = "one" },
                    tint = colorOnTheSpot.value
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.navinos),
                    contentDescription = "с_собой",
                    modifier = Modifier.clickable { state.value = "two" },
                    tint = colorTakeaway.value
                )
            }
            when (state.value) {
                "one" -> {
                    colorTakeaway.value = border; colorOnTheSpot.value = black
                }
                "two" -> {
                    colorTakeaway.value = black; colorOnTheSpot.value = border
                }
            }
        }
        Divider(color = border)
        //Объем, мл
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.size(width = 50.dp, height = 70.dp)
                .padding(top = 10.dp, bottom = 10.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Объем, мл", style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 14.sp,
                )
            )
            val oneColor = remember { mutableStateOf(Color(color = border.hashCode())) }
            val twoColor = remember { mutableStateOf(Color(color = border.hashCode())) }
            val treeColor = remember { mutableStateOf(Color(color = black.hashCode())) }
            val selectedItem = remember { mutableStateOf("") }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.clickable { selectedItem.value = "one" }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.volumesvg),
                        contentDescription = "volume",
                        modifier = Modifier.size(22.dp),
                        oneColor.value
                    )
                    Text(text = "250", modifier = Modifier.padding(top = 5.dp), oneColor.value)
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .clickable { selectedItem.value = "two" },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.volumesvg),
                        contentDescription = "volume",
                        modifier = Modifier.size(31.dp),
                        twoColor.value
                    )
                    Text(text = "350", modifier = Modifier.padding(top = 5.dp), twoColor.value)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { selectedItem.value = "tree" }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.volumesvg),
                        contentDescription = "volume",
                        modifier = Modifier.size(38.dp),
                        treeColor.value
                    )
                    Text(
                        text = "450", modifier = Modifier.padding(top = 5.dp), treeColor.value
                    )
                    when (selectedItem.value) {
                        "one" -> {
                            oneColor.value = Color.Black
                            twoColor.value = Color.LightGray
                            treeColor.value = Color.LightGray
                            cost.value = 250.0
                            summ.value = cost.value * counter.value
                        }
                        "two" -> {
                            oneColor.value = Color.LightGray
                            twoColor.value = Color.Black
                            treeColor.value = Color.LightGray
                            cost.value = 350.0
                            summ.value = cost.value * counter.value
                        }
                        "tree" -> {
                            oneColor.value = Color.LightGray
                            twoColor.value = Color.LightGray
                            treeColor.value = Color.Black
                            cost.value = 450.0
                            summ.value = cost.value * counter.value
                        }
                    }
                }
            }
        }
        Divider(color = border)
        //определённое время
        val switchCheckedState = remember { mutableStateOf(true) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.size(width = 50.dp, height = 70.dp)
                .padding(top = 10.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Приготовить к определенному \n" + "времени сегодня?"
            )
            Switch(
                modifier = Modifier.scale(scale = 1.5f),
                checked = switchCheckedState.value,
                onCheckedChange = { switchCheckedState.value = it },

                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(52, 199, 98, 100),
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.LightGray,
                )
            )
        }
        if (switchCheckedState.value) //если true
        {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                Card(
                    elevation = 0.dp,
                ) {
                    Text(
                        text = "18 : 10",
                        modifier = Modifier
                            .background(color = backcard)
                            .padding(10.dp)
                    )

                }
            }
        }
        Card(
            elevation = 0.dp, shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth()
        ) {
            Row(modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(color = gradColorTwo.hashCode()),
                            Color(color = gradColorOne.hashCode())
                        ), start = Offset(0f, 0f), // top left corner
                        end = Offset(100f, 400f)
                    )
                )
                .clickable { }
                .padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.filter),
                        contentDescription = "icon Tune",
                        modifier = Modifier.padding(end = 10.dp)
                    )
                    Text(text = "Конструктор кофемана", color = white)
                }
                Icon(
                    imageVector = Icons.Filled.ChevronRight,
                    contentDescription = "Chevron Right",
                    tint = white
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Итоговя сумма")
            Text(
                text = "Руб " + (summ.value * 100).roundToInt() / 100.0,
                fontFamily = FontFamily(Font(R.font.poppinsmedium))
            )
        }
        Card(shape = RoundedCornerShape(30.dp), modifier = Modifier
            .fillMaxWidth()
            .clickable { }) {
            Row(modifier = Modifier
                .background(Color(color = button.hashCode()))
                .clickable { }
                .padding(15.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Далее", color = white)
            }
        }
    }

}
