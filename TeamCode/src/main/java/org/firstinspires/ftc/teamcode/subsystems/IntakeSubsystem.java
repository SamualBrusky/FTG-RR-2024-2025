package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Constants;

/**
 * A gripper mechanism that grabs a stone from the quarry.
 * Centered around the Skystone game for FTC that was done in the 2020
 * to 2021 season.
 */
public class IntakeSubsystem extends SubsystemBase {

    private final ServoEx leftGrabberServo;
    private final ServoEx rightGrabberServo;

    public IntakeSubsystem(final HardwareMap hMap, final String leftGrabberServoName, final String rightGrabberServoName) {
        leftGrabberServo = hMap.get(ServoEx.class, leftGrabberServoName);
        rightGrabberServo = hMap.get(ServoEx.class, rightGrabberServoName);

    }

    /**
     * Grabs a stone.
     */
    public void ON() {
        leftGrabberServo.rotateByAngle(0);
        rightGrabberServo.rotateByAngle(0);
    }

    /**
     * Releases a stone.
     */
    public void OFF() {
        leftGrabberServo.rotateByAngle(0);
        rightGrabberServo.rotateByAngle(0);
    }

}