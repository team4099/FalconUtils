package org.team4099.lib.controller

import edu.wpi.first.math.controller.SimpleMotorFeedforward as WPISimpleFeedforward
import org.team4099.lib.units.Acceleration
import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value
import org.team4099.lib.units.Velocity
import org.team4099.lib.units.derived.AccelerationFeedforward
import org.team4099.lib.units.derived.StaticFeedforward
import org.team4099.lib.units.derived.VelocityFeedforward

class SimpleMotorFeedforward<E : UnitKey, O : UnitKey>(
    val kS: StaticFeedforward<O>,
    val kV: VelocityFeedforward<E, O>,
    val kA: AccelerationFeedforward<E, O>,
) {
  private val feedforward: WPISimpleFeedforward = WPISimpleFeedforward(kS.value, kV.value, kA.value)

  constructor(
      kS: StaticFeedforward<O>,
      kV: VelocityFeedforward<E, O>,
  ) : this(kS, kV, AccelerationFeedforward(0.0))

  @Deprecated(
      "calculate(Value<Velocity<E>>, Value<Velocity<E>>) is deprecated since version 2025 and marked for removal",
      replaceWith =
          ReplaceWith(
              "calculateWithVelocities(currentVelocitySetpoint: Value<Velocity<E>>, nextVelocitySetpoint: Value<Velocity<E>>)",
          ),
  )
  fun calculate(velocity: Value<Velocity<E>>, acceleration: Value<Acceleration<E>>): Value<O> {
    return Value(feedforward.calculate(velocity.value, acceleration.value))
  }

  fun calculateWithVelocities(
      currentVelocitySetpoint: Value<Velocity<E>>,
      nextVelocitySetpoint: Value<Velocity<E>>,
  ): Value<O> {
    return Value(
        feedforward.calculateWithVelocities(
            currentVelocitySetpoint.value,
            nextVelocitySetpoint.value,
        ),
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
