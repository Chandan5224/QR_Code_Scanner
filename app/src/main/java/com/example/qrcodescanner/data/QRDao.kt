package com.example.qrcodescanner.data

import androidx.room.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Dao
class QRDao {
    private val db = FirebaseFirestore.getInstance()
    val qrCollection = db.collection("qr-data")
    val auth = Firebase.auth

    fun addData(data: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val id = getRandomString(15)
            val user = auth.currentUser!!.displayName
            val qrData = QRData(id, data, user!!)
            qrCollection.document(qrData.id).set(qrData).addOnSuccessListener {

            }
        }
    }

    private fun getRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}