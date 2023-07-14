package com.example.magiccoffe.ui.theme.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material.icons.rounded.East
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.magiccoffe.MainViewModal
import com.example.magiccoffe.R
import com.example.magiccoffe.roomDB.Users
import com.example.magiccoffe.ui.theme.screens.ui.theme.black
import com.example.magiccoffe.ui.theme.screens.ui.theme.border
import com.example.magiccoffe.ui.theme.screens.ui.theme.button
import com.example.magiccoffe.ui.theme.screens.ui.theme.white

@Composable
fun Authorization(navController: NavController,
                  mainViewModal: MainViewModal = viewModel(factory = MainViewModal.factory)
) {
    val mContext = LocalContext.current
    val login = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }
    val check = remember { mutableStateOf(false) }
    val itemsList = mainViewModal.userList.collectAsState(initial = emptyList())
    val userList: MutableList<Users> = mutableListOf()

    Card(
        modifier = Modifier
            .fillMaxSize()
            .background(color = white)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 30.dp, start = 30.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp, top = 10.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .clickable {
                            navController.navigate("OnBoardScreen") {
                                popUpTo("OnBoardScreen")
                            }
                        },
                    tint = black
                )
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Войти",
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 22.sp,
                    modifier = Modifier.padding(bottom = 10.dp),
                    color = black
                )
                Text(
                    text = "Добро пожаловать",
                    fontFamily = FontFamily(Font(R.font.poppinsregular)),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 25.dp),
                    color = border
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(1.2f)
            ) {
                TextField(
                    value = login.value,
                    onValueChange = {
                        login.value = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(text = "Адрес электронной почты")
                    },
                    leadingIcon = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.message),
                                contentDescription = "",
                                tint = black,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.line),
                                contentDescription = "",
                                tint = border
                            )
                        }
                    },
                    maxLines = 1,
                    shape = RoundedCornerShape(0.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = white,
                        unfocusedIndicatorColor = border,
                        focusedIndicatorColor = border,
                        placeholderColor = border,
                        textColor = black,
                        cursorColor = border
                    ),

                    )

                TextField(
                    value = password.value,
                    onValueChange = {
                        password.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    placeholder = {
                        Text(text = "Пароль")
                    },
                    leadingIcon = {
                        Row(//modifier = Modifier.fillMaxHeight(.1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.message),
                                contentDescription = "",
                                tint = black,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.line),
                                contentDescription = "",
                                tint = border
                            )
                        }
                    },
                    trailingIcon = {
                        Icon(
                            contentDescription = "",
                            imageVector = (if (check.value) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff),
                            modifier = Modifier.clickable {
                                check.value = !check.value
                            },
                            tint = black
                        )
                    },
                    maxLines = 1,
                    shape = RoundedCornerShape(0.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = white,
                        unfocusedIndicatorColor = border,
                        focusedIndicatorColor = border,
                        placeholderColor = border,
                        textColor = black,
                        cursorColor = black
                    ),
                    visualTransformation = if (check.value) VisualTransformation.None else PasswordVisualTransformation(),
                )


            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.2f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Забыли пароль?",
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 14.sp,
                    color = button,
                    modifier = Modifier.clickable { })
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.45f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom
            ) {
                Card(
                    modifier = Modifier
                        .size(60.dp, 60.dp)
                        .clickable {
                            if (login.value.text.isEmpty() and password.value.text.isEmpty()) {
                                Toast
                                    .makeText(
                                        mContext,
                                        "Введите логин и пароль",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            } else {
                                if (login.value.text.isEmpty()) {
                                    Toast
                                        .makeText(
                                            mContext,
                                            "Введите логин",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                                if (password.value.text.isEmpty()) {
                                    Toast
                                        .makeText(mContext, "Введите пароль", Toast.LENGTH_SHORT)
                                        .show()
                                }
                                if (login.value.text.isNotEmpty() and password.value.text.isNotEmpty()) {
                                    val regex = Regex(".*@.*\\..*")
                                    if (login.value.text.matches(regex)
                                    ) {

                                        itemsList.value.forEach loop@
                                        {
                                            if (it.emailUser == login.value.text && it.passwordUser == password.value.text) {
                                                Toast
                                                    .makeText(
                                                        mContext,
                                                        "Авторизация прошла успешно",
                                                        Toast.LENGTH_SHORT
                                                    )
                                                    .show()
                                                navController.navigate("MapScreen") {
                                                    popUpTo("MapScreen") {
                                                        inclusive = false
                                                    }
                                                }
                                                return@clickable
                                            }
                                        }
                                        Toast
                                            .makeText(
                                                mContext,
                                                "Неверный логин/пароль",
                                                Toast.LENGTH_SHORT
                                            )
                                            .show()
                                        return@clickable

                                    } else {
                                        Toast
                                            .makeText(
                                                mContext,
                                                "Введите правильный адрес электронной почты",
                                                Toast.LENGTH_SHORT
                                            )
                                            .show()
                                    }
                                }
                            }
                        },
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.8f),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Впервые? ",
                    fontFamily = FontFamily(Font(R.font.poppinsregular)),
                    fontSize = 14.sp,
                    color = border
                )
                Text(text = "Зарегистрироваться.",
                    fontFamily = FontFamily(Font(R.font.poppinsregular)),
                    fontSize = 14.sp,
                    color = button,
                    modifier = Modifier.clickable { navController.navigate("Registration")}
                )
            }
        }
    }
}

