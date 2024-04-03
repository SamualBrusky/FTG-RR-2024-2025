package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.Motor.Encoder;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem extends SubsystemBase {

    private final MecanumDrive m_drive;

    RevIMU imu;

    // the extended gamepad object
    GamepadEx driverOp = new GamepadEx(gamepad1);

    /**
     * Creates a new DriveSubsystem.
     */
    public DriveSubsystem(MotorEx frontLeft, MotorEx frontRight, MotorEx backLeft, MotorEx backRight, RevIMU imu) {

        m_drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
    }
    public DriveSubsystem(HardwareMap hMap, final String frontLeftMotorName, String frontRightMotorName, String backLeftMotorName, String backRightMotorName, String ImuName) {
        this(new MotorEx(hMap, frontLeftMotorName), new MotorEx(hMap, frontRightMotorName), new MotorEx(hMap, backLeftMotorName), new MotorEx(hMap, backRightMotorName), new RevIMU(hMap, ImuName));
    }
    public void drive() {
        m_drive.driveFieldCentric(
                driverOp.getLeftX(),
                driverOp.getLeftY(),
                driverOp.getRightX(),
                imu.getRotation2d().getDegrees(),   // gyro value passed in here must be in degrees
                false
        );
    }
}