package com.jdlstudios.multiplicaciones.data.database.converters

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jdlstudios.multiplicaciones.domain.model.Multiplication
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class Converters {

    @TypeConverter
    fun fromLocalDate(value: LocalDate?): Long? {
        return value?.toEpochDay()
    }

    @TypeConverter
    fun toLocalDate(value: Long?): LocalDate? {
        return value?.let { LocalDate.ofEpochDay(it) }
    }

    @TypeConverter
    fun fromJson(value: String): List<Multiplication> {
        val type = object : TypeToken<List<Multiplication>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toJson(list: List<Multiplication>): String {
        return Gson().toJson(list)
    }
}
