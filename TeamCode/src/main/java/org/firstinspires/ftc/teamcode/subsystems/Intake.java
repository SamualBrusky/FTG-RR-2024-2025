package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Intake extends SubsystemBase {
    public final DcMotor Intake;
    public Intake(DcMotor intake) {
        this.Intake = intake;

    }

    @Override
    public void periodic() {

    }
}