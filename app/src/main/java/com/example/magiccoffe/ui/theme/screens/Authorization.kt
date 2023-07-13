package com.example.magiccoffe.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.magiccoffe.R
import com.example.magiccoffe.ui.theme.screens.ui.theme.black
import com.example.magiccoffe.ui.theme.screens.ui.theme.border
import com.example.magiccoffe.ui.theme.screens.ui.theme.white

@Composable
@Preview(showBackground = true)
fun Authorization() {
    val login = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 30.dp, start = 30.dp)
            .background(color = white)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp, top = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "",
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Войти",
                fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                fontSize = 22.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = "Добро пожаловать",
                fontFamily = FontFamily(Font(R.font.poppinsregular)),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 25.dp)
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            BasicTextField(
                value = login.value, maxLines = 1, singleLine = true, onValueChange = {
                    login.value = it
                },
                modifier = Modifier.padding(top = 20.dp),
                decorationBox = { innerTextField ->
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(start = 10.dp)
                            ) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.lock),
                                    contentDescription = "",
                                    tint = black
                                )
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.line),
                                    contentDescription = "",
                                    tint = black,
                                    modifier = Modifier.padding(horizontal = 10.dp)
                                )
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(30.dp),
                                    elevation = 0.dp
                                ) {
                                    innerTextField()
                                }
                            }
                            Divider(
                                color = border, modifier = Modifier.padding(top = 6.dp)
                            )
                        }
                    }
                }
            )


            BasicTextField(value = password.value,
                maxLines = 1,
                singleLine = true,
                onValueChange = {
                    password.value = it
                },
                modifier = Modifier.padding(top = 20.dp),
                decorationBox = { innerTextField ->
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(start = 10.dp)
                            ) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.lock),
                                    contentDescription = "",
                                    tint = black
                                )
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.line),
                                    contentDescription = "",
                                    tint = black,
                                    modifier = Modifier.padding(horizontal = 10.dp)
                                )
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth(.9f)
                                            .height(30.dp),
                                        elevation = 0.dp
                                    ) {
                                        innerTextField()
                                    }
                                    Icon(
                                        imageVector = Icons.Filled.Visibility,
                                        contentDescription = ""
                                    )
                                }
                            }
                            Divider(
                                color = border, modifier = Modifier.padding(top = 6.dp)
                            )
                        }
                    }

                })
        }
    }
}
