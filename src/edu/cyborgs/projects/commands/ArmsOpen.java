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
public class ArmsOpen extends CommandBase {
    
    private boolean hasOpened = false;
    
    public ArmsOpen() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(armSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        armSystem.open();
        hasOpened = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasOpened;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//armSystem.doNothing();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
