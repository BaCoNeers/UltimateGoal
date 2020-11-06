package org.baconeers.common.templates;

import org.baconeers.common.teleop.BaconComponent;
import org.baconeers.common.teleop.BaconOpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 *
 *      Copy this file to use as a base for a component.
 *      Rename the file, location, and imports. Add import for configuration needed.
 *
 */

public class ComponentTemplate extends BaconComponent {

    /**
     *
     *      Opmode, config and telemetry variables below
     *      Change the config variable to the correct type (e.g. UltimateGoalConfiguration)
     *      Declare any extra variables (e.g. motors, servos, sensors) below
     *
     */

    private BaconOpMode opmode;
    private ConfigurationTemplate config;
    private Telemetry telemetry;

    /**
     *
     *      The below method will construct this class. Rename this class and the below method to
     *      be the same as the file name. Do not edit the method below unless necessary.
     *
     */

    public ComponentTemplate(BaconOpMode opmodeIn, ConfigurationTemplate configIn, Telemetry telemetryIn) {
        super(opmodeIn);
        opmode = opmodeIn;
        config = configIn;
        telemetry = telemetryIn;
    }

    public void update() {

        /**
         *
         *      Write code to run every frame here. Call this method in the main opmode class.
         *      Remember: do not use unbreakable loops (e.g. while loops)
         *
         */

    }
}