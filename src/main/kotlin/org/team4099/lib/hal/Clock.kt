package org.team4099.lib.hal

import org.team4099.lib.units.base.Time
import org.team4099.lib.units.base.seconds
import org.team4099.lib.units.micro
import edu.wpi.first.wpilibj.RobotController

object Clock {
  val fpgaTime: Time
    get() = RobotController.getFPGATime().micro.seconds
}
