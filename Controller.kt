package org.team4099.lib.units.derived

typealias ProportionalGain<E, O> = Value<Fraction<O, E>>

typealias IntegralGain<E, O> = Value<Fraction<O, Product<E, Second>>>

typealias DerivativeGain<E, O> = Value<Fraction<O, Fraction<E, Second>>>

inline val ProportionalGain<Radian, Volt>.inVoltPerRadian
  get() = value
inline val IntegralGain<Radian, Volt>.inVoltPerRadian
  get() = value
inline val DerivativeGain<Radian, Volt>.inVoltPerRadian
  get() = value

inline val ProportionalGain<Meter, Volt>.inVoltPerMeter
  get() = value
inline val IntegralGain<Meter, Volt>.inVoltPerMeter
  get() = value
inline val DerivativeGain<Meter, Volt>.inVoltPerMeter
  get() = value

inline val ProportionalGain<Radian, Ampere>.inAmperePerRadian
  get() = value
inline val IntegralGain<Radian, Ampere>.inAmperePerRadian
  get() = value
inline val DerivativeGain<Radian, Ampere>.inAmperePerRadian
  get() = value

inline val ProportionalGain<Meter, Ampere>.inAmperePerMeter
  get() = value
inline val IntegralGain<Meter, Ampere>.inAmperePerMeter
  get() = value
inline val DerivativeGain<Meter, Ampere>.inAmperePerMeter
  get() = value
