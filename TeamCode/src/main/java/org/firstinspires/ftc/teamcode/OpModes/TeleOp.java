package org.firstinspires.ftc.teamcode.OpModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Commands.GrabberCloseCmd;
import org.firstinspires.ftc.teamcode.Commands.GrabberOpenCmd;
import org.firstinspires.ftc.teamcode.Commands.LiftHighBucketPosCmd;
import org.firstinspires.ftc.teamcode.Commands.LiftIntakePosCmd;
import org.firstinspires.ftc.teamcode.Commands.LiftLowBucketPosCmd;
import org.firstinspires.ftc.teamcode.Commands.LiftStartPosCmd;
import org.firstinspires.ftc.teamcode.Commands.LiftSubmersibleScoreCmd;
import org.firstinspires.ftc.teamcode.Commands.LiftSubmersibleSetupCmd;
import org.firstinspires.ftc.teamcode.subsystems.GrabberSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.tuning.MecanumDrive;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Blue TeleOp")
@Disabled
public class TeleOp extends CommandOpMode {
    //drive subsystem
    private MotorEx m_frontLeft, m_frontRight, m_backLeft, m_backRight;
    private RevIMU m_imu;
    private MecanumDrive mecanumDrive;
    //GamePads
    private GamepadEx m_driverOp;
    private GamepadEx m_engineerOp;

    private LiftHighBucketPosCmd m_LiftHighBucketPosCmd;
    private LiftStartPosCmd m_LiftStartPosCmd;
    private LiftIntakePosCmd m_LiftintakePosCmd;
    private GrabberOpenCmd m_GrabberOpenCmd;
    private GrabberCloseCmd m_GrabberCloseCmd;
    private LiftSubmersibleSetupCmd m_LiftSubmersibleSetupCmd;
    private LiftLowBucketPosCmd m_LiftLowBucketPosCmd;
    private LiftSubmersibleScoreCmd m_LiftSubmersibleScoreCmd;

    private GrabberSubsystem m_GrabberSubsystem;
    private LiftSubsystem m_LiftSubsystem;
    @Override
    public void initialize() {
        // Chasis Motors
        m_LiftSubsystem = new LiftSubsystem(hardwareMap);
        //Intake
        m_GrabberSubsystem = new GrabberSubsystem(hardwareMap);
        //Gamepads
        m_driverOp = new GamepadEx(gamepad1);
        m_engineerOp = new GamepadEx(gamepad2);

        //init commands
        m_LiftStartPosCmd = new LiftStartPosCmd(m_LiftSubsystem);
        m_LiftHighBucketPosCmd = new LiftHighBucketPosCmd(m_LiftSubsystem);
        m_LiftintakePosCmd = new LiftIntakePosCmd(m_LiftSubsystem);
        m_GrabberCloseCmd = new GrabberCloseCmd(m_GrabberSubsystem);
        m_GrabberOpenCmd = new GrabberOpenCmd(m_GrabberSubsystem);
        m_LiftSubmersibleScoreCmd = new LiftSubmersibleScoreCmd(m_LiftSubsystem);
        m_LiftLowBucketPosCmd = new LiftLowBucketPosCmd(m_LiftSubsystem);
        m_LiftSubmersibleSetupCmd = new LiftSubmersibleSetupCmd(m_LiftSubsystem);

        m_LiftIntakePos = (new GamepadButton(m_engineerOp, GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(m_LiftintakePosCmd));

        m_GrabberOpen = (new GamepadButton(m_engineerOp, GamepadKeys.Button.X)
                .whenPressed(m_GrabberOpenCmd));

        m_engineerOp.getGamepadButton(GamepadKeys.Button.A).
                whenPressed(m_GrabberCloseCmd);
        m_engineerOp.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(m_LiftHighBucketPosCmd);
    }

}