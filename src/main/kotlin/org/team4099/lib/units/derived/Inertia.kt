package org.team4099.lib.units.derived

import org.team4099.lib.units.Product
import org.team4099.lib.units.Squared
import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value
import org.team4099.lib.units.base.Kilogram
import org.team4099.lib.units.base.Meter

typealias Inertia = Product<Kilogram, Squared<Meter>>

typealias MomentOfInertia = Value<Inertia>

inline val MomentOfInertia.inKilogramsMeterSquared
  get() = value

inline val <K : UnitKey> Value<K>.meterSquared
  get() = Value<Product<K, Squared<Meter>>>(value)
