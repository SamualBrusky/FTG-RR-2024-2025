package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.TriggerReader;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Commands.ClimberLowerCmd;
import org.firstinspires.ftc.teamcode.Commands.ClimberRaiseCmd;
import org.firstinspires.ftc.teamcode.Commands.OuttakeOpen;
import org.firstinspires.ftc.teamcode.Commands.OuttakeRotateIntakePos;
import org.firstinspires.ftc.teamcode.Commands.OuttakeRotateOuttakePos;
import org.firstinspires.ftc.teamcode.subsystems.ClimberSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.OuttakeRotateSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.OuttakeSubsystem;

@TeleOp(name = "Blue TeleOp")
@Disabled
public class BlueTeleOp extends CommandOpMode {
    //drive subsystem
    private MotorEx m_frontLeft, m_frontRight, m_backLeft, m_backRight;
    private MotorEx m_ClimberMotor;
    private RevIMU m_imu;
    private DriveSubsystem m_drive;
    //GamePads
    private GamepadEx m_driverOp;
    private GamepadEx m_engineerOp;
    //Climber Subsystem
    private ClimberSubsystem m_Climber;
    //Climber Commands
    private ClimberLowerCmd m_ClimberLower;
    private ClimberRaiseCmd m_ClimberRaise;
    //Outtake subsystem + commands + Servos + etc.
    private OuttakeRotateSubsystem m_OuttakeRotateSubsystem;
    private OuttakeRotateOuttakePos m_OuttakeRotateOuttakePos;
    private OuttakeRotateIntakePos m_OuttakeRotateIntakePos;

    private OuttakeSubsystem m_OuttakeSubsystem;
    private OuttakeOpen m_OuttakeOpen;
    //buttons
    private Button m_Raise, m_Lower, m_OuttakePos, m_IntakePos, m_Open;
    @Override
    public void initialize() {
        // Chasis Motors
        m_frontLeft = new MotorEx(hardwareMap, "frontLeft");
        m_frontRight = new MotorEx(hardwareMap, "frontRight");
        m_backLeft = new MotorEx(hardwareMap, "backLeft");
        m_backRight = new MotorEx(hardwareMap, "backRight");
        // NavX?
        m_imu = new RevIMU(hardwareMap, "imu");
        // Climber Motor
        m_ClimberMotor = new MotorEx(hardwareMap, "ClimberMotor");
        //OuttakeRotate
        m_OuttakeSubsystem = new OuttakeSubsystem(hardwareMap, "DropperServo");
        m_OuttakeRotateSubsystem = new OuttakeRotateSubsystem(hardwareMap, "LeftRotate", "RightRotate");

        m_driverOp = new GamepadEx(gamepad1);
        m_engineerOp = new GamepadEx(gamepad2);

        m_drive = new DriveSubsystem(m_frontLeft, m_frontRight, m_backLeft, m_backRight, m_imu);

        m_drive.drive();
        //init commands
        m_ClimberRaise = new ClimberRaiseCmd(m_Climber);
        m_ClimberLower = new ClimberLowerCmd(m_Climber);
        m_OuttakeRotateOuttakePos = new OuttakeRotateOuttakePos(m_OuttakeRotateSubsystem, m_OuttakeSubsystem);
        m_OuttakeRotateIntakePos = new OuttakeRotateIntakePos(m_OuttakeRotateSubsystem, m_OuttakeSubsystem);
        m_OuttakeOpen = new OuttakeOpen(m_OuttakeSubsystem);

        //Outtake
        m_OuttakePos = (new GamepadButton(m_engineerOp, GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(m_OuttakeRotateOuttakePos));
        m_IntakePos = (new GamepadButton(m_engineerOp, GamepadKeys.Button.RIGHT_BUMPER)
                .whenReleased(m_OuttakeRotateIntakePos));
        m_Open = (new GamepadButton(m_engineerOp, GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(m_OuttakeOpen));
       //Climber
        m_Raise = (new GamepadButton(m_engineerOp, GamepadKeys.Button.DPAD_UP)
                .whenPressed(m_ClimberRaise));
        m_Lower = (new GamepadButton(m_engineerOp, GamepadKeys.Button.DPAD_DOWN)
                .whenPressed(m_ClimberLower));
    }

}