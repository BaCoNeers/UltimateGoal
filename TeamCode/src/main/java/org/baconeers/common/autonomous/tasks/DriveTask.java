package org.baconeers.common.autonomous.tasks;

import org.baconeers.common.autonomous.BaseTask;
import org.baconeers.common.teleop.BaconOpMode;
import org.baconeers.configurations.UltimateGoalConfiguration;

public class DriveTask extends BaseTask {

    private UltimateGoalConfiguration config;
    public enum DriveSpeed { SLOW, FAST }
    private DriveSpeed driveSpeed;
    double distance;

    public DriveTask(BaconOpMode opMode, UltimateGoalConfiguration config, DriveSpeed driveSpeed, double distance) {
        super(opMode);
        this.config = config;
        this.driveSpeed = driveSpeed;
    }

    @Override
    public void run() {

    }

    @Override
    public void isFinished() {

    }
}
