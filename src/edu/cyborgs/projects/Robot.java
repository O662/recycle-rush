/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.cyborgs.projects;

import edu.cyborgs.project.autonomous.AutonDoNothing;
import edu.cyborgs.project.autonomous.ForwardTurn;
import edu.cyborgs.project.autonomous.GrabContainerBackup;
import edu.cyborgs.project.autonomous.GrabToteBackup;
import edu.cyborgs.projects.commands.CommandBase;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
// import edu.cyborgs.projects.commands.CommandBase;
// import edu.cyborgs.projects.OI;
// import edu.cyborgs.projects.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    private Command autonomousCommand;
    private SendableChooser autoChooser;
    private BuiltInAccelerometer accel = new BuiltInAccelerometer();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

    	autoChooser = new SendableChooser();
    	autoChooser.addDefault("Do Nothing", new AutonDoNothing());
    	autoChooser.addObject("Forward Turn", new ForwardTurn());
    	autoChooser.addObject("Grab Container Backup", new GrabContainerBackup());
    	autoChooser.addObject("Grab Tote Backup", new GrabToteBackup());
    	SmartDashboard.putData("Autonomous Chooser", autoChooser);
    	autonomousCommand = new AutonDoNothing();
        CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) autoChooser.getSelected();
        autonomousCommand.start();

        // new ResetLiftEncoder().start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        SmartDashboard.putString("DB/String 0", String.format("X: %.4f", accel.getX()));
        SmartDashboard.putString("DB/String 1", String.format("Y: %.4f", accel.getY()));
        SmartDashboard.putString("DB/String 2", String.format("Z: %.4f", accel.getZ()));
    }
}
