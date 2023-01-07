package com.team4099.units

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.team4099.lib.units.derived.inAttonewtons
import org.team4099.lib.units.derived.inCentinewtons
import org.team4099.lib.units.derived.inDecanewtons
import org.team4099.lib.units.derived.inDecinewtons
import org.team4099.lib.units.derived.inExanewtons
import org.team4099.lib.units.derived.inFemtonewtons
import org.team4099.lib.units.derived.inGiganewtons
import org.team4099.lib.units.derived.inHectonewtons
import org.team4099.lib.units.derived.inKilonewtons
import org.team4099.lib.units.derived.inMeganewtons
import org.team4099.lib.units.derived.inMicronewtons
import org.team4099.lib.units.derived.inMillinewtons
import org.team4099.lib.units.derived.inNanonewtons
import org.team4099.lib.units.derived.inNewtons
import org.team4099.lib.units.derived.inPetanewtons
import org.team4099.lib.units.derived.inPiconewtons
import org.team4099.lib.units.derived.inTeranewtons
import org.team4099.lib.units.derived.inYoctonewtons
import org.team4099.lib.units.derived.inYottanewtons
import org.team4099.lib.units.derived.inZeptonewtons
import org.team4099.lib.units.derived.inZetanewtons
import org.team4099.lib.units.derived.newtons

/* Unit tests for Force units */
class ForceTest {
  private val kEpsilon = 1E-9

  @Test
  fun testNewtonsToYottanewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inYottanewtons, 4.099E-21, kEpsilon)
  }

  @Test
  fun testNewtonsToZetanewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inZetanewtons, 4.099E-18, kEpsilon)
  }

  @Test
  fun testNewtonsToExanewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inExanewtons, 4.099E-15, kEpsilon)
  }

  @Test
  fun testNewtonsToPetanewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inPetanewtons, 4.099E-12, kEpsilon)
  }

  @Test
  fun testNewtonsToTeranewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inTeranewtons, 4.099E-9, kEpsilon)
  }

  @Test
  fun testNewtonsToGiganewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inGiganewtons, 4.099E-6, kEpsilon)
  }

  @Test
  fun testNewtonsToMeganewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inMeganewtons, 4.099E-3, kEpsilon)
  }

  @Test
  fun testNewtonsToKilonewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inKilonewtons, 4.099E0, kEpsilon)
  }

  @Test
  fun testNewtonsToHectonewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inHectonewtons, 4.099E1, kEpsilon)
  }

  @Test
  fun testNewtonsToDecanewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inDecanewtons, 4.099E2, kEpsilon)
  }

  @Test
  fun testNewtonsToDecinewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inDecinewtons, 4.099E4, kEpsilon)
  }

  @Test
  fun testNewtonsToCentinewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inCentinewtons, 4.099E5, kEpsilon)
  }

  @Test
  fun testNewtonsToMillinewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inMillinewtons, 4.099E6, kEpsilon)
  }

  @Test
  fun testNewtonsToMicronewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inMicronewtons, 4.099E9, kEpsilon)
  }

  // Unstable due to floating point errors
  @Test
  fun testNewtonsToNanonewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inNanonewtons, 4.099E12, kEpsilon)
  }

  // Unstable due to floating point errors
  @Test
  fun testNewtonsToPiconewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inPiconewtons, 4.099E15, kEpsilon)
  }

  // Unstable due to floating point errors
  @Test
  fun testNewtonsToFemtonewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inFemtonewtons, 4.099E18, kEpsilon)
  }

  // Unstable due to floating point errors
  @Test
  fun testNewtonsToAttonewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inAttonewtons, 4.099E21, kEpsilon)
  }

  // Unstable due to floating point errors
  @Test
  fun testNewtonsToZeptonewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inZeptonewtons, 4.099E24, kEpsilon)
  }

  // Unstable due to floating point errors
  @Test
  fun testNewtonsToYoctonewtons() {
    val forceNewtons = 4099.newtons
    Assertions.assertEquals(forceNewtons.inYoctonewtons, 4.099E27, kEpsilon)
  }

  @Test
  fun testAddingNewtons() {
    val f1 = 1.0.newtons
    val f2 = 2.0.newtons
    Assertions.assertEquals((f1 + f2).inNewtons, 3.0, kEpsilon)
  }

  @Test
  fun testSubtractingNewtons() {
    val f1 = 1.0.newtons
    val f2 = 2.0.newtons
    Assertions.assertEquals((f2 - f1).inNewtons, 1.0, kEpsilon)
  }

  @Test
  fun testMultiplyingNewtonsByScalar() {
    val f1 = 1.0.newtons
    Assertions.assertEquals((f1 * 4099).inNewtons, 4099.0, kEpsilon)
  }

  @Test
  fun testDividingNewtonsByScalar() {
    val f1 = 4099.0.newtons
    Assertions.assertEquals((f1 / 4099.0).inNewtons, 1.0, kEpsilon)
  }
}
