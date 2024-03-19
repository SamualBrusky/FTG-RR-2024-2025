package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.Motor.Encoder;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class driveSubsystem extends SubsystemBase {

    public MotorEx frontLeft, frontRight, backLeft, backRight;

    private MecanumDrive m_drive;

    double strafeSpeed = 0;
    double forwardSpeed = 0;
    double turn = 0;
    double heading = 0;

    /**
     * Creates a new DriveSubsystem.
     */
    public driveSubsystem(MotorEx frontLeft, MotorEx frontRight, MotorEx backLeft, MotorEx backRight) {

        m_drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
        m_drive.driveFieldCentric(strafeSpeed, forwardSpeed, turn, heading);
    }

    /**
     * Creates a new DriveSubsystem with the hardware map and configuration names.
     */
    public driveSubsystem(HardwareMap hMap, final String FL_name, final String FR_name, final String BL_name, final String BR_name) {
        this(new MotorEx(hMap, FL_name), new MotorEx(hMap, FR_name), new MotorEx(hMap, BL_name), new MotorEx(hMap, BR_name));
    }




}