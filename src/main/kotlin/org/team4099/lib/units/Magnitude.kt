package org.team4099.lib.units

object Magnitude {
  const val YOTTA = 1E24
  const val ZETA = 1E21
  const val EXA = 1E18
  const val PETA = 1E15
  const val TERA = 1E12
  const val GIGA = 1E9
  const val MEGA = 1E6
  const val KILO = 1E3
  const val HECTO = 1E2
  const val DECA = 10
  const val DECI = 1E-1
  const val CENTI = 1E-2
  const val MILLI = 1E-3
  const val MICRO = 1E-6
  const val NANO = 1E-9
  const val PICO = 1E-12
  const val FEMTO = 1E-15
  const val ATTO = 1E-18
  const val ZEPTO = 1E-21
  const val YOCTO = 1E-24

  const val YOTTA_INVERSE = 1E-24
  const val ZETA_INVERSE = 1E-21
  const val EXA_INVERSE = 1E-18
  const val PETA_INVERSE = 1E-15
  const val TERA_INVERSE = 1E-12
  const val GIGA_INVERSE = 1E-9
  const val MEGA_INVERSE = 1E-6
  const val KILO_INVERSE = 1E-3
  const val HECTO_INVERSE = 1E-2
  const val DECA_INVERSE = 1E-1
  const val DECI_INVERSE = 1E1
  const val CENTI_INVERSE = 1E2
  const val MILLI_INVERSE = 1E3
  const val MICRO_INVERSE = 1E6
  const val NANO_INVERSE = 1E9
  const val PICO_INVERSE = 1E12
  const val FEMTO_INVERSE = 1E15
  const val ATTO_INVERSE = 1E18
  const val ZEPTO_INVERSE = 1E21
  const val YOCTO_INVERSE = 1E24
}

inline val Double.yotta: Double
  get() = this * Magnitude.YOTTA

inline val Double.zeta: Double
  get() = this * Magnitude.ZETA

inline val Double.exa: Double
  get() = this * Magnitude.EXA

inline val Double.peta: Double
  get() = this * Magnitude.PETA

inline val Double.tera: Double
  get() = this * Magnitude.TERA

inline val Double.giga: Double
  get() = this * Magnitude.GIGA

inline val Double.mega: Double
  get() = this * Magnitude.MEGA

inline val Double.kilo: Double
  get() = this * Magnitude.KILO

inline val Double.hecto: Double
  get() = this * Magnitude.HECTO

inline val Double.deca: Double
  get() = this * Magnitude.DECA

inline val Double.deci: Double
  get() = this * Magnitude.DECI

inline val Double.centi: Double
  get() = this * Magnitude.CENTI

inline val Double.milli: Double
  get() = this * Magnitude.MILLI

inline val Double.micro: Double
  get() = this * Magnitude.MICRO

inline val Double.nano: Double
  get() = this * Magnitude.NANO

inline val Double.pico: Double
  get() = this * Magnitude.PICO

inline val Double.femto: Double
  get() = this * Magnitude.FEMTO

inline val Double.atto: Double
  get() = this * Magnitude.ATTO

inline val Double.zepto: Double
  get() = this * Magnitude.ZEPTO

inline val Double.yocto: Double
  get() = this * Magnitude.YOCTO

inline val Number.yotta: Double
  get() = this.toDouble() * Magnitude.YOTTA

inline val Number.zeta: Double
  get() = this.toDouble() * Magnitude.ZETA

inline val Number.exa: Double
  get() = this.toDouble() * Magnitude.EXA

inline val Number.peta: Double
  get() = this.toDouble() * Magnitude.PETA

inline val Number.tera: Double
  get() = this.toDouble() * Magnitude.TERA

inline val Number.giga: Double
  get() = this.toDouble() * Magnitude.GIGA

inline val Number.mega: Double
  get() = this.toDouble() * Magnitude.MEGA

inline val Number.kilo: Double
  get() = this.toDouble() * Magnitude.KILO

inline val Number.hecto: Double
  get() = this.toDouble() * Magnitude.HECTO

inline val Number.deca: Double
  get() = this.toDouble() * Magnitude.DECA

inline val Number.deci: Double
  get() = this.toDouble() * Magnitude.DECI

inline val Number.centi: Double
  get() = this.toDouble() * Magnitude.CENTI

inline val Number.milli: Double
  get() = this.toDouble() * Magnitude.MILLI

inline val Number.micro: Double
  get() = this.toDouble() * Magnitude.MICRO

inline val Number.nano: Double
  get() = this.toDouble() * Magnitude.NANO

inline val Number.pico: Double
  get() = this.toDouble() * Magnitude.PICO

inline val Number.femto: Double
  get() = this.toDouble() * Magnitude.FEMTO

inline val Number.atto: Double
  get() = this.toDouble() * Magnitude.ATTO

inline val Number.zepto: Double
  get() = this.toDouble() * Magnitude.ZEPTO

inline val Number.yocto: Double
  get() = this.toDouble() * Magnitude.YOCTO

inline val Double.yottainverse: Double
  get() = this * Magnitude.YOTTA_INVERSE

inline val Double.zetainverse: Double
  get() = this * Magnitude.ZETA_INVERSE

inline val Double.exainverse: Double
  get() = this * Magnitude.EXA_INVERSE

inline val Double.petainverse: Double
  get() = this * Magnitude.PETA_INVERSE

inline val Double.terainverse: Double
  get() = this * Magnitude.TERA_INVERSE

inline val Double.gigainverse: Double
  get() = this * Magnitude.GIGA_INVERSE

inline val Double.megainverse: Double
  get() = this * Magnitude.MEGA_INVERSE

inline val Double.kiloinverse: Double
  get() = this * Magnitude.KILO_INVERSE

inline val Double.hectoinverse: Double
  get() = this * Magnitude.HECTO_INVERSE

inline val Double.decainverse: Double
  get() = this * Magnitude.DECA_INVERSE

inline val Double.deciinverse: Double
  get() = this * Magnitude.DECI_INVERSE

inline val Double.centiinverse: Double
  get() = this * Magnitude.CENTI_INVERSE

inline val Double.milliinverse: Double
  get() = this * Magnitude.MILLI_INVERSE

inline val Double.microinverse: Double
  get() = this * Magnitude.MICRO_INVERSE

inline val Double.nanoinverse: Double
  get() = this * Magnitude.NANO_INVERSE

inline val Double.picoinverse: Double
  get() = this * Magnitude.PICO_INVERSE

inline val Double.femtoinverse: Double
  get() = this * Magnitude.FEMTO_INVERSE

inline val Double.attoinverse: Double
  get() = this * Magnitude.ATTO_INVERSE

inline val Double.zeptoinverse: Double
  get() = this * Magnitude.ZEPTO_INVERSE

inline val Double.yoctoinverse: Double
  get() = this * Magnitude.YOCTO_INVERSE

inline val Number.yottainverse: Double
  get() = this.toDouble() * Magnitude.YOTTA_INVERSE

inline val Number.zetainverse: Double
  get() = this.toDouble() * Magnitude.ZETA_INVERSE

inline val Number.exainverse: Double
  get() = this.toDouble() * Magnitude.EXA_INVERSE

inline val Number.petainverse: Double
  get() = this.toDouble() * Magnitude.PETA_INVERSE

inline val Number.terainverse: Double
  get() = this.toDouble() * Magnitude.TERA_INVERSE

inline val Number.gigainverse: Double
  get() = this.toDouble() * Magnitude.GIGA_INVERSE

inline val Number.megainverse: Double
  get() = this.toDouble() * Magnitude.MEGA_INVERSE

inline val Number.kiloinverse: Double
  get() = this.toDouble() * Magnitude.KILO_INVERSE

inline val Number.hectoinverse: Double
  get() = this.toDouble() * Magnitude.HECTO_INVERSE

inline val Number.decainverse: Double
  get() = this.toDouble() * Magnitude.DECA_INVERSE

inline val Number.deciinverse: Double
  get() = this.toDouble() * Magnitude.DECI_INVERSE

inline val Number.centiinverse: Double
  get() = this.toDouble() * Magnitude.CENTI_INVERSE

inline val Number.milliinverse: Double
  get() = this.toDouble() * Magnitude.MILLI_INVERSE

inline val Number.microinverse: Double
  get() = this.toDouble() * Magnitude.MICRO_INVERSE

inline val Number.nanoinverse: Double
  get() = this.toDouble() * Magnitude.NANO_INVERSE

inline val Number.picoinverse: Double
  get() = this.toDouble() * Magnitude.PICO_INVERSE

inline val Number.femtoinverse: Double
  get() = this.toDouble() * Magnitude.FEMTO_INVERSE

inline val Number.attoinverse: Double
  get() = this.toDouble() * Magnitude.ATTO_INVERSE

inline val Number.zeptoinverse: Double
  get() = this.toDouble() * Magnitude.ZEPTO_INVERSE

inline val Number.yoctoinverse: Double
  get() = this.toDouble() * Magnitude.YOCTO_INVERSE
