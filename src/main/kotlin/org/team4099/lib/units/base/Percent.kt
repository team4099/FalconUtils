package org.team4099.lib.units.base

import org.team4099.lib.units.Fraction
import org.team4099.lib.units.Unitless
import org.team4099.lib.units.Value

typealias Decimal = Value<Unitless>

typealias Rate = Value<Fraction<Unitless, Second>>

const val PERCENTAGE_TO_DOUBLE = 0.01

inline val Double.percent: Decimal
  get() = Decimal(this * PERCENTAGE_TO_DOUBLE)

inline val Number.percent: Decimal
  get() = this.toDouble().percent

inline val Decimal.toDecimal: Double
  get() = value

inline val Decimal.toPercent: Double
    get() = value / PERCENTAGE_TO_DOUBLE

inline val Rate.inOutputPerSecond: Double
  get() = value

inline val Rate.inPercentPerSecond: Double
  get() = value / PERCENTAGE_TO_DOUBLE
