package com.jdlstudios.multiplicaciones.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jdlstudios.multiplicaciones.R
import com.jdlstudios.multiplicaciones.databinding.FragmentPracticaNivelIntermediateBinding

class PracticaNivelIntermediateFragment : Fragment() {

    private lateinit var binding: FragmentPracticaNivelIntermediateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPracticaNivelIntermediateBinding.inflate(inflater)



        return binding.root
    }

}