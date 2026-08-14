package org.team4099.lib.kinematics

import org.team4099.lib.geometry.Pose2d
import org.team4099.lib.geometry.Translation2d
import org.team4099.lib.units.AngularVelocity
import org.team4099.lib.units.LinearVelocity
import org.team4099.lib.units.Value
import org.team4099.lib.units.Velocity
import org.team4099.lib.units.base.Meter
import org.team4099.lib.units.base.Time
import org.team4099.lib.units.base.inSeconds
import org.team4099.lib.units.base.meters
import org.team4099.lib.units.base.seconds
import org.team4099.lib.units.derived.Angle
import org.team4099.lib.units.derived.Radian
import org.team4099.lib.units.derived.cos
import org.team4099.lib.units.derived.radians
import org.team4099.lib.units.derived.sin
import org.team4099.lib.units.inMetersPerSecond
import org.team4099.lib.units.inRadiansPerSecond
import org.team4099.lib.units.perSecond
import org.wpilib.math.kinematics.ChassisVelocities as WPIChassisVelocities
import org.wpilib.math.util.MathUtil

class ChassisVelocities(
    val vx: LinearVelocity,
    val vy: LinearVelocity,
    val omega: AngularVelocity
) {
  constructor(
      chassisVelocities: WPIChassisVelocities,
  ) : this(
      chassisVelocities.vx.meters.perSecond,
      chassisVelocities.vy.meters.perSecond,
      chassisVelocities.omega.radians.perSecond,
  ) {}

  constructor() : this(0.0.meters.perSecond, 0.0.meters.perSecond, 0.0.radians.perSecond) {}

  val chassisVelocitiesWPILIB =
      WPIChassisVelocities(vx.inMetersPerSecond, vy.inMetersPerSecond, omega.inRadiansPerSecond)

  fun discretize(dt: Time): ChassisVelocities {
    val desiredDeltaPose =
        Pose2d(
            (vx.value * dt.value).meters,
            (vy.value * dt.value).meters,
            (omega.value * dt.value).radians,
        )

    val twist = Pose2d().log(desiredDeltaPose)
    return ChassisVelocities(twist.dx / dt, twist.dy / dt, twist.dtheta / dt)
  }

  fun div(scalar: Double): ChassisVelocities {
    return times(1.0 / scalar)
  }

  fun interpolate(endValue: ChassisVelocities, t: Time): ChassisVelocities {
    if (t <= 0.seconds) return this
    if (t >= 1.seconds) return endValue

    return ChassisVelocities(
        MathUtil.lerp(this.vx.inMetersPerSecond, endValue.vx.inMetersPerSecond, t.inSeconds)
            .meters
            .perSecond,
        MathUtil.lerp(this.vy.inMetersPerSecond, endValue.vy.inMetersPerSecond, t.inSeconds)
            .meters
            .perSecond,
        MathUtil.lerp(this.omega.inRadiansPerSecond, endValue.omega.inRadiansPerSecond, t.inSeconds)
            .radians
            .perSecond,
    )
  }

  fun minus(other: ChassisVelocities): ChassisVelocities {
    return ChassisVelocities(chassisVelocitiesWPILIB.minus(other.chassisVelocitiesWPILIB))
  }

  fun plus(other: ChassisVelocities): ChassisVelocities {
    return ChassisVelocities(chassisVelocitiesWPILIB.plus(other.chassisVelocitiesWPILIB))
  }

  fun times(scalar: Double): ChassisVelocities {
    return ChassisVelocities(chassisVelocitiesWPILIB.times(scalar))
  }

  fun toRobotRelative(robotAngle: Angle): ChassisVelocities {
    val rotated = Translation2d(vx.value.meters, vy.value.meters).rotateBy(robotAngle.unaryMinus())
    return ChassisVelocities(rotated.x.perSecond, rotated.y.perSecond, omega)
  }

  fun toFieldRelative(robotAngle: Angle): ChassisVelocities {
    val rotated = Translation2d(vx.value.meters, vy.value.meters).rotateBy(robotAngle)
    return ChassisVelocities(rotated.x.perSecond, rotated.y.perSecond, omega)
  }

  fun unaryMinus(): ChassisVelocities {
    return ChassisVelocities(chassisVelocitiesWPILIB.unaryMinus())
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is ChassisVelocities) return false

    if ((vx - other.vx).absoluteValue.value > 1E-9) return false
    if ((vy - other.vy).absoluteValue.value > 1E-9) return false
    if ((omega - other.omega).absoluteValue.value > 1E-9) return false

    return true
  }

  companion object {
    fun fromFieldRelativeSpeeds(
        vx: Value<Velocity<Meter>>,
        vy: Value<Velocity<Meter>>,
        omega: Value<Velocity<Radian>>,
        robotAngle: Angle,
    ): ChassisVelocities {
      return ChassisVelocities(
          vx * robotAngle.cos + vy * robotAngle.sin,
          -vx * robotAngle.sin + vy * robotAngle.cos,
          omega,
      )
    }

    fun fromFieldRelativeSpeeds(
        fieldRelativeSpeeds: ChassisVelocities,
        robotAngle: Angle
    ): ChassisVelocities {
      return fromFieldRelativeSpeeds(
          fieldRelativeSpeeds.vx,
          fieldRelativeSpeeds.vy,
          fieldRelativeSpeeds.omega,
          robotAngle,
      )
    }
  }
}
