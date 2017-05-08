package edu.cyborgs.projects.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurnDegrees extends CommandBase {

	private double angle;
	private boolean clockwise;
	
    public DriveTurnDegrees(double degrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	angle = degrees;
    	requires(mechDriveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	mechDriveSystem.resetGyro();
    	if (angle < 0)
    		clockwise = false;
    	else
    		clockwise = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = 0.7;
    	if (clockwise)
    		mechDriveSystem.drive(0, 0, speed, true);
    	else
    		mechDriveSystem.drive(0, 0, -speed, true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(mechDriveSystem.getAngle() - angle) < 3;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
