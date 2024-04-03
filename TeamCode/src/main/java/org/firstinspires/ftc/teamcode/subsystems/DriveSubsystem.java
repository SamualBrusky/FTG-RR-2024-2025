package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.Motor.Encoder;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem extends SubsystemBase {

    private final MecanumDrive m_drive;

    /**
     * Creates a new DriveSubsystem.
     */
    public DriveSubsystem(MotorEx frontLeft, MotorEx frontRight, MotorEx backLeft, MotorEx backRight) {

        m_drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
    }
    public DriveSubsystem(HardwareMap hMap, final String frontLeftMotorName, String frontRightMotorName, String backLeftMotorName, String backRightMotorName) {
        this(new MotorEx(hMap, frontLeftMotorName), new MotorEx(hMap, frontRightMotorName), new MotorEx(hMap, backLeftMotorName), new MotorEx(hMap, backRightMotorName));
    }
    public void drive() {
//        m_drive.driveFieldCentric(
//                driverOp.getLeftX(),
//                driverOp.getLeftY(),
//                driverOp.getRightX(),
//                imu.getRotation2d().getDegrees(),   // gyro value passed in here must be in degrees
//                false
//        );
    }
}