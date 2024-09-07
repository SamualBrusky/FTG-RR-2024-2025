package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.checkerframework.checker.signedness.qual.Constant;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

import java.util.function.DoubleSupplier;

/**
 * A command to drive the robot with joystick input
 * (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes.
 */
public class LiftIntakePosCmd extends CommandBase {

    private final LiftSubsystem m_Lift;

    /**
     * Creates a new DefaultDrive.
     *
     * @param subsystem The drive subsystem this command will run on.
     */
    public LiftIntakePosCmd(LiftSubsystem subsystem) {
        m_Lift = subsystem;
        addRequirements(m_Lift);
    }

    @Override
    public void execute() {m_Lift.INTAKEPOS(Constants.LiftConstants.INTAKE_LIFT_HEIGHT, Constants.LiftConstants.INTAKE_LIFT_ANGLE);}


    @Override
    public boolean isFinished() {
        return true;
    }

}