package edu.cyborgs.projects;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //Motor Inputs (PWM)
    public static final int
            frontLeftMotorPort = 3,
            backLeftMotorPort = 2,
            frontRightMotorPort = 1,
            backRightMotorPort = 0,
            liftMotorPort1 = 4,
            liftMotorPort2 = 5;
    
    //Analog Inputs
    public static final int
    		gyroPort = 0,
            rangefinderPort = 2,
            pneumaticGauge = 3;
    
    //Digital Inputs (DIO)
    public static final int
            upperLimitSwitch = 0,
            lowerLimitSwitch = 1,
            // midLimitSwitch = 2;
            liftEncoderPortA = 2,
            liftEndocerPortB = 3;

    //Pneumatic Inputs
    public static final int
            //relay
            compressorCntrlPort = 2,
            // Pneumatics (PCM)
            armsSolenoidOpen = 1,
            armsSolenoidClose = 0;
            //Pneumatics variable Pressure switch (analog)
            
    
    //Relay Inputs
    public static final int
            relayCompressor = 0;

    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
}
