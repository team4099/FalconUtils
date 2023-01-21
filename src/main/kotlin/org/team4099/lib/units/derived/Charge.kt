package org.team4099.lib.units.derived

import org.team4099.lib.units.Product
import org.team4099.lib.units.Value
import org.team4099.lib.units.attoinverse
import org.team4099.lib.units.base.Ampere
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

typealias Coulomb = Product<Ampere, Second>

typealias Charge = Value<Coulomb>

inline val Double.coulombs
  get() = Charge(this)

inline val Number.coulombs
  get() = Charge(this.toDouble())

inline val Charge.inCoulombs: Double
  get() = value

inline val Charge.inYottacoulombs: Double
  get() = value * 1.yottainverse

inline val Charge.inZetacoulombs: Double
  get() = value * 1.zetainverse

inline val Charge.inExacoulombs: Double
  get() = value * 1.exainverse

inline val Charge.inPetacoulombs: Double
  get() = value * 1.petainverse

inline val Charge.inTeracoulombs: Double
  get() = value * 1.terainverse

inline val Charge.inGigacoulombs: Double
  get() = value * 1.gigainverse

inline val Charge.inMegacoulombs: Double
  get() = value * 1.megainverse

inline val Charge.inKilocoulombs: Double
  get() = value * 1.kiloinverse

inline val Charge.inHectocoulombs: Double
  get() = value * 1.hectoinverse

inline val Charge.inDecacoulombs: Double
  get() = value * 1.decainverse

inline val Charge.inDecicoulombs: Double
  get() = value * 1.deciinverse

inline val Charge.inCenticoulombs: Double
  get() = value * 1.centiinverse

inline val Charge.inMillicoulombs: Double
  get() = value * 1.milliinverse

inline val Charge.inMicrocoulombs: Double
  get() = value * 1.microinverse

inline val Charge.inNanocoulombs: Double
  get() = value * 1.nanoinverse

inline val Charge.inPicocoulombs: Double
  get() = value * 1.picoinverse

inline val Charge.inFemtocoulombs: Double
  get() = value * 1.femtoinverse

inline val Charge.inAttocoulombs: Double
  get() = value * 1.attoinverse

inline val Charge.inZeptocoulombs: Double
  get() = value * 1.zeptoinverse

inline val Charge.inYoctocoulombs: Double
  get() = value * 1.yoctoinverse
