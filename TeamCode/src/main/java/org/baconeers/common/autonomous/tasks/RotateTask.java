package org.baconeers.common.autonomous.tasks;

import android.graphics.drawable.GradientDrawable;

import org.baconeers.common.autonomous.BaseTask;
import org.baconeers.common.teleop.BaconOpMode;
import org.baconeers.configurations.UltimateGoalConfiguration;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

public class RotateTask extends BaseTask {
    /**
     *      RotateTask uses the inertial measurement unit (imu) in-built into the expansion hub to
     *      rotate the robot to a specified angle.
     *
     *      All angles within this task are measured in degrees, with everything in reference to
     *      the rotation of the robot at the time the task begins.
     *
     *      The robot can be rotated with multiple precisions - LOW, MEDIUM, and HIGH.
     *      The precision determines at what point the robot stops rotation - the robot will stop
     *      rotating between the range (targetAngle - tolerance) - (targetAngle + tolerance).
     *      Increasing the precision, however, also increases the amount of time it takes to
     *      complete the rotation. For most use-cases, MEDIUM precision is fine, as the
     *      rotation is not super time-critical and doesn't need the precision of HIGH.
     */

    private final UltimateGoalConfiguration config;

    private final double targetAngle;
    private double currentAngle;
    private Orientation previousAngles = new Orientation();

    public enum Precision { LOW, MEDIUM, HIGH }
    private final double tolerance; // Degrees

    public RotateTask(BaconOpMode opmode, UltimateGoalConfiguration config, double targetAngle, Precision precision) {
        super(opmode);
        this.config = config;
        this.targetAngle = targetAngle;

        switch(precision) {
            case LOW:
                tolerance = 5;
                break;
            case MEDIUM:
                tolerance = 1;
                break;
            default:
                tolerance = 0.5;
                break;
        }
    }

    @Override
    public void run() {
        previousAngles = config.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES); // Initial rotation
        currentAngle = 0;
    }

    @Override
    public boolean isFinished() {
        if (currentAngle > (this.targetAngle - this.tolerance) && currentAngle < (this.targetAngle + this.tolerance)) {
            config.leftMotor.setPower(0);
            config.rightMotor.setPower(0);
            return true;
        }

        updateAngles(); // Updates currentAngle and previousAngles

        // Normalises the current angle to a value between 0 and -1/1 (depending on the target rotation)
        double normalisedAngle = 1 - (currentAngle / targetAngle);

        config.leftMotor.setPower(-normalisedAngle);
        config.rightMotor.setPower(normalisedAngle);

        return false;
    }

    private void updateAngles() {
        Orientation currentAngles = config.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        double deltaAngle = currentAngles.firstAngle - previousAngles.firstAngle;

        if (deltaAngle < -180) {
            deltaAngle += 360;
        } else if (deltaAngle > 180) {
            deltaAngle -= 360;
        }

        currentAngle += deltaAngle;

        previousAngles = currentAngles;
    }
}
