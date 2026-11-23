package team4099.units

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.team4099.lib.units.base.GRAMS_PER_POUND
import org.team4099.lib.units.base.grams
import org.team4099.lib.units.base.inches
import org.team4099.lib.units.base.pounds
import org.team4099.lib.units.derived.INCHES_SQUARED_PER_METER_SQUARED
import org.team4099.lib.units.derived.gramsMeterSquared
import org.team4099.lib.units.derived.inGramsMeterSquared
import org.team4099.lib.units.derived.inKilogramsMeterSquared
import org.team4099.lib.units.derived.inPoundsInchSquared
import org.team4099.lib.units.derived.poundsInchSquared
import org.team4099.lib.units.kilo

class InertiaTest {

  private val kEpsilon = 1E-9

  @Test
  fun testInertia() {
    val inertia = 1.0.kilo.grams * 3.0.inches.squared
    val inertiaDefinition = 1.0.kilo.gramsMeterSquared

    assertEquals(1.0, inertiaDefinition.inKilogramsMeterSquared)
    assertEquals(0.00580644, inertia.inKilogramsMeterSquared, kEpsilon)

    val inertia2 = 1.0.pounds * 3.0.inches.squared
    assertEquals(9.0, inertia2.inPoundsInchSquared, kEpsilon)

    val inertia3 = 9.0.poundsInchSquared
    assertEquals(inertia2.inKilogramsMeterSquared, inertia3.inKilogramsMeterSquared, kEpsilon)
  }

  @Test
  fun testKilogramsMeterSquaredToGramsMeterSquared() {
    val inertia = 4099.0.gramsMeterSquared

    assertEquals(inertia.inGramsMeterSquared, inertia.inKilogramsMeterSquared * 1000.0, kEpsilon)
  }

  @Test
  fun testGramsMeterSquaredToKilogramsMeterSquared() {
    val inertia = 4099.gramsMeterSquared

    assertEquals(inertia.inKilogramsMeterSquared, inertia.inGramsMeterSquared / 1000.0, kEpsilon)
  }

  @Test
  fun testKilogramsMeterSquaredToPoundsInchSquared() {
    val inertia = 4099.gramsMeterSquared

    assertEquals(
        inertia.inPoundsInchSquared,
        inertia.inKilogramsMeterSquared * 1000.0 / GRAMS_PER_POUND *
            INCHES_SQUARED_PER_METER_SQUARED,
        kEpsilon)
  }

  @Test
  fun testPoundsInchSquaredToKilogramsMeterSquared() {
    val inertia = 4099.poundsInchSquared

    assertEquals(
        inertia.inKilogramsMeterSquared,
        inertia.inPoundsInchSquared * GRAMS_PER_POUND / 1000.0 / INCHES_SQUARED_PER_METER_SQUARED,
        kEpsilon)
  }
}
