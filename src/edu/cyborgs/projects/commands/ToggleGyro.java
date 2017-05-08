package edu.cyborgs.projects.commands;

/**
 *
 */
public class ToggleGyro extends CommandBase {

	private boolean hasToggled = false;
	private boolean useSetGyro;
	private boolean gyroState;
	
    public ToggleGyro() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(mechDriveSystem);
    	useSetGyro = false;
    }
    
    public ToggleGyro(boolean gyroState) {
    	requires(mechDriveSystem);
    	useSetGyro = true;
    	this.gyroState = gyroState;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (useSetGyro)
    		mechDriveSystem.toggleGyro(gyroState);
    	else
    		mechDriveSystem.toggleGyro(mechDriveSystem.isUsingGyro());
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
