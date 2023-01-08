package org.team4099.lib.units.derived

import org.team4099.lib.units.Acceleration
import org.team4099.lib.units.Fraction
import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value
import org.team4099.lib.units.Velocity
import org.team4099.lib.units.base.Ampere
import org.team4099.lib.units.base.Meter

typealias StaticFeedforward<O> = Value<O>

typealias VelocityFeedforward<E, O> = Value<Fraction<O, Velocity<E>>>

typealias AccelerationFeedforward<E, O> = Value<Fraction<O, Acceleration<E>>>

typealias AngularGravityFeedforward = Value<Fraction<Volt, Radian>>

typealias LinearGravityFeedforward = Value<Volt>

val <K : UnitKey> Value<K>.perMeterPerSecondPerSecond
  get() = Value<Fraction<K, Acceleration<Meter>>>(value)

val <K : UnitKey> Value<K>.perRadianPerSecondPerSecond
  get() = Value<Fraction<K, Acceleration<Radian>>>(value)

val AccelerationFeedforward<Radian, Volt>.inVoltsPerRadianPerSecondPerSecond
  get() = value

val AccelerationFeedforward<Meter, Volt>.inVoltsPerMeterPerSecondPerSecond
  get() = value

val AccelerationFeedforward<Radian, Ampere>.inAmpsPerRadianPerSecondPerSecond
  get() = value

val AccelerationFeedforward<Meter, Ampere>.inAmpsPerMeterPerSecondPerSecond
  get() = value
