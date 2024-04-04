package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.OuttakeRotateSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.OuttakeSubsystem;

public class OuttakeRotateOuttakePos extends CommandBase {

    private final OuttakeRotateSubsystem m_OuttakeRotateSubsystem;
    private final OuttakeSubsystem m_OuttakeSubsystem;

    public OuttakeRotateOuttakePos(OuttakeRotateSubsystem subsystem1, OuttakeSubsystem subsystem2) {
        m_OuttakeRotateSubsystem = subsystem1;
        m_OuttakeSubsystem = subsystem2;
        addRequirements(m_OuttakeRotateSubsystem, m_OuttakeSubsystem);
    }

    @Override
    public void initialize() {
        m_OuttakeSubsystem.CLOSE();
        m_OuttakeRotateSubsystem.OUTTAKEPOS();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}