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

object RefreshCycle : UnitKey

typealias Cycle = Value<RefreshCycle>

inline val Double.cycles: Cycle
    get() = Cycle(this)

inline val Number.cycles: Cycle
    get() = this.toDouble().cycles

inline val Cycle.inCycles
    get() = value

inline val Cycle.inYottacycles
    get() = value * 1.yottainverse

inline val Cycle.inZetacycles
    get() = value * 1.zetainverse

inline val Cycle.inExacycles
    get() = value * 1.exainverse

inline val Cycle.inPetacycles
    get() = value * 1.petainverse

inline val Cycle.inTeracycles
    get() = value * 1.terainverse

inline val Cycle.inGigacycles
    get() = value * 1.gigainverse

inline val Cycle.inMegacycles
    get() = value * 1.megainverse

inline val Cycle.inKilocycles
    get() = value * 1.kiloinverse

inline val Cycle.inHectocycles
    get() = value * 1.hectoinverse

inline val Cycle.inDecacycles
    get() = value * 1.decainverse

inline val Cycle.inDecicycles
    get() = value * 1.deciinverse

inline val Cycle.inCenticycles
    get() = value * 1.centiinverse

inline val Cycle.inMillicycles
    get() = value * 1.milliinverse

inline val Cycle.inMicrocycles
    get() = value * 1.microinverse

inline val Cycle.inNanocycles
    get() = value * 1.nanoinverse

inline val Cycle.inPicocycles
    get() = value * 1.picoinverse

inline val Cycle.inFemtocycles
    get() = value * 1.femtoinverse

inline val Cycle.inAttocycles
    get() = value * 1.attoinverse

inline val Cycle.inZeptocycles
    get() = value * 1.zeptoinverse

inline val Cycle.inYoctocycles
    get() = value * 1.yoctoinverse
