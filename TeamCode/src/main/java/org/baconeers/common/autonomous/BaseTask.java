package org.baconeers.common.autonomous;

import org.baconeers.common.teleop.BaconOpMode;

public abstract class BaseTask implements Task {

    protected double time;
    protected boolean isFinished = false;
    protected double startTime = 0;
    protected BaconOpMode opMode;


    /**
     * the number of nanoseconds in a second
     */
    public static final double NANOS_IN_SECONDS = 1000000000.0;


    public BaseTask(BaconOpMode opMode, double time) {

        this.time = time;
        this.opMode = opMode;

    }

    public boolean isFinished() {
        if (isFinished) {
            return isFinished;
        }

        if (startTime == 0) {
            startTime = getCurrentTime();
        }
        if (getCurrentTime() > (startTime + time)) {
            isFinished = true;
        }
        return isFinished;
    }


    private double getCurrentTime() {
        return System.nanoTime() / NANOS_IN_SECONDS;
    }

}
