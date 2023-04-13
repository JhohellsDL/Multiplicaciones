package com.jdlstudios.multiplicaciones.data.model

import android.util.Log

class MultiplicationProvider {

    companion object {

        fun randomMultiplication(): MultiplicationModel {
            val f1 = (0..10).random()
            val f2 = (0..10).random()
            val r = f1 * f2

            return MultiplicationModel(
                factor1 = f1,
                factor2 = f2,
                result = r
            )
        }
    }

}