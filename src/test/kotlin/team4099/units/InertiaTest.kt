package team4099.units

import org.junit.jupiter.api.Test
import org.team4099.lib.units.base.grams
import org.team4099.lib.units.base.inches
import org.team4099.lib.units.derived.MomentOfInertia
import org.team4099.lib.units.derived.asKilogramsPerMeterSquared
import org.team4099.lib.units.kilo

class InertiaTest {

  private val kEpsilon = 1E-9

  @Test
  fun testInertia() {
    val inertia: MomentOfInertia = 1.0.kilo.grams * 3.0.inches.squared
    println(inertia.asKilogramsPerMeterSquared)
  }
}
