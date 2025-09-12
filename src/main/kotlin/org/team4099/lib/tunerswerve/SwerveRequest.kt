package org.team4099.lib.tunerswerve

import org.team4099.lib.geometry.Translation2d
import org.team4099.lib.kinematics.ChassisSpeeds
import org.team4099.lib.units.AngularVelocity
import org.team4099.lib.units.LinearVelocity
import org.team4099.lib.units.Velocity
import org.team4099.lib.units.derived.Angle
import org.team4099.lib.units.derived.DerivativeGain
import org.team4099.lib.units.derived.ElectricalPotential
import org.team4099.lib.units.derived.Force
import org.team4099.lib.units.derived.IntegralGain
import org.team4099.lib.units.derived.ProportionalGain
import org.team4099.lib.units.derived.Radian
import org.team4099.lib.units.derived.inRadiansPerSecondPerRadian
import org.team4099.lib.units.derived.inRadiansPerSecondPerRadianPerSecond
import org.team4099.lib.units.derived.inRadiansPerSecondPerRadianSeconds
import org.team4099.lib.units.derived.inRotation2ds
import org.team4099.lib.units.derived.inVolts
import org.team4099.lib.units.inMetersPerSecond
import org.team4099.lib.units.inRadiansPerSecond
import com.ctre.phoenix6.swerve.SwerveRequest as TunerSwerveRequest

sealed interface SwerveRequest : TunerSwerveRequest {
  class ApplyFieldSpeeds() : TunerSwerveRequest.ApplyFieldSpeeds() {
    fun withCenterOfRotation(newCenterOfRotation: Translation2d): ApplyFieldSpeeds {
      super.withCenterOfRotation(newCenterOfRotation.translation2d)
      return this
    }
    fun withSpeeds(newSpeeds: ChassisSpeeds): ApplyFieldSpeeds {
      super.withSpeeds(newSpeeds.chassisSpeedsWPILIB)
      return this
    }
    fun withWheelForceFeedforwardsX(newWheelForceFeedforwards: Array<Force>): ApplyFieldSpeeds {
      super.withWheelForceFeedforwardsX(newWheelForceFeedforwards.map { it.value }.toDoubleArray())
      return this
    }
    fun withWheelForceFeedforwardsY(newWheelForceFeedforwards: Array<Force>): ApplyFieldSpeeds {
      super.withWheelForceFeedforwardsY(newWheelForceFeedforwards.map { it.value }.toDoubleArray())
      return this
    }
  }

  class ApplyRobotSpeeds() : TunerSwerveRequest.ApplyRobotSpeeds() {
    fun withCenterOfRotation(newCenterOfRotation: Translation2d): ApplyRobotSpeeds {
      super.withCenterOfRotation(newCenterOfRotation.translation2d)
      return this
    }
    fun withSpeeds(newSpeeds: ChassisSpeeds): ApplyRobotSpeeds {
      super.withSpeeds(newSpeeds.chassisSpeedsWPILIB)
      return this
    }
    fun withWheelForceFeedforwardsX(newWheelForceFeedforwards: Array<Force>): ApplyRobotSpeeds {
      super.withWheelForceFeedforwardsX(newWheelForceFeedforwards.map { it.value }.toDoubleArray())
      return this
    }
    fun withWheelForceFeedforwardsY(newWheelForceFeedforwards: Array<Force>): ApplyRobotSpeeds {
      super.withWheelForceFeedforwardsY(newWheelForceFeedforwards.map { it.value }.toDoubleArray())
      return this
    }
  }

  class FieldCentric : TunerSwerveRequest.FieldCentric() {
    fun withCenterOfRotation(newCenterOfRotation: Translation2d): FieldCentric {
      super.withCenterOfRotation(newCenterOfRotation.translation2d)
      return this
    }
    fun withDeadband(newDeadband: LinearVelocity): FieldCentric {
      super.withDeadband(newDeadband.inMetersPerSecond)
      return this
    }
    fun withRotationalDeadband(newRotationalDeadband: AngularVelocity): FieldCentric {
      super.withRotationalDeadband(newRotationalDeadband.inRadiansPerSecond)
      return this
    }
    fun withRotationalRate(newRotationalRate: AngularVelocity): FieldCentric {
      super.withRotationalRate(newRotationalRate.inRadiansPerSecond)
      return this
    }
    fun withVelocityX(newVelocityX: LinearVelocity): FieldCentric {
      super.withVelocityX(newVelocityX.inMetersPerSecond)
      return this
    }
    fun withVelocityY(newVelocityY: LinearVelocity): FieldCentric {
      super.withVelocityY(newVelocityY.inMetersPerSecond)
      return this
    }
  }

  class FieldCentricFacingAngle : TunerSwerveRequest.FieldCentricFacingAngle() {
    fun withCenterOfRotation(newCenterOfRotation: Translation2d): FieldCentricFacingAngle {
      super.withCenterOfRotation(newCenterOfRotation.translation2d)
      return this
    }
    fun withDeadband(newDeadband: LinearVelocity): FieldCentricFacingAngle {
      super.withDeadband(newDeadband.inMetersPerSecond)
      return this
    }
    fun withHeadingPID(
      kP: ProportionalGain<Radian, Velocity<Radian>>,
      kI: IntegralGain<Radian, Velocity<Radian>>,
      kD: DerivativeGain<Radian, Velocity<Radian>>
    ): FieldCentricFacingAngle {
      super.withHeadingPID(
        kP.inRadiansPerSecondPerRadian,
        kI.inRadiansPerSecondPerRadianSeconds,
        kD.inRadiansPerSecondPerRadianPerSecond
      )
      return this
    }
    fun withRotationalDeadband(newRotationalDeadband: AngularVelocity): FieldCentricFacingAngle {
      super.withRotationalDeadband(newRotationalDeadband.inRadiansPerSecond)
      return this
    }
    fun withTargetDirection(newTargetDirection: Angle): FieldCentricFacingAngle {
      super.withTargetDirection(newTargetDirection.inRotation2ds)
      return this
    }
    fun withTargetRateFeedforward(
      newTargetRateFeedforward: AngularVelocity
    ): FieldCentricFacingAngle {
      super.withTargetRateFeedforward(newTargetRateFeedforward.inRadiansPerSecond)
      return this
    }
    fun withVelocityX(newVelocityX: LinearVelocity): FieldCentricFacingAngle {
      super.withVelocityX(newVelocityX.inMetersPerSecond)
      return this
    }
    fun withVelocityY(newVelocityY: LinearVelocity): FieldCentricFacingAngle {
      super.withVelocityY(newVelocityY.inMetersPerSecond)
      return this
    }
  }

  class Idle : TunerSwerveRequest.Idle()

  class PointWheelsAt : TunerSwerveRequest.PointWheelsAt() {
    fun withModuleDirection(newModuleDirection: Angle): PointWheelsAt {
      super.withModuleDirection(newModuleDirection.inRotation2ds)
      return this
    }
  }

  class RobotCentric : TunerSwerveRequest.RobotCentric() {
    fun withCenterOfRotation(newCenterOfRotation: Translation2d): RobotCentric {
      super.withCenterOfRotation(newCenterOfRotation.translation2d)
      return this
    }
    fun withDeadband(newDeadband: LinearVelocity): RobotCentric {
      super.withDeadband(newDeadband.inMetersPerSecond)
      return this
    }
    fun withRotationalDeadband(newRotationalDeadband: AngularVelocity): RobotCentric {
      super.withRotationalDeadband(newRotationalDeadband.inRadiansPerSecond)
      return this
    }
    fun withRotationalRate(newRotationalRate: AngularVelocity): RobotCentric {
      super.withRotationalRate(newRotationalRate.inRadiansPerSecond)
      return this
    }
    fun withVelocityX(newVelocityX: LinearVelocity): RobotCentric {
      super.withVelocityX(newVelocityX.inMetersPerSecond)
      return this
    }
    fun withVelocityY(newVelocityY: LinearVelocity): RobotCentric {
      super.withVelocityY(newVelocityY.inMetersPerSecond)
      return this
    }
  }

  class SwerveDriveBrake : TunerSwerveRequest.SwerveDriveBrake()

  class SysIdSwerveRotation : TunerSwerveRequest.SysIdSwerveRotation() {
    fun withRotationalRate(newRotationalRate: AngularVelocity): SysIdSwerveRotation {
      super.withRotationalRate(newRotationalRate.inRadiansPerSecond)
      return this
    }
  }

  class SysIdSwerveSteerGains : TunerSwerveRequest.SysIdSwerveSteerGains() {
    fun withVolts(volts: ElectricalPotential): SysIdSwerveSteerGains {
      super.withVolts(volts.inVolts)
      return this
    }
  }

  class SysIdSwerveTranslation : TunerSwerveRequest.SysIdSwerveTranslation() {
    fun withVolts(volts: ElectricalPotential): SysIdSwerveTranslation {
      super.withVolts(volts.inVolts)
      return this
    }
  }
}

typealias ForwardPerspectiveValue = TunerSwerveRequest.ForwardPerspectiveValue

typealias NativeSwerveRequest = TunerSwerveRequest.NativeSwerveRequest
