package com.team4099.units

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.team4099.lib.units.base.SECONDS_PER_HOUR
import org.team4099.lib.units.base.SECONDS_PER_MINUTE
import org.team4099.lib.units.base.hours
import org.team4099.lib.units.base.inAttoseconds
import org.team4099.lib.units.base.inCentiseconds
import org.team4099.lib.units.base.inDeciseconds
import org.team4099.lib.units.base.inFemtoseconds
import org.team4099.lib.units.base.inHours
import org.team4099.lib.units.base.inMicroseconds
import org.team4099.lib.units.base.inMilliseconds
import org.team4099.lib.units.base.inMinutes
import org.team4099.lib.units.base.inNanoseconds
import org.team4099.lib.units.base.inPicoseconds
import org.team4099.lib.units.base.inSeconds
import org.team4099.lib.units.base.inYoctoseconds
import org.team4099.lib.units.base.inZeptoseconds
import org.team4099.lib.units.base.minutes
import org.team4099.lib.units.base.seconds

/* Unit tests for Time units */
class TimeTest {
  private val kEpsilon = 1E-9

  @Test
  fun testSecondsToMinutes() {
    val seconds = 4099.seconds
    assertEquals(seconds.inMinutes, seconds.inSeconds / SECONDS_PER_MINUTE, kEpsilon)
  }

  @Test
  fun testSecondsToHours() {
    val seconds = 4099.seconds
    assertEquals(seconds.inHours, seconds.inSeconds / SECONDS_PER_HOUR, kEpsilon)
  }

  @Test
  fun testMinutesToSeconds() {
    val minutes = 4099.minutes
    assertEquals(minutes.inSeconds, minutes.inMinutes * SECONDS_PER_MINUTE, kEpsilon)
  }

  @Test
  fun testHoursToSeconds() {
    val hours = 4099.hours
    assertEquals(hours.inSeconds, hours.inHours * SECONDS_PER_HOUR, kEpsilon)
  }

  @Test
  fun testSecondsToDeciseconds() {
    val seconds = 1.seconds
    assertEquals(seconds.inDeciseconds, 1E1, kEpsilon)
  }

  @Test
  fun testSecondsToCentiseconds() {
    val seconds = 1.seconds
    assertEquals(seconds.inCentiseconds, 1E2, kEpsilon)
  }

  @Test
  fun testSecondsToMilliseconds() {
    val seconds = 1.seconds
    assertEquals(seconds.inMilliseconds, 1E3, kEpsilon)
  }

  @Test
  fun testSecondsToMicroseconds() {
    val seconds = 1.seconds
    assertEquals(seconds.inMicroseconds, 1E6, kEpsilon)
  }

  @Test
  fun testSecondsToNanoseconds() {
    val seconds = 1.seconds
    assertEquals(seconds.inNanoseconds, 1E9, kEpsilon)
  }

  @Test
  fun testSecondsToPicoseconds() {
    val seconds = 1.seconds
    assertEquals(seconds.inPicoseconds, 1E12, kEpsilon)
  }

  @Test
  fun testSecondsToFemtoseconds() {
    val seconds = 1.seconds
    assertEquals(seconds.inFemtoseconds, 1E15, kEpsilon)
  }

  @Test
  fun testSecondsToAttoseconds() {
    val seconds = 1.seconds
    assertEquals(seconds.inAttoseconds, 1E18, kEpsilon)
  }

  @Test
  fun testSecondsToZeptoseconds() {
    val seconds = 1.seconds
    assertEquals(seconds.inZeptoseconds, 1E21, kEpsilon)
  }

  @Test
  fun testSecondsToYoctoseconds() {
    val seconds = 1.seconds
    assertEquals(seconds.inYoctoseconds, 1E24, kEpsilon)
  }

  @Test
  fun testAddingSeconds() {
    val seconds1 = 9.seconds
    val seconds2 = 10.seconds
    assertEquals((seconds1 + seconds2).inSeconds, 19.0, kEpsilon)
  }

  @Test
  fun testSubtractingSeconds() {
    val seconds1 = 10.seconds
    val seconds2 = 9.seconds
    assertEquals((seconds1 - seconds2).inSeconds, 1.0, kEpsilon)
  }

  @Test
  fun testMultiplyingSecondsByScalar() {
    val seconds = 2.seconds
    val scalar = 3.0
    assertEquals((seconds * scalar).inSeconds, 6.0, kEpsilon)
  }

  @Test
  fun testDividingSecondsByScalar() {
    val seconds = 6.seconds
    val scalar = 3
    assertEquals((seconds / scalar).inSeconds, 2.0, kEpsilon)
  }
}
