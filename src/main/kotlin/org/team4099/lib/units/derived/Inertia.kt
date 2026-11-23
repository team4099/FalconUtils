package org.team4099.lib.units.derived

import org.team4099.lib.units.Product
import org.team4099.lib.units.Squared
import org.team4099.lib.units.Value
import org.team4099.lib.units.base.GRAMS_PER_POUND
import org.team4099.lib.units.base.Kilogram
import org.team4099.lib.units.base.Meter

const val INCHES_SQUARED_PER_METER_SQUARED = 1550.0031

typealias Inertia = Product<Kilogram, Squared<Meter>>

typealias MomentOfInertia = Value<Inertia>

inline val MomentOfInertia.inKilogramsMeterSquared
  get() = value

inline val MomentOfInertia.inGramsMeterSquared
  get() = value * 1000.0

inline val MomentOfInertia.inPoundsInchSquared
  get() = value * 1000.0 / GRAMS_PER_POUND * INCHES_SQUARED_PER_METER_SQUARED

inline val Double.gramsMeterSquared
  get() = Value<Product<Kilogram, Squared<Meter>>>(this / 1000.0)

inline val Number.gramsMeterSquared
  get() = toDouble().gramsMeterSquared

inline val Double.poundsInchSquared
  get() =
      Value<Product<Kilogram, Squared<Meter>>>(
          this * GRAMS_PER_POUND / 1000.0 / INCHES_SQUARED_PER_METER_SQUARED)

inline val Number.poundsInchSquared
  get() = toDouble().poundsInchSquared
