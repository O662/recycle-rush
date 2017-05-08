/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cyborgs.projects.commands;

/**
 *
 * @author ricshawn
 */
public class LiftLower extends CommandBase {
    
	private boolean lowerLimitHit;
	private boolean useTimeout;
	
    public LiftLower() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(liftSystem);
    }
    
    public LiftLower(double seconds) {
    	this();
    	useTimeout = true;
    	setTimeout(seconds);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lowerLimitHit = liftSystem.getLowerLimit();
    	if (!lowerLimitHit)
    		liftSystem.lower();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return lowerLimitHit ||
        		useTimeout && isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	liftSystem.doNothing();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
