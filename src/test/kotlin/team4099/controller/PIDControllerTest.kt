package com.team4099.controller

import org.junit.jupiter.api.Test
import org.team4099.lib.controller.PIDController
import org.team4099.lib.controller.ProfiledPIDController
import org.team4099.lib.controller.SimpleMotorFeedforward
import org.team4099.lib.controller.TrapezoidProfile
import org.team4099.lib.units.Acceleration
import org.team4099.lib.units.Fraction
import org.team4099.lib.units.Value
import org.team4099.lib.units.base.Meter
import org.team4099.lib.units.base.Second
import org.team4099.lib.units.base.amps
import org.team4099.lib.units.base.meters
import org.team4099.lib.units.base.seconds
import org.team4099.lib.units.derived.ProportionalGain
import org.team4099.lib.units.derived.degrees
import org.team4099.lib.units.derived.inDegreesPerSecondPerDegreesPerSecond
import org.team4099.lib.units.derived.metersPerSecondPerMetersPerSecond
import org.team4099.lib.units.derived.radiansPerSecondPerRadiansPerSecond
import org.team4099.lib.units.derived.volts
import org.team4099.lib.units.perSecond

class PIDControllerTest {

  @Test
  fun testConstruction() {
    val kP: ProportionalGain<Meter, Fraction<Meter, Second>> = 10.meters.perSecond / 1.meters
    val kD = (0.5.meters.perSecond / (1.meters / 1.seconds)).metersPerSecondPerMetersPerSecond
    val kI = 0.1.meters.perSecond / (10.meters * 1.seconds)
    val positionToVelocityPIDController = PIDController<Meter, Fraction<Meter, Second>>(kP, kI, kD)
  }

  @Test
  fun ampFeedForward() {
    val aff =
      SimpleMotorFeedforward(
        1.0.amps, 1.0.amps / 1.0.meters.perSecond, 1.0.amps / 1.0.meters.perSecond.perSecond
      )

    val vff =
      SimpleMotorFeedforward(
        1.0.volts, 1.0.volts / 1.0.meters.perSecond, 1.0.volts / 1.0.meters.perSecond.perSecond
      )

    val output: Value<Acceleration<Meter>> =
      vff.maxAchievableAcceleration(12.0.volts, 1.0.meters.perSecond)
    val aoutput: Value<Acceleration<Meter>> =
      aff.maxAchievableAcceleration(12.0.amps, 1.0.meters.perSecond)
  }

  @Test
  fun testPID() {
    val AUTO_LEVEL_KP = 2.0.meters.perSecond / 1.0.degrees // tune this
    val AUTO_LEVEL_KI = 2.0.meters.perSecond / (1.0.degrees * 1.seconds) // tune this
    val AUTO_LEVEL_KD = 2.0.meters.perSecond / (1.0.degrees.perSecond) // tune this
    val AUTO_LEVEL_MAX_VEL_SETPOINT = 5.degrees.perSecond
    val AUTO_LEVEL_MAX_ACCEL_SETPOINT = 3.degrees.perSecond / 1.0.seconds

    val levelPID =
      ProfiledPIDController(
        AUTO_LEVEL_KP,
        AUTO_LEVEL_KI,
        AUTO_LEVEL_KD,
        TrapezoidProfile.Constraints(
          AUTO_LEVEL_MAX_VEL_SETPOINT, AUTO_LEVEL_MAX_ACCEL_SETPOINT
        )
      )
  }

  @Test
  fun testConversion() {
    val kp = (0.1.degrees.perSecond / (1.degrees / 1.seconds)).radiansPerSecondPerRadiansPerSecond

    println(kp.inDegreesPerSecondPerDegreesPerSecond)
  }
}
