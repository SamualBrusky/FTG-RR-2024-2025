package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ElevatorFeedforward;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

/**
 * A gripper mechanism that grabs a stone from the quarry.
 * Centered around the Skystone game for FTC that was done in the 2020
 * to 2021 season.
 */
public class LiftSubsystem extends SubsystemBase {

    private final MotorEx m_LiftMotor;

    //PIDFController LiftPIDF = new PIDFController(1, 0, 0, 0);

//    ElevatorFeedforward feedforward = new ElevatorFeedforward(0, 0, 0, 0);

    public LiftSubsystem(final HardwareMap hMap, final String LiftMotorName) {
        m_LiftMotor = hMap.get(MotorEx.class, LiftMotorName);
    }


    public void INTAKEPOS(int INTAKEPOS) {
        m_LiftMotor.setTargetPosition(INTAKEPOS);
        m_LiftMotor.setRunMode(MotorEx.RunMode.PositionControl);
        m_LiftMotor.set(INTAKEPOS);
    }
    public void POS1(int POS1) {
        m_LiftMotor.setTargetPosition(POS1);
        m_LiftMotor.setRunMode(MotorEx.RunMode.PositionControl);
        m_LiftMotor.set(POS1);
    }

    public void POS2(int POS2) {
        m_LiftMotor.setTargetPosition(POS2);
        m_LiftMotor.setRunMode(MotorEx.RunMode.PositionControl);
        m_LiftMotor.set(POS2);
}}