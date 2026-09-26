package com.izel.planejadordeviagem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.izel.planejadordeviagem.databinding.FragmentTripCostResultBinding

class TripCostResultFragment : Fragment() {
    private var _binding: FragmentTripCostResultBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TripCalculatorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTripCostResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fuelConsumption = viewModel.fuelConsumption
        val fuelPrice = viewModel.fuelPrice
        val tripCostEstimatedResult = viewModel.calculateTripCost()

        with(binding) {
            averageConsumptionResult.text = getString(R.string.consumption_label, fuelConsumption)
            fuelPriceResult.text = getString(R.string.fuel_price_label, fuelPrice)
            estimatedCostResult.text = getString(R.string.total_cost_label, tripCostEstimatedResult)
        }

        binding.newTripButton.setOnClickListener {
            viewModel.clearData()

            findNavController().navigate(R.id.action_tripCostResultFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}