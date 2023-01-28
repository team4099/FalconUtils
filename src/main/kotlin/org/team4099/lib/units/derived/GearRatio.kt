package org.team4099.lib.units.derived

import org.team4099.lib.units.Fraction
import org.team4099.lib.units.Unitless
import org.team4099.lib.units.Value

typealias GearRatio = Value<Fraction<Driving, Driven>>

typealias Driving = Unitless

typealias Driven = Unitless

// Reductions are < 1
inline val Double.reduction
  get() = GearRatio(1 / this)

inline val Double.overdrive
  get() = GearRatio(this)

inline val Number.reduction
  get() = this.toDouble().reduction

inline val Number.overdrive
  get() = this.toDouble().overdrive

inline val Double.driving
  get() = Value<Driving>(this)

inline val Double.driven
  get() = Value<Driven>(this)

inline val GearRatio.asDrivingOverDriven
  get() = 1 / value

inline val GearRatio.asDrivenOverDriving
  get() = value
