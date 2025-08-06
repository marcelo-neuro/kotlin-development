package br.com.marceloneuro.conversortemperatura.conversor

import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test

class ConversorTemperaturaTest {

    private val conversor = ConversorTemperatura()

    @Test
    fun testCelsius2Fahrenheit() {
        val result = conversor.celsius2Fahrenheit(25.0)
        assertEquals(77.0, result, 0.01)
    }

    @Test
    fun testFahrenheit2celsius() {
        val result = conversor.fahrenheit2celsius(77.0)
        assertEquals(25.0, result, 0.01)
    }

}