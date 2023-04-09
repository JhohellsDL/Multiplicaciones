package com.jdlstudios.multiplicaciones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jdlstudios.multiplicaciones.databinding.FragmentPracticaBinding

class PracticaFragment : Fragment() {

    private lateinit var binding: FragmentPracticaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPracticaBinding.inflate(inflater)
        return binding.root
    }

}