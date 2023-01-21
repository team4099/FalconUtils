package org.team4099.lib.units

interface UnitKey

object Unitless : UnitKey

class Product<A : UnitKey, B : UnitKey> : UnitKey

class Fraction<N : UnitKey, D : UnitKey> : UnitKey

typealias Inverse<K> = Fraction<Unitless, K>

typealias Squared<K> = Product<K, K>

typealias Cubed<K> = Product<K, Squared<K>>

inline val Double.unitless: Value<Unitless>
  get() = Value(this)

inline val Number.unitless: Value<Unitless>
  get() = this.toDouble().unitless

inline val Value<Unitless>.asDouble
  get() = value
