package com.izel.planejadordeviagem

import androidx.lifecycle.ViewModel

class TripCalculatorViewModel : ViewModel() {
    var distance = 0
        private set

    var fuelConsumption = 0
        private set

    var fuelPrice = 1.2f
        private set

    fun setDistanceValue(value: Int) {
        this.distance = value
    }

    fun setFuelConsumptionValue(value: Int) {
        this.fuelConsumption = value
    }

    fun setFuelPriceValue(value: Float) {
        this.fuelPrice = value
    }

    fun calculateTripCost() : Float {
        return (distance.toFloat() / fuelConsumption.toFloat()) * fuelPrice
    }

    fun clearData() {
        distance = 0
        fuelConsumption = 0
        fuelPrice = 0f
    }
}