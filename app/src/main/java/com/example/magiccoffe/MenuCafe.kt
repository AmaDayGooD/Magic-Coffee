package com.example.magiccoffe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.magiccoffe.models.coffeeGet
import com.example.magiccoffe.sealed.DataState4
import com.example.magiccoffe.ui.theme.screens.ui.theme.black
import com.example.magiccoffe.ui.theme.screens.ui.theme.cardcolor
import com.example.magiccoffe.ui.theme.screens.ui.theme.white
import com.example.magiccoffe.viewmodels.MainViewModel

class MenuCafe : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val name = remember { mutableStateOf("Алексей") }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(
                            text = "Добро пожаловать!",
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Text(text = name.value)
                    }
                    Row() {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.basket),
                            contentDescription = "basket",
                            tint = Color(color = black.hashCode()),
                            modifier = Modifier
                                .padding(end = 20.dp)
                                .size(26.dp)
                        )
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.profile),
                            contentDescription = "Profile",
                            tint = Color(color = black.hashCode()),
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .size(26.dp)
                        )
                    }
                }
                Card(
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
                    backgroundColor = Color(color = cardcolor.hashCode()),
                    elevation = 0.dp,
                    modifier = Modifier
                        .fillMaxWidth().height(750.dp)
                ) {
                    Card(
                        modifier = Modifier.padding(20.dp), elevation = 0.dp,
                        backgroundColor = Color(color = cardcolor.hashCode())
                    ) {
                        Text(
                            text = "Выберите Ваш кофе",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                                color = white
                            )
                        )
                    }
                    SetData(viewModel)
                }
            }
        }
    }

    @Composable
    fun SetData(veiwModel: MainViewModel) {
        when (val result = veiwModel.response.value) {
            is DataState4.Failure -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is DataState4.Success -> {
                ShowLazyList(result.data)
            }
            is DataState4.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = result.toString(),
                    )
                }
            }
            else -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                )
                {
                    Text(
                        text = "Error fetching data"
                    )
                }
            }
        }
    }

    @Composable
    fun ShowLazyList(cofee: MutableList<coffeeGet>) {
        LazyColumn(){
            items(cofee) { cofe ->
                CardItem(cofe)
            }
        }
    }

    @Composable
    fun CardItem(cofe: coffeeGet) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(10.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize())
            {
                Image(
                    painter = rememberImagePainter(cofe.addressCafe),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "image cofe"
                )
            }
            Text(
                text = cofe.nameCafe!!,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}