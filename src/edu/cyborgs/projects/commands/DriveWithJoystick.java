/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cyborgs.projects.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author ricshawn
 */
public class DriveWithJoystick extends CommandBase {
    
    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(mechDriveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double strafe = getDeadZone(oi.getStrafe(), 0.15);
    	strafe = getSquaredValue(strafe);
    	double forwardBackward = getDeadZone(oi.getForwardBackward(), 0.15);
    	forwardBackward = getSquaredValue(forwardBackward);
    	double turn = getDeadZone(oi.getTurn(), 0.15);
    	turn = getSquaredValue(turn);
        mechDriveSystem.drive(strafe, forwardBackward, turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private double getDeadZone(double input, double deadZone) {
    	if (Math.abs(input) > deadZone)
    		return input;
    	return 0;
    }
    
    private double getSquaredValue(double input) {
    	return input < 0 ? -Math.pow(input, 2) : Math.pow(input, 2);
    }
}
