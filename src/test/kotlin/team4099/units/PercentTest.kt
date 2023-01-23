package team4099.units

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.team4099.lib.units.base.inOutputPerSecond
import org.team4099.lib.units.base.percent
import org.team4099.lib.units.base.seconds
import org.team4099.lib.units.base.toDecimal
import org.team4099.lib.units.perSecond

class PercentTest {
  private val kEpsilon = 1E-9

  @Test
  fun testPercentToDecimal() {
    val percent = 50.0.percent
    Assertions.assertEquals(percent.toDecimal, 0.5, kEpsilon)
  }

  @Test
  fun testRate() {
    val rate = 50.0.percent / 2.seconds
    Assertions.assertEquals(rate.inOutputPerSecond, 0.25, kEpsilon)
  }
}
