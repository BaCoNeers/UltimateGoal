package org.baconeers.teleop;

import com.qualcomm.robotcore.util.Range;

import org.baconeers.common.teleop.BaconComponent;
import org.baconeers.common.teleop.BaconOpMode;
import org.baconeers.common.templates.ConfigurationTemplate;
import org.baconeers.configurations.UltimateGoalConfiguration;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SwerveDrive extends BaconComponent {

    private BaconOpMode opmode;
    private UltimateGoalConfiguration config;
    private Telemetry telemetry;

    double drivePower;
    double turnPower;
    double turnFactor = 0.75;
    double leftMotorPower = 0;
    double rightMotorPower = 0;


    public SwerveDrive(BaconOpMode opmodeIn, UltimateGoalConfiguration configIn, Telemetry telemetryIn) {
        super(opmodeIn);
        opmode = opmodeIn;
        config = configIn;
        telemetry = telemetryIn;
    }

    public void update() {

        drivePower = opmode.gamepad1.left_stick_y;
        turnPower = opmode.gamepad1.right_stick_x;


        if (turnPower > 0 || turnPower < 0) {
            leftMotorPower = drivePower + (turnFactor * turnPower);
            rightMotorPower = drivePower 	 - (turnFactor * turnPower);
        } else {
            leftMotorPower = drivePower;
            rightMotorPower =drivePower;
        }

        Range.clip(leftMotorPower,-1,1);
        Range.clip(rightMotorPower,-1,1);

        config.leftMotor.setPower(leftMotorPower);
        config.rightMotor.setPower(rightMotorPower);

    }
}