/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cyborgs.projects.subsystems;
import edu.cyborgs.projects.RobotMap;
import edu.cyborgs.projects.commands.LiftUseTriggers;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
// import edu.wpi.first.wpilibj.Encoder;
// import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author ricshawn
 */
public class LiftSystem extends Subsystem
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private final SpeedController liftMotor1 = new Victor(RobotMap.liftMotorPort1);
    private final SpeedController liftMotor2 = new Victor(RobotMap.liftMotorPort2);
    private final DigitalInput lowerLimit = new DigitalInput(RobotMap.lowerLimitSwitch);
    private final DigitalInput upperLimit = new DigitalInput(RobotMap.upperLimitSwitch);
    // private final DigitalInput midLimit = new DigitalInput(RobotMap.midLimitSwitch);
    private final double upSpeed = 1.0;
    private final double downSpeed = 0.4;
    private final double pulsesPerInch = 29.6;
    
    // Encoder encoder = new Encoder(1, 2, false);
    private final Encoder encoder = new Encoder(RobotMap.liftEncoderPortA,RobotMap.liftEndocerPortB, true, EncodingType.k4X);
    
    public void initDefaultCommand()
    {
    	encoder.reset();
    	// SmartDashboard.putString("DB/String 6",
    	//		String.format("Encoder Dir: %d", encoder.getDirection()));
       // Set the default command for a subsystem here.
        setDefaultCommand(new LiftUseTriggers());
    }
    
    public void doNothing()
    {
        liftMotor1.set(0.0);
        liftMotor2.set(0.0);

    	SmartDashboard.putString("DB/String 5",
    			String.format("Encoder Dist: %.4f", encoder.getDistance()));
    }
    
    public void useTriggers(double left, double right) {
    	double trigger = right - left;
    	double speed;
    	if (trigger < 0) {
    		speed = downSpeed*trigger;
    		liftMotor1.set(speed);
    		liftMotor2.set(speed);
    	} else {
    		speed = upSpeed*trigger;
    		liftMotor1.set(speed);
    		liftMotor2.set(speed);
    	}

    	SmartDashboard.putString("DB/String 5",
    			String.format("Encoder Dist: %.4f", encoder.getDistance()));
    	SmartDashboard.putString("DB/String 6",
    			String.format("Lift Height: %.4f in.", getHeight()));
    }
    
    public void raise()
    {
        liftMotor1.set(upSpeed);
        liftMotor2.set(upSpeed);
    }
    
    public void lower()
    {
        liftMotor1.set(-downSpeed);
        liftMotor2.set(-downSpeed);
    }
    
    public boolean getLowerLimit() {
        return lowerLimit.get();
    }
    
    public boolean getUpperLimit() {
        return upperLimit.get();
    }
    
    public void resetLiftEncoder() {
    	encoder.reset();
    }
    
    public double getEncoder() {
    	return encoder.getDistance();
    }
    
    public double getHeight() {
    	return encoder.getDistance() / pulsesPerInch;
    }
    /*
    public boolean getMidLimit() {
    	return midLimit.get();
    }
    */
}
