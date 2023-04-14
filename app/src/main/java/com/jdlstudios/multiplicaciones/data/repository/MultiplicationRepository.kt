package com.jdlstudios.multiplicaciones.data.repository

import com.jdlstudios.multiplicaciones.data.model.MultiplicationModel
import com.jdlstudios.multiplicaciones.data.model.MultiplicationProvider
import javax.inject.Inject

class MultiplicationRepository @Inject constructor() {

    fun getMultiplication(): MultiplicationModel {
        return MultiplicationProvider.randomMultiplication()
    }
}