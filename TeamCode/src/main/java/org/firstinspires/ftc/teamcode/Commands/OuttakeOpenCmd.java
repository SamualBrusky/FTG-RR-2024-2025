package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.OuttakeSubsystem;

public class OuttakeOpenCmd extends CommandBase {

    private final OuttakeSubsystem m_OuttakeSubsystem;

    public OuttakeOpenCmd(OuttakeSubsystem subsystem) {
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