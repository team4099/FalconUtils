package org.team4099.lib.kinematics

import org.team4099.lib.units.AngularVelocity
import org.team4099.lib.units.LinearVelocity
import org.team4099.lib.units.Value
import org.team4099.lib.units.Velocity
import org.team4099.lib.units.base.Meter
import org.team4099.lib.units.base.meters
import org.team4099.lib.units.derived.Angle
import org.team4099.lib.units.derived.Radian
import org.team4099.lib.units.derived.cos
import org.team4099.lib.units.derived.radians
import org.team4099.lib.units.derived.sin
import org.team4099.lib.units.inMetersPerSecond
import org.team4099.lib.units.inRadiansPerSecond
import org.team4099.lib.units.perSecond
import edu.wpi.first.math.kinematics.ChassisSpeeds as WPIChassisSpeeds

class ChassisSpeeds(val vx: LinearVelocity, val vy: LinearVelocity, val omega: AngularVelocity) {
  constructor(
    chassisSpeeds: WPIChassisSpeeds
  ) : this(
    chassisSpeeds.vxMetersPerSecond.meters.perSecond,
    chassisSpeeds.vyMetersPerSecond.meters.perSecond,
    chassisSpeeds.omegaRadiansPerSecond.radians.perSecond
  ) {}

  constructor() : this(0.0.meters.perSecond, 0.0.meters.perSecond, 0.0.radians.perSecond) {}

  val chassisSpeedsWPILIB =
    WPIChassisSpeeds(vx.inMetersPerSecond, vy.inMetersPerSecond, omega.inRadiansPerSecond)

  companion object {
    fun fromFieldRelativeSpeeds(
      vx: Value<Velocity<Meter>>,
      vy: Value<Velocity<Meter>>,
      omega: Value<Velocity<Radian>>,
      robotAngle: Angle
    ): ChassisSpeeds {
      return ChassisSpeeds(
        vx * robotAngle.cos + vy * robotAngle.sin,
        -vx * robotAngle.sin + vy * robotAngle.cos,
        omega
      )
    }

    fun fromFieldRelativeSpeeds(
      fieldRelativeSpeeds: ChassisSpeeds,
      robotAngle: Angle
    ): ChassisSpeeds {
      return fromFieldRelativeSpeeds(
        fieldRelativeSpeeds.vx, fieldRelativeSpeeds.vy, fieldRelativeSpeeds.omega, robotAngle
      )
    }
  }
}
