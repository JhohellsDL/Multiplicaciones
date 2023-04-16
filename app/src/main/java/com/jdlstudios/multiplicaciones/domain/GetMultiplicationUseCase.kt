package com.jdlstudios.multiplicaciones.domain

import com.jdlstudios.multiplicaciones.data.repository.MultiplicationRepository
import com.jdlstudios.multiplicaciones.domain.model.Multiplication
import javax.inject.Inject

class GetMultiplicationUseCase @Inject constructor(private val repository : MultiplicationRepository) {

    operator fun invoke(level: DifficultyLevel): Multiplication {
        return repository.getMultiplicationFromProvider(level)
    }

}