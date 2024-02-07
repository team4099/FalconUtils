package org.team4099.lib.pplib

import com.pathplanner.lib.controllers.PPHolonomicDriveController
import com.pathplanner.lib.path.PathConstraints
import com.pathplanner.lib.path.PathPlannerTrajectory
import com.pathplanner.lib.util.ReplanningConfig
import org.team4099.lib.geometry.Pose2d
import org.team4099.lib.kinematics.ChassisSpeeds
import org.team4099.lib.units.AngularAcceleration
import org.team4099.lib.units.AngularVelocity
import org.team4099.lib.units.LinearAcceleration
import org.team4099.lib.units.LinearVelocity
import org.team4099.lib.units.base.Length
import org.team4099.lib.units.base.Time
import org.team4099.lib.units.base.inMeters
import org.team4099.lib.units.base.inSeconds
import org.team4099.lib.units.base.seconds
import org.team4099.lib.units.derived.Angle
import org.team4099.lib.units.derived.inRotation2ds
import org.team4099.lib.units.inMetersPerSecond
import org.team4099.lib.units.inMetersPerSecondPerSecond
import org.team4099.lib.units.inRadiansPerSecond
import org.team4099.lib.units.inRadiansPerSecondPerSecond
import java.util.Optional
import com.pathplanner.lib.path.GoalEndState as pplibGoalEndState
import com.pathplanner.lib.util.HolonomicPathFollowerConfig as pplibHolonomicPathFollowerConfig

class PathPlannerHolonomicDriveController(
  translationConstants: PathPlannerTranslationPID,
  rotationConstants: PathPlannerRotationPID,
  maxModuleSpeed: LinearVelocity,
  driveBaseRadius: Length,
  period: Time = 0.02.seconds
) {
  private val pplibController: PPHolonomicDriveController =
    PPHolonomicDriveController(
      translationConstants.pplibTranslationConstants,
      rotationConstants.pplibRotationConstants,
      period.inSeconds,
      maxModuleSpeed.inMetersPerSecond,
      driveBaseRadius.inMeters
    )

  val positionalError = pplibController.positionalError
  val isHolonomic = pplibController.isHolonomic

  fun calculateRobotRelativeSpeeds(
    currentPose: Pose2d,
    targetState: PathPlannerTrajectory.State
  ): ChassisSpeeds {
    return ChassisSpeeds(
      pplibController.calculateRobotRelativeSpeeds(currentPose.pose2d, targetState)
    )
  }

  fun reset(currentPose: Pose2d, currentSpeeds: ChassisSpeeds) {
    pplibController.reset(currentPose.pose2d, currentSpeeds.chassisSpeedsWPILIB)
  }

  fun setEnabled(enabled: Boolean) {
    pplibController.setEnabled(enabled)
  }

  fun setRotationTargetOverride(rotationTargetOverride: () -> Angle) {
    PPHolonomicDriveController.setRotationTargetOverride {
      Optional.of(rotationTargetOverride().inRotation2ds)
    }
  }

  companion object {
    data class HolonomicPathFollowerConfig(
      val translationConstants: PathPlannerTranslationPID,
      val rotationConstants: PathPlannerRotationPID,
      val maxModuleSpeed: LinearVelocity,
      val driveBaseRadius: Length,
    ) {
      val pplibConfig =
        pplibHolonomicPathFollowerConfig(
          translationConstants.pplibTranslationConstants,
          rotationConstants.pplibRotationConstants,
          maxModuleSpeed.inMetersPerSecond,
          driveBaseRadius.inMeters,
          ReplanningConfig()
        )
    }
    data class GoalEndState(
      val velocity: LinearVelocity,
      val rotation: Angle,
      val rotateFast: Boolean
    ) {
      val pplibGoalEndState: pplibGoalEndState =
        pplibGoalEndState(velocity.inMetersPerSecond, rotation.inRotation2ds, rotateFast)
    }

    data class PathConstraints(
      val maxVelocity: LinearVelocity,
      val maxAcceleration: LinearAcceleration,
      val maxAngularVelocity: AngularVelocity,
      val maxAngularAcceleration: AngularAcceleration
    ) {
      val pplibConstraints =
        PathConstraints(
          maxVelocity.inMetersPerSecond,
          maxAcceleration.inMetersPerSecondPerSecond,
          maxAngularVelocity.inRadiansPerSecond,
          maxAngularAcceleration.inRadiansPerSecondPerSecond
        )
    }
  }
}
