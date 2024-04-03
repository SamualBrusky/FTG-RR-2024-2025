package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.ClimberSubsystem;

import java.util.function.DoubleSupplier;

/**
 * A command to drive the robot with joystick input
 * (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes.
 */
public class ClimberLowerCmd extends CommandBase {

    private final ClimberSubsystem m_Climb;

    /**
     * Creates a new DefaultDrive.
     *
     * @param subsystem The drive subsystem this command will run on.
     */
    public ClimberLowerCmd(ClimberSubsystem subsystem) {
        m_Climb = subsystem;
        addRequirements(m_Climb);
    }

    @Override
    public void execute() {
        m_Climb.LOWER(Constants.ClimberConstants.LOWERPOS);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}