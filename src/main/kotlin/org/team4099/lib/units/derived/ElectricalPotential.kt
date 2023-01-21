package org.team4099.lib.units.derived

import org.team4099.lib.units.Fraction
import org.team4099.lib.units.Value

val BATTERY_VOLTAGE = 12.volts

typealias Volt = Fraction<Joule, Coulomb>

typealias ElectricalPotential = Value<Volt>

inline val Double.volts
  get() = ElectricalPotential(this)

inline val Number.volts
  get() = toDouble().volts

inline val ElectricalPotential.inVolts
  get() = value

inline val ElectricalPotential.inPercentOutput
  get() = this / BATTERY_VOLTAGE
