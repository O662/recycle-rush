package edu.cyborgs.projects.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class LiftSetHeight extends CommandBase {

	private static final double pulsesPerInch = 29.6;
	private static final double inchTolerance = 0.5;
	
	private double endHeight;
	private double currHeight;
	
    public LiftSetHeight(double height) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(liftSystem);
    	endHeight = height;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currHeight = liftSystem.getEncoder() / pulsesPerInch;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currHeight = liftSystem.getEncoder() / pulsesPerInch;
    	
    	if (currHeight < endHeight) {
    		liftSystem.raise();
    	} else {
    		liftSystem.lower();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(currHeight - endHeight) < inchTolerance;
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
