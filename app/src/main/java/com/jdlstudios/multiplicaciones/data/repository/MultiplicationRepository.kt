package com.jdlstudios.multiplicaciones.data.repository

import com.jdlstudios.multiplicaciones.data.model.MultiplicationModel
import com.jdlstudios.multiplicaciones.data.model.MultiplicationProvider

class MultiplicationRepository {

    fun getMultiplication(): MultiplicationModel{
        return MultiplicationProvider.randomMultiplication()
    }
}