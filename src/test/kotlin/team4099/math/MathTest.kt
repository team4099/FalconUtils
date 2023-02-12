package team4099.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.team4099.lib.math.clamp
import org.team4099.lib.units.base.inInches
import org.team4099.lib.units.base.inches

class MathTest {

  @Test
  fun noClamp() {
    val value = 5.0.inches
    val lowerBound = 0.0.inches
    val upperBound = 10.0.inches
    assertEquals(clamp(value, lowerBound, upperBound).inInches, value.inInches)
  }

  @Test
  fun upperClamp() {
    val value = 15.0.inches
    val lowerBound = 0.0.inches
    val upperBound = 10.0.inches
    assertEquals(clamp(value, lowerBound, upperBound).inInches, upperBound.inInches)
  }

  @Test
  fun lowerClamp() {
    val value = -5.0.inches
    val lowerBound = 0.0.inches
    val upperBound = 10.0.inches
    assertEquals(clamp(value, lowerBound, upperBound).inInches, lowerBound.inInches)
  }
}
