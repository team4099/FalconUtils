package com.team4099.controller

import org.team4099.lib.controller.PIDController
import org.team4099.lib.units.Fraction
import org.team4099.lib.units.base.Meter
import org.team4099.lib.units.base.Second
import org.team4099.lib.units.base.meters
import org.team4099.lib.units.base.seconds
import org.team4099.lib.units.derived.ProportionalGain
import org.team4099.lib.units.derived.metersPerSecondPerMetersPerSecond
import org.team4099.lib.units.perSecond
import org.junit.jupiter.api.Test

class PIDControllerTest {

  @Test
  fun testConstruction() {
    val kP: ProportionalGain<Meter, Fraction<Meter, Second>> = 10.meters.perSecond / 1.meters
    val kD = (0.5.meters.perSecond / (1.meters / 1.seconds)).metersPerSecondPerMetersPerSecond
    val kI = 0.1.meters.perSecond / (10.meters * 1.seconds)
    val positionToVelocityPIDController = PIDController<Meter, Fraction<Meter, Second>>(kP, kI, kD)
  }
}
