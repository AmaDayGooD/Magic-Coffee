package com.example.magiccoffe.ui.theme.screens

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.annotation.DrawableRes
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.magiccoffe.MainViewModal
import com.example.magiccoffe.R
import com.example.magiccoffe.ui.theme.screens.ui.theme.button
import com.example.magiccoffe.ui.theme.screens.ui.theme.gradColorOne
import com.example.magiccoffe.ui.theme.screens.ui.theme.gradColorTwo
import com.example.magiccoffe.ui.theme.screens.ui.theme.white
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapScreen(
    mainViewModal: MainViewModal = viewModel(factory = MainViewModal.factory),
    navController: NavController
) {

    val itemsList = mainViewModal.estList.collectAsState(initial = emptyList())

    val home = LatLng(56.636506, 47.896149)
    var cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(home, 14f)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier
                .fillMaxHeight(.6f)
                .fillMaxWidth(),
            cameraPositionState = cameraPositionState,
            uiSettings = MapUiSettings(myLocationButtonEnabled = false),
            properties = MapProperties(isMyLocationEnabled = true)

        ) {
            itemsList.value.forEach() {
                val mark = LatLng(it.latitude!!, it.longitude!!)
                MapMarker(
                    position = mark,
                    title = it.nameCafe.toString(),
                    context = LocalContext.current,
                    iconResourceId = R.drawable.marker
                )
            }
        }
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
            backgroundColor = button

        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Выберите кофейню Magic Cofe",
                    color = white,
                    modifier = Modifier.padding(top = 30.dp)
                )
                Card(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(1),
                        modifier = Modifier.padding(
                            top = 10.dp, bottom = 10.dp, start = 20.dp, end = 20.dp
                        )
                    ) {
                        items(itemsList.value) { item ->
                            Card(
                                        modifier = Modifier
                                            .fillMaxHeight(.8f)
                                            .fillMaxWidth()
                                            .padding(10.dp, top = 20.dp)
                                            .clickable {
                                                if (approximatelyEqual(
                                                        cameraPositionState.position.target.latitude,
                                                        item.latitude!!,
                                                        0.001
                                                    ) && (approximatelyEqual(
                                                        cameraPositionState.position.target.longitude,
                                                        item.longitude!!,
                                                        0.001
                                                    ))
                                                ) {
                                                    navController.navigate("MenuScreen/" + item.cafe_id)
                                                } else {
                                                    Log.d(
                                                        "myTag",
                                                        "что то пошло не так позиция камеры \n ${cameraPositionState.position.target.longitude} позиция заведения ${item.longitude} \n ${cameraPositionState.position.target.latitude} позиция заведения ${item.latitude}"
                                                    )
                                                }
                                            },
                                shape = RoundedCornerShape(16.dp),
                                elevation = 0.dp
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(
                                            brush = Brush.linearGradient(
                                                colors = listOf(
                                                    Color(color = gradColorTwo.hashCode()),
                                                    Color(color = gradColorOne.hashCode())
                                                ), start = Offset(0f, 0f), // top left corner
                                                end = Offset(100f, 400f)
                                            )
                                        )
                                        .padding(top = 5.dp, bottom = 5.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(.8f),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = ImageVector.vectorResource(id = R.drawable.shop),
                                            contentDescription = "Shop",
                                            tint = white
                                        )
                                        Text(
                                            text = item.addressCafe!!,
                                            color = white,
                                            modifier = Modifier.padding(10.dp)
                                        )
                                    }
                                    Icon(
                                        imageVector = Icons.Filled.ArrowForwardIos,
                                        contentDescription = "arrow right",
                                        tint = white
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MapMarker(
    context: Context,
    position: LatLng,
    title: String,
    @DrawableRes iconResourceId: Int
) {
    val icon = bitmapDescriptorFromVector(
        context, iconResourceId
    )
    Marker(
        state = MarkerState(position = position),
        title = title,
        icon = icon,
    )
}

fun bitmapDescriptorFromVector(
    context: Context,
    vectorResId: Int
): BitmapDescriptor? {

    // retrieve the actual drawable
    val drawable = ContextCompat.getDrawable(context, vectorResId) ?: return null
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    val bm = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )

    // draw it onto the bitmap
    val canvas = android.graphics.Canvas(bm)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
}

fun approximatelyEqual(a: Double, b: Double, epsilon: Double): Boolean {
    return Math.abs(a - b) <= epsilon
}
