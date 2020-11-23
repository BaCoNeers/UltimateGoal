package org.baconeers.common.autonomous.tasks;

import org.baconeers.common.autonomous.BaseTask;
import org.baconeers.common.teleop.BaconOpMode;
import org.baconeers.configurations.UltimateGoalConfiguration;

public class LiftTask extends BaseTask {
    // Config
    private UltimateGoalConfiguration config;

    // Enum for direction of lift
    public enum LiftDirection { UP, DOWN }
    private LiftDirection liftDirection;

    private double endTime; // Should be 3 seconds

    public LiftTask(BaconOpMode opmode, UltimateGoalConfiguration config, LiftDirection liftDirection) {
        super(opmode);
        this.config = config;
        this.liftDirection = liftDirection;
    }

    public void run() {
        if(liftDirection == LiftDirection.UP) {
            //config.liftMotor.setPower(1);
        }
        else {
            //config.liftMotor.setPower(-1);
        }

        endTime = (System.nanoTime() / NANOS_IN_SECONDS) + 3;
    }

    public boolean isFinished() {
        if((System.nanoTime() / NANOS_IN_SECONDS) > endTime) {
            //config.liftMotor.setPower(0);
            return true;
        }
        return false;
    }
}
