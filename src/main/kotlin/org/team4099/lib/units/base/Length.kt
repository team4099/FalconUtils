package org.team4099.lib.units.base

import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value
import org.team4099.lib.units.attoinverse
import org.team4099.lib.units.centiinverse
import org.team4099.lib.units.decainverse
import org.team4099.lib.units.deciinverse
import org.team4099.lib.units.exainverse
import org.team4099.lib.units.femtoinverse
import org.team4099.lib.units.gigainverse
import org.team4099.lib.units.hectoinverse
import org.team4099.lib.units.kiloinverse
import org.team4099.lib.units.megainverse
import org.team4099.lib.units.microinverse
import org.team4099.lib.units.milliinverse
import org.team4099.lib.units.nanoinverse
import org.team4099.lib.units.petainverse
import org.team4099.lib.units.picoinverse
import org.team4099.lib.units.terainverse
import org.team4099.lib.units.yoctoinverse
import org.team4099.lib.units.yottainverse
import org.team4099.lib.units.zeptoinverse
import org.team4099.lib.units.zetainverse

object Meter : UnitKey

typealias Length = Value<Meter>

const val METERS_PER_INCH = 0.0254

const val METERS_PER_THOU = METERS_PER_INCH / 1000

const val METERS_PER_FOOT = METERS_PER_INCH * 12

inline val Double.meters: Length
  get() = Length(this)

inline val Double.inches: Length
  get() = Length(this * METERS_PER_INCH)

inline val Double.thou: Length
  get() = Length(this * METERS_PER_THOU)

inline val Double.feet: Length
  get() = Length(this * METERS_PER_FOOT)

inline val Number.meters: Length
  get() = toDouble().meters

inline val Number.inches: Length
  get() = toDouble().inches

inline val Number.thou: Length
  get() = toDouble().thou

inline val Number.feet: Length
  get() = toDouble().feet

inline val Length.inMeters: Double
  get() = value

inline val Length.inInches: Double
  get() = value / METERS_PER_INCH

inline val Length.inThou: Double
  get() = value / METERS_PER_THOU

inline val Length.inFeet: Double
  get() = value / METERS_PER_FOOT

inline val Length.inYottameters: Double
  get() = value * 1.yottainverse

inline val Length.inZetameters: Double
  get() = value * 1.zetainverse

inline val Length.inExameters: Double
  get() = value * 1.exainverse

inline val Length.inPetameters: Double
  get() = value * 1.petainverse

inline val Length.inTerameters: Double
  get() = value * 1.terainverse

inline val Length.inGigameters: Double
  get() = value * 1.gigainverse

inline val Length.inMegameters: Double
  get() = value * 1.megainverse

inline val Length.inKilometers: Double
  get() = value * 1.kiloinverse

inline val Length.inHectometers: Double
  get() = value * 1.hectoinverse

inline val Length.inDecameters: Double
  get() = value * 1.decainverse

inline val Length.inDecimeters: Double
  get() = value * 1.deciinverse

inline val Length.inCentimeters: Double
  get() = value * 1.centiinverse

inline val Length.inMillimeters: Double
  get() = value * 1.milliinverse

inline val Length.inMicrometers: Double
  get() = value * 1.microinverse

inline val Length.inNanometers: Double
  get() = value * 1.nanoinverse

inline val Length.inPicometers: Double
  get() = value * 1.picoinverse

inline val Length.inFemtometers: Double
  get() = value * 1.femtoinverse

inline val Length.inAttometers: Double
  get() = value * 1.attoinverse

inline val Length.inZeptometers: Double
  get() = value * 1.zeptoinverse

inline val Length.inYoctometers: Double
  get() = value * 1.yoctoinverse
