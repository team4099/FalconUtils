package team4099.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.team4099.lib.math.clamp
import org.team4099.lib.units.base.inInches
import org.team4099.lib.units.base.inches
import org.team4099.lib.units.max
import org.team4099.lib.units.min

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

  @Test
  fun min() {
    val a = -0.01.inches
    val b = 0.01.inches
    assertEquals(min(a, b), a)
  }

  @Test
  fun max() {
    val a = -0.01.inches
    val b = 0.01.inches
    assertEquals(max(a, b), b)
  }
}
