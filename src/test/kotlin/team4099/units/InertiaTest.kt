package team4099.units

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.team4099.lib.units.base.grams
import org.team4099.lib.units.base.inches
import org.team4099.lib.units.derived.inKilogramsMeterSquared
import org.team4099.lib.units.derived.meterSquared
import org.team4099.lib.units.kilo

class InertiaTest {

  private val kEpsilon = 1E-9

  @Test
  fun testInertia() {
    val inertia = 1.0.kilo.grams * 3.0.inches.squared
    val inertiaDefinition = 1.0.kilo.grams.meterSquared

    assertEquals(1.0, inertiaDefinition.inKilogramsMeterSquared)
    assertEquals(0.00580644, inertia.inKilogramsMeterSquared, kEpsilon)
  }
}
