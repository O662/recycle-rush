/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cyborgs.projects.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.cyborgs.projects.RobotMap;
import edu.cyborgs.projects.commands.ArmsDoNothing;


public class ArmsSystem extends Subsystem {
	
	private static final double PSIPerVolt = 20.0;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid armSolenoid_open = new Solenoid(RobotMap.armsSolenoidOpen);
    Solenoid armSolenoid_close = new Solenoid(RobotMap.armsSolenoidClose);
    Relay compressor = new Relay(RobotMap.relayCompressor);
    AnalogInput pneumaticGauge = new AnalogInput(RobotMap.pneumaticGauge);
    private boolean compressorOn;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArmsDoNothing());
        compressorOn = false;
    }
    
    public void doNothing() {
        armSolenoid_open.set(false);
        armSolenoid_close.set(false);
        if (compressorOn) {
        	compressor.set(Value.kReverse);
        } else {
        	compressor.set(Value.kOff);
        }
        SmartDashboard.putString("DB/String 1",
    			String.format("PSI: %.4f", getPressure()));
    }
    
    public void open() {
        armSolenoid_open.set(true);
        armSolenoid_close.set(false);
        SmartDashboard.putString("DB/String 1",
    			String.format("PSI: %.4f", getPressure()));

    }
    
    public void close() {
        armSolenoid_open.set(false);
        armSolenoid_close.set(true);
        SmartDashboard.putString("DB/String 1",
    			String.format("PSI: %.4f", getPressure()));

    }
    
    public void toggleCompressor() {
    	compressorOn = !compressorOn;
    }
    
    public double getPressure() {
    	return pneumaticGauge.getVoltage() * PSIPerVolt;
    }
}
