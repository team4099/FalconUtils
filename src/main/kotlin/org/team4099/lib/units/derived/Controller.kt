package org.team4099.lib.units.derived

import org.team4099.lib.units.Fraction
import org.team4099.lib.units.Product
import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Unitless
import org.team4099.lib.units.Value
import org.team4099.lib.units.Velocity
import org.team4099.lib.units.base.Ampere
import org.team4099.lib.units.base.METERS_PER_FOOT
import org.team4099.lib.units.base.METERS_PER_INCH
import org.team4099.lib.units.base.Meter
import org.team4099.lib.units.base.SECONDS_PER_MINUTE
import org.team4099.lib.units.base.Second

typealias ProportionalGain<E, O> = Value<Fraction<O, E>>

typealias IntegralGain<E, O> = Value<Fraction<O, Product<E, Second>>>

typealias DerivativeGain<E, O> = Value<Fraction<O, Fraction<E, Second>>>

inline val Double.metersPerMeter
  get() = Value<Fraction<Meter, Meter>>(this)

inline val Double.metersPerSecondPerMetersPerSecond
  get() = Value<Fraction<Velocity<Meter>, Velocity<Meter>>>(this)

inline val Double.radiansPerSecondPerRadiansPerSecond
  get() = Value<Fraction<Velocity<Radian>, Velocity<Radian>>>(this)

inline val ProportionalGain<Radian, Velocity<Radian>>.inDegreesPerSecondPerDegree: Double
  get() = value

inline val IntegralGain<Radian, Velocity<Radian>>.inDegreesPerSecondPerDegreeSeconds: Double
  get() = value

inline val DerivativeGain<Radian, Velocity<Radian>>.inDegreesPerSecondPerDegreesPerSecond: Double
  get() = value

inline val ProportionalGain<Radian, Velocity<Radian>>.inRadiansPerSecondPerRadian: Double
  get() = value

inline val IntegralGain<Radian, Velocity<Radian>>.inRadiansPerSecondPerRadianSeconds: Double
  get() = value

inline val DerivativeGain<Radian, Velocity<Radian>>.inRadiansPerSecondPerRadiansPerSecond: Double
  get() = value

inline val Value<Unitless>.metersPerMeter
  get() = Value<Fraction<Meter, Meter>>(value)

inline val Value<Unitless>.metersPerSecondPerMeterPerSecond
  get() = Value<Fraction<Velocity<Meter>, Velocity<Meter>>>(value)

inline val ProportionalGain<Meter, Velocity<Meter>>.inMetersPerSecondPerMeter
  get() = value

inline val IntegralGain<Meter, Velocity<Meter>>.inMetersPerSecondPerMeterSecond
  get() = value

inline val DerivativeGain<Meter, Velocity<Meter>>.inMetersPerSecondPerMetersPerSecond
  get() = value

inline val <K : UnitKey> Value<K>.perMeter
  get() = Value<Fraction<K, Meter>>(value)

inline val <K : UnitKey> Value<K>.perInch
  get() = perMeter * METERS_PER_INCH

inline val <K : UnitKey> Value<K>.perFoot
  get() = perMeter * METERS_PER_FOOT

inline val <K : UnitKey> Value<K>.perRadian
  get() = Value<Fraction<K, Radian>>(value)

inline val <K : UnitKey> Value<K>.perDegree
  get() = perRadian * RADIANS_PER_DEGREES

inline val <K : UnitKey> Value<K>.perRotation
  get() = perRadian * RADIANS_PER_ROTATION

inline val <K : UnitKey> Value<K>.perMeterSeconds
  get() = Value<Fraction<K, Product<Meter, Second>>>(value)

inline val <K : UnitKey> Value<K>.perInchSeconds
  get() = perMeterSeconds / METERS_PER_INCH

inline val <K : UnitKey> Value<K>.perFootSeconds
  get() = perMeterSeconds / METERS_PER_FOOT

inline val <K : UnitKey> Value<K>.perRadianSeconds
  get() = Value<Fraction<K, Product<Radian, Second>>>(value)

inline val <K : UnitKey> Value<K>.perDegreeSeconds
  get() = perRadianSeconds / RADIANS_PER_DEGREES

inline val <K : UnitKey> Value<K>.perMeterPerSecond
  get() = Value<Fraction<K, Fraction<Meter, Second>>>(value)

inline val <K : UnitKey> Value<K>.perInchPerSecond
  get() = perMeterPerSecond / METERS_PER_INCH

inline val <K : UnitKey> Value<K>.perFootPerSecond
  get() = perMeterPerSecond / METERS_PER_FOOT

inline val <K : UnitKey> Value<K>.perRadianPerSecond
  get() = Value<Fraction<K, Fraction<Radian, Second>>>(value)

inline val <K : UnitKey> Value<K>.perDegreePerSecond
  get() = perRadianPerSecond / RADIANS_PER_DEGREES

inline val ProportionalGain<Meter, Volt>.inVoltsPerMeter: Double
  get() = value

inline val ProportionalGain<Meter, Volt>.inVoltsPerInch: Double
  get() = inVoltsPerMeter * METERS_PER_INCH

inline val ProportionalGain<Meter, Volt>.inVoltsPerFoot: Double
  get() = inVoltsPerMeter * METERS_PER_FOOT

inline val ProportionalGain<Radian, Volt>.inVoltsPerRadian: Double
  get() = value

inline val ProportionalGain<Radian, Volt>.inVoltsPerDegree: Double
  get() = inVoltsPerRadian * RADIANS_PER_DEGREES

inline val ProportionalGain<Radian, Volt>.inVoltsPerRotation: Double
  get() = inVoltsPerRadian * RADIANS_PER_ROTATION

inline val ProportionalGain<Velocity<Meter>, Volt>.inVoltsPerMetersPerSecond: Double
  get() = value

inline val ProportionalGain<Velocity<Radian>, Volt>.inVoltsPerRadiansPerSecond: Double
  get() = value

inline val ProportionalGain<Velocity<Radian>, Volt>.inVoltsPerRotationPerMinute: Double
  get() = inVoltsPerRadiansPerSecond * RADIANS_PER_ROTATION / SECONDS_PER_MINUTE

inline val IntegralGain<Meter, Volt>.inVoltsPerMeterSeconds: Double
  get() = value

inline val IntegralGain<Meter, Volt>.inVoltsPerInchSeconds: Double
  get() = inVoltsPerMeterSeconds * METERS_PER_INCH

inline val IntegralGain<Meter, Volt>.inVoltsPerFootSeconds: Double
  get() = inVoltsPerMeterSeconds * METERS_PER_FOOT

inline val IntegralGain<Velocity<Meter>, Volt>.inVoltsPerMeters: Double
  get() = value

inline val IntegralGain<Radian, Volt>.inVoltsPerRadianSeconds: Double
  get() = value

inline val IntegralGain<Radian, Volt>.inVoltsPerDegreeSeconds: Double
  get() = inVoltsPerRadianSeconds * RADIANS_PER_DEGREES

inline val IntegralGain<Radian, Volt>.inVoltsPerRotationSeconds: Double
  get() = inVoltsPerRadianSeconds / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val IntegralGain<Velocity<Radian>, Volt>.inVoltsPerRadians: Double
  get() = value

inline val IntegralGain<Velocity<Radian>, Volt>.inVoltsPerDegrees: Double
  get() = inVoltsPerRadians * RADIANS_PER_DEGREES

inline val IntegralGain<Velocity<Radian>, Volt>.inVoltsPerRotations: Double
  get() = inVoltsPerRadians / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Meter, Volt>.inVoltsPerMeterPerSecond: Double
  get() = value

inline val DerivativeGain<Meter, Volt>.inVoltsPerInchPerSecond: Double
  get() = inVoltsPerMeterPerSecond * METERS_PER_INCH

inline val DerivativeGain<Meter, Volt>.inVoltsPerFootPerSecond: Double
  get() = inVoltsPerMeterPerSecond * METERS_PER_FOOT

inline val DerivativeGain<Velocity<Meter>, Volt>.inVoltsPerMetersPerSecondPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Volt>.inVoltsPerRadianPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Volt>.inVoltsPerDegreePerSecond: Double
  get() = inVoltsPerRadianPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Radian, Volt>.inVoltsPerRotationsPerMinute: Double
  get() = inVoltsPerRadianPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Velocity<Radian>, Volt>.inVoltsPerRadiansPerSecondPerSecond: Double
  get() = value

inline val DerivativeGain<Velocity<Radian>, Volt>.inVoltsPerDegreesPerSecondPerSecond: Double
  get() = inVoltsPerRadiansPerSecondPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Velocity<Radian>, Volt>.inVoltsPerRotationsPerMinutePerSecond: Double
  get() = inVoltsPerRadiansPerSecondPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val ProportionalGain<Meter, Ampere>.inAmpsPerMeter: Double
  get() = value

inline val ProportionalGain<Meter, Ampere>.inAmpsPerInch: Double
  get() = inAmpsPerMeter * METERS_PER_INCH

inline val ProportionalGain<Meter, Ampere>.inAmpsPerFoot: Double
  get() = inAmpsPerMeter * METERS_PER_FOOT

inline val ProportionalGain<Radian, Ampere>.inAmpsPerRadian: Double
  get() = value

inline val ProportionalGain<Radian, Ampere>.inAmpsPerDegrees: Double
  get() = inAmpsPerRadian * RADIANS_PER_DEGREES

inline val ProportionalGain<Radian, Ampere>.inAmpsPerRotation: Double
  get() = inAmpsPerRadian * RADIANS_PER_ROTATION

inline val IntegralGain<Meter, Ampere>.inAmpsPerMeterSeconds: Double
  get() = value

inline val IntegralGain<Meter, Ampere>.inAmpsPerInchSeconds: Double
  get() = inAmpsPerMeterSeconds * METERS_PER_INCH

inline val IntegralGain<Meter, Ampere>.inAmpsPerFootSeconds: Double
  get() = inAmpsPerMeterSeconds * METERS_PER_FOOT

inline val IntegralGain<Radian, Ampere>.inAmpsPerRadianSeconds: Double
  get() = value

inline val IntegralGain<Radian, Ampere>.inAmpsPerDegreeSeconds: Double
  get() = inAmpsPerRadianSeconds * RADIANS_PER_DEGREES

inline val IntegralGain<Radian, Ampere>.inAmpsPerRotationsMinutes: Double
  get() = inAmpsPerRadianSeconds / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Meter, Ampere>.inAmpsPerMeterPerSecond: Double
  get() = value

inline val DerivativeGain<Meter, Ampere>.inAmpsPerInchPerSecond: Double
  get() = inAmpsPerMeterPerSecond * METERS_PER_INCH

inline val DerivativeGain<Meter, Ampere>.inAmpsPerFootPerSecond: Double
  get() = inAmpsPerMeterPerSecond * METERS_PER_FOOT

inline val DerivativeGain<Radian, Ampere>.inAmpsPerRadianPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Ampere>.inAmpsPerDegreePerSecond: Double
  get() = inAmpsPerRadianPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Radian, Ampere>.inAmpsPerRotationsPerMinute: Double
  get() = inAmpsPerRadianPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION
