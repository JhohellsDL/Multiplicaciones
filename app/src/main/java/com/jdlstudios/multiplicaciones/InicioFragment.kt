package com.jdlstudios.multiplicaciones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jdlstudios.multiplicaciones.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {

    private lateinit var binding: FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInicioBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

}