package com.team4099.units

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.team4099.lib.units.base.celsius
import org.team4099.lib.units.base.fahrenheit
import org.team4099.lib.units.base.inCelsius
import org.team4099.lib.units.base.inFahrenheit
import org.team4099.lib.units.base.inKelvins
import org.team4099.lib.units.base.kelvin

class TemperatureTest {
  private val kEpsilon = 1E-9

  @Test
  fun testCelsiusToKelvins() {
    val temperature = 0.0.celsius
    assertEquals(temperature.inKelvins, 273.15, kEpsilon)
  }

  @Test
  fun testFahrenheitToKelvins() {
    val temperature = 32.0.fahrenheit
    assertEquals(temperature.inKelvins, 273.15, kEpsilon)
  }

  @Test
  fun testKelvinsToCelsius() {
    val temperature = 273.15.kelvin
    assertEquals(temperature.inCelsius, 0.0, kEpsilon)
  }

  @Test
  fun testKelvinsToFahrenheit() {
    val temperature = 273.15.kelvin
    assertEquals(temperature.inFahrenheit, 32.0, kEpsilon)
  }
}
