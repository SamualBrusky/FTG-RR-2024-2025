package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.TriggerReader;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.ClimberLowerCmd;
import org.firstinspires.ftc.teamcode.Commands.ClimberRaiseCmd;
import org.firstinspires.ftc.teamcode.subsystems.ClimberSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@TeleOp(name = "Sample TeleOp")
@Disabled
public class BlueTeleOp extends CommandOpMode {

    private MotorEx m_frontLeft, m_frontRight, m_backLeft, m_backRight;

    private RevIMU m_imu;
    private DriveSubsystem m_drive;
    private GamepadEx m_driverOp;

    private MotorEx m_ClimberMotor;

    private GamepadEx m_engineerOp;

    private ClimberSubsystem m_Climber;

    private ClimberLowerCmd m_ClimberLower;

    private ClimberRaiseCmd m_ClimberRaise;

    private Trigger m_Raise, m_Lower;

    @Override
    public void initialize() {
        m_frontLeft = new MotorEx(hardwareMap, "frontLeft");
        m_frontRight = new MotorEx(hardwareMap, "frontRight");
        m_backLeft = new MotorEx(hardwareMap, "backLeft");
        m_backRight = new MotorEx(hardwareMap, "backRight");

        m_imu = new RevIMU(hardwareMap, "imu");

        m_ClimberMotor = new MotorEx(hardwareMap, "ClimberMotor");

        m_drive = new DriveSubsystem(m_frontLeft, m_frontRight, m_backLeft, m_backRight, m_imu);

        m_driverOp = new GamepadEx(gamepad1);
        m_engineerOp = new GamepadEx(gamepad2);
        m_drive.drive();

        m_ClimberRaise = new ClimberRaiseCmd(m_Climber);
        m_ClimberLower = new ClimberLowerCmd(m_Climber);

        m_Raise = (new GamepadButton(m_engineerOp, GamepadKeys.Button.DPAD_UP)
                .whenPressed(m_ClimberRaise));
        m_Lower = (new GamepadButton(m_engineerOp, GamepadKeys.Button.DPAD_DOWN)
                .whenPressed(m_ClimberLower));


    }

}