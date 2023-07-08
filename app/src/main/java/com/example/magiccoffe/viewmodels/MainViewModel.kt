package com.example.magiccoffe.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.magiccoffe.models.coffeeGet
import com.example.magiccoffe.sealed.DataState4
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel : ViewModel () {

    val response: MutableState<DataState4> = mutableStateOf(DataState4.Empty)

    init {
        fetchDatafromFirebase()
    }

    private fun fetchDatafromFirebase() {
        val tempList = mutableListOf<coffeeGet>()
        response.value = DataState4.Loading
        FirebaseDatabase.getInstance().getReference("idCafe")
            .addListenerForSingleValueEvent(object : ValueEventListener
            {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(DataSnap in snapshot.children)
                    {
                        val cofeitem = DataSnap.getValue(coffeeGet::class.java)
                        if(cofeitem != null)
                            tempList.add(cofeitem)
                    }
                    response.value = DataState4.Success(tempList)
                }

                override fun onCancelled(error: DatabaseError) {
                    response.value = DataState4.Failure(error.message)
                }

            })

    }
}