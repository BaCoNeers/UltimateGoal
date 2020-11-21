package org.baconeers.common.autonomous;

import org.baconeers.common.teleop.BaconOpMode;

public abstract class BaseTask {
    protected BaconOpMode opMode;

    /**
     *      The number of nanoseconds in a second
     *      Use System.nanoTime() to get the current time in nano seconds
     */

    public static final double NANOS_IN_SECONDS = 1000000000.0;

    /**
     *
     *      The following constructor can be called using "super". This
     *      constructor can be used to initialise variables that every
     *      task requires to run, such as opMode.
     *
     */

    public BaseTask(BaconOpMode opMode) {
        this.opMode = opMode;
    }

    /**
     *
     *      The below methods are necessary for a task to run. To see the
     *      use of the methods, see already created task. Otherwise, see
     *      the AutonomousOpModeTemplate for the calling of the methods.
     *
     */

    public abstract void run();
    public abstract boolean isFinished();
}
