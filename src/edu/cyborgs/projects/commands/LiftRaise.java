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
public class LiftRaise extends CommandBase {
    
	private boolean upperLimitHit;
	private boolean useMidLimit;
	private boolean useTimeout;
	
    public LiftRaise() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(liftSystem);
        useMidLimit = false;
    }
    
    public LiftRaise(boolean useMidLimit) {
    	this();
    	this.useMidLimit = useMidLimit;
    }
    
    public LiftRaise(double seconds) {
    	this();
    	useTimeout = true;
    	setTimeout(seconds);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	upperLimitHit = liftSystem.getUpperLimit();
    	if (!upperLimitHit)
    		liftSystem.raise();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return upperLimitHit ||
    			// useMidLimit && liftSystem.getMidLimit() ||
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
