package com.jdlstudios.multiplicaciones.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "multiplication_table")
data class MultiplicationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "factor1") val factor1: Int,
    @ColumnInfo(name = "factor2") val factor2: Int,
    @ColumnInfo(name = "result") val result: Int
)