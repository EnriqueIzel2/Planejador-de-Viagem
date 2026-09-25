package com.izel.planejadordeviagem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.izel.planejadordeviagem.databinding.FragmentDistanceInputBinding

class DistanceInputFragment : Fragment() {
    private var _binding: FragmentDistanceInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDistanceInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextScreenButton.setOnClickListener {
            findNavController().navigate(R.id.action_distanceInputFragment_to_fuelConsumptionInputFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}