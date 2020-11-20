package org.baconeers.common.autonomous;

import org.baconeers.common.teleop.BaconOpMode;

public abstract class BaseTask {

    protected BaconOpMode opMode;

    /**
     *      The number of nanoseconds in a second
     *      Use System.nanoTime() to get the current time in nano seconds
     */

    public static final double NANOS_IN_SECONDS = 1000000000.0;

    public BaseTask(BaconOpMode opMode) {
        this.opMode = opMode;
    }

    public abstract void run();
    public abstract boolean isFinished();
}
