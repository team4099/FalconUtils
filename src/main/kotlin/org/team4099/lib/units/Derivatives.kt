package org.team4099.lib.units

import org.team4099.lib.units.base.METERS_PER_FOOT
import org.team4099.lib.units.base.METERS_PER_INCH
import org.team4099.lib.units.base.Meter
import org.team4099.lib.units.base.SECONDS_PER_MINUTE
import org.team4099.lib.units.base.Second
import org.team4099.lib.units.derived.Radian
import kotlin.math.PI

typealias Velocity<K> = Fraction<K, Second>

typealias Acceleration<K> = Fraction<Velocity<K>, Second>

typealias LinearVelocity = Value<Velocity<Meter>>

typealias AngularVelocity = Value<Velocity<Radian>>

typealias LinearAcceleration = Value<Acceleration<Meter>>

typealias AngularAcceleration = Value<Acceleration<Radian>>

inline val <K : UnitKey> Value<K>.perSecond
  get() = Value<Velocity<K>>(value)

inline val <K : UnitKey> Value<K>.perMinute
  get() = Value<Velocity<K>>(value / SECONDS_PER_MINUTE)

inline val LinearVelocity.inMetersPerSecond: Double
  get() = value

inline val LinearVelocity.inFeetPerSecond: Double
  get() = value / METERS_PER_FOOT

inline val LinearVelocity.inFeetPerMinute: Double
  get() = inFeetPerSecond * SECONDS_PER_MINUTE

inline val LinearVelocity.inInchesPerSecond: Double
  get() = value / METERS_PER_INCH

inline val AngularVelocity.inRadiansPerSecond: Double
  get() = value

inline val AngularVelocity.inDegreesPerSecond: Double
  get() = Math.toDegrees(value)

inline val AngularVelocity.inRotationsPerSecond: Double
  get() = value / (2 * PI)

inline val AngularVelocity.inRotationsPerMinute: Double
  get() = value * SECONDS_PER_MINUTE / (2 * PI)

inline val LinearAcceleration.inMetersPerSecondPerSecond: Double
  get() = value

inline val LinearAcceleration.inFeetPerSecondPerSecond: Double
  get() = value / METERS_PER_FOOT

inline val LinearAcceleration.inFeetPerMinutePerSecond: Double
  get() = inFeetPerSecondPerSecond * SECONDS_PER_MINUTE

inline val LinearAcceleration.inInchesPerSecondPerSecond: Double
  get() = value / METERS_PER_INCH

inline val AngularAcceleration.inRadiansPerSecondPerSecond: Double
  get() = value

inline val AngularAcceleration.inDegreesPerSecondPerSecond: Double
  get() = Math.toDegrees(value)

inline val AngularAcceleration.inRotationsPerSecondPerSecond: Double
  get() = value / (2 * PI)



inline val AngularAcceleration.inRotationsPerMinutePerMinute: Double
  get() = value * SECONDS_PER_MINUTE * SECONDS_PER_MINUTE / (2 * PI)
