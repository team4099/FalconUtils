package org.team4099.lib.kinematics

import org.team4099.lib.geometry.Translation2d
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
import org.wpilib.math.kinematics.ChassisAccelerations as ChassisAccelerationsWPILIB

class ChassisAccelerations(
    val ax: LinearAcceleration,
    val ay: LinearAcceleration,
    val alpha: AngularAcceleration,
) {
  constructor(
      chassisAccelerationsWPILIB: ChassisAccelerationsWPILIB
  ) : this(
      chassisAccelerationsWPILIB.ax.meters.perSecond.perSecond,
      chassisAccelerationsWPILIB.ay.meters.perSecond.perSecond,
      chassisAccelerationsWPILIB.alpha.radians.perSecond.perSecond)

  constructor() :
      this(
          0.0.meters.perSecond.perSecond,
          0.0.meters.perSecond.perSecond,
          0.0.radians.perSecond.perSecond,
      ) {}

  val chassisAccelerationsWPILIB =
      ChassisAccelerationsWPILIB(
          ax.inMetersPerSecondPerSecond,
          ay.inMetersPerSecondPerSecond,
          alpha.inRadiansPerSecondPerSecond,
      )

  operator fun div(scalar: Double): ChassisAccelerations {
    return times(1.0 / scalar)
  }

  operator fun minus(other: ChassisAccelerations): ChassisAccelerations {
    return ChassisAccelerations(chassisAccelerationsWPILIB.minus(other.chassisAccelerationsWPILIB))
  }

  operator fun plus(other: ChassisAccelerations): ChassisAccelerations {
    return ChassisAccelerations(chassisAccelerationsWPILIB.plus(other.chassisAccelerationsWPILIB))
  }

  operator fun times(scalar: Double): ChassisAccelerations {
    return ChassisAccelerations(chassisAccelerationsWPILIB.times(scalar))
  }

  fun toRobotRelative(robotAngle: Angle): ChassisAccelerations {
    val rotated = Translation2d(ax.value.meters, ay.value.meters).rotateBy(robotAngle.unaryMinus())
    return ChassisAccelerations(rotated.x.perSecond.perSecond, rotated.y.perSecond.perSecond, alpha)
  }

  fun toFieldRelative(robotAngle: Angle): ChassisAccelerations {
    val rotated = Translation2d(ax.value.meters, ay.value.meters).rotateBy(robotAngle)
    return ChassisAccelerations(rotated.x.perSecond.perSecond, rotated.y.perSecond.perSecond, alpha)
  }

  operator fun unaryMinus(): ChassisAccelerations {
    return ChassisAccelerations(chassisAccelerationsWPILIB.unaryMinus())
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is ChassisAccelerations) return false

    if ((ax - other.ax).absoluteValue.value > 1E-9) return false
    if ((ay - other.ay).absoluteValue.value > 1E-9) return false
    if ((alpha - other.alpha).absoluteValue.value > 1E-9) return false

    return true
  }

  companion object {
    fun fromFieldRelativeAccels(
        ax: LinearAcceleration,
        ay: LinearAcceleration,
        alpha: AngularAcceleration,
        robotAngle: Angle,
    ): ChassisAccelerations {
      return ChassisAccelerations(
          ax * robotAngle.cos + ay * robotAngle.sin,
          -ax * robotAngle.sin + ay * robotAngle.cos,
          alpha,
      )
    }

    fun fromFieldRelativeAccels(
        fieldRelativeAccels: ChassisAccelerations,
        robotAngle: Angle
    ): ChassisAccelerations {
      return fromFieldRelativeAccels(
          fieldRelativeAccels.ax,
          fieldRelativeAccels.ay,
          fieldRelativeAccels.alpha,
          robotAngle,
      )
    }
  }
}
