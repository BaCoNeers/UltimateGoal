package org.baconeers.autonomous;

import org.baconeers.common.autonomous.BaseTask;
import org.baconeers.common.autonomous.tasks.DriveTask;
import org.baconeers.common.autonomous.tasks.HarvesterTask;
import org.baconeers.common.teleop.BaconOpMode;
import org.baconeers.configurations.UltimateGoalConfiguration;
import org.baconeers.teleop.UltimateGoalOpMode;

import java.util.ArrayDeque;
import java.util.Stack;

public class Autonomous {

    UltimateGoalOpMode opmode;
    UltimateGoalConfiguration config;

    private ArrayDeque<BaseTask> tasks = new ArrayDeque<BaseTask>();

    private int[] integers = new int[2];
    private boolean currentTaskRunning = false;
    private BaseTask task;


    private void activeLoop() {
        tasks.add(new HarvesterTask(opmode,config,true,0));
        tasks.add(new DriveTask(opmode, config, DriveTask.DriveSpeed.MEDIUM, 19));
        tasks.add(new DriveTask(opmode, config, DriveTask.DriveSpeed.SLOW, 1));
        tasks.add(new DriveTask(opmode, config, DriveTask.DriveSpeed.FAST, 23));

        if (!currentTaskRunning) {
            task = tasks.peekFirst();
            task.run();
        }
        if(task.isFinished()) {
            tasks.removeFirst();
        }




    }

}
