package com.jdlstudios.multiplicaciones.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.jdlstudios.multiplicaciones.databinding.FragmentExerciseQuantityBinding
import com.jdlstudios.multiplicaciones.domain.model.ExerciseDifficulty
import com.jdlstudios.multiplicaciones.ui.viewmodel.ExerciseQuantityViewModel

class ExerciseQuantityFragment : Fragment() {

    private lateinit var binding: FragmentExerciseQuantityBinding
    private val viewModel: ExerciseQuantityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExerciseQuantityBinding.inflate(inflater)
        binding.exerciseQuantityViewModel = viewModel
        binding.lifecycleOwner = this

        val args: ExerciseQuantityFragmentArgs by navArgs()
        val exerciseQuantityArgs = args.exerciseDifficulty

        viewModel.setExerciseDifficultyData(exerciseQuantityArgs.difficulty)

        binding.seekBarQuantity.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textQuantity.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        binding.buttonStartExercises.setOnClickListener {
            val quantityExercises = binding.textQuantity.text.toString().toInt()
            viewModel.setExerciseDifficultyData(exerciseQuantityArgs.difficulty, quantityExercises)
            val exerciseDifficulty =
                ExerciseDifficulty(exerciseQuantityArgs.difficulty, quantityExercises)
            val action =
                ExerciseQuantityFragmentDirections.actionExerciseQuantityFragmentToPracticaFragment(
                    exerciseDifficulty
                )
            findNavController().navigate(action)
        }

        return binding.root
    }

}