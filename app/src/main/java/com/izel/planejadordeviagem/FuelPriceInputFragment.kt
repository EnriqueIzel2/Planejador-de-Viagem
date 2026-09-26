package com.izel.planejadordeviagem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.izel.planejadordeviagem.databinding.FragmentFuelPriceInputBinding

class FuelPriceInputFragment : Fragment() {
    private var _binding: FragmentFuelPriceInputBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TripCalculatorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFuelPriceInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            previousScreenButton.setOnClickListener {
                findNavController().popBackStack()
            }

            finishButton.setOnClickListener {
                val fuelPrice = fuelPriceInput.text.toString().toFloatOrNull() ?: 0f
                viewModel.setFuelPriceValue(fuelPrice)

                findNavController().navigate(R.id.action_fuelPriceInputFragment_to_tripCostResultFragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}