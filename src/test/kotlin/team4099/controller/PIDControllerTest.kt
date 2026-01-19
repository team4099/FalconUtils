package com.team4099.controller

import org.junit.jupiter.api.Test
import org.team4099.lib.controller.ProfiledPIDController
import org.team4099.lib.controller.SimpleMotorFeedforward
import org.team4099.lib.controller.TrapezoidProfile
import org.team4099.lib.units.Acceleration
import org.team4099.lib.units.LinearMechanismSensor
import org.team4099.lib.units.Timescale
import org.team4099.lib.units.Value
import org.team4099.lib.units.base.Meter
import org.team4099.lib.units.base.amps
import org.team4099.lib.units.base.inches
import org.team4099.lib.units.base.meters
import org.team4099.lib.units.base.seconds
import org.team4099.lib.units.derived.degrees
import org.team4099.lib.units.derived.inVoltsPerInch
import org.team4099.lib.units.derived.inVoltsPerRotation
import org.team4099.lib.units.derived.inVoltsPerRotationPerMinute
import org.team4099.lib.units.derived.inVoltsPerRotationsPerMinutePerSecond
import org.team4099.lib.units.derived.perInch
import org.team4099.lib.units.derived.rotations
import org.team4099.lib.units.derived.volts
import org.team4099.lib.units.perMinute
import org.team4099.lib.units.perSecond

class PIDControllerTest {
  @Test
  fun ampFeedForward() {
    val aff =
        SimpleMotorFeedforward(
            1.0.amps,
            1.0.amps / 1.0.meters.perSecond,
            1.0.amps / 1.0.meters.perSecond.perSecond,
        )

    val vff =
        SimpleMotorFeedforward(
            1.0.volts,
            1.0.volts / 1.0.meters.perSecond,
            1.0.volts / 1.0.meters.perSecond.perSecond,
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
                AUTO_LEVEL_MAX_VEL_SETPOINT,
                AUTO_LEVEL_MAX_ACCEL_SETPOINT,
            ),
        )
  }

  @Test
  fun testConversion() {
    val kp = 0.4.volts.perInch

    println(kp.inVoltsPerInch)
  }

  @Test
  fun testRPM() {
    val kp = 2.0.volts / 1.0.rotations.perMinute
    val kI = 2.0.volts / 1.0.rotations
    val kD = 2.0.volts / 1.0.rotations.perMinute.perSecond

    println(kp.inVoltsPerRotationPerMinute)
    println(kI.inVoltsPerRotation)
    println(kD.inVoltsPerRotationsPerMinutePerSecond)
  }

  @Test
  fun testFFConversion() {
    val kFF = 12.0.volts / 4.1675.meters.perSecond

    val testSensor =
        LinearMechanismSensor(
            3.827.inches,
            (14.0 / 50.0) * (27.0 / 17.0) * (15.0 / 45.0) / 2048,
            Timescale.CTRE,
            1023.0,
            12.0.volts,
            { 0.0 },
            { 0.0 },
        )

    println(testSensor.velocityFeedforwardToRawUnits(kFF))
  }
}
