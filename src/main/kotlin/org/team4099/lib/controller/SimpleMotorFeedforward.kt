package org.team4099.lib.controller

import org.team4099.lib.units.Acceleration
import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value
import org.team4099.lib.units.Velocity
import org.team4099.lib.units.base.Time
import org.team4099.lib.units.base.inSeconds
import org.team4099.lib.units.derived.AccelerationFeedforward
import org.team4099.lib.units.derived.ElectricalPotential
import org.team4099.lib.units.derived.StaticFeedforward
import org.team4099.lib.units.derived.VelocityFeedforward
import org.team4099.lib.units.derived.volts
import edu.wpi.first.math.controller.SimpleMotorFeedforward as WPISimpleFeedforward

class SimpleMotorFeedforward<U : UnitKey, T : UnitKey>(
  val kS: StaticFeedforward<U>,
  val kV: VelocityFeedforward<U, T>,
  val kA: AccelerationFeedforward<U, T>
) {
  private val feedforward: WPISimpleFeedforward = WPISimpleFeedforward(kS.value, kV.value, kA.value)

  constructor(
    kS: StaticFeedforward<U>,
    kV: VelocityFeedforward<U, T>
  ) : this(kS, kV, AccelerationFeedforward(0.0))

  fun calculate(
    velocity: Value<Velocity<U>>,
    acceleration: Value<Acceleration<U>>
  ): ElectricalPotential {
    return feedforward.calculate(velocity.value, acceleration.value).volts
  }

  fun calculate(
    currentVelocitySetpoint: Value<Velocity<U>>,
    nextVelocitySetpoint: Value<Velocity<U>>,
    dT: Time
  ): Value<U> {
    return Value(
      feedforward.calculate(
        currentVelocitySetpoint.value, nextVelocitySetpoint.value, dT.inSeconds
      )
    )
  }

  fun calculate(velocity: Value<Velocity<T>>): Value<U> {
    return Value(feedforward.calculate(velocity.value))
  }

  fun maxAchievableVelocity(
    maxControlOutput: Value<U>,
    acceleration: Value<Acceleration<T>>
  ): Value<Velocity<T>> {
    return Value(feedforward.maxAchievableVelocity(maxControlOutput.value, acceleration.value))
  }

  fun minAchievableVelocity(
    maxControlOutput: Value<U>,
    acceleration: Value<Acceleration<T>>
  ): Value<Velocity<T>> {
    return Value(feedforward.minAchievableVelocity(maxControlOutput.value, acceleration.value))
  }

  fun maxAchievableAcceleration(
    maxControlOutput: Value<U>,
    velocity: Value<Velocity<T>>
  ): Value<Acceleration<T>> {
    return Value(feedforward.maxAchievableAcceleration(maxControlOutput.value, velocity.value))
  }

  fun minAchievableAcceleration(
    maxControlOutput: Value<U>,
    velocity: Value<Velocity<T>>
  ): Value<Acceleration<T>> {
    return Value(feedforward.minAchievableAcceleration(maxControlOutput.value, velocity.value))
  }
}
