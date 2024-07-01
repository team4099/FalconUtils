package org.team4099.lib.units.base

import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value

object Hertz: UnitKey
typealias Frequency = Value<Hertz>

inline val Double.hertz: Frequency
    get() = Frequency(this)

inline val Number.hertz: Frequency
    get() = toDouble().hertz

inline val Frequency.inHertz: Double
    get() = value