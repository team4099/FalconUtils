package org.team4099.lib.apriltag

import edu.wpi.first.apriltag.AprilTag as AprilTagWPI
import org.team4099.lib.geometry.Pose3d

class AprilTag(val id: Int, val pose: Pose3d) {
  constructor(apriltagWpilib: AprilTagWPI) : this(apriltagWpilib.ID, Pose3d(apriltagWpilib.pose)) {}

  val apriltagWpilib = AprilTagWPI(id, pose.pose3d)

  override fun equals(obj: Any?): Boolean {
    if (obj is AprilTag) {
      val other = obj
      return id == other.id && pose == other.pose
    }
    return false
  }
}
