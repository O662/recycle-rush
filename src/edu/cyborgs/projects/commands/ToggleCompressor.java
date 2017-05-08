package edu.cyborgs.projects.commands;

/**
 *
 */
public class ToggleCompressor extends CommandBase {

	private boolean hasToggled;
	
    public ToggleCompressor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(armSystem);
    	hasToggled = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	armSystem.toggleCompressor();
    	hasToggled = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasToggled;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
