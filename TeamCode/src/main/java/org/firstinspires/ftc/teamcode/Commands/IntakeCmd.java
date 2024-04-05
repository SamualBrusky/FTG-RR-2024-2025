package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.ClimberSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

import java.util.function.DoubleSupplier;

/**
 * A command to drive the robot with joystick input
 * (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes.
 */
public class IntakeCmd extends CommandBase {

    private final IntakeSubsystem m_Intake;

    public IntakeCmd(IntakeSubsystem subsystem) {
        m_Intake = subsystem;
        addRequirements(m_Intake);
    }

    @Override
    public void execute() {

        m_Intake.ON();
    }

    @Override
    public boolean isFinished() {
        m_Intake.OFF();
        return true;
    }

}