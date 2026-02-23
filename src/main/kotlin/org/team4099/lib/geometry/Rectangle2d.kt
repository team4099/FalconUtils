package org.team4099.lib.geometry

import java.util.Objects
import org.team4099.lib.math.abs
import org.team4099.lib.math.clamp
import org.team4099.lib.units.base.Length
import org.team4099.lib.units.base.meters
import org.team4099.lib.units.derived.Angle
import org.team4099.lib.units.derived.radians

data class Rectangle2d(val center: Pose2d, val xWidth: Length, val yWidth: Length) {
  constructor(
      cornerA: Translation2d,
      cornerB: Translation2d
  ) : this(
      Pose2d(cornerA.plus(cornerB).div(2.0), 0.radians),
      abs(cornerA.x - cornerB.x),
      abs(cornerA.y - cornerB.y))

  val rotation = center.rotation

  fun transformBy(other: Transform2d): Rectangle2d {
    return Rectangle2d(center.transformBy(other), xWidth, yWidth)
  }

  fun rotateBy(other: Angle): Rectangle2d {
    return Rectangle2d(center.rotateBy(other), xWidth, yWidth)
  }

  fun intersects(point: Translation2d): Boolean {
    val pointInFrame = point.minus(center.translation).rotateBy(center.rotation.unaryMinus())

    if (abs(abs(point.x) - xWidth / 2.0) <= 1E-9.meters) {
      return abs(point.y) <= yWidth / 2.0
    } else if (abs(abs(point.y) - yWidth / 2.0) <= 1E-9.meters) {
      return abs(point.x) <= xWidth / 2.0
    }

    return false
  }

  fun contains(point: Translation2d): Boolean {
    val pointInFrame = point.rotateAround(center.translation, center.rotation.unaryMinus())

    return point.x >= (center.x - xWidth / 2.0) &&
        point.x <= (center.x + xWidth / 2.0) &&
        point.y >= (center.y - yWidth / 2.0) &&
        point.y <= (center.y + yWidth / 2.0)
  }

  fun getDistance(point: Translation2d): Length {
    return nearest(point).getDistance(point)
  }

  fun nearest(point: Translation2d): Translation2d {
    if (contains(point)) {
      return point
    }

    val rotatedPoint = point.rotateAround(center.translation, center.rotation.unaryMinus())

    val nearestPoint =
        Translation2d(
            clamp(rotatedPoint.x, center.x - xWidth / 2.0, center.x + xWidth / 2.0),
            clamp(rotatedPoint.y, center.y - yWidth / 2.0, center.y + yWidth / 2.0))

    return nearestPoint.rotateAround(center.translation, center.rotation)
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is Rectangle2d) return false

    return center.equals(other) &&
        (xWidth - other.xWidth).absoluteValue <= 1E-9.meters &&
        (yWidth - other.yWidth).absoluteValue <= 1E-9.meters
  }

  override fun hashCode(): Int {
    return Objects.hash(center, xWidth, yWidth)
  }
}
