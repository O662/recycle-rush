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
public class ArmsClose extends CommandBase {
    
    private boolean hasClosed = false;
    
    public ArmsClose() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(armSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        armSystem.close();
        hasClosed = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasClosed;
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
