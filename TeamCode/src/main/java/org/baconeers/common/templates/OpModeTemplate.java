package org.baconeers.common.templates;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.baconeers.common.teleop.BaconOpMode;

@TeleOp(name = "OpModeTemplate", group = "Linear Opmode")
public class OpModeTemplate extends BaconOpMode {
    /**
     *
     *      Declare copies of every TeleOp class required for the robot, including the configuration
     *      for this opmode. Do not need to set up motors, that is set up in configuration.
     *
     *      E.g:
     *
     *      private ConfigurationTemplate config = null;
     *      private TankDrive drive = null;
     *
     */

    @Override
    protected void onInit() {
        /**
         *
         *      Use try-catches to initialise each class declared above. Use factory for config.
         *
         *      E.g:
         *
         *      config = ConfigurationTemplate.newConfig(hardwareMap, telemetry);
         *
         *      try {
         *          drive = new TankDrive(this, config);
         *
         *      } catch (Exception e) {
         *          telemetry.addLine("Failed to initialise drive");
         *      }
         *
         */
    }

    @Override
    protected void activeLoop() throws InterruptedException {
        /**
         *
         *      Call the update methods for each component above. Check if null before attempting
         *      to run.
         *
         *      E.g:
         *
         *      if (drive != null) {
         *          drive.update();
         *      }
         *
         *      if (lift != null) {
         *          lift.update();
         *      }
         *
         */
    }
}
