package com.izel.planejadordeviagem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.izel.planejadordeviagem.databinding.FragmentTripCostResultBinding

class TripCostResultFragment : Fragment() {
    private var _binding: FragmentTripCostResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTripCostResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newTripButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_distanceInputFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}