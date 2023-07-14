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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
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
import java.util.*

fun generateUniqueId(): Int {
    val random = Random()
    return random.nextInt(Int.MAX_VALUE)
}

@Composable
fun Registration(mainViewModal: MainViewModal = viewModel(factory = MainViewModal.factory)
                 ,navController: NavController) {
    val mContext = LocalContext.current
    val nameUser = remember { mutableStateOf(TextFieldValue("")) }
    val numberPhone = remember { mutableStateOf(TextFieldValue("")) }
    val emailUser = remember { mutableStateOf(TextFieldValue("")) }
    val passwordUser = remember { mutableStateOf(TextFieldValue("")) }
    val check = remember { mutableStateOf(false) }

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
                            navController.navigate("Authorization") {
                                popUpTo("Authorization") {
                                    inclusive = true
                                }
                            }
                        },
                    tint = black
                )
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Зарегистрироваться",
                    fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                    fontSize = 22.sp,
                    modifier = Modifier.padding(bottom = 10.dp),
                    color = black
                )
                Text(
                    text = "Создать аккаунт здесь",
                    fontFamily = FontFamily(Font(R.font.poppinsregular)),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 25.dp),
                    color = border
                )
            }

            Column {
                TextField(
                    value = nameUser.value,
                    onValueChange = {
                        nameUser.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    placeholder = {
                        Text(text = "Имя пользователя")
                    },
                    leadingIcon = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = ImageVector
                                    .vectorResource(id = R.drawable.profile),
                                contentDescription = "",
                                tint = black,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Icon(
                                imageVector = ImageVector
                                    .vectorResource(id = R.drawable.line),
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
                        cursorColor = black
                    ),

                    )
                TextField(
                    value = numberPhone.value,
                    onValueChange = {
                        numberPhone.value = it
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    placeholder = {
                        Text(text = "Номер мобильного телефона")
                    }
                    ,leadingIcon = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = ImageVector
                                    .vectorResource(id = R.drawable.smartphone),
                                contentDescription = "",
                                tint = black,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Icon(
                                imageVector = ImageVector
                                    .vectorResource(id = R.drawable.line),
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
                        cursorColor = black
                    ),

                    )
                TextField(
                    value = emailUser.value,
                    onValueChange = {
                        emailUser.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    placeholder = {
                        Text(text = "Адрес электронной почты")
                    },
                    leadingIcon = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = ImageVector
                                    .vectorResource(id = R.drawable.message),
                                contentDescription = "",
                                tint = black,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Icon(
                                imageVector = ImageVector
                                    .vectorResource(id = R.drawable.line),
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
                        cursorColor = black
                    ),

                    )
                TextField(
                    value = passwordUser.value,
                    onValueChange = {
                        passwordUser.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    placeholder = {
                        Text(text = "Пароль")
                    },
                    leadingIcon = {
                        Row(//modifier = Modifier.fillMaxHeight(.1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = ImageVector
                                    .vectorResource(id = R.drawable.lock),
                                contentDescription = "",
                                tint = black,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Icon(
                                imageVector = ImageVector
                                    .vectorResource(id = R.drawable.line),
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
            Text(
                text = "Регистрируясь, вы соглашаетесь с нашими\nусловиями использования",
                color = button
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.3f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom
            ) {
                Card(
                    modifier = Modifier
                        .size(60.dp, 60.dp)
                        .clickable {
                            val user = Users(
                                user_id = generateUniqueId(),
                                nameUser = nameUser.value.text,
                                passwordUser = passwordUser.value.text,
                                numberPhoneUser = numberPhone.value.text,
                                emailUser = emailUser.value.text
                            )
                            mainViewModal.insertUser(user)
                            Toast.makeText(mContext,"Создание пользователя: ${nameUser.value.text} прошло успешно", Toast.LENGTH_SHORT).show()
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
                    .fillMaxHeight(.6f),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Уже зарегистрировались? ",
                    fontFamily = FontFamily(Font(R.font.poppinsregular)),
                    fontSize = 14.sp,
                    color = border
                )
                Text(text = " Войти.",
                    fontFamily = FontFamily(Font(R.font.poppinsregular)),
                    fontSize = 14.sp,
                    color = button,
                    modifier = Modifier.clickable {
                        navController.navigate("Authorization") {
                            popUpTo("Authorization")
                        }
                    }
                )
            }
        }
    }
}

private fun creditCardFilter(text: AnnotatedString): TransformedText {
    val trimmed = if (text.text.length >= 16) text.text.substring(0..15) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 4 == 3 && i != 15) out += "-"
    }
    val creditCardOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset <= 3 -> offset
                offset <= 7 -> offset + 1
                offset <= 11 -> offset + 2
                offset <= 16 -> offset + 3
                else -> 19
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset <= 4 -> offset
                offset <= 9 -> offset - 1
                offset <= 14 -> offset - 2
                offset <= 19 -> offset - 3
                else -> 16
            }
        }
    }

    return TransformedText(AnnotatedString(out), creditCardOffsetTranslator)
}