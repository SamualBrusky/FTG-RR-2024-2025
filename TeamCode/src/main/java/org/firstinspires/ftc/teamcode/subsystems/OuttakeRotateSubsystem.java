package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

/**
 * A gripper mechanism that grabs a stone from the quarry.
 * Centered around the Skystone game for FTC that was done in the 2020
 * to 2021 season.
 */
public class OuttakeRotateSubsystem extends SubsystemBase {

    private final Servo m_LeftRotateServo, m_RightRotateServo;

    public OuttakeRotateSubsystem(final HardwareMap hMap, String LeftServoName, String RightServoName) {
        m_LeftRotateServo = hMap.get(Servo.class, LeftServoName);
        m_RightRotateServo = hMap.get(Servo.class, RightServoName);
    }

    /**
     * Grabs a stone.
     */
    public void INTAKEPOS() {
       m_LeftRotateServo.setPosition(Constants.DropperConstants.INTAKEPOS);
       m_RightRotateServo.setPosition(Constants.DropperConstants.INTAKEPOS);
    }

    /**
     * Releases a stone.
     */
    public void OUTTAKEPOS() {
        m_LeftRotateServo.setPosition(Constants.DropperConstants.OUTTAKEPOS);
        m_RightRotateServo.setPosition(Constants.DropperConstants.OUTTAKEPOS);
    }

}