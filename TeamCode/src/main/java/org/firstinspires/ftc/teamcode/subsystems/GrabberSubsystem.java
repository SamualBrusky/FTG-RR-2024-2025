package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.checkerframework.checker.units.qual.Angle;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

/**
 * A gripper mechanism that grabs a stone from the quarry.
 * Centered around the Skystone game for FTC that was done in the 2020
 * to 2021 season.
 */
public class GrabberSubsystem extends SubsystemBase {

    private final ServoEx m_leftGrabberServo;
    private final ServoEx m_rightGrabberServo;

    public enum GrabberPosition {
        OPEN_POSITION(1),
        CLOSED_POSITION(0);

        private final double AnglePos;

        GrabberPosition(double AnglePos) {
            this.AnglePos = AnglePos;
        }

        public double getAnglePos() {
            return AnglePos;
        }
    }

    public GrabberSubsystem(HardwareMap hardwareMap) {
       m_leftGrabberServo = hardwareMap.get(ServoEx.class, "leftGrabberServo");
       m_rightGrabberServo = hardwareMap.get(ServoEx.class, "rightGrabberServo");
    }

    public void rotationToPosition(GrabberPosition position) {
        m_leftGrabberServo.setPosition(position.getAnglePos());
        m_rightGrabberServo.setPosition(position.getAnglePos());
    }

    public void rotationToPosition(double position) {
        m_leftGrabberServo.setPosition(position);
        m_rightGrabberServo.setPosition(position);
    }

    public double getLeftRotation(){
        return m_leftGrabberServo.getPosition();
    }

    public double getRightRotation(){
        return m_rightGrabberServo.getPosition();
    }
}