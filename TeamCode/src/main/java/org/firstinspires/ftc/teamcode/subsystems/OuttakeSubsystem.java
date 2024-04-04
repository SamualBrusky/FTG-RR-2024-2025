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
public class OuttakeSubsystem extends SubsystemBase {

    private final ServoEx m_DropperServo;

    public OuttakeSubsystem(final HardwareMap hMap, final String OuttakeServo) {
        m_DropperServo = hMap.get(ServoEx.class, OuttakeServo);
    }

    /**
     * Grabs a stone.
     */
    public void CLOSE() {
        m_DropperServo.setPosition(Constants.DropperConstants.Closed);
    }

    /**
     * Releases a stone.
     */
    public void OPEN() {
        m_DropperServo.setPosition(Constants.DropperConstants.Open);
    }

}