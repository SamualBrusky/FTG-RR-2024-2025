package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

/**
 * A gripper mechanism that grabs a stone from the quarry.
 * Centered around the Skystone game for FTC that was done in the 2020
 * to 2021 season.
 */
public class LauncherSubsystem extends SubsystemBase {

    private final Servo LauncherServo;

    public LauncherSubsystem(final HardwareMap hMap, final String LauncherServoName) {
        LauncherServo = hMap.get(Servo.class, LauncherServoName);
    }

    /**
     * Grabs a stone.
     */
    public void LAUNCH() {
      LauncherServo.setPosition(Constants.LauncherConstants.LAUNCH);
    }

    /**
     * Releases a stone.
     */
    public void NOLAUNCH() {
        LauncherServo.setPosition(Constants.LauncherConstants.NO_LAUNCH);
    }

}