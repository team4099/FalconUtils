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

object Ampere : UnitKey

typealias Current = Value<Ampere>

val Double.amps: Current
  get() = Current(this)

val Number.amps: Current
  get() = this.toDouble().amps

val Current.inAmperes
  get() = value

val Current.inYottaamps
  get() = value * 1.yottainverse

val Current.inZetaamps
  get() = value * 1.zetainverse

val Current.inExaamps
  get() = value * 1.exainverse

val Current.inPetaamps
  get() = value * 1.petainverse

val Current.inTeraamps
  get() = value * 1.terainverse

val Current.inGigaamps
  get() = value * 1.gigainverse

val Current.inMegaamps
  get() = value * 1.megainverse

val Current.inKiloamps
  get() = value * 1.kiloinverse

val Current.inHectoamps
  get() = value * 1.hectoinverse

val Current.inDecaamps
  get() = value * 1.decainverse

val Current.inDeciamps
  get() = value * 1.deciinverse

val Current.inCentiamps
  get() = value * 1.centiinverse

val Current.inMilliamps
  get() = value * 1.milliinverse

val Current.inMicroamps
  get() = value * 1.microinverse

val Current.inNanoamps
  get() = value * 1.nanoinverse

val Current.inPicoamps
  get() = value * 1.picoinverse

val Current.inFemtoamps
  get() = value * 1.femtoinverse

val Current.inAttoamps
  get() = value * 1.attoinverse

val Current.inZeptoamps
  get() = value * 1.zeptoinverse

val Current.inYoctoamps
  get() = value * 1.yoctoinverse
