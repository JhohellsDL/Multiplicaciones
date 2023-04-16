package com.jdlstudios.multiplicaciones.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.jdlstudios.multiplicaciones.databinding.FragmentPracticaBinding
import com.jdlstudios.multiplicaciones.ui.viewmodel.MultiplicationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PracticaFragment : Fragment() {

    private lateinit var binding: FragmentPracticaBinding
    private val viewModel: MultiplicationViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPracticaBinding.inflate(inflater)

        val args: PracticaFragmentArgs by navArgs()
        val exerciseQuantityArgs = args.exerciseDifficulty
        var quantity = exerciseQuantityArgs.exerciseCount

        viewModel.setDifficulty(exerciseQuantityArgs.difficulty)
        viewModel.setExerciseDifficultyData(
            exerciseQuantityArgs.difficulty,
            exerciseQuantityArgs.exerciseCount
        )

        binding.practiceViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.quantity.value?.let {
            quantity = it
        } ?: run {
            viewModel.setQuantity(quantity)
        }

        binding.buttonCheck.setOnClickListener {

            val answer = binding.edittextAnswer.text.toString().toIntOrNull()

            if (answer != null) {
                if (viewModel.checkAnswer(answer)) {
                    Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Incorrect!", Toast.LENGTH_SHORT).show()
                }
                quantity -= 1
                viewModel.setQuantity(quantity)
                viewModel.reset()
            } else {
                Toast.makeText(context, "Please enter a number", Toast.LENGTH_SHORT).show()
            }
            binding.edittextAnswer.text.clear()
        }

        return binding.root
    }

}
