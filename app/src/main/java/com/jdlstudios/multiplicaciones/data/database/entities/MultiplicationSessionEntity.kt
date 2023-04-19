package com.jdlstudios.multiplicaciones.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.annotation.IntRange
import com.jdlstudios.multiplicaciones.domain.DifficultyLevel
import com.jdlstudios.multiplicaciones.domain.model.Multiplication
import java.time.LocalDate

@Entity(tableName = "session_table")
data class MultiplicationSessionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0L,
    @ColumnInfo(name = "level") val level: DifficultyLevel,
    @ColumnInfo(name = "date") val date: LocalDate,
    @ColumnInfo(name = "corrects") @IntRange(from = 0) val correct: Int,
    @ColumnInfo(name = "incorrect") @IntRange(from = 0) val incorrect: Int,
    @ColumnInfo(name = "wrong_list") val wrongList: List<Multiplication>,
    @ColumnInfo(name = "correct_list") val correctList: List<Multiplication>
) {
    constructor(
        level: DifficultyLevel,
        date: LocalDate,
        correct: Int,
        incorrect: Int,
        wrongList: List<Multiplication>,
        correctList: List<Multiplication>
    ) : this(0L, level, date, correct, incorrect, wrongList, correctList)
}
