package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.GrabberCloseCmd;
import org.firstinspires.ftc.teamcode.Commands.GrabberOpenCmd;
import org.firstinspires.ftc.teamcode.Commands.LiftClimbPosCmd;
import org.firstinspires.ftc.teamcode.Commands.LiftHighBucketPosCmd;
import org.firstinspires.ftc.teamcode.Commands.LiftIntakePosCmd;
import org.firstinspires.ftc.teamcode.Commands.LiftStartPosCmd;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.GrabberSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

@TeleOp(name = "Blue TeleOp")
@Disabled
public class BlueTeleOp extends CommandOpMode {
    //drive subsystem
    private MotorEx m_frontLeft, m_frontRight, m_backLeft, m_backRight;
    private RevIMU m_imu;
    private DriveSubsystem m_drive;
    //GamePads
    private GamepadEx m_driverOp;
    private GamepadEx m_engineerOp;

    private LiftHighBucketPosCmd m_LiftHighBucketPosCmd;
    private LiftStartPosCmd m_LiftStartPosCmd;
    private LiftIntakePosCmd m_LiftintakePosCmd;
    private LiftClimbPosCmd m_LiftClimbPosCmd;
    private GrabberOpenCmd m_GrabberOpenCmd;
    private GrabberCloseCmd m_GrabberCloseCmd;

    private GrabberSubsystem m_GrabberSubsystem;
    private LiftSubsystem m_LiftSubsystem;
    //buttons
    public Button m_LiftHighBucketPos, m_LiftIntakePos, m_LiftStartPos, m_LiftClimbPos, m_GrabberClose, m_GrabberOpen;
    @Override
    public void initialize() {
        // Chasis Motors
        m_LiftSubsystem = new LiftSubsystem(hardwareMap, "LiftHeightMotor", "LiftAngleMotor");
        //Intake
        m_GrabberSubsystem = new GrabberSubsystem(hardwareMap, "leftGrabberServo", "rightGrabberServo");
        //Gamepads
        m_driverOp = new GamepadEx(gamepad1);
        m_engineerOp = new GamepadEx(gamepad2);

        m_drive = new DriveSubsystem(m_frontLeft, m_frontRight, m_backLeft, m_backRight, m_imu);

        m_drive.drive();
        //init commands
        m_LiftStartPosCmd = new LiftStartPosCmd(m_LiftSubsystem);
        m_LiftHighBucketPosCmd = new LiftHighBucketPosCmd(m_LiftSubsystem);
        m_LiftintakePosCmd = new LiftIntakePosCmd(m_LiftSubsystem);
        m_LiftClimbPosCmd = new LiftClimbPosCmd(m_LiftSubsystem);
        m_GrabberCloseCmd = new GrabberCloseCmd(m_GrabberSubsystem);
        m_GrabberOpenCmd = new GrabberOpenCmd(m_GrabberSubsystem);

        m_LiftHighBucketPos = (new GamepadButton(m_engineerOp, GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(m_LiftHighBucketPosCmd));

        m_LiftIntakePos = (new GamepadButton(m_engineerOp, GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(m_LiftintakePosCmd));

        m_GrabberClose = (new GamepadButton(m_engineerOp, GamepadKeys.Button.A)
                .whenPressed(m_GrabberCloseCmd));

        m_GrabberOpen = (new GamepadButton(m_engineerOp, GamepadKeys.Button.X)
                .whenPressed(m_GrabberOpenCmd));
    }

}