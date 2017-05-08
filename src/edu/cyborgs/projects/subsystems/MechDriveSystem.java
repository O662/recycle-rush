/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cyborgs.projects.subsystems;

import edu.cyborgs.projects.RobotMap;
import edu.cyborgs.projects.commands.*;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author ricshawn
 */
public class MechDriveSystem extends PIDSubsystem {
    
    private static final double Kp = 4.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
	private static final double inchesPerVolt = 106.1391;
	private static final double maxSpeed = 0.35;
	private static final double maxTurn = 0.5;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private RobotDrive mechDrive = new RobotDrive(RobotMap.frontLeftMotorPort, RobotMap.backLeftMotorPort,
            RobotMap.frontRightMotorPort, RobotMap.backRightMotorPort);
    private AnalogInput ultrasonic = new AnalogInput(RobotMap.rangefinderPort);
    private Gyro gyro = new Gyro(RobotMap.gyroPort);
    private boolean useGyro;
    
    public MechDriveSystem() {
        super("MecanumDrive", Kp, Ki, Kd);
        mechDrive.setInvertedMotor(MotorType.kRearLeft, true);
        mechDrive.setInvertedMotor(MotorType.kFrontLeft, true);
        useGyro = false;
        disable();
    }
    
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void drive(double x, double y, double rotation) {
    	drive(x, y, rotation, useGyro);
    }
    
    public void drive(double x, double y, double rotation, boolean useGyro) {
    	x = clamp(x, -1, 1);
    	y = clamp(y, -1, 1);
    	rotation = clamp(rotation, -1, 1);
    	double angle = Math.toDegrees(Math.atan2(-x, y));
    	double speed;
    	if (useGyro) {
    		speed = maxSpeed + maxSpeed * Math.abs(Math.sin(Math.toRadians(angle - gyro.getAngle())));
	        mechDrive.mecanumDrive_Polar(Math.hypot(-x, y) * speed,
	        		angle - gyro.getAngle(),
	        		-rotation * maxTurn);
    	} else {
    		speed = maxSpeed + maxSpeed * Math.abs(Math.sin(Math.toRadians(angle)));
    		mechDrive.mecanumDrive_Polar(Math.hypot(-x, y) * speed,
	        		angle,
	        		-rotation * maxTurn);
    	}
    	SmartDashboard.putString("DB/String 0",
    			String.format("Distance: %.4f", getDistance()));
    	SmartDashboard.putString("DB/String 2",
    			String.format("Gyro: %.4f", gyro.getAngle()));
    	SmartDashboard.putString("DB/String 3", "Using Gyro: " + useGyro);
    	SmartDashboard.putString("DB/String 4", "Angle: " + angle);
    }
    
    public void resetGyro() {
    	gyro.reset();
    }
    
    public void toggleGyro(boolean gyroState) {
    	useGyro = gyroState;
    }
    
    public boolean isUsingGyro() {
    	return useGyro;
    }
    
    public double getAngle() {
    	return gyro.getAngle();
    }

    protected double returnPIDInput() {
        return gyro.getAngle();
    }

    protected void usePIDOutput(double d) {
        //drive(0, 0, d);
    }
    
    private double getDistance() {
    	return ultrasonic.getVoltage() * inchesPerVolt;
    }
    
    private double clamp(double value, double min, double max) {
    	return Math.min(Math.max(value, min), max);
    }
}
