package org.team4099.lib.units.base

import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value
import org.team4099.lib.units.attoinverse
import org.team4099.lib.units.centiinverse
import org.team4099.lib.units.deciinverse
import org.team4099.lib.units.femtoinverse
import org.team4099.lib.units.microinverse
import org.team4099.lib.units.milliinverse
import org.team4099.lib.units.nanoinverse
import org.team4099.lib.units.picoinverse
import org.team4099.lib.units.yoctoinverse
import org.team4099.lib.units.zeptoinverse

object Second : UnitKey

typealias Time = Value<Second>

const val SECONDS_PER_MINUTE = 60

const val SECONDS_PER_HOUR = SECONDS_PER_MINUTE * 60

inline val Double.seconds: Time
  get() = Time(this)

inline val Double.minutes: Time
  get() = Time(this * SECONDS_PER_MINUTE)

inline val Double.hours: Time
  get() = Time(this * SECONDS_PER_HOUR)

inline val Number.seconds: Time
  get() = toDouble().seconds

inline val Number.minutes: Time
  get() = toDouble().minutes

inline val Number.hours: Time
  get() = toDouble().hours

inline val Time.inSeconds: Double
  get() = value

inline val Time.inMinutes: Double
  get() = value / SECONDS_PER_MINUTE

inline val Time.inHours: Double
  get() = value / SECONDS_PER_HOUR

inline val Time.inDeciseconds: Double
  get() = value * 1.deciinverse

inline val Time.inCentiseconds: Double
  get() = value * 1.centiinverse

inline val Time.inMilliseconds: Double
  get() = value * 1.milliinverse

inline val Time.inMicroseconds: Double
  get() = value * 1.microinverse

inline val Time.inNanoseconds: Double
  get() = value * 1.nanoinverse

inline val Time.inPicoseconds: Double
  get() = value * 1.picoinverse

inline val Time.inFemtoseconds: Double
  get() = value * 1.femtoinverse

inline val Time.inAttoseconds: Double
  get() = value * 1.attoinverse

inline val Time.inZeptoseconds: Double
  get() = value * 1.zeptoinverse

inline val Time.inYoctoseconds: Double
  get() = value * 1.yoctoinverse
