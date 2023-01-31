package org.team4099.lib.controller

import org.team4099.lib.units.AngularAcceleration
import org.team4099.lib.units.AngularVelocity
import org.team4099.lib.units.derived.AccelerationFeedforward
import org.team4099.lib.units.derived.Angle
import org.team4099.lib.units.derived.AngularGravityFeedforward
import org.team4099.lib.units.derived.ElectricalPotential
import org.team4099.lib.units.derived.Radian
import org.team4099.lib.units.derived.StaticFeedforward
import org.team4099.lib.units.derived.VelocityFeedforward
import org.team4099.lib.units.derived.Volt
import org.team4099.lib.units.derived.inRadians
import org.team4099.lib.units.derived.inVolts
import org.team4099.lib.units.derived.inVoltsPerRadianPerSecond
import org.team4099.lib.units.derived.inVoltsPerRadianPerSecondPerSecond
import org.team4099.lib.units.derived.perRadianPerSecondPerSecond
import org.team4099.lib.units.derived.radians
import org.team4099.lib.units.derived.volts
import org.team4099.lib.units.inRadiansPerSecond
import org.team4099.lib.units.inRadiansPerSecondPerSecond
import org.team4099.lib.units.perSecond
import edu.wpi.first.math.controller.ArmFeedforward as WPIArmFeedforward

class ArmFeedforward(
  kS: StaticFeedforward<Volt>,
  kG: AngularGravityFeedforward,
  kV: VelocityFeedforward<Radian, Volt>,
  kA: AccelerationFeedforward<Radian, Volt>
) {
  private val feedforward =
    WPIArmFeedforward(
      kS.inVolts,
      kG.inVolts,
      kV.inVoltsPerRadianPerSecond,
      kA.inVoltsPerRadianPerSecondPerSecond
    )

  constructor(
    kS: StaticFeedforward<Volt>,
    kG: AngularGravityFeedforward,
    kV: VelocityFeedforward<Radian, Volt>
  ) : this(kS, kG, kV, 0.volts.perRadianPerSecondPerSecond)

  fun calculate(
    position: Angle,
    velocity: AngularVelocity,
    acceleration: AngularAcceleration
  ): ElectricalPotential {
    return feedforward.calculate(
      position.inRadians,
      velocity.inRadiansPerSecond,
      acceleration.inRadiansPerSecondPerSecond
    )
      .volts
  }

  fun calculate(position: Angle, velocity: AngularVelocity): ElectricalPotential {
    return feedforward.calculate(position.inRadians, velocity.inRadiansPerSecond).volts
  }

  fun maxAchievableVelocity(
    maxVoltage: ElectricalPotential,
    angle: Angle,
    acceleration: AngularAcceleration
  ): AngularVelocity {
    return feedforward.maxAchievableVelocity(
      maxVoltage.inVolts, angle.inRadians, acceleration.inRadiansPerSecondPerSecond
    )
      .radians
      .perSecond
  }

  fun minAchievableVelocity(
    maxVoltage: ElectricalPotential,
    angle: Angle,
    acceleration: AngularAcceleration
  ): AngularVelocity {
    return feedforward.minAchievableVelocity(
      maxVoltage.inVolts, angle.inRadians, acceleration.inRadiansPerSecondPerSecond
    )
      .radians
      .perSecond
  }

  fun maxAchievableAcceleration(
    maxVoltage: ElectricalPotential,
    angle: Angle,
    velocity: AngularVelocity
  ): AngularAcceleration {
    return feedforward.maxAchievableVelocity(
      maxVoltage.inVolts, angle.inRadians, velocity.inRadiansPerSecond
    )
      .radians
      .perSecond
      .perSecond
  }

  fun minAchievableAcceleration(
    maxVoltage: ElectricalPotential,
    angle: Angle,
    velocity: AngularVelocity
  ): AngularAcceleration {
    return feedforward.minAchievableAcceleration(
      maxVoltage.inVolts, angle.inRadians, velocity.inRadiansPerSecond
    )
      .radians
      .perSecond
      .perSecond
  }
}
