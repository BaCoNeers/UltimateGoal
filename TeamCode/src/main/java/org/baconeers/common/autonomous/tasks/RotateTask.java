package org.baconeers.common.autonomous.tasks;

import org.baconeers.common.autonomous.BaseTask;
import org.baconeers.common.teleop.BaconOpMode;
import org.baconeers.configurations.UltimateGoalConfiguration;
import com.qualcomm.robotcore.hardware.GyroSensor;

public class RotateTask extends BaseTask {

    private UltimateGoalConfiguration config;

    // Amount the robot will rotate in degrees
    private float turnAngle;


    public RotateTask(BaconOpMode opmode, UltimateGoalConfiguration config, float turnAngle) {
        super(opmode);
        this.config = config;
        this.turnAngle = turnAngle;
    }

    public void run() {

    }

    public boolean isFinished() {

        return true;
    }
}
