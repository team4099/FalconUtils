package org.team4099.lib.units.base

import org.team4099.lib.units.Magnitude
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

object Kilogram : UnitKey

typealias Mass = Value<Kilogram>

internal const val GRAMS_PER_POUND = 453.5924

val Double.grams: Mass
  get() = Mass(this / 1000)

val Double.pounds: Mass
  get() = Mass(this * GRAMS_PER_POUND / 1000)

val Number.grams: Mass
  get() = toDouble().grams

val Number.pounds: Mass
  get() = toDouble().pounds

val Mass.inGrams: Double
  get() = value * Magnitude.KILO

val Mass.inPounds: Double
  get() = (value * Magnitude.KILO) / GRAMS_PER_POUND

val Mass.inYottagrams: Double
  get() = (value * Magnitude.KILO) * 1.yottainverse

val Mass.inZetagrams: Double
  get() = (value * Magnitude.KILO) * 1.zetainverse

val Mass.inExagrams: Double
  get() = (value * Magnitude.KILO) * 1.exainverse

val Mass.inPetagrams: Double
  get() = (value * Magnitude.KILO) * 1.petainverse

val Mass.inTeragrams: Double
  get() = (value * Magnitude.KILO) * 1.terainverse

val Mass.inGigagrams: Double
  get() = (value * Magnitude.KILO) * 1.gigainverse

val Mass.inMegagrams: Double
  get() = (value * Magnitude.KILO) * 1.megainverse

val Mass.inKilograms: Double
  get() = (value * Magnitude.KILO) * 1.kiloinverse

val Mass.inHectograms: Double
  get() = (value * Magnitude.KILO) * 1.hectoinverse

val Mass.inDecagrams: Double
  get() = (value * Magnitude.KILO) * 1.decainverse

val Mass.inDecigrams: Double
  get() = (value * Magnitude.KILO) * 1.deciinverse

val Mass.inCentigrams: Double
  get() = (value * Magnitude.KILO) * 1.centiinverse

val Mass.inMilligrams: Double
  get() = (value * Magnitude.KILO) * 1.milliinverse

val Mass.inMicrograms: Double
  get() = (value * Magnitude.KILO) * 1.microinverse

val Mass.inNanograms: Double
  get() = (value * Magnitude.KILO) * 1.nanoinverse

val Mass.inPicograms: Double
  get() = (value * Magnitude.KILO) * 1.picoinverse

val Mass.inFemtograms: Double
  get() = (value * Magnitude.KILO) * 1.femtoinverse

val Mass.inAttograms: Double
  get() = (value * Magnitude.KILO) * 1.attoinverse

val Mass.inZeptograms: Double
  get() = (value * Magnitude.KILO) * 1.zeptoinverse

val Mass.inYoctograms: Double
  get() = (value * Magnitude.KILO) * 1.yoctoinverse
