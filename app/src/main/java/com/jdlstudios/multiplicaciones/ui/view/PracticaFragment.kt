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

        viewModel.setDifficulty(exerciseQuantityArgs.difficulty)
        viewModel.setExerciseDifficultyData(
            exerciseQuantityArgs.difficulty,
            exerciseQuantityArgs.exerciseCount
        )

        binding.practiceViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.quantity.value ?: viewModel.setQuantity(exerciseQuantityArgs.exerciseCount)

        binding.buttonCheck.setOnClickListener {
            checkAnswer()
            binding.edittextAnswer.text.clear()
        }

        return binding.root
    }

    private fun checkAnswer() {
        val answer = binding.edittextAnswer.text.toString().toIntOrNull()
        if (answer != null) {
            if (viewModel.checkAnswer(answer)) {
                Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Incorrect!", Toast.LENGTH_SHORT).show()
            }
            viewModel.setQuantity((viewModel.quantity.value ?: 0) - 1)
            viewModel.reset()
        } else {
            Toast.makeText(context, "Please enter a number", Toast.LENGTH_SHORT).show()
        }
    }

}
