package org.baconeers.common.autonomous.tasks;

import org.baconeers.common.autonomous.BaseTask;
import org.baconeers.common.teleop.BaconOpMode;
import org.baconeers.configurations.UltimateGoalConfiguration;

public class HarvesterTask extends BaseTask {

    private UltimateGoalConfiguration config;
    private boolean on;

    final double onPower = 1;
    final double offPower = 0;
    double endTime = 0;
    boolean isFinished = false;
    double time;

    public HarvesterTask(BaconOpMode opMode, UltimateGoalConfiguration config, boolean On, double Time) {
        super(opMode);
        this.config = config;
        this.on = On;
        this.time = Time;

    }

    @Override
    public void run() {
        if (on) {
            config.baseHarvesterMotor.setPower(onPower);
        } else {
            config.baseHarvesterMotor.setPower(offPower);
        }
        if (endTime == 0) {
            endTime = (System.nanoTime() / NANOS_IN_SECONDS) + time;

        }
        isFinished = true;
    }

    @Override
    public boolean isFinished() {
        if((System.nanoTime() / NANOS_IN_SECONDS) > endTime) {
            if (on && time > 0) {
                config.baseHarvesterMotor.setPower(offPower);
            } else if (!on && time > 0) {
                config.baseHarvesterMotor.setPower(onPower);
            }
            return true;
        }
        return false;
    }
}
