package org.baconeers.configurations;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.baconeers.common.utilities.RobotConfiguration;
import org.firstinspires.ftc.robotcore.external.Telemetry;

// Copy this class for robot configuration
// Set up as described by the comments
public class UltimateGoalConfiguration extends RobotConfiguration {

    /**
     *      Declare all motors, servos, sensors, etc. in here and set to null.
     *
     *      E.g:
     *
     *      public DcMotor liftMotor = null;
     * @return
     */

    @Override
    protected void init(HardwareMap hardwareMap, final Telemetry telemetry) {
        setTelemetry(telemetry);

        /**
         *      Add try-catch statements for each component declared above to initialise each component
         *      from the phone's configuration. Make sure the name of the component is the same as the
         *      phone configuration. You can also set up the components here
         *
         *      E.g:
         *
         *      try {
         *            liftMotor = hardwareMap.get(DcMotor.class, "LiftMotor");
         *            if (liftMotor != null) {
         *                liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         *                liftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         *                liftMotor.setZeroPowerBehaviour(DcMotor.ZeroPowerBehaviour.BRAKE);
         *            }
         *
         *          } catch (Exception e) {
         *                telemetry.addLine("LiftMotor failed to configure");
         *            }
         *
         */

        telemetry.addData("Initialized", "True");
        telemetry.update();
    }

    /**
     * Factory method for this class. Below method will create a new copy of this class for use elsewhere.
     *
     * @param hardwareMap
     * @param telemetry
     * @return
     */

    public static UltimateGoalConfiguration newConfig(HardwareMap hardwareMap, Telemetry telemetry) {
        UltimateGoalConfiguration config = new UltimateGoalConfiguration();
        config.init(hardwareMap, telemetry);
        return config;
    }
}
