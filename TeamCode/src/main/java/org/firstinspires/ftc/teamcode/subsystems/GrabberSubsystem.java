package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * A gripper mechanism that grabs a stone from the quarry.
 * Centered around the Skystone game for FTC that was done in the 2020
 * to 2021 season.
 */
public class GrabberSubsystem extends SubsystemBase {

    private final ServoEx leftGrabberServo;
    private final ServoEx rightGrabberServo;

    public GrabberSubsystem(final HardwareMap hMap, final String leftGrabberServoName, final String rightGrabberServoName) {
        leftGrabberServo = hMap.get(ServoEx.class, leftGrabberServoName);
        rightGrabberServo = hMap.get(ServoEx.class, rightGrabberServoName);

    }

    /**
     * Grabs a stone.
     */
    public void CLOSED() {
        leftGrabberServo.rotateByAngle(0);
        rightGrabberServo.rotateByAngle(0);
    }

    /**
     * Releases a stone.
     */
    public void OPEN() {
        leftGrabberServo.rotateByAngle(0);
        rightGrabberServo.rotateByAngle(0);
    }

}