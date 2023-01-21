package org.team4099.lib.units.base

import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value

object Kelvin : UnitKey

typealias Temperature = Value<Kelvin>

inline val Double.kelvin: Temperature
  get() = Temperature(this)

inline val Double.celsius: Temperature
  get() = Temperature(this + 273.15)

inline val Double.fahrenheit: Temperature
  get() = Temperature((this - 32) * 5.0 / 9.0 + 273.15)

inline val Number.kelvin: Temperature
  get() = toDouble().kelvin

inline val Number.celsius: Temperature
  get() = toDouble().celsius

inline val Number.fahrenheit: Temperature
  get() = toDouble().fahrenheit

inline val Temperature.inKelvins: Double
  get() = value

inline val Temperature.inCelsius: Double
  get() = value - 273.15

inline val Temperature.inFahrenheit: Double
  get() = (value - 273.15) * 1.8 + 32
