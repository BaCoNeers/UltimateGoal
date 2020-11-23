package org.baconeers.common.autonomous.tasks;

import org.baconeers.common.autonomous.BaseTask;
import org.baconeers.common.teleop.BaconOpMode;
import org.baconeers.configurations.UltimateGoalConfiguration;

public class HarvesterTask extends BaseTask {
    // Config
    private final UltimateGoalConfiguration config;

    private final double harvesterPower = 1;

    double endTime = 0;
    double duration;

    public HarvesterTask(BaconOpMode opMode, UltimateGoalConfiguration config, double duration) {
        super(opMode);
        this.config = config;
        this.duration = duration;
    }

    @Override
    public void run() {
        endTime = (System.nanoTime() / NANOS_IN_SECONDS) + duration;
        config.baseHarvesterMotor.setPower(harvesterPower);
    }

    @Override
    public boolean isFinished() {
        if((System.nanoTime() / NANOS_IN_SECONDS) > endTime) {
            config.baseHarvesterMotor.setPower(0);
            return true;
        }
        return false;
    }
}
