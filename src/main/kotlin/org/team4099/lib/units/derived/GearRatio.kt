package org.team4099.lib.units.derived

import org.team4099.lib.units.Fraction
import org.team4099.lib.units.Unitless
import org.team4099.lib.units.Value

typealias GearRatio = Value<Fraction<Driving, Driven>>

typealias Driving = Unitless

typealias Driven = Unitless

// Reductions are < 1
inline val Double.gearRatio
  get() = GearRatio(this)

inline val Double.driving
  get() = Value<Driving>(this)

inline val Double.driven
  get() = Value<Driven>(this)

inline val GearRatio.asDrivingOverDriven
  get() = value

inline val GearRatio.asDrivenOverDriving
  get() = 1 / value
