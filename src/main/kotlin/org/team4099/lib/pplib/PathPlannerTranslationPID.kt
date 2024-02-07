package org.team4099.lib.pplib

import com.pathplanner.lib.util.PIDConstants
import org.team4099.lib.units.Velocity
import org.team4099.lib.units.base.Length
import org.team4099.lib.units.base.Meter
import org.team4099.lib.units.base.inMeters
import org.team4099.lib.units.base.meters
import org.team4099.lib.units.derived.DerivativeGain
import org.team4099.lib.units.derived.IntegralGain
import org.team4099.lib.units.derived.ProportionalGain
import org.team4099.lib.units.derived.inMetersPerSecondPerMeter
import org.team4099.lib.units.derived.inMetersPerSecondPerMeterPerSecond
import org.team4099.lib.units.derived.inMetersPerSecondPerMeterSeconds

data class PathPlannerTranslationPID(
  val kP: ProportionalGain<Meter, Velocity<Meter>>,
  val kI: IntegralGain<Meter, Velocity<Meter>>,
  val kD: DerivativeGain<Meter, Velocity<Meter>>,
  val iZone: Length = 1.0.meters
) {
  val pplibTranslationConstants =
    PIDConstants(
      kP.inMetersPerSecondPerMeter,
      kI.inMetersPerSecondPerMeterSeconds,
      kD.inMetersPerSecondPerMeterPerSecond,
      iZone.inMeters
    )
}
