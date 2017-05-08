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
public class LiftUseTriggers extends CommandBase {
    
    public LiftUseTriggers() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(liftSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (liftSystem.getLowerLimit()) {
    		liftSystem.useTriggers(0, oi.getRightTrigger());
    		liftSystem.resetLiftEncoder();
    	} else if (liftSystem.getUpperLimit()) {
    		liftSystem.useTriggers(oi.getLeftTrigger(), 0);
    	} else {
    		liftSystem.useTriggers(oi.getLeftTrigger(), oi.getRightTrigger());
    	}
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
}
