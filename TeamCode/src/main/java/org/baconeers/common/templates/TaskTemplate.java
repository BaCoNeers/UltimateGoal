package org.baconeers.common.templates;

import org.baconeers.common.autonomous.BaseTask;
import org.baconeers.common.teleop.BaconOpMode;

public class TaskTemplate extends BaseTask {
    /**
     *
     *      The configuration is below. Change to the season's configuration file.
     *      Put any variables this task needs to store for operation under the config.
     *      e.g: private double distance, private double runTime
     *
     */

    private ConfigurationTemplate config;

    /**
     *
     *      Below is the constructor that will initialise the variables declared above.
     *      Pass in the variables as parameters and set the class variables using 'this'
     *      The class variables will be stored after the constructor runs. Any unsaved
     *      parameters will be lost.
     *
     *      Set any other variables here, too. Do not set up time. This will begin upon
     *      initialisation of the class. Use System.nanoTime in the run() method to get
     *      the time at the start of the task's operation.
     *
     *      e.g: this.distance = distance, this.runTime = runTime
     *
     */


    public TaskTemplate(BaconOpMode opmode, ConfigurationTemplate config) {
        // The below variables are necessary
        super(opmode);
        this.config = config;
    }

    /**
     *
     *      The run() method will be run once by the autonomous opmode. Think of it
     *      like a beginTask() method instead of a run() method (poorly named, I
     *      know). Put any code necessary to start the task. The code in here will
     *      only be run when the task first starts, instead of the constructor,
     *      which runs the code when the task is created. Set up time variables in
     *      here using System.nanoTime to get the current time of the program. Also
     *      set motor power in here.
     *
     *      e.g: endTime = (System.nanoTime/NANOS_IN_SECONDS) + runTime
     *      motor.setPower(motorPower)
     *
     *      For information on NANOS_IN_SECONDS, see BaseTask
     *
     */

    public void run() {

    }

    /**
     *
     *      The isFinished() method will be run every frame and check for whether
     *      the task has been completed. Use a conditional statement to check for
     *      state of task.
     *
     *      e.g. if((System.nanoTime/NANOS_IN_SECONDS) > endTime) will check if
     *      the current system time has passed the runTime.
     *
     */

    public boolean isFinished() {
        boolean condition = false;

        if(condition) {
            return true;
        }
        return false;
    }

}
