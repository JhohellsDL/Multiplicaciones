package com.jdlstudios.multiplicaciones.domain

import com.jdlstudios.multiplicaciones.data.model.MultiplicationModel
import com.jdlstudios.multiplicaciones.data.repository.MultiplicationRepository

class GetMultiplicationUseCase {

    private val repository = MultiplicationRepository()

    operator fun invoke(): MultiplicationModel {
        return repository.getMultiplication()
    }
}