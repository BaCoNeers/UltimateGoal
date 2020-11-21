package org.baconeers.common.templates;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.baconeers.common.autonomous.BaseTask;
import org.baconeers.common.teleop.BaconOpMode;

import java.util.ArrayDeque;

@Autonomous(name = "AutonomousTemplate", group = "Task Opmode")
public class AutonomousOpModeTemplate extends BaconOpMode {

    /**
     *
     *      This file is a template for autonomous runs using the "task system".
     *      The task system requires use of the BaseTask abstract class. See
     *      base class for more information.
     *
     *      Below holds the config and ArrayDeque. The config will need to be set
     *      to the season's config. The ArrayDeque can stay as is, unless a
     *      different base will be used for the tasks.
     *
     */

    private ConfigurationTemplate config;
    private ArrayDeque<BaseTask> tasks = new ArrayDeque<BaseTask>();

    /**
     *
     *      The onInit() method will run when the init button is pressed on the
     *      phone. Place the whole autonomous run in this method, below the
     *      initialisation of the configuration file. Tasks can be added to the
     *      run using "tasks.add(Task)". All tasks must extend the base class.
     *
     *      e.g: tasks.add(new DriveTask(this, config, DriveSpeed.FAST, 1)
     *
     *      This will add task of type DriveTask. The constructor is passed the
     *      values needed for the task to run. For more information, see
     *      TaskTemplate.
     *
     */


    @Override
    protected void onInit() {
        config = ConfigurationTemplate.newConfig(hardwareMap, telemetry);

    }

    /**
     *
     *      Below is the activeLoop() method. This method is run every frame
     *      the robot is running, and occurs after onInit(). The method is
     *      already set up to run the tasks in the order outlined above in
     *      the onInit() method. This method does not require any editing if
     *      being used as a template. Only edit if extra functionality is
     *      needed.
     *
     */


    @Override
    protected void activeLoop() throws InterruptedException {
        BaseTask currentTask = tasks.peekFirst();
        boolean taskInProgress = false;

        if(currentTask == null) {
            return;
        }
        else if(taskInProgress) {
            currentTask.run();
            taskInProgress = true;
        }
        else if(currentTask.isFinished()) {
            tasks.removeFirst();
            taskInProgress = false;
        }
    }

}
