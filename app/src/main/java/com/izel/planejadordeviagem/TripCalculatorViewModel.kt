package com.izel.planejadordeviagem

import androidx.lifecycle.ViewModel

class TripCalculatorViewModel : ViewModel() {
    var distance = 0
        private set

    var fuelConsumption = 0
        private set

    var fuelPrice = 1.2
        private set

    fun setDistanceValue(value: Int) {
        this.distance = value
    }

    fun setFuelConsumptionValue(value: Int) {
        this.fuelConsumption = value
    }

    fun setFuelPriceValue(value: Double) {
        this.fuelPrice = value
    }

    fun calculateTripCost() : Double {
        return (distance.toDouble() / fuelConsumption.toDouble()) * fuelPrice
    }

    fun clearData() {
        distance = 0
        fuelConsumption = 0
        fuelPrice = 0.0
    }
}