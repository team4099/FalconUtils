package com.team4099.units

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.team4099.lib.units.base.grams
import org.team4099.lib.units.base.inAttograms
import org.team4099.lib.units.base.inCentigrams
import org.team4099.lib.units.base.inDecagrams
import org.team4099.lib.units.base.inDecigrams
import org.team4099.lib.units.base.inExagrams
import org.team4099.lib.units.base.inFemtograms
import org.team4099.lib.units.base.inGigagrams
import org.team4099.lib.units.base.inGrams
import org.team4099.lib.units.base.inHectograms
import org.team4099.lib.units.base.inKilograms
import org.team4099.lib.units.base.inMegagrams
import org.team4099.lib.units.base.inMicrograms
import org.team4099.lib.units.base.inMilligrams
import org.team4099.lib.units.base.inNanograms
import org.team4099.lib.units.base.inPetagrams
import org.team4099.lib.units.base.inPicograms
import org.team4099.lib.units.base.inPounds
import org.team4099.lib.units.base.inTeragrams
import org.team4099.lib.units.base.inYoctograms
import org.team4099.lib.units.base.inYottagrams
import org.team4099.lib.units.base.inZeptograms
import org.team4099.lib.units.base.inZetagrams
import org.team4099.lib.units.base.pounds

/* Unit tests for Mass units */
class MassTest {
  private val kEpsilon = 1E-9

  @Test
  fun testGramsToPounds() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inPounds, 9.036747529279591, kEpsilon)
  }

  @Test
  fun testPoundsToGrams() {
    val weightPounds = 4099.pounds
    assertEquals(weightPounds.inGrams, 1859275.2476, kEpsilon)
  }

  @Test
  fun testGramsToYottagrams() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inYottagrams, 4.099E-21, kEpsilon)
  }

  @Test
  fun testGramsToZetagrams() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inZetagrams, 4.099E-18, kEpsilon)
  }

  @Test
  fun testGramsToExagrams() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inExagrams, 4.099E-15, kEpsilon)
  }

  @Test
  fun testGramsToPetagrams() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inPetagrams, 4.099E-12, kEpsilon)
  }

  @Test
  fun testGramsToTeragrams() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inTeragrams, 4.099E-9, kEpsilon)
  }

  @Test
  fun testGramsToGigagrams() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inGigagrams, 4.099E-6, kEpsilon)
  }

  @Test
  fun testGramsToMegagrams() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inMegagrams, 4.099E-3, kEpsilon)
  }

  @Test
  fun testGramsToKilograms() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inKilograms, 4.099E0, kEpsilon)
  }

  @Test
  fun testGramsToHectograms() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inHectograms, 4.099E1, kEpsilon)
  }

  @Test
  fun testGramsToDecagrams() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inDecagrams, 4.099E2, kEpsilon)
  }

  @Test
  fun testGramsToDecigrams() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inDecigrams, 4.099E4, kEpsilon)
  }

  @Test
  fun testGramstoCentigrams() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inCentigrams, 4.099E5, kEpsilon)
  }

  @Test
  fun testGramstoMilligrams() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inMilligrams, 4.099E6, kEpsilon)
  }

  @Test
  fun testGramstoMicrograms() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inMicrograms, 4.099E9, kEpsilon)
  }

  // Unstable due to floating point errors
  @Test
  fun testGramstoNanograms() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inNanograms, 4.099E12, kEpsilon)
  }

  // Unstable due to floating point errors
  @Test
  fun testGramstoPicograms() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inPicograms, 4.099E15, kEpsilon)
  }

  // Unstable due to floating point errors
  @Test
  fun testGramstoFemtograms() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inFemtograms, 4.099E18, kEpsilon)
  }

  // Unstable due to floating point errors
  @Test
  fun testGramstoAttograms() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inAttograms, 4.099E21, kEpsilon)
  }

  // Unstable due to floating point errors
  @Test
  fun testGramstoZeptograms() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inZeptograms, 4.099E24, kEpsilon)
  }

  // Unstable due to floating point errors
  @Test
  fun testGramstoYoctograms() {
    val weightGrams = 4099.grams
    assertEquals(weightGrams.inYoctograms, 4.099E27, kEpsilon)
  }

  @Test
  fun testAddingGrams() {
    val g1 = 1.0.grams
    val g2 = 2.0.grams
    assertEquals((g1 + g2).inGrams, 3.0, kEpsilon)
  }

  @Test
  fun testSubtractingGrams() {
    val g1 = 1.0.grams
    val g2 = 2.0.grams
    assertEquals((g2 - g1).inGrams, 1.0, kEpsilon)
  }

  @Test
  fun testMultiplyingGramsByScalar() {
    val g1 = 1.0.grams
    assertEquals((g1 * 4099).inGrams, 4099.0, kEpsilon)
  }

  @Test
  fun testDividingGramsByScalar() {
    val g1 = 4099.0.grams
    assertEquals((g1 / 4099.0).inGrams, 1.0, kEpsilon)
  }
}
