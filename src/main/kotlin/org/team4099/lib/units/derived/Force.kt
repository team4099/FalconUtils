package org.team4099.lib.units.derived

import org.team4099.lib.units.Fraction
import org.team4099.lib.units.Product
import org.team4099.lib.units.Squared
import org.team4099.lib.units.Value
import org.team4099.lib.units.attoinverse
import org.team4099.lib.units.base.Kilogram
import org.team4099.lib.units.base.Meter
import org.team4099.lib.units.base.Second
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

typealias Newton = Fraction<Product<Kilogram, Meter>, Squared<Second>>

typealias Force = Value<Newton>

inline val Double.newtons
  get() = Force(this)

inline val Number.newtons
  get() = Force(this.toDouble())

inline val Force.inNewtons: Double
  get() = value

inline val Force.inYottanewtons: Double
  get() = value * 1.yottainverse

inline val Force.inZetanewtons: Double
  get() = value * 1.zetainverse

inline val Force.inExanewtons: Double
  get() = value * 1.exainverse

inline val Force.inPetanewtons: Double
  get() = value * 1.petainverse

inline val Force.inTeranewtons: Double
  get() = value * 1.terainverse

inline val Force.inGiganewtons: Double
  get() = value * 1.gigainverse

inline val Force.inMeganewtons: Double
  get() = value * 1.megainverse

inline val Force.inKilonewtons: Double
  get() = value * 1.kiloinverse

inline val Force.inHectonewtons: Double
  get() = value * 1.hectoinverse

inline val Force.inDecanewtons: Double
  get() = value * 1.decainverse

inline val Force.inDecinewtons: Double
  get() = value * 1.deciinverse

inline val Force.inCentinewtons: Double
  get() = value * 1.centiinverse

inline val Force.inMillinewtons: Double
  get() = value * 1.milliinverse

inline val Force.inMicronewtons: Double
  get() = value * 1.microinverse

inline val Force.inNanonewtons: Double
  get() = value * 1.nanoinverse

inline val Force.inPiconewtons: Double
  get() = value * 1.picoinverse

inline val Force.inFemtonewtons: Double
  get() = value * 1.femtoinverse

inline val Force.inAttonewtons: Double
  get() = value * 1.attoinverse

inline val Force.inZeptonewtons: Double
  get() = value * 1.zeptoinverse

inline val Force.inYoctonewtons: Double
  get() = value * 1.yoctoinverse
