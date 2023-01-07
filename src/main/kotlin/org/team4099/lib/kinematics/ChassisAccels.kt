package org.team4099.lib.kinematics

import org.team4099.lib.units.AngularAcceleration
import org.team4099.lib.units.LinearAcceleration
import org.team4099.lib.units.base.meters
import org.team4099.lib.units.derived.Angle
import org.team4099.lib.units.derived.cos
import org.team4099.lib.units.derived.radians
import org.team4099.lib.units.derived.sin
import org.team4099.lib.units.inMetersPerSecondPerSecond
import org.team4099.lib.units.inRadiansPerSecondPerSecond
import org.team4099.lib.units.perSecond
import edu.wpi.first.math.kinematics.ChassisSpeeds as ChassisSpeedsWPILIB

class ChassisAccels(
  val ax: LinearAcceleration,
  val ay: LinearAcceleration,
  val alpha: AngularAcceleration
) {
  constructor() :
    this(
      0.0.meters.perSecond.perSecond,
      0.0.meters.perSecond.perSecond,
      0.0.radians.perSecond.perSecond
    ) {}

  val chassisAccelsWPILIB =
    ChassisSpeedsWPILIB(
      ax.inMetersPerSecondPerSecond,
      ay.inMetersPerSecondPerSecond,
      alpha.inRadiansPerSecondPerSecond
    )

  companion object {
    fun fromFieldRelativeAccels(
      ax: LinearAcceleration,
      ay: LinearAcceleration,
      alpha: AngularAcceleration,
      robotAngle: Angle
    ): ChassisAccels {
      return ChassisAccels(
        ax * robotAngle.cos + ay * robotAngle.sin,
        -ax * robotAngle.sin + ay * robotAngle.cos,
        alpha
      )
    }

    fun fromFieldRelativeAccels(
      fieldRelativeAccels: ChassisAccels,
      robotAngle: Angle
    ): ChassisAccels {
      return fromFieldRelativeAccels(
        fieldRelativeAccels.ax, fieldRelativeAccels.ay, fieldRelativeAccels.alpha, robotAngle
      )
    }
  }
}
