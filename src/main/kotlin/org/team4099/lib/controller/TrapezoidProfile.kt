package org.team4099.lib.controller

import org.team4099.lib.units.Acceleration
import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value
import org.team4099.lib.units.Velocity
import org.team4099.lib.units.base.Time
import org.team4099.lib.units.base.inSeconds
import org.team4099.lib.units.base.seconds
import edu.wpi.first.math.trajectory.TrapezoidProfile as WPITrapezoidProfile

class TrapezoidProfile<U : UnitKey>(
  val constraints: Constraints<U>,
  val goal: State<U>,
  val initial: State<U>
) {
  val trapezoidProfile =
    WPITrapezoidProfile(constraints.wpiConstraints, goal.wpiState, initial.wpiState)

  constructor(
    constraints: Constraints<U>,
    goal: State<U>
  ) : this(constraints, goal, State(Value(0.0), Value(0.0)))

  data class Constraints<U : UnitKey>(
    val maxVelocity: Value<Velocity<U>>,
    val maxAcceleration: Value<Acceleration<U>>
  ) {
    internal val wpiConstraints =
      WPITrapezoidProfile.Constraints(maxVelocity.value, maxAcceleration.value)
  }

  class State<U : UnitKey>(position: Value<U>, velocity: Value<Velocity<U>>) {
    val wpiState = WPITrapezoidProfile.State(position.value, velocity.value)

    var position = position
      get() = Value(wpiState.position)
      set(value) {
        field = value
        wpiState.position = value.value
      }

    var velocity = velocity
      get() = Value(wpiState.velocity)
      set(value) {
        field = value
        wpiState.velocity = value.value
      }

    constructor() : this(Value(0.0), Value(0.0))
    constructor(
      state: WPITrapezoidProfile.State
    ) : this(Value(state.position), Value(state.velocity))

    override fun equals(other: Any?): Boolean {
      if (this === other) return true
      if (javaClass != other?.javaClass) return false

      other as State<*>

      if (position != other.position) return false
      if (velocity != other.velocity) return false

      return true
    }

    override fun hashCode(): Int {
      var result = position.hashCode()
      result = 31 * result + velocity.hashCode()
      return result
    }
  }

  fun calculate(t: Time): State<U> {
    return State(trapezoidProfile.calculate(t.inSeconds))
  }

  fun timeLeftUntil(target: Value<U>): Time {
    return trapezoidProfile.timeLeftUntil(target.value).seconds
  }

  fun totalTime(): Time {
    return trapezoidProfile.totalTime().seconds
  }

  fun isFinished(t: Time): Boolean {
    return trapezoidProfile.isFinished(t.inSeconds)
  }
}
