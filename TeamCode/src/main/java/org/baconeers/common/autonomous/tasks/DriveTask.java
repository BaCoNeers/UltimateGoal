package org.baconeers.common.autonomous.tasks;

import org.baconeers.common.autonomous.BaseTask;
import org.baconeers.common.teleop.BaconOpMode;
import org.baconeers.configurations.UltimateGoalConfiguration;

public class DriveTask extends BaseTask {
    // Config
    private UltimateGoalConfiguration config;

    // Drive speed enum
    public enum DriveSpeed { SLOW, MEDIUM, FAST }
    private DriveSpeed driveSpeed;

    // Distance in metres
    double distance;

    // Speed in metres per second
    int speed;
    double motorPower;
    double endTime = 0;

    public DriveTask(BaconOpMode opMode, UltimateGoalConfiguration config, DriveSpeed driveSpeed, double distance) {
        super(opMode);
        this.config = config;
        this.driveSpeed = driveSpeed;

        switch(driveSpeed) {
            case SLOW:
                speed = 1;
                motorPower = .3;
                break;
            case MEDIUM:
                speed = 1;
                motorPower = .6;
                break;
            case FAST:
                speed = 1;
                motorPower = .9;
                break;
            default:
                speed = 1;
                motorPower = 1;
                break;
        }
    }

    @Override
    public void run() {
        endTime = (System.nanoTime() / NANOS_IN_SECONDS) + (distance / speed);
        config.leftMotor.setPower(motorPower);
    }

    @Override
    public boolean isFinished() {
        if((System.nanoTime() / NANOS_IN_SECONDS) > endTime) {
            config.leftMotor.setPower(0);
            return true;
        }
        return false;
    }
}
