package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.ClimberSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

/**
 * A command to drive the robot with joystick input
 * (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes.
 */
public class ClimberRaiseCmd extends CommandBase {

    private final ClimberSubsystem m_Climb;

    /**
     * Creates a new DefaultDrive.
     *
     * @param subsystem The drive subsystem this command will run on.
     */
    public ClimberRaiseCmd(ClimberSubsystem subsystem) {
        m_Climb = subsystem;
        addRequirements(m_Climb);
    }

    @Override
    public void execute() {
       m_Climb.RAISE(Constants.ClimberConstants.RAISEPOS);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}