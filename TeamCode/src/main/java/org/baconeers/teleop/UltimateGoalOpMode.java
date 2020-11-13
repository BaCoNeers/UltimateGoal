package org.baconeers.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.baconeers.common.teleop.BaconOpMode;
import org.baconeers.configurations.UltimateGoalConfiguration;

@TeleOp(name = "UltimateGoalOpMode", group = "Linear Opmode")
public class UltimateGoalOpMode extends BaconOpMode {
    private UltimateGoalConfiguration config;
    private SwerveDrive swerveDrive;

    @Override
    protected void onInit() {
        config = UltimateGoalConfiguration.newConfig(hardwareMap, telemetry);

        try {
            swerveDrive = new SwerveDrive(this, config, telemetry);
        } catch(Exception e) {
            telemetry.addLine("Failed to initialise swerve drive");
        }
    }

    @Override
    protected void activeLoop() throws InterruptedException {
        swerveDrive.update();
    }
}
