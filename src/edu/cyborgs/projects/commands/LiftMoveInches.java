package edu.cyborgs.projects.commands;


/**
 *
 */
public class LiftMoveInches extends CommandBase {
	
	private static final double pulsesPerInch = 29.6;
	private static final double inchTolerance = 0.5;
	
	private double targetHeight;
	private double currHeight;

    public LiftMoveInches(double inches) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(liftSystem);
    	liftSystem.resetLiftEncoder();
    	targetHeight = liftSystem.getEncoder() / pulsesPerInch + inches;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currHeight = liftSystem.getEncoder() / pulsesPerInch;
    	
    	if (currHeight < targetHeight) {
    		liftSystem.raise();
    	} else {
    		liftSystem.lower();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(targetHeight - currHeight) < inchTolerance;
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
