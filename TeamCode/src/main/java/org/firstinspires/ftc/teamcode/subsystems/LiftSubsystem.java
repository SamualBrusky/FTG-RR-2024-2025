package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ElevatorFeedforward;
import com.arcrobotics.ftclib.hardware.motors.Motor;
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

    private final MotorEx m_LiftHeightMotor;
    private final MotorEx m_LiftAngleMotor;

    //PIDFController LiftPIDF = new PIDFController(1, 0, 0, 0);

//    ElevatorFeedforward feedforward = new ElevatorFeedforward(0, 0, 0, 0);

    public LiftSubsystem(final HardwareMap hMap, final String LiftHeightMotorName, final String LiftAngleMotorName) {
        m_LiftHeightMotor = hMap.get(MotorEx.class, LiftHeightMotorName);
        m_LiftAngleMotor = hMap.get(MotorEx.class, LiftAngleMotorName);
    }


    public void INTAKEPOS(int INTAKEPOS, int INTAKEANGLE) {
        m_LiftHeightMotor.setTargetPosition(INTAKEPOS);
        m_LiftHeightMotor.setRunMode(MotorEx.RunMode.PositionControl);
        m_LiftHeightMotor.set(INTAKEPOS);
        m_LiftAngleMotor.setTargetPosition(INTAKEANGLE);
        m_LiftAngleMotor.setRunMode(MotorEx.RunMode.PositionControl);
        m_LiftAngleMotor.set(INTAKEANGLE);
    }
    public void TALLBUCKETPOS(int TALLBUCKETPOS, int TALLBUCKETANGLE) {
        m_LiftHeightMotor.setTargetPosition(TALLBUCKETPOS);
        m_LiftHeightMotor.setRunMode(MotorEx.RunMode.PositionControl);
        m_LiftHeightMotor.set(TALLBUCKETPOS);
        m_LiftAngleMotor.setTargetPosition(TALLBUCKETANGLE);
        m_LiftAngleMotor.setRunMode(Motor.RunMode.PositionControl);
        m_LiftAngleMotor.set(TALLBUCKETANGLE);
    }

    public void CLIMBERPOS(int CLIMBERPOS, int CLIMBERANGLE) {
        m_LiftHeightMotor.setTargetPosition(CLIMBERPOS);
        m_LiftHeightMotor.setRunMode(MotorEx.RunMode.PositionControl);
        m_LiftHeightMotor.set(CLIMBERPOS);
        m_LiftAngleMotor.setTargetPosition(CLIMBERANGLE);
        m_LiftAngleMotor.setRunMode(MotorEx.RunMode.PositionControl);
        m_LiftAngleMotor.set(CLIMBERANGLE);
    }

    public void STARTPOS(int STARTPOS, int STARTANGLE) {
        m_LiftHeightMotor.setTargetPosition(STARTPOS);
        m_LiftHeightMotor.setRunMode(Motor.RunMode.PositionControl);
        m_LiftHeightMotor.set(STARTPOS);
        m_LiftAngleMotor.setTargetPosition(STARTANGLE);
        m_LiftAngleMotor.setRunMode(Motor.RunMode.PositionControl);
        m_LiftAngleMotor.set(STARTANGLE);
    }
}