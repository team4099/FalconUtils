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

inline val Double.amps: Current
  get() = Current(this)

inline val Number.amps: Current
  get() = this.toDouble().amps

inline val Current.inAmperes
  get() = value

inline val Current.inYottaamps
  get() = value * 1.yottainverse

inline val Current.inZetaamps
  get() = value * 1.zetainverse

inline val Current.inExaamps
  get() = value * 1.exainverse

inline val Current.inPetaamps
  get() = value * 1.petainverse

inline val Current.inTeraamps
  get() = value * 1.terainverse

inline val Current.inGigaamps
  get() = value * 1.gigainverse

inline val Current.inMegaamps
  get() = value * 1.megainverse

inline val Current.inKiloamps
  get() = value * 1.kiloinverse

inline val Current.inHectoamps
  get() = value * 1.hectoinverse

inline val Current.inDecaamps
  get() = value * 1.decainverse

inline val Current.inDeciamps
  get() = value * 1.deciinverse

inline val Current.inCentiamps
  get() = value * 1.centiinverse

inline val Current.inMilliamps
  get() = value * 1.milliinverse

inline val Current.inMicroamps
  get() = value * 1.microinverse

inline val Current.inNanoamps
  get() = value * 1.nanoinverse

inline val Current.inPicoamps
  get() = value * 1.picoinverse

inline val Current.inFemtoamps
  get() = value * 1.femtoinverse

inline val Current.inAttoamps
  get() = value * 1.attoinverse

inline val Current.inZeptoamps
  get() = value * 1.zeptoinverse

inline val Current.inYoctoamps
  get() = value * 1.yoctoinverse
