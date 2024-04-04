package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.LauncherSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.OuttakeSubsystem;

public class LaunchCmd extends CommandBase {

    private final LauncherSubsystem m_LauncherSubsystem;

    public LaunchCmd(LauncherSubsystem subsystem) {
        m_LauncherSubsystem = subsystem;
        addRequirements(m_LauncherSubsystem);
    }

    @Override
    public void initialize() {
        m_LauncherSubsystem.LAUNCH();
    }

    @Override
    public boolean isFinished() {
        m_LauncherSubsystem.NOLAUNCH();
        return true;

    }

}