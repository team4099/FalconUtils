package org.team4099.lib.units.derived

import edu.wpi.first.math.geometry.Rotation2d
import org.team4099.lib.geometry.Rotation2dWPILIB
import org.team4099.lib.units.AngularVelocity
import org.team4099.lib.units.LinearVelocity
import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value
import org.team4099.lib.units.base.Length
import org.team4099.lib.units.inRadiansPerSecond
import org.team4099.lib.units.perSecond
import kotlin.math.PI

object Radian : UnitKey

const val RADIANS_PER_DEGREES = (2 * Math.PI) / 360

const val RADIANS_PER_ROTATION = (2 * Math.PI)

typealias Angle = Value<Radian>

inline fun Angle(x: Double, y: Double): Angle {
  return Rotation2dWPILIB(x, y).angle
}

inline val Double.radians: Angle
  get() = Angle(this)

inline val Double.degrees: Angle
  get() = Angle(Math.toRadians(this))

inline val Double.rotations: Angle
  get() = Angle(this * 2 * Math.PI)

inline val Rotation2d.angle: Angle
  get() = Angle(this.radians)

inline val Number.radians: Angle
  get() = toDouble().radians

inline val Number.degrees: Angle
  get() = toDouble().degrees

inline val Number.rotations: Angle
  get() = toDouble().rotations

inline val Angle.inDegrees: Double
  get() = Math.toDegrees(value)

inline val Angle.inRadians: Double
  get() = value

inline val Angle.inRotations: Double
  get() = value / (2 * PI)

inline val Angle.inRotation2ds: Rotation2d
  get() = Rotation2d(value)

inline val Angle.sin: Double
  get() = kotlin.math.sin(value)

inline val Angle.cos: Double
  get() = kotlin.math.cos(value)

inline val Angle.tan: Double
  get() = kotlin.math.tan(value)

operator fun AngularVelocity.times(o: Length): LinearVelocity = (o * inRadiansPerSecond).perSecond
