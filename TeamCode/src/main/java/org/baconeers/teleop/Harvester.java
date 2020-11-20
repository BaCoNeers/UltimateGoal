package org.baconeers.teleop;

import com.qualcomm.robotcore.util.Range;

import org.baconeers.common.teleop.BaconComponent;
import org.baconeers.common.teleop.BaconOpMode;
import org.baconeers.configurations.UltimateGoalConfiguration;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Harvester extends BaconComponent {

    private BaconOpMode opmode;
    private UltimateGoalConfiguration config;
    private Telemetry telemetry;

    double turnPower = 1;
    double offTurnPower = 0;
    double MotorPower = 0;
    boolean toggle = false;
    // For the harvester is this what we need to implement? - Bryce

    public Harvester(BaconOpMode opmodeIn, UltimateGoalConfiguration configIn, Telemetry telemetryIn) {
        super(opmodeIn);
        opmode = opmodeIn;
        config = configIn;
        telemetry = telemetryIn;
    }


    public void update() {
        if (opmode.gamepad1.y) {
            if (toggle) {
                toggle = false;
            } else {
                toggle = true;
            }
        }
        // button y pressed to toggle
        Range.clip(MotorPower,-1,1);
        // clip at a min of 0; - Bryce
        if (toggle) {
            config.leftDriveMotor.setPower(turnPower);
        } else {
            config.leftDriveMotor.setPower(offTurnPower);
        }
        // are there only two motors we can set the power for? - Bryce

    }
}