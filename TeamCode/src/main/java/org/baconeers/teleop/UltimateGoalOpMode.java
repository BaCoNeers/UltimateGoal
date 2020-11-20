package org.baconeers.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.baconeers.common.teleop.BaconOpMode;
import org.baconeers.configurations.UltimateGoalConfiguration;

@TeleOp(name = "UltimateGoalOpMode", group = "Linear Opmode")
public class UltimateGoalOpMode extends BaconOpMode {

    private UltimateGoalConfiguration config = null;
    private Harvester harvester = null;
    private SwerveDrive drive = null;

    @Override
    protected void onInit() {
        config = UltimateGoalConfiguration.newConfig(hardwareMap, telemetry);

        try {
            harvester = new Harvester(this, config, telemetry);

        } catch (Exception e) {
            telemetry.addLine("Failed to initialise harvester");
        }

        try {
            drive = new SwerveDrive(this, config, telemetry);

        } catch (Exception e) {
            telemetry.addLine("Failed to initialise drive");
        }
    }

    @Override
    protected void activeLoop() throws InterruptedException {
        if (harvester != null) {
            harvester.update();
        }
        if (drive != null) {
            drive.update();
        }
    }
}
