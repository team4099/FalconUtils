package org.team4099.lib.controller

import org.team4099.lib.units.LinearAcceleration
import org.team4099.lib.units.LinearVelocity
import org.team4099.lib.units.base.Meter
import org.team4099.lib.units.base.meters
import org.team4099.lib.units.derived.AccelerationFeedforward
import org.team4099.lib.units.derived.ElectricalPotential
import org.team4099.lib.units.derived.LinearGravityFeedforward
import org.team4099.lib.units.derived.StaticFeedforward
import org.team4099.lib.units.derived.VelocityFeedforward
import org.team4099.lib.units.derived.Volt
import org.team4099.lib.units.derived.inVolts
import org.team4099.lib.units.derived.inVoltsPerMeterPerSecond
import org.team4099.lib.units.derived.inVoltsPerMeterPerSecondPerSecond
import org.team4099.lib.units.derived.perMeterPerSecondPerSecond
import org.team4099.lib.units.derived.volts
import org.team4099.lib.units.inMetersPerSecond
import org.team4099.lib.units.inMetersPerSecondPerSecond
import org.team4099.lib.units.perSecond
import edu.wpi.first.math.controller.ElevatorFeedforward as WPIElevatorFeedforward

class ElevatorFeedforward(
  kS: StaticFeedforward<Volt>,
  kG: LinearGravityFeedforward,
  kV: VelocityFeedforward<Meter, Volt>,
  kA: AccelerationFeedforward<Meter, Volt>
) {
  private val feedforward =
    WPIElevatorFeedforward(
      kS.inVolts, kG.inVolts, kV.inVoltsPerMeterPerSecond, kA.inVoltsPerMeterPerSecondPerSecond
    )

  constructor(
    kS: StaticFeedforward<Volt>,
    kG: LinearGravityFeedforward,
    kV: VelocityFeedforward<Meter, Volt>
  ) : this(kS, kG, kV, 0.0.volts.perMeterPerSecondPerSecond)

  @Deprecated(
    message = "Marked for removal since 2025. Use calculute(velocity: LinearVelocity) instead.",
    level = DeprecationLevel.ERROR
  )
  fun calculate(velocity: LinearVelocity, acceleration: LinearAcceleration): ElectricalPotential {
    return feedforward.calculate(
      velocity.inMetersPerSecond, acceleration.inMetersPerSecondPerSecond
    )
      .volts
  }

  fun calculate(velocity: LinearVelocity): ElectricalPotential {
    return feedforward.calculate(velocity.inMetersPerSecond).volts
  }

  fun calculateWithVelocities(
    currentVelocity: LinearVelocity,
    nextVelocity: LinearVelocity
  ): ElectricalPotential {
    return feedforward.calculateWithVelocities(
      currentVelocity.inMetersPerSecond, nextVelocity.inMetersPerSecond
    )
      .volts
  }

  fun maxAchievableVelocity(
    maxVoltage: ElectricalPotential,
    acceleration: LinearAcceleration
  ): LinearVelocity {
    return feedforward.maxAchievableVelocity(
      maxVoltage.inVolts, acceleration.inMetersPerSecondPerSecond
    )
      .meters
      .perSecond
  }

  fun minAchievableVelocity(
    maxVoltage: ElectricalPotential,
    acceleration: LinearAcceleration
  ): LinearVelocity {
    return feedforward.minAchievableVelocity(
      maxVoltage.inVolts, acceleration.inMetersPerSecondPerSecond
    )
      .meters
      .perSecond
  }

  fun maxAchievableAcceleration(
    maxVoltage: ElectricalPotential,
    velocity: LinearVelocity
  ): LinearAcceleration {
    return feedforward.maxAchievableAcceleration(maxVoltage.inVolts, velocity.inMetersPerSecond)
      .meters
      .perSecond
      .perSecond
  }

  fun minAchievableAcceleration(
    maxVoltage: ElectricalPotential,
    velocity: LinearVelocity
  ): LinearAcceleration {
    return feedforward.minAchievableAcceleration(maxVoltage.inVolts, velocity.inMetersPerSecond)
      .meters
      .perSecond
      .perSecond
  }
}
