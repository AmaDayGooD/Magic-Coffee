package com.example.magiccoffe.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.magiccoffe.MainViewModal
import com.example.magiccoffe.R
import com.example.magiccoffe.roomDB.Menu
import com.example.magiccoffe.ui.theme.screens.ui.theme.black
import com.example.magiccoffe.ui.theme.screens.ui.theme.border
import com.example.magiccoffe.ui.theme.screens.ui.theme.button
import com.example.magiccoffe.ui.theme.screens.ui.theme.white

@Composable
fun MenuScreen(
    mainViewModal: MainViewModal = viewModel(factory = MainViewModal.factory),
    navController: NavController,
    cafeID: Int?
) {
    val itemsList = mainViewModal.itemlist.collectAsState(initial = emptyList())
    val menuList: MutableList<Menu> = mutableListOf()
    itemsList.value.forEach()
    {
        if (it.cafe_id == cafeID) {
            menuList.add(it)
        }

    }

    Column(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Добро пожаловать!",
                    color = border,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppinsmedium))
                )
                Text(
                    text = "Алексей",
                    color = black,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.poppinsmedium))
                )
            }
            Row {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.basket),
                    contentDescription = "basket",
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .size(width = 26.dp, height = 26.dp)
                        .clickable { }
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.profile),
                    contentDescription = "basket",
                    modifier = Modifier
                        .size(width = 26.dp, height = 26.dp)
                )
            }
        }
        Card(
            shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
            modifier = Modifier.fillMaxSize(),
            backgroundColor = Color(color = button.hashCode())
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Выберите Ваш кофе",
                    modifier = Modifier.padding(top = 10.dp, start = 20.dp, end = 10.dp),
                    color = white,
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 16.sp,
                )
                Card(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 30.dp)
                        .fillMaxHeight(.85f)
                        .fillMaxWidth(1f)
                        .background(color = button)
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.background(color = button)
                    ) {
                        items(menuList) { item ->
                            Card(

                                modifier = Modifier
                                    .size(width = 150.dp, height = 160.dp)
                                    .background(Color(color = button.hashCode()))
                                    .clickable {
                                        val cutUrl = cut(item.image_url)
                                        navController.navigate("OrderScreen/" + item.coffee_name + "/" + item.price + "/" + cutUrl + "/" + item.cafe_id)
                                    }, elevation = 0.dp,
                                shape = RoundedCornerShape(12.dp),
                                border = BorderStroke(1.dp, color = black)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    AsyncImage(
                                        model = item.image_url,
                                        contentDescription = "image",
                                        modifier = Modifier.fillMaxSize(0.8f)
                                    )
                                    Text(text = item.coffee_name)
                                }
                            }
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, color = black)

                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.shop),
                            contentDescription = "Shop",
                            tint = black
                        )
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.gifts),
                            contentDescription = "Shop",
                            tint = border
                        )
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.note),
                            contentDescription = "Shop",
                            tint = border
                        )
                    }

                }

            }

        }

    }
}

fun cut(url: String): String {
    return url.removePrefix("https://i.imgur.com/")
}

