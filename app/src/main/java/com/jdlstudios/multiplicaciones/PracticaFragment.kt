package com.jdlstudios.multiplicaciones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jdlstudios.multiplicaciones.databinding.FragmentPracticaBinding
import com.jdlstudios.multiplicaciones.viewmodel.MultiplyViewModel

class PracticaFragment : Fragment() {

    private lateinit var binding: FragmentPracticaBinding
    private lateinit var viewModel: MultiplyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPracticaBinding.inflate(inflater)

        viewModel = ViewModelProvider(this)[MultiplyViewModel::class.java]
        binding.practiceViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.numeros.observe(viewLifecycleOwner){
            binding.textviewNumber1.text = it.factor1.toString()
            binding.textviewNumber2.text = it.factor2.toString()
        }
        binding.buttonCheck.setOnClickListener {
            val answer = binding.edittextAnswer.text.toString().toIntOrNull()
            if (answer != null) {
                viewModel.checkAnswer(answer)
                if (viewModel.answerCorrect.value!!) {
                    Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Incorrect!", Toast.LENGTH_SHORT).show()
                }
                viewModel.reset()
            } else {
                Toast.makeText(context, "Please enter a number", Toast.LENGTH_SHORT).show()
            }
            binding.edittextAnswer.text.clear()
        }

        return binding.root
    }

}
