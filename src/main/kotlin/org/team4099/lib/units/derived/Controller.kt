package org.team4099.lib.units.derived

import org.team4099.lib.units.Fraction
import org.team4099.lib.units.Product
import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value
import org.team4099.lib.units.Velocity
import org.team4099.lib.units.base.Ampere
import org.team4099.lib.units.base.METERS_PER_FOOT
import org.team4099.lib.units.base.METERS_PER_INCH
import org.team4099.lib.units.base.Meter
import org.team4099.lib.units.base.SECONDS_PER_MINUTE
import org.team4099.lib.units.base.Second

// E: Error, O: Output

typealias ProportionalGain<E, O> = Value<Fraction<O, E>>

typealias IntegralGain<E, O> = Value<Fraction<O, Product<E, Second>>>

typealias DerivativeGain<E, O> = Value<Fraction<O, Fraction<E, Second>>>

inline val <K : UnitKey> Value<K>.perMeter
  get() = Value<Fraction<K, Meter>>(value)

inline val <K : UnitKey> Value<K>.perInch
  get() = perMeter / METERS_PER_INCH

inline val <K : UnitKey> Value<K>.perFoot
  get() = perMeter / METERS_PER_FOOT

inline val <K : UnitKey> Value<K>.perRadian
  get() = Value<Fraction<K, Radian>>(value)

inline val <K : UnitKey> Value<K>.perDegree
  get() = perRadian / RADIANS_PER_DEGREES

inline val <K : UnitKey> Value<K>.perRotation
  get() = perRadian / RADIANS_PER_ROTATION

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

inline val <K : UnitKey> Value<K>.perRotationPerMinute
  get() = (perRadianPerSecond * SECONDS_PER_MINUTE) / RADIANS_PER_ROTATION



inline val Double.VoltsPerVolts
  get() = Value<Fraction<Volt, Volt>>(this)

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


inline val Double.AmpsPerAmps
  get() = Value<Fraction<Ampere, Ampere>>(this)

inline val ProportionalGain<Meter, Ampere>.inAmpsPerMeter: Double
  get() = value

inline val ProportionalGain<Meter, Ampere>.inAmpsPerInch: Double
  get() = inAmpsPerMeter * METERS_PER_INCH

inline val ProportionalGain<Meter, Ampere>.inAmpsPerFoot: Double
  get() = inAmpsPerMeter * METERS_PER_FOOT

inline val ProportionalGain<Radian, Ampere>.inAmpsPerRadian: Double
  get() = value

inline val ProportionalGain<Radian, Ampere>.inAmpsPerDegree: Double
  get() = inAmpsPerRadian * RADIANS_PER_DEGREES

inline val ProportionalGain<Radian, Ampere>.inAmpsPerRotation: Double
  get() = inAmpsPerRadian * RADIANS_PER_ROTATION

inline val ProportionalGain<Velocity<Meter>, Ampere>.inAmpsPerMetersPerSecond: Double
  get() = value

inline val ProportionalGain<Velocity<Radian>, Ampere>.inAmpsPerRadiansPerSecond: Double
  get() = value

inline val ProportionalGain<Velocity<Radian>, Ampere>.inAmpsPerRotationPerMinute: Double
  get() = inAmpsPerRadiansPerSecond * RADIANS_PER_ROTATION / SECONDS_PER_MINUTE

inline val IntegralGain<Meter, Ampere>.inAmpsPerMeterSeconds: Double
  get() = value

inline val IntegralGain<Meter, Ampere>.inAmpsPerInchSeconds: Double
  get() = inAmpsPerMeterSeconds * METERS_PER_INCH

inline val IntegralGain<Meter, Ampere>.inAmpsPerFootSeconds: Double
  get() = inAmpsPerMeterSeconds * METERS_PER_FOOT

inline val IntegralGain<Velocity<Meter>, Ampere>.inAmpsPerMeters: Double
  get() = value

inline val IntegralGain<Radian, Ampere>.inAmpsPerRadianSeconds: Double
  get() = value

inline val IntegralGain<Radian, Ampere>.inAmpsPerDegreeSeconds: Double
  get() = inAmpsPerRadianSeconds * RADIANS_PER_DEGREES

inline val IntegralGain<Radian, Ampere>.inAmpsPerRotationSeconds: Double
  get() = inAmpsPerRadianSeconds / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val IntegralGain<Velocity<Radian>, Ampere>.inAmpsPerRadians: Double
  get() = value

inline val IntegralGain<Velocity<Radian>, Ampere>.inAmpsPerDegrees: Double
  get() = inAmpsPerRadians * RADIANS_PER_DEGREES

inline val IntegralGain<Velocity<Radian>, Ampere>.inAmpsPerRotations: Double
  get() = inAmpsPerRadians / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Meter, Ampere>.inAmpsPerMeterPerSecond: Double
  get() = value

inline val DerivativeGain<Meter, Ampere>.inAmpsPerInchPerSecond: Double
  get() = inAmpsPerMeterPerSecond * METERS_PER_INCH

inline val DerivativeGain<Meter, Ampere>.inAmpsPerFootPerSecond: Double
  get() = inAmpsPerMeterPerSecond * METERS_PER_FOOT

inline val DerivativeGain<Velocity<Meter>, Ampere>.inAmpsPerMetersPerSecondPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Ampere>.inAmpsPerRadianPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Ampere>.inAmpsPerDegreePerSecond: Double
  get() = inAmpsPerRadianPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Radian, Ampere>.inAmpsPerRotationsPerMinute: Double
  get() = inAmpsPerRadianPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Velocity<Radian>, Ampere>.inAmpsPerRadiansPerSecondPerSecond: Double
  get() = value

inline val DerivativeGain<Velocity<Radian>, Ampere>.inAmpsPerDegreesPerSecondPerSecond: Double
  get() = inAmpsPerRadiansPerSecondPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Velocity<Radian>, Ampere>.inAmpsPerRotationsPerMinutePerSecond: Double
  get() = inAmpsPerRadiansPerSecondPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION


inline val Double.radiansPerSecondPerRadiansPerSecond
  get() = Value<Fraction<Velocity<Radian>, Velocity<Radian>>>(this)

inline val ProportionalGain<Meter, Velocity<Radian>>.inRadiansPerSecondPerMeter: Double
  get() = value

inline val ProportionalGain<Meter, Velocity<Radian>>.inRadiansPerSecondPerInch: Double
  get() = inRadiansPerSecondPerMeter * METERS_PER_INCH

inline val ProportionalGain<Meter, Velocity<Radian>>.inRadiansPerSecondPerFoot: Double
  get() = inRadiansPerSecondPerMeter * METERS_PER_FOOT

inline val ProportionalGain<Radian, Velocity<Radian>>.inRadiansPerSecondPerRadian: Double
  get() = value

inline val ProportionalGain<Radian, Velocity<Radian>>.inRadiansPerSecondPerDegree: Double
  get() = inRadiansPerSecondPerRadian * RADIANS_PER_DEGREES

inline val ProportionalGain<Radian, Velocity<Radian>>.inRadiansPerSecondPerRotation: Double
  get() = inRadiansPerSecondPerRadian * RADIANS_PER_ROTATION

inline val ProportionalGain<Velocity<Meter>, Velocity<Radian>>.inRadiansPerSecondPerMetersPerSecond: Double
  get() = value

inline val ProportionalGain<Velocity<Radian>, Velocity<Radian>>.inRadiansPerSecondPerRadiansPerSecond: Double
  get() = value

inline val ProportionalGain<Velocity<Radian>, Velocity<Radian>>.inRadiansPerSecondPerRotationPerMinute: Double
  get() = inRadiansPerSecondPerRadiansPerSecond * RADIANS_PER_ROTATION / SECONDS_PER_MINUTE

inline val IntegralGain<Meter, Velocity<Radian>>.inRadiansPerSecondPerMeterSeconds: Double
  get() = value

inline val IntegralGain<Meter, Velocity<Radian>>.inRadiansPerSecondPerInchSeconds: Double
  get() = inRadiansPerSecondPerMeterSeconds * METERS_PER_INCH

inline val IntegralGain<Meter, Velocity<Radian>>.inRadiansPerSecondPerFootSeconds: Double
  get() = inRadiansPerSecondPerMeterSeconds * METERS_PER_FOOT

inline val IntegralGain<Velocity<Meter>, Velocity<Radian>>.inRadiansPerSecondPerMeters: Double
  get() = value

inline val IntegralGain<Radian, Velocity<Radian>>.inRadiansPerSecondPerRadianSeconds: Double
  get() = value

inline val IntegralGain<Radian, Velocity<Radian>>.inRadiansPerSecondPerDegreeSeconds: Double
  get() = inRadiansPerSecondPerRadianSeconds * RADIANS_PER_DEGREES

inline val IntegralGain<Radian, Velocity<Radian>>.inRadiansPerSecondPerRotationSeconds: Double
  get() = inRadiansPerSecondPerRadianSeconds / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val IntegralGain<Velocity<Radian>, Velocity<Radian>>.inRadiansPerSecondPerRadians: Double
  get() = value

inline val IntegralGain<Velocity<Radian>, Velocity<Radian>>.inRadiansPerSecondPerDegrees: Double
  get() = inRadiansPerSecondPerRadians * RADIANS_PER_DEGREES

inline val IntegralGain<Velocity<Radian>, Velocity<Radian>>.inRadiansPerSecondPerRotations: Double
  get() = inRadiansPerSecondPerRadians / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Meter, Velocity<Radian>>.inRadiansPerSecondPerMeterPerSecond: Double
  get() = value

inline val DerivativeGain<Meter, Velocity<Radian>>.inRadiansPerSecondPerInchPerSecond: Double
  get() = inRadiansPerSecondPerMeterPerSecond * METERS_PER_INCH

inline val DerivativeGain<Meter, Velocity<Radian>>.inRadiansPerSecondPerFootPerSecond: Double
  get() = inRadiansPerSecondPerMeterPerSecond * METERS_PER_FOOT

inline val DerivativeGain<Velocity<Meter>, Velocity<Radian>>.inRadiansPerSecondPerMetersPerSecondPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Velocity<Radian>>.inRadiansPerSecondPerRadianPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Velocity<Radian>>.inRadiansPerSecondPerDegreePerSecond: Double
  get() = inRadiansPerSecondPerRadianPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Radian, Velocity<Radian>>.inRadiansPerSecondPerRotationsPerMinute: Double
  get() = inRadiansPerSecondPerRadianPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Velocity<Radian>, Velocity<Radian>>.inRadiansPerSecondPerRadiansPerSecondPerSecond: Double
  get() = value

inline val DerivativeGain<Velocity<Radian>, Velocity<Radian>>.inRadiansPerSecondPerDegreesPerSecondPerSecond: Double
  get() = inRadiansPerSecondPerRadiansPerSecondPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Velocity<Radian>, Velocity<Radian>>.inRadiansPerSecondPerRotationsPerMinutePerSecond: Double
  get() = inRadiansPerSecondPerRadiansPerSecondPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION


inline val Double.metersPerSecondPerMetersPerSecond
  get() = Value<Fraction<Velocity<Meter>, Velocity<Meter>>>(this)

inline val ProportionalGain<Meter, Velocity<Meter>>.inMetersPerSecondPerMeter: Double
  get() = value

inline val ProportionalGain<Meter, Velocity<Meter>>.inMetersPerSecondPerInch: Double
  get() = inMetersPerSecondPerMeter * METERS_PER_INCH

inline val ProportionalGain<Meter, Velocity<Meter>>.inMetersPerSecondPerFoot: Double
  get() = inMetersPerSecondPerMeter * METERS_PER_FOOT

inline val ProportionalGain<Radian, Velocity<Meter>>.inMetersPerSecondPerRadian: Double
  get() = value

inline val ProportionalGain<Radian, Velocity<Meter>>.inMetersPerSecondPerDegree: Double
  get() = inMetersPerSecondPerRadian * RADIANS_PER_DEGREES

inline val ProportionalGain<Radian, Velocity<Meter>>.inMetersPerSecondPerRotation: Double
  get() = inMetersPerSecondPerRadian * RADIANS_PER_ROTATION

inline val ProportionalGain<Velocity<Meter>, Velocity<Meter>>.inMetersPerSecondPerMetersPerSecond: Double
  get() = value

inline val ProportionalGain<Velocity<Radian>, Velocity<Meter>>.inMetersPerSecondPerRadiansPerSecond: Double
  get() = value

inline val ProportionalGain<Velocity<Radian>, Velocity<Meter>>.inMetersPerSecondPerRotationPerMinute: Double
  get() = inMetersPerSecondPerRadiansPerSecond * RADIANS_PER_ROTATION / SECONDS_PER_MINUTE

inline val IntegralGain<Meter, Velocity<Meter>>.inMetersPerSecondPerMeterSeconds: Double
  get() = value

inline val IntegralGain<Meter, Velocity<Meter>>.inMetersPerSecondPerInchSeconds: Double
  get() = inMetersPerSecondPerMeterSeconds * METERS_PER_INCH

inline val IntegralGain<Meter, Velocity<Meter>>.inMetersPerSecondPerFootSeconds: Double
  get() = inMetersPerSecondPerMeterSeconds * METERS_PER_FOOT

inline val IntegralGain<Velocity<Meter>, Velocity<Meter>>.inMetersPerSecondPerMeters: Double
  get() = value

inline val IntegralGain<Radian, Velocity<Meter>>.inMetersPerSecondPerRadianSeconds: Double
  get() = value

inline val IntegralGain<Radian, Velocity<Meter>>.inMetersPerSecondPerDegreeSeconds: Double
  get() = inMetersPerSecondPerRadianSeconds * RADIANS_PER_DEGREES

inline val IntegralGain<Radian, Velocity<Meter>>.inMetersPerSecondPerRotationSeconds: Double
  get() = inMetersPerSecondPerRadianSeconds / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val IntegralGain<Velocity<Radian>, Velocity<Meter>>.inMetersPerSecondPerRadians: Double
  get() = value

inline val IntegralGain<Velocity<Radian>, Velocity<Meter>>.inMetersPerSecondPerDegrees: Double
  get() = inMetersPerSecondPerRadians * RADIANS_PER_DEGREES

inline val IntegralGain<Velocity<Radian>, Velocity<Meter>>.inMetersPerSecondPerRotations: Double
  get() = inMetersPerSecondPerRadians / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Meter, Velocity<Meter>>.inMetersPerSecondPerMeterPerSecond: Double
  get() = value

inline val DerivativeGain<Meter, Velocity<Meter>>.inMetersPerSecondPerInchPerSecond: Double
  get() = inMetersPerSecondPerMeterPerSecond * METERS_PER_INCH

inline val DerivativeGain<Meter, Velocity<Meter>>.inMetersPerSecondPerFootPerSecond: Double
  get() = inMetersPerSecondPerMeterPerSecond * METERS_PER_FOOT

inline val DerivativeGain<Velocity<Meter>, Velocity<Meter>>.inMetersPerSecondPerMetersPerSecondPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Velocity<Meter>>.inMetersPerSecondPerRadianPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Velocity<Meter>>.inMetersPerSecondPerDegreePerSecond: Double
  get() = inMetersPerSecondPerRadianPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Radian, Velocity<Meter>>.inMetersPerSecondPerRotationsPerMinute: Double
  get() = inMetersPerSecondPerRadianPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Velocity<Radian>, Velocity<Meter>>.inMetersPerSecondPerRadiansPerSecondPerSecond: Double
  get() = value

inline val DerivativeGain<Velocity<Radian>, Velocity<Meter>>.inMetersPerSecondPerDegreesPerSecondPerSecond: Double
  get() = inMetersPerSecondPerRadiansPerSecondPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Velocity<Radian>, Velocity<Meter>>.inMetersPerSecondPerRotationsPerMinutePerSecond: Double
  get() = inMetersPerSecondPerRadiansPerSecondPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION


inline val Double.MetersPerMeters
  get() = Value<Fraction<Meter, Meter>>(this)

inline val ProportionalGain<Meter, Meter>.inMetersPerMeter: Double
  get() = value

inline val ProportionalGain<Meter, Meter>.inMetersPerInch: Double
  get() = inMetersPerMeter * METERS_PER_INCH

inline val ProportionalGain<Meter, Meter>.inMetersPerFoot: Double
  get() = inMetersPerMeter * METERS_PER_FOOT

inline val ProportionalGain<Radian, Meter>.inMetersPerRadian: Double
  get() = value

inline val ProportionalGain<Radian, Meter>.inMetersPerDegree: Double
  get() = inMetersPerRadian * RADIANS_PER_DEGREES

inline val ProportionalGain<Radian, Meter>.inMetersPerRotation: Double
  get() = inMetersPerRadian * RADIANS_PER_ROTATION

inline val ProportionalGain<Velocity<Meter>, Meter>.inMetersPerMetersPerSecond: Double
  get() = value

inline val ProportionalGain<Velocity<Radian>, Meter>.inMetersPerRadiansPerSecond: Double
  get() = value

inline val ProportionalGain<Velocity<Radian>, Meter>.inMetersPerRotationPerMinute: Double
  get() = inMetersPerRadiansPerSecond * RADIANS_PER_ROTATION / SECONDS_PER_MINUTE

inline val IntegralGain<Meter, Meter>.inMetersPerMeterSeconds: Double
  get() = value

inline val IntegralGain<Meter, Meter>.inMetersPerInchSeconds: Double
  get() = inMetersPerMeterSeconds * METERS_PER_INCH

inline val IntegralGain<Meter, Meter>.inMetersPerFootSeconds: Double
  get() = inMetersPerMeterSeconds * METERS_PER_FOOT

inline val IntegralGain<Velocity<Meter>, Meter>.inMetersPerMeters: Double
  get() = value

inline val IntegralGain<Radian, Meter>.inMetersPerRadianSeconds: Double
  get() = value

inline val IntegralGain<Radian, Meter>.inMetersPerDegreeSeconds: Double
  get() = inMetersPerRadianSeconds * RADIANS_PER_DEGREES

inline val IntegralGain<Radian, Meter>.inMetersPerRotationSeconds: Double
  get() = inMetersPerRadianSeconds / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val IntegralGain<Velocity<Radian>, Meter>.inMetersPerRadians: Double
  get() = value

inline val IntegralGain<Velocity<Radian>, Meter>.inMetersPerDegrees: Double
  get() = inMetersPerRadians * RADIANS_PER_DEGREES

inline val IntegralGain<Velocity<Radian>, Meter>.inMetersPerRotations: Double
  get() = inMetersPerRadians / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Meter, Meter>.inMetersPerMeterPerSecond: Double
  get() = value

inline val DerivativeGain<Meter, Meter>.inMetersPerInchPerSecond: Double
  get() = inMetersPerMeterPerSecond * METERS_PER_INCH

inline val DerivativeGain<Meter, Meter>.inMetersPerFootPerSecond: Double
  get() = inMetersPerMeterPerSecond * METERS_PER_FOOT

inline val DerivativeGain<Velocity<Meter>, Meter>.inMetersPerMetersPerSecondPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Meter>.inMetersPerRadianPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Meter>.inMetersPerDegreePerSecond: Double
  get() = inMetersPerRadianPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Radian, Meter>.inMetersPerRotationsPerMinute: Double
  get() = inMetersPerRadianPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Velocity<Radian>, Meter>.inMetersPerRadiansPerSecondPerSecond: Double
  get() = value

inline val DerivativeGain<Velocity<Radian>, Meter>.inMetersPerDegreesPerSecondPerSecond: Double
  get() = inMetersPerRadiansPerSecondPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Velocity<Radian>, Meter>.inMetersPerRotationsPerMinutePerSecond: Double
  get() = inMetersPerRadiansPerSecondPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION


inline val Double.DegreesPerSecondPerDegreesPerSecond
  get() = Value<Fraction<Velocity<Radian>, Velocity<Radian>>>(this)

inline val ProportionalGain<Meter, Velocity<Radian>>.inDegreesPerSecondPerMeter: Double
  get() = value

inline val ProportionalGain<Meter, Velocity<Radian>>.inDegreesPerSecondPerInch: Double
  get() = inDegreesPerSecondPerMeter * METERS_PER_INCH

inline val ProportionalGain<Meter, Velocity<Radian>>.inDegreesPerSecondPerFoot: Double
  get() = inDegreesPerSecondPerMeter * METERS_PER_FOOT

inline val ProportionalGain<Radian, Velocity<Radian>>.inDegreesPerSecondPerRadian: Double
  get() = value

inline val ProportionalGain<Radian, Velocity<Radian>>.inDegreesPerSecondPerDegree: Double
  get() = inDegreesPerSecondPerRadian * RADIANS_PER_DEGREES

inline val ProportionalGain<Radian, Velocity<Radian>>.inDegreesPerSecondPerRotation: Double
  get() = inDegreesPerSecondPerRadian * RADIANS_PER_ROTATION

inline val ProportionalGain<Velocity<Meter>, Velocity<Radian>>.inDegreesPerSecondPerMetersPerSecond: Double
  get() = value

inline val ProportionalGain<Velocity<Radian>, Velocity<Radian>>.inDegreesPerSecondPerRadiansPerSecond: Double
  get() = value

inline val ProportionalGain<Velocity<Radian>, Velocity<Radian>>.inDegreesPerSecondPerRotationPerMinute: Double
  get() = inDegreesPerSecondPerRadiansPerSecond * RADIANS_PER_ROTATION / SECONDS_PER_MINUTE

inline val IntegralGain<Meter, Velocity<Radian>>.inDegreesPerSecondPerMeterSeconds: Double
  get() = value

inline val IntegralGain<Meter, Velocity<Radian>>.inDegreesPerSecondPerInchSeconds: Double
  get() = inDegreesPerSecondPerMeterSeconds * METERS_PER_INCH

inline val IntegralGain<Meter, Velocity<Radian>>.inDegreesPerSecondPerFootSeconds: Double
  get() = inDegreesPerSecondPerMeterSeconds * METERS_PER_FOOT

inline val IntegralGain<Velocity<Meter>, Velocity<Radian>>.inDegreesPerSecondPerMeters: Double
  get() = value

inline val IntegralGain<Radian, Velocity<Radian>>.inDegreesPerSecondPerRadianSeconds: Double
  get() = value

inline val IntegralGain<Radian, Velocity<Radian>>.inDegreesPerSecondPerDegreeSeconds: Double
  get() = inDegreesPerSecondPerRadianSeconds * RADIANS_PER_DEGREES

inline val IntegralGain<Radian, Velocity<Radian>>.inDegreesPerSecondPerRotationSeconds: Double
  get() = inDegreesPerSecondPerRadianSeconds / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val IntegralGain<Velocity<Radian>, Velocity<Radian>>.inDegreesPerSecondPerRadians: Double
  get() = value

inline val IntegralGain<Velocity<Radian>, Velocity<Radian>>.inDegreesPerSecondPerDegrees: Double
  get() = inDegreesPerSecondPerRadians * RADIANS_PER_DEGREES

inline val IntegralGain<Velocity<Radian>, Velocity<Radian>>.inDegreesPerSecondPerRotations: Double
  get() = inDegreesPerSecondPerRadians / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Meter, Velocity<Radian>>.inDegreesPerSecondPerMeterPerSecond: Double
  get() = value

inline val DerivativeGain<Meter, Velocity<Radian>>.inDegreesPerSecondPerInchPerSecond: Double
  get() = inDegreesPerSecondPerMeterPerSecond * METERS_PER_INCH

inline val DerivativeGain<Meter, Velocity<Radian>>.inDegreesPerSecondPerFootPerSecond: Double
  get() = inDegreesPerSecondPerMeterPerSecond * METERS_PER_FOOT

inline val DerivativeGain<Velocity<Meter>, Velocity<Radian>>.inDegreesPerSecondPerMetersPerSecondPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Velocity<Radian>>.inDegreesPerSecondPerRadianPerSecond: Double
  get() = value

inline val DerivativeGain<Radian, Velocity<Radian>>.inDegreesPerSecondPerDegreePerSecond: Double
  get() = inDegreesPerSecondPerRadianPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Radian, Velocity<Radian>>.inDegreesPerSecondPerRotationsPerMinute: Double
  get() = inDegreesPerSecondPerRadianPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION

inline val DerivativeGain<Velocity<Radian>, Velocity<Radian>>.inDegreesPerSecondPerRadiansPerSecondPerSecond: Double
  get() = value

inline val DerivativeGain<Velocity<Radian>, Velocity<Radian>>.inDegreesPerSecondPerDegreesPerSecondPerSecond: Double
  get() = inDegreesPerSecondPerRadiansPerSecondPerSecond * RADIANS_PER_DEGREES

inline val DerivativeGain<Velocity<Radian>, Velocity<Radian>>.inDegreesPerSecondPerRotationsPerMinutePerSecond: Double
  get() = inDegreesPerSecondPerRadiansPerSecondPerSecond / SECONDS_PER_MINUTE * RADIANS_PER_ROTATION
