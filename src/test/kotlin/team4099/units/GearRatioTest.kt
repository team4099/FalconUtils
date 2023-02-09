package team4099.units

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.team4099.lib.units.derived.asDrivenOverDriving
import org.team4099.lib.units.derived.asDrivingOverDriven
import org.team4099.lib.units.derived.driven
import org.team4099.lib.units.derived.driving
import org.team4099.lib.units.derived.gearRatio

class GearRatioTest {

  private val kEpsilon = 1E-9

  @Test
  fun testGearRatio() {
    val reductionRatio = (72.0.driven / 18.0.driving).gearRatio

    assertEquals(reductionRatio.asDrivenOverDriving, 0.25)
    assertEquals(reductionRatio.asDrivingOverDriven, 4.0)
  }
}
