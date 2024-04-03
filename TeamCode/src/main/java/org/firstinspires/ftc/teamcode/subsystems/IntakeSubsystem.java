package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

/**
 * A gripper mechanism that grabs a stone from the quarry.
 * Centered around the Skystone game for FTC that was done in the 2020
 * to 2021 season.
 */
public class IntakeSubsystem extends SubsystemBase {

    private final MotorEx IntakeMotor;

    public IntakeSubsystem(final HardwareMap hMap, final String IntakeMotorName) {
        IntakeMotor = hMap.get(MotorEx.class, IntakeMotorName);
    }

    /**
     * Grabs a stone.
     */
    public void ON() {
        IntakeMotor.setVelocity(Constants.IntakeContants.INTAKESPEED);
    }

    /**
     * Releases a stone.
     */
    public void OFF() {
        IntakeMotor.setVelocity(Constants.IntakeContants.ZERO);
    }

}