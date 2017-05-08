package edu.cyborgs.projects.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurnForSeconds extends CommandBase {
	
	boolean clockwise;
	
    public DriveTurnForSeconds(double seconds, boolean clockwise) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(mechDriveSystem);
    	setTimeout(seconds);
    	this.clockwise = clockwise;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (clockwise)
    		mechDriveSystem.drive(0, 0, 0.5);
    	else
    		mechDriveSystem.drive(0, 0, -0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
