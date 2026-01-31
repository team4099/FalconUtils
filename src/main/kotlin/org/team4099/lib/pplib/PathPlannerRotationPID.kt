package org.team4099.lib.pplib

import com.pathplanner.lib.config.PIDConstants
import org.team4099.lib.units.Velocity
import org.team4099.lib.units.derived.Angle
import org.team4099.lib.units.derived.DerivativeGain
import org.team4099.lib.units.derived.IntegralGain
import org.team4099.lib.units.derived.ProportionalGain
import org.team4099.lib.units.derived.Radian
import org.team4099.lib.units.derived.inRadians
import org.team4099.lib.units.derived.inRadiansPerSecondPerRadian
import org.team4099.lib.units.derived.inRadiansPerSecondPerRadianPerSecond
import org.team4099.lib.units.derived.inRadiansPerSecondPerRadianSeconds
import org.team4099.lib.units.derived.radians

data class PathPlannerRotationPID(
    val kP: ProportionalGain<Radian, Velocity<Radian>>,
    val kI: IntegralGain<Radian, Velocity<Radian>>,
    val kD: DerivativeGain<Radian, Velocity<Radian>>,
    val iZone: Angle = 1.0.radians,
) {
  val pplibRotationConstants =
      PIDConstants(
          kP.inRadiansPerSecondPerRadian,
          kI.inRadiansPerSecondPerRadianSeconds,
          kD.inRadiansPerSecondPerRadianPerSecond,
          iZone.inRadians,
      )
}
