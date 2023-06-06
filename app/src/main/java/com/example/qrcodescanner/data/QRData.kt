package com.example.qrcodescanner.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "qr-data")
data class QRData(
    @PrimaryKey val id: String = "",
    @ColumnInfo(name = "data") val data: String = "",
    @ColumnInfo(name = "user") val user: String = ""
)
