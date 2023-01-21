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

typealias Joule = Fraction<Product<Kilogram, Squared<Meter>>, Squared<Second>>

typealias Energy = Value<Joule>

inline val Double.joules
  get() = Energy(this)

inline val Number.joules
  get() = Energy(this.toDouble())

inline val Energy.inJoules: Double
  get() = value

inline val Energy.inYottajoules: Double
  get() = value * 1.yottainverse

inline val Energy.inZetajoules: Double
  get() = value * 1.zetainverse

inline val Energy.inExajoules: Double
  get() = value * 1.exainverse

inline val Energy.inPetajoules: Double
  get() = value * 1.petainverse

inline val Energy.inTerajoules: Double
  get() = value * 1.terainverse

inline val Energy.inGigajoules: Double
  get() = value * 1.gigainverse

inline val Energy.inMegajoules: Double
  get() = value * 1.megainverse

inline val Energy.inKilojoules: Double
  get() = value * 1.kiloinverse

inline val Energy.inHectojoules: Double
  get() = value * 1.hectoinverse

inline val Energy.inDecajoules: Double
  get() = value * 1.decainverse

inline val Energy.inDecijoules: Double
  get() = value * 1.deciinverse

inline val Energy.inCentijoules: Double
  get() = value * 1.centiinverse

inline val Energy.inMillijoules: Double
  get() = value * 1.milliinverse

inline val Energy.inMicrojoules: Double
  get() = value * 1.microinverse

inline val Energy.inNanojoules: Double
  get() = value * 1.nanoinverse

inline val Energy.inPicojoules: Double
  get() = value * 1.picoinverse

inline val Energy.inFemtojoules: Double
  get() = value * 1.femtoinverse

inline val Energy.inAttojoules: Double
  get() = value * 1.attoinverse

inline val Energy.inZeptojoules: Double
  get() = value * 1.zeptoinverse

inline val Energy.inYoctojoules: Double
  get() = value * 1.yoctoinverse
