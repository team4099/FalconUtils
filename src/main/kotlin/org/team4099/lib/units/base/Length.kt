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

internal const val METERS_PER_INCH = 0.0254

internal const val METERS_PER_THOU = METERS_PER_INCH / 1000

internal const val METERS_PER_FOOT = METERS_PER_INCH * 12

val Double.meters: Length
  get() = Length(this)

val Double.inches: Length
  get() = Length(this * METERS_PER_INCH)

val Double.thou: Length
  get() = Length(this * METERS_PER_THOU)

val Double.feet: Length
  get() = Length(this * METERS_PER_FOOT)

val Number.meters: Length
  get() = toDouble().meters

val Number.inches: Length
  get() = toDouble().inches

val Number.thou: Length
  get() = toDouble().thou

val Number.feet: Length
  get() = toDouble().feet

val Length.inMeters: Double
  get() = value

val Length.inInches: Double
  get() = value / METERS_PER_INCH

val Length.inThou: Double
  get() = value / METERS_PER_THOU

val Length.inFeet: Double
  get() = value / METERS_PER_FOOT

val Length.inYottameters: Double
  get() = value * 1.yottainverse

val Length.inZetameters: Double
  get() = value * 1.zetainverse

val Length.inExameters: Double
  get() = value * 1.exainverse

val Length.inPetameters: Double
  get() = value * 1.petainverse

val Length.inTerameters: Double
  get() = value * 1.terainverse

val Length.inGigameters: Double
  get() = value * 1.gigainverse

val Length.inMegameters: Double
  get() = value * 1.megainverse

val Length.inKilometers: Double
  get() = value * 1.kiloinverse

val Length.inHectometers: Double
  get() = value * 1.hectoinverse

val Length.inDecameters: Double
  get() = value * 1.decainverse

val Length.inDecimeters: Double
  get() = value * 1.deciinverse

val Length.inCentimeters: Double
  get() = value * 1.centiinverse

val Length.inMillimeters: Double
  get() = value * 1.milliinverse

val Length.inMicrometers: Double
  get() = value * 1.microinverse

val Length.inNanometers: Double
  get() = value * 1.nanoinverse

val Length.inPicometers: Double
  get() = value * 1.picoinverse

val Length.inFemtometers: Double
  get() = value * 1.femtoinverse

val Length.inAttometers: Double
  get() = value * 1.attoinverse

val Length.inZeptometers: Double
  get() = value * 1.zeptoinverse

val Length.inYoctometers: Double
  get() = value * 1.yoctoinverse
