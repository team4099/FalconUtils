package org.team4099.lib.units

import com.ctre.phoenix.motorcontrol.can.BaseTalon
import com.revrobotics.CANSparkMax
import org.team4099.lib.units.base.Length
import org.team4099.lib.units.base.Meter
import org.team4099.lib.units.base.Time
import org.team4099.lib.units.base.inMeters
import org.team4099.lib.units.base.inSeconds
import org.team4099.lib.units.base.meters
import org.team4099.lib.units.base.minutes
import org.team4099.lib.units.base.seconds
import org.team4099.lib.units.derived.DerivativeGain
import org.team4099.lib.units.derived.ElectricalPotential
import org.team4099.lib.units.derived.IntegralGain
import org.team4099.lib.units.derived.ProportionalGain
import org.team4099.lib.units.derived.Radian
import org.team4099.lib.units.derived.VelocityFeedforward
import org.team4099.lib.units.derived.Volt
import org.team4099.lib.units.derived.inRotations
import org.team4099.lib.units.derived.inVolts
import org.team4099.lib.units.derived.inVoltsPerMeter
import org.team4099.lib.units.derived.inVoltsPerMeterPerSecond
import org.team4099.lib.units.derived.inVoltsPerMeterSeconds
import org.team4099.lib.units.derived.inVoltsPerMeters
import org.team4099.lib.units.derived.inVoltsPerMetersPerSecond
import org.team4099.lib.units.derived.inVoltsPerMetersPerSecondPerSecond
import org.team4099.lib.units.derived.inVoltsPerRadian
import org.team4099.lib.units.derived.inVoltsPerRadianPerSecond
import org.team4099.lib.units.derived.inVoltsPerRadianSeconds
import org.team4099.lib.units.derived.inVoltsPerRadians
import org.team4099.lib.units.derived.inVoltsPerRadiansPerSecond
import org.team4099.lib.units.derived.inVoltsPerRadiansPerSecondPerSecond
import org.team4099.lib.units.derived.radians
import org.team4099.lib.units.derived.rotations
import kotlin.math.PI

enum class Timescale(val velocity: Time, val acceleration: Time) {
  REV_NEO(1.minutes, 1.seconds),
  CTRE(100.milli.seconds, 1.seconds),
}

interface MechanismSensor<U : UnitKey> {
  val position: Value<U>
  val velocity: Value<Velocity<U>>

  fun positionToRawUnits(position: Value<U>): Double
  fun velocityToRawUnits(velocity: Value<Velocity<U>>): Double
  fun accelerationToRawUnits(acceleration: Value<Acceleration<U>>): Double

  fun proportionalPositionGainToRawUnits(
    proportionalGain: ProportionalGain<U, Volt>,
  ): Double
  fun integralPositionGainToRawUnits(
    integralGain: IntegralGain<U, Volt>,
  ): Double
  fun derivativePositionGainToRawUnits(
    derivativeGain: DerivativeGain<U, Volt>,
  ): Double

  fun proportionalVelocityGainToRawUnits(
    proportionalGain: ProportionalGain<Velocity<U>, Volt>,
  ): Double
  fun integralVelocityGainToRawUnits(
    integralGain: IntegralGain<Velocity<U>, Volt>,
  ): Double
  fun derivativeVelocityGainToRawUnits(
    derivativeGain: DerivativeGain<Velocity<U>, Volt>,
  ): Double

  fun velocityFeedforwardToRawUnits(velocityFeedforward: VelocityFeedforward<U, Volt>): Double
}

class LinearMechanismSensor(
  val diameter: Length,
  val ratio: Double,
  val timescale: Timescale,
  val fullPowerThrottle: Double,
  val compensationVoltage: ElectricalPotential,
  val getRawVelocity: () -> Double,
  val getRawPosition: () -> Double
) : MechanismSensor<Meter> {
  override inline val position: Length
    get() = (diameter * PI) * getRawPosition() * ratio

  override inline val velocity: Value<Velocity<Meter>>
    get() {
      val linearUnscaledVelocity = diameter.inMeters * getRawVelocity() * ratio * PI
      return (linearUnscaledVelocity / timescale.velocity.inSeconds).meters.perSecond
    }

  override inline fun positionToRawUnits(position: Value<Meter>): Double =
    position / diameter / ratio / PI

  override inline fun velocityToRawUnits(velocity: Value<Velocity<Meter>>): Double {
    val linearUnscaledVelocity = velocity.inMetersPerSecond * timescale.velocity.inSeconds
    return linearUnscaledVelocity / diameter.inMeters / ratio / PI
  }

  override inline fun accelerationToRawUnits(acceleration: Value<Acceleration<Meter>>): Double {
    val linearUnscaledVelocity =
      velocity.inMetersPerSecond * timescale.velocity.inSeconds * timescale.acceleration.inSeconds
    return linearUnscaledVelocity / diameter.inMeters / ratio / PI
  }

  override inline fun proportionalPositionGainToRawUnits(
    proportionalGain: ProportionalGain<Meter, Volt>
  ): Double {
    return (proportionalGain.inVoltsPerMeter / (positionToRawUnits(1.meters))) /
      compensationVoltage.inVolts * fullPowerThrottle
  }

  override inline fun integralPositionGainToRawUnits(
    integralGain: IntegralGain<Meter, Volt>,
  ): Double {
    return (
      integralGain.inVoltsPerMeterSeconds /
        (positionToRawUnits(1.meters) * timescale.velocity.inSeconds)
      ) /
      compensationVoltage.inVolts * fullPowerThrottle
  }

  override inline fun derivativePositionGainToRawUnits(
    derivativeGain: DerivativeGain<Meter, Volt>,
  ): Double {
    return (
      derivativeGain.inVoltsPerMeterPerSecond * timescale.velocity.inSeconds /
        positionToRawUnits(1.meters)
      ) / compensationVoltage.inVolts * fullPowerThrottle
  }

  override inline fun proportionalVelocityGainToRawUnits(
    proportionalGain: ProportionalGain<Velocity<Meter>, Volt>
  ): Double {
    return (proportionalGain.inVoltsPerMetersPerSecond / (velocityToRawUnits(1.meters.perSecond))) /
      compensationVoltage.inVolts * fullPowerThrottle
  }

  override inline fun integralVelocityGainToRawUnits(
    integralGain: IntegralGain<Velocity<Meter>, Volt>,
  ): Double {
    return (
      integralGain.inVoltsPerMeters /
        (velocityToRawUnits(1.meters.perSecond) * timescale.velocity.inSeconds)
      ) /
      compensationVoltage.inVolts * fullPowerThrottle
  }

  override inline fun derivativeVelocityGainToRawUnits(
    derivativeGain: DerivativeGain<Velocity<Meter>, Volt>,
  ): Double {
    return (
      derivativeGain.inVoltsPerMetersPerSecondPerSecond * timescale.velocity.inSeconds /
        velocityToRawUnits(1.meters.perSecond)
      ) / compensationVoltage.inVolts * fullPowerThrottle
  }

  override inline fun velocityFeedforwardToRawUnits(
    velocityFeedforward: VelocityFeedforward<Meter, Volt>
  ): Double {
    return velocityFeedforward.value * velocityToRawUnits(1.0.meters.perSecond) /
      compensationVoltage.inVolts * fullPowerThrottle
  }
}

class AngularMechanismSensor(
  val ratio: Double,
  val timescale: Timescale,
  val fullPowerThrottle: Double,
  val compensationVoltage: ElectricalPotential,
  val getRawVelocity: () -> Double,
  val getRawPosition: () -> Double
) : MechanismSensor<Radian> {
  override inline val position: Value<Radian>
    get() = (getRawPosition() * ratio).rotations

  override inline val velocity: Value<Velocity<Radian>>
    get() = (getRawVelocity() * ratio / timescale.velocity.inSeconds).rotations.perSecond

  override inline fun positionToRawUnits(position: Value<Radian>): Double =
    position.inRotations / ratio

  override inline fun velocityToRawUnits(velocity: Value<Velocity<Radian>>): Double =
    (velocity.inRotationsPerSecond * timescale.velocity.inSeconds) / ratio

  override inline fun accelerationToRawUnits(acceleration: Value<Acceleration<Radian>>): Double =
    (
      acceleration.inRotationsPerSecondPerSecond *
        timescale.velocity.inSeconds *
        timescale.acceleration.inSeconds
      ) / ratio

  override inline fun proportionalPositionGainToRawUnits(
    proportionalGain: ProportionalGain<Radian, Volt>
  ): Double {
    return (proportionalGain.inVoltsPerRadian / (positionToRawUnits(1.radians))) /
      compensationVoltage.inVolts * fullPowerThrottle
  }

  override inline fun integralPositionGainToRawUnits(
    integralGain: IntegralGain<Radian, Volt>
  ): Double {
    return (
      integralGain.inVoltsPerRadianSeconds /
        (positionToRawUnits(1.radians) * timescale.velocity.inSeconds)
      ) /
      compensationVoltage.inVolts * fullPowerThrottle
  }

  override inline fun derivativePositionGainToRawUnits(
    derivativeGain: DerivativeGain<Radian, Volt>
  ): Double {
    return (
      derivativeGain.inVoltsPerRadianPerSecond * timescale.velocity.inSeconds /
        positionToRawUnits(1.radians)
      ) / compensationVoltage.inVolts * fullPowerThrottle
  }

  override inline fun proportionalVelocityGainToRawUnits(
    proportionalGain: ProportionalGain<Velocity<Radian>, Volt>
  ): Double {
    return (
      proportionalGain.inVoltsPerRadiansPerSecond /
        (velocityToRawUnits(1.radians.perSecond))
      ) / compensationVoltage.inVolts * fullPowerThrottle
  }

  override inline fun integralVelocityGainToRawUnits(
    integralGain: IntegralGain<Velocity<Radian>, Volt>
  ): Double {
    return (
      integralGain.inVoltsPerRadians /
        (velocityToRawUnits(1.radians.perSecond) * timescale.velocity.inSeconds)
      ) /
      compensationVoltage.inVolts * fullPowerThrottle
  }

  override inline fun derivativeVelocityGainToRawUnits(
    derivativeGain: DerivativeGain<Velocity<Radian>, Volt>
  ): Double {
    return (
      derivativeGain.inVoltsPerRadiansPerSecondPerSecond * timescale.velocity.inSeconds /
        velocityToRawUnits(1.radians.perSecond)
      ) / compensationVoltage.inVolts * fullPowerThrottle
  }

  override inline fun velocityFeedforwardToRawUnits(
    velocityFeedforward: VelocityFeedforward<Radian, Volt>
  ): Double {
    return velocityFeedforward.value * velocityToRawUnits(1.0.radians.perSecond) /
      compensationVoltage.inVolts * fullPowerThrottle
  }
}

fun ctreAngularMechanismSensor(
  controller: BaseTalon,
  sensorCpr: Int,
  ratio: Double,
  compensationVoltage: ElectricalPotential
): AngularMechanismSensor {
  return AngularMechanismSensor(
    ratio / sensorCpr,
    Timescale.CTRE,
    1023.0,
    compensationVoltage,
    { controller.selectedSensorVelocity.toDouble() },
    { controller.selectedSensorPosition.toDouble() }
  )
}

fun ctreLinearMechanismSensor(
  controller: BaseTalon,
  sensorCpr: Int,
  ratio: Double,
  diameter: Length,
  compensationVoltage: ElectricalPotential
): LinearMechanismSensor {
  return LinearMechanismSensor(
    diameter,
    ratio / sensorCpr,
    Timescale.CTRE,
    1023.0,
    compensationVoltage,
    { controller.selectedSensorVelocity.toDouble() },
    { controller.selectedSensorPosition.toDouble() }
  )
}

fun sparkMaxAngularMechanismSensor(
  controller: CANSparkMax,
  ratio: Double,
  compensationVoltage: ElectricalPotential
): AngularMechanismSensor {
  val encoder = controller.encoder

  return AngularMechanismSensor(
    ratio,
    Timescale.REV_NEO,
    1.0,
    compensationVoltage,
    { encoder.velocity },
    { encoder.position }
  )
}

fun sparkMaxLinearMechanismSensor(
  controller: CANSparkMax,
  ratio: Double,
  diameter: Length,
  compensationVoltage: ElectricalPotential
): LinearMechanismSensor {
  val encoder = controller.encoder

  return LinearMechanismSensor(
    diameter,
    ratio,
    Timescale.REV_NEO,
    1.0,
    compensationVoltage,
    { encoder.velocity },
    { encoder.position }
  )
}
