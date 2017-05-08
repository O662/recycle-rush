package edu.cyborgs.projects.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DelayUntilPressure extends CommandBase {

	private static final double pressureTolerance = 0.5;
	
	private double target;
	
    public DelayUntilPressure(double psi) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(armSystem);
    	target = psi;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return armSystem.getPressure() > target;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
