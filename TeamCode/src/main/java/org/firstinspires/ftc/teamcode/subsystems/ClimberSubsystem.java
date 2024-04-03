package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class ClimberSubsystem extends SubsystemBase {

    private final MotorEx ClimberMotor;

    public ClimberSubsystem(final HardwareMap hMap, final String ClimberMotorName) {
        ClimberMotor = hMap.get(MotorEx.class, ClimberMotorName);
    }

    public void RAISE(int position) {
        ClimberMotor.setTargetPosition(position);
        ClimberMotor.setRunMode(MotorEx.RunMode.PositionControl);
        ClimberMotor.set(position);
    }

    public void LOWER(int position) {
        ClimberMotor.setTargetPosition(position);
        ClimberMotor.setRunMode(MotorEx.RunMode.PositionControl);
        ClimberMotor.set(position);
    }

}