package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.OuttakeSubsystem;

public class OuttakeOpen extends CommandBase {

    private final OuttakeSubsystem m_OuttakeSubsystem;

    public OuttakeOpen(OuttakeSubsystem subsystem) {
        m_OuttakeSubsystem = subsystem;
        addRequirements(m_OuttakeSubsystem);
    }

    @Override
    public void initialize() {
        m_OuttakeSubsystem.OPEN();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}