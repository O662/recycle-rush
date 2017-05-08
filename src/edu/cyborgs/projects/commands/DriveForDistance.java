package edu.cyborgs.projects.commands;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class DriveForDistance extends CommandBase {

	private static final double maxSpeed = 1.118;
	private static final double decceleration = 2.3;
	private static final double feetPerMeter = 3.28;
	
	private boolean isForward;
	private double velocity;
	private double position;
	private double target;
	private double oldTime;
	private BuiltInAccelerometer accel;

    public DriveForDistance(double feet) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(mechDriveSystem);
    	if (feet > 0)
    		isForward = true;
    	else
    		isForward = false;
    	target = feet / feetPerMeter;
    	position = 0;
    	velocity = 0;
    	accel = new BuiltInAccelerometer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	mechDriveSystem.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double deltaTime = Timer.getFPGATimestamp() - oldTime;
    	oldTime = Timer.getFPGATimestamp();
    	position += velocity * deltaTime + Math.pow(accel.getX()/9.81, 2) * deltaTime / 2;
    	velocity += accel.getX()/9.81 * deltaTime;
    	
    	if (isForward)
    		mechDriveSystem.drive(0, -1, 0, false);
    	else
    		mechDriveSystem.drive(0, 1, 0, false);
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double stopTime = velocity / decceleration;
    	return Math.abs(position + velocity * stopTime +
				Math.pow(decceleration, 2) / 2 * stopTime)
				>= Math.abs(target);
    }

    // Called once after isFinished returns true
    protected void end() {
    	mechDriveSystem.drive(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
