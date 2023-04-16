package com.jdlstudios.multiplicaciones.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.jdlstudios.multiplicaciones.databinding.FragmentInicioBinding
import com.jdlstudios.multiplicaciones.domain.DifficultyLevel
import com.jdlstudios.multiplicaciones.domain.model.ExerciseDifficulty

class InicioFragment : Fragment() {

    private lateinit var binding: FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInicioBinding.inflate(inflater)

        binding.buttonNext.setOnClickListener {

            val selectedDifficulty = binding.radioGroupDifficulty.checkedRadioButtonId.let { id ->
                binding.root.findViewById<RadioButton>(id)?.tag?.toString()?.let { tag ->
                    DifficultyLevel.getDifficultyLevelFromName(tag)
                } ?: DifficultyLevel.EASY
            }

            val exerciseDifficulty = ExerciseDifficulty(selectedDifficulty, 0)

            it.findNavController().navigate(
                InicioFragmentDirections.actionInicioFragmentToExerciseQuantityFragment(
                    exerciseDifficulty
                )
            )
        }

        return binding.root
    }

}