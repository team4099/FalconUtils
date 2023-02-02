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

typealias AngularGravityFeedforward = Value<Volt>

typealias LinearGravityFeedforward = Value<Volt>

inline val <K : UnitKey> Value<K>.perMeterPerSecondPerSecond
  get() = Value<Fraction<K, Acceleration<Meter>>>(value)

inline val <K : UnitKey> Value<K>.perRadianPerSecondPerSecond
  get() = Value<Fraction<K, Acceleration<Radian>>>(value)

inline val <K : UnitKey> Value<K>.perDegreePerSecondPerSecond
  get() = Value<Fraction<K, Acceleration<Radian>>>(value / RADIANS_PER_DEGREES)

inline val AccelerationFeedforward<Radian, Volt>.inVoltsPerRadianPerSecondPerSecond
  get() = value

inline val AccelerationFeedforward<Radian, Volt>.inVoltsPerDegreePerSecondPerSecond
  get() = inVoltsPerRadianPerSecondPerSecond / RADIANS_PER_DEGREES

inline val AccelerationFeedforward<Meter, Volt>.inVoltsPerMeterPerSecondPerSecond
  get() = value

inline val AccelerationFeedforward<Radian, Ampere>.inAmpsPerRadianPerSecondPerSecond
  get() = value

inline val AccelerationFeedforward<Radian, Ampere>.inAmpsPerDegreePerSecondPerSecond
  get() = inAmpsPerRadianPerSecondPerSecond / RADIANS_PER_DEGREES

inline val AccelerationFeedforward<Meter, Ampere>.inAmpsPerMeterPerSecondPerSecond
  get() = value
