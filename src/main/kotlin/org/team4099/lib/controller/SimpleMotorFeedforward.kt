package org.team4099.lib.controller

import org.team4099.lib.units.Acceleration
import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value
import org.team4099.lib.units.Velocity
import org.team4099.lib.units.base.Time
import org.team4099.lib.units.base.inSeconds
import org.team4099.lib.units.derived.AccelerationFeedforward
import org.team4099.lib.units.derived.StaticFeedforward
import org.team4099.lib.units.derived.VelocityFeedforward
import edu.wpi.first.math.controller.SimpleMotorFeedforward as WPISimpleFeedforward

class SimpleMotorFeedforward<E : UnitKey, O : UnitKey>(
  val kS: StaticFeedforward<O>,
  val kV: VelocityFeedforward<E, O>,
  val kA: AccelerationFeedforward<E, O>
) {
  private val feedforward: WPISimpleFeedforward = WPISimpleFeedforward(kS.value, kV.value, kA.value)

  constructor(
    kS: StaticFeedforward<O>,
    kV: VelocityFeedforward<E, O>
  ) : this(kS, kV, AccelerationFeedforward(0.0))

  fun calculate(velocity: Value<Velocity<E>>, acceleration: Value<Acceleration<E>>): Value<O> {
    return Value(feedforward.calculate(velocity.value, acceleration.value))
  }

  fun calculate(
    currentVelocitySetpoint: Value<Velocity<E>>,
    nextVelocitySetpoint: Value<Velocity<E>>,
    dT: Time
  ): Value<O> {
    return Value(
      feedforward.calculate(
        currentVelocitySetpoint.value, nextVelocitySetpoint.value, dT.inSeconds
      )
    )
  }

  fun calculate(velocity: Value<Velocity<E>>): Value<O> {
    return Value(feedforward.calculate(velocity.value))
  }

  fun maxAchievableVelocity(
    maxControlOutput: Value<O>,
    acceleration: Value<Acceleration<E>>
  ): Value<Velocity<E>> {
    return Value(feedforward.maxAchievableVelocity(maxControlOutput.value, acceleration.value))
  }

  fun minAchievableVelocity(
    maxControlOutput: Value<O>,
    acceleration: Value<Acceleration<E>>
  ): Value<Velocity<E>> {
    return Value(feedforward.minAchievableVelocity(maxControlOutput.value, acceleration.value))
  }

  fun maxAchievableAcceleration(
    maxControlOutput: Value<O>,
    velocity: Value<Velocity<E>>
  ): Value<Acceleration<E>> {
    return Value(feedforward.maxAchievableAcceleration(maxControlOutput.value, velocity.value))
  }

  fun minAchievableAcceleration(
    maxControlOutput: Value<O>,
    velocity: Value<Velocity<E>>
  ): Value<Acceleration<E>> {
    return Value(feedforward.minAchievableAcceleration(maxControlOutput.value, velocity.value))
  }
}
