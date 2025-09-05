package org.team4099.lib.pplib

import com.pathplanner.lib.controllers.PPHolonomicDriveController
import com.pathplanner.lib.path.PathConstraints
import com.pathplanner.lib.trajectory.PathPlannerTrajectoryState
import edu.wpi.first.math.system.plant.DCMotor
import org.team4099.lib.geometry.Pose2d
import org.team4099.lib.geometry.Translation2d
import org.team4099.lib.kinematics.ChassisSpeeds
import org.team4099.lib.units.AngularAcceleration
import org.team4099.lib.units.AngularVelocity
import org.team4099.lib.units.LinearAcceleration
import org.team4099.lib.units.LinearVelocity
import org.team4099.lib.units.base.Current
import org.team4099.lib.units.base.Length
import org.team4099.lib.units.base.Mass
import org.team4099.lib.units.base.Time
import org.team4099.lib.units.base.inAmperes
import org.team4099.lib.units.base.inKilograms
import org.team4099.lib.units.base.inMeters
import org.team4099.lib.units.base.inSeconds
import org.team4099.lib.units.base.seconds
import org.team4099.lib.units.derived.Angle
import org.team4099.lib.units.derived.MomentOfInertia
import org.team4099.lib.units.derived.inKilogramsMeterSquared
import org.team4099.lib.units.derived.inRotation2ds
import org.team4099.lib.units.inMetersPerSecond
import org.team4099.lib.units.inMetersPerSecondPerSecond
import org.team4099.lib.units.inRadiansPerSecond
import org.team4099.lib.units.inRadiansPerSecondPerSecond
import java.util.Optional
import java.util.function.DoubleSupplier
import com.pathplanner.lib.config.ModuleConfig as pplibModuleConfig
import com.pathplanner.lib.config.RobotConfig as pplibRobotConfig
import com.pathplanner.lib.path.GoalEndState as pplibGoalEndState

class PathPlannerHolonomicDriveController(
  translationConstants: PathPlannerTranslationPID,
  rotationConstants: PathPlannerRotationPID,
  period: Time = 0.02.seconds
) {
  val pplibController: PPHolonomicDriveController =
    PPHolonomicDriveController(
      translationConstants.pplibTranslationConstants,
      rotationConstants.pplibRotationConstants,
      period.inSeconds,
    )

  val isHolonomic = pplibController.isHolonomic

  fun calculateRobotRelativeSpeeds(
    currentPose: Pose2d,
    targetState: PathPlannerTrajectoryState
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

  @Deprecated(
    message = "Use overrideRotationFeedback instead, with the output of your own PID controller",
    replaceWith = ReplaceWith("")
  )
  fun setRotationTargetOverride(rotationTargetOverride: () -> Angle) {
    PPHolonomicDriveController.setRotationTargetOverride {
      Optional.of(rotationTargetOverride().inRotation2ds)
    }
  }

  companion object {
    data class GoalEndState(
      val velocity: LinearVelocity,
      val rotation: Angle,
    ) {
      val pplibGoalEndState: pplibGoalEndState =
        pplibGoalEndState(velocity.inMetersPerSecond, rotation.inRotation2ds)
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

    fun overrideRotationFeedback(rotationFeedbackOverride: DoubleSupplier) {
      PPHolonomicDriveController.overrideRotationFeedback(rotationFeedbackOverride)
    }

    data class RobotConfig(
      val mass: Mass,
      val moi: MomentOfInertia,
      val moduleConfig: ModuleConfig,
      val moduleOffsetFL: Translation2d,
      val moduleOffsetFR: Translation2d,
      val moduleOffsetBL: Translation2d,
      val moduleOffsetBR: Translation2d
    ) {
      val ppllibRobotConfig =
        pplibRobotConfig(
          mass.inKilograms,
          moi.inKilogramsMeterSquared,
          moduleConfig.pplibModuleConfig,
          moduleOffsetFL.translation2d,
          moduleOffsetFR.translation2d,
          moduleOffsetBL.translation2d,
          moduleOffsetBR.translation2d
        )
    }

    data class ModuleConfig(
      val wheelRadius: Length,
      val maxDriveVelocity: LinearVelocity,
      val wheelCOF: Double,
      val driveMotor: DCMotor,
      val driveCurrentLimit: Current,
      val numMotors: Int
    ) {
      val pplibModuleConfig =
        pplibModuleConfig(
          wheelRadius.inMeters,
          maxDriveVelocity.inMetersPerSecond,
          wheelCOF,
          driveMotor,
          driveCurrentLimit.inAmperes,
          numMotors
        )
    }
  }
}
