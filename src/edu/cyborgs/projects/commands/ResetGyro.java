package edu.cyborgs.projects.commands;

/**
 *
 */
public class ResetGyro extends CommandBase {

	private boolean hasReset = false;
	
    public ResetGyro() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(mechDriveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	mechDriveSystem.resetGyro();
    	hasReset = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasReset;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
