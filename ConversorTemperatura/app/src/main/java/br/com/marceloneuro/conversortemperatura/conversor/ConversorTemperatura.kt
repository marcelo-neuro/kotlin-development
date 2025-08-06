package br.com.marceloneuro.conversortemperatura.conversor

class ConversorTemperatura {

    fun celsius2Fahrenheit(celsius: Double) :Double {
        return (celsius * 9/5) + 32
    }

    fun fahrenheit2celsius(fahrenheit: Double) :Double {
        return (fahrenheit - 32) * 5/9
    }

    fun celsius2Kelvin(celsius: Double) :Double {
        return celsius + 273.15
    }

    fun kelvin2Celsius(kelvin: Double) :Double {
        return kelvin - 273.15
    }
}