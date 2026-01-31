package org.team4099.lib.controller

import edu.wpi.first.math.controller.ProfiledPIDController as WPIProfiledPIDController
import org.team4099.lib.units.Fraction
import org.team4099.lib.units.Product
import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value
import org.team4099.lib.units.base.Second
import org.team4099.lib.units.base.Time
import org.team4099.lib.units.base.inSeconds
import org.team4099.lib.units.base.seconds
import org.team4099.lib.units.derived.DerivativeGain
import org.team4099.lib.units.derived.IntegralGain
import org.team4099.lib.units.derived.ProportionalGain

class ProfiledPIDController<E : UnitKey, O : UnitKey>(
    proportionalGain: ProportionalGain<E, O>,
    integralGain: IntegralGain<E, O>,
    derivativeGain: DerivativeGain<E, O>,
    constraints: TrapezoidProfile.Constraints<E>,
    period: Time,
) {
  val wpiPidController =
      WPIProfiledPIDController(
          proportionalGain.value,
          integralGain.value,
          derivativeGain.value,
          constraints.wpiConstraints,
          period.inSeconds,
      )

  var proportionalGain: ProportionalGain<E, O>
    get() = ProportionalGain(wpiPidController.p)
    set(value) {
      wpiPidController.p = value.value
    }

  val setpoint: TrapezoidProfile.State<E>
    get() = TrapezoidProfile.State(wpiPidController.setpoint)

  val atSetpoint: Boolean
    get() = wpiPidController.atSetpoint()

  var integralGain: IntegralGain<E, O>
    get() = IntegralGain(wpiPidController.i)
    set(value) {
      wpiPidController.i = value.value
    }

  var derivativeGain: DerivativeGain<E, O>
    get() = DerivativeGain(wpiPidController.d)
    set(value) {
      wpiPidController.d = value.value
    }

  val period: Time
    get() = wpiPidController.period.seconds

  var errorTolerance: Value<E>
    get() = Value(wpiPidController.positionTolerance)
    set(value) {
      wpiPidController.setTolerance(value.value)
    }

  var errorDerivativeTolerance: Value<Fraction<E, Second>>
    get() = Value(wpiPidController.velocityTolerance)
    set(value) {
      wpiPidController.setTolerance(wpiPidController.positionTolerance, value.value)
    }

  var goal: TrapezoidProfile.State<E>
    get() = TrapezoidProfile.State(wpiPidController.goal)
    set(value) {
      wpiPidController.goal = value.wpiState
    }

  val atGoal: Boolean
    get() = wpiPidController.atGoal()

  val error: Value<E>
    get() = Value(wpiPidController.positionError)

  val errorDerivative: Value<Fraction<E, Second>>
    get() = Value(wpiPidController.velocityError)

  // TODO: Fix this to not rely on robot code
  constructor(
      proportionalGain: ProportionalGain<E, O>,
      integralGain: IntegralGain<E, O>,
      derivativeGain: DerivativeGain<E, O>,
      constraints: TrapezoidProfile.Constraints<E>,
  ) : this(proportionalGain, integralGain, derivativeGain, constraints, 0.02.seconds)

  fun setGoal(goal: Value<E>) {
    wpiPidController.setGoal(goal.value)
  }

  fun calculate(measurement: Value<E>, goal: Value<E>): Value<O> {
    return Value(wpiPidController.calculate(measurement.value, goal.value))
  }

  fun calculate(measurement: Value<E>): Value<O> {
    return Value(wpiPidController.calculate(measurement.value))
  }

  fun calculate(measurement: Value<E>, goal: TrapezoidProfile.State<E>): Value<O> {
    return Value(wpiPidController.calculate(measurement.value, goal.wpiState))
  }

  fun calculate(
      measurement: Value<E>,
      goal: TrapezoidProfile.State<E>,
      constraints: TrapezoidProfile.Constraints<E>,
  ): Value<O> {
    return Value(
        wpiPidController.calculate(measurement.value, goal.wpiState, constraints.wpiConstraints),
    )
  }

  fun enableContinuousInput(minimumInput: Value<E>, maximumInput: Value<E>) {
    wpiPidController.enableContinuousInput(minimumInput.value, maximumInput.value)
  }

  fun disableContinuousInput() {
    wpiPidController.disableContinuousInput()
  }

  fun setIntegratorRange(
      minimumIntegral: Value<Product<E, Second>>,
      maximumIntegral: Value<Product<E, Second>>
  ) {
    wpiPidController.setIntegratorRange(minimumIntegral.value, maximumIntegral.value)
  }

  fun reset(measurement: TrapezoidProfile.State<E>) {
    wpiPidController.reset(measurement.wpiState)
  }

  fun reset(measuredPosition: Value<E>) {
    wpiPidController.reset(measuredPosition.value)
  }

  fun setPID(kP: ProportionalGain<E, O>, kI: IntegralGain<E, O>, kD: DerivativeGain<E, O>) {
    proportionalGain = kP
    integralGain = kI
    derivativeGain = kD
  }

  fun setConstraints(constraints: TrapezoidProfile.Constraints<E>) {
    wpiPidController.setConstraints(constraints.wpiConstraints)
  }
}
