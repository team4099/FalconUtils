package team4099.units

import org.junit.jupiter.api.Test
import org.team4099.lib.units.derived.asDrivenOverDriving
import org.team4099.lib.units.derived.driven
import org.team4099.lib.units.derived.driving
import org.team4099.lib.units.derived.overdrive
import org.team4099.lib.units.derived.reduction

class GearRatioTest {

  private val kEpsilon = 1E-9

  @Test
  fun testGearRatio() {
    val reductionRatio = (18.0.driving / 72.0.driven).reduction
    val overdriveRatio = (18.0.driving / 72.0.driven).overdrive
    println(reductionRatio.asDrivenOverDriving) // 4.0
    println(overdriveRatio.asDrivenOverDriving) // 0.25
  }
}
