package org.team4099.lib.units.derived

import org.team4099.lib.units.Product
import org.team4099.lib.units.Squared
import org.team4099.lib.units.Value
import org.team4099.lib.units.base.Kilogram
import org.team4099.lib.units.base.Meter

typealias Inertia = Product<Kilogram, Squared<Meter>>

typealias MomentOfInertia = Value<Inertia>

inline val Double.momentOfInertia
  get() = MomentOfInertia(this)

inline val Number.momentOfInertia
  get() = MomentOfInertia(this.toDouble())

inline val MomentOfInertia.asKilogramsPerMeterSquared
  get() = value
