package org.baconeers.configurations;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.baconeers.common.utilities.RobotConfiguration;
import org.firstinspires.ftc.robotcore.external.Telemetry;

// Copy this class for robot configuration
// Set up as described by the comments
public class UltimateGoalConfiguration extends RobotConfiguration {

     public DcMotor leftDriveMotor;
     public DcMotor rightDriveMotor;

     public DcMotor leftHarvesterMotor;


    @Override
    protected void init(HardwareMap hardwareMap, final Telemetry telemetry) {
        setTelemetry(telemetry);

        try {
            leftDriveMotor = hardwareMap.get(DcMotor.class, "leftDriveMotor");
            if(leftDriveMotor != null) {
                leftDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                leftDriveMotor.setDirection(DcMotorSimple.Direction.FORWARD);
            }

        } catch(Exception e) {
            telemetry.addLine("leftDriveMotor failed to configure");
        }

        try {
            rightDriveMotor = hardwareMap.get(DcMotor.class, "rightDriveMotor");
            if(rightDriveMotor != null) {
                rightDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                rightDriveMotor.setDirection(DcMotorSimple.Direction.REVERSE);
            }

        } catch(Exception e) {
            telemetry.addLine("rightDriveMotor failed to configure");
        }

        try {
            leftHarvesterMotor = hardwareMap.get(DcMotor.class, "leftHarvesterMotor");
            if(leftHarvesterMotor != null) {
                leftHarvesterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                leftHarvesterMotor.setDirection(DcMotorSimple.Direction.FORWARD);
            }

        } catch(Exception e) {
            telemetry.addLine("leftHarvesterMotor failed to configure");
        }

        telemetry.addData("Initialized", "True");
        telemetry.update();
    }

    public static UltimateGoalConfiguration newConfig(HardwareMap hardwareMap, Telemetry telemetry) {
        UltimateGoalConfiguration config = new UltimateGoalConfiguration();
        config.init(hardwareMap, telemetry);
        return config;
    }
}
