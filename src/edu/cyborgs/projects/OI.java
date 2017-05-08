
package edu.cyborgs.projects;

import edu.cyborgs.project.autonomous.ForwardTurn;
import edu.cyborgs.project.autonomous.GrabToteBackup;
import edu.cyborgs.project.autonomous.GrabTurnGo;
import edu.cyborgs.projects.commands.ArmsClose;
import edu.cyborgs.projects.commands.ArmsOpen;
import edu.cyborgs.projects.commands.DriveTurnDegrees;
import edu.cyborgs.projects.commands.LiftLower;
import edu.cyborgs.projects.commands.LiftSetHeight;
import edu.cyborgs.projects.commands.ResetGyro;
import edu.cyborgs.projects.commands.ToggleCompressor;
import edu.cyborgs.projects.commands.ToggleGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
    
    Joystick stick = new Joystick(0); // USB Port
    Joystick testStick = new Joystick(1);

    JoystickButton buttonA = new JoystickButton(stick, 1);
    JoystickButton buttonB = new JoystickButton(stick, 2);
    JoystickButton buttonLB = new JoystickButton(stick, 5);
    JoystickButton buttonRB = new JoystickButton(stick, 6);
    JoystickButton buttonSEL = new JoystickButton(stick, 7);
    JoystickButton leftStickClick = new JoystickButton(stick, 9);
    JoystickButton rightStickClick = new JoystickButton(stick, 10);
    
    JoystickButton testButtonA = new JoystickButton(testStick, 1);
    JoystickButton testButtonB = new JoystickButton(testStick, 2);
    JoystickButton testButtonX = new JoystickButton(testStick, 3);
    JoystickButton testButtonY = new JoystickButton(testStick, 4);
    
    public OI() {
        buttonRB.whenPressed(new LiftSetHeight(12));
        buttonLB.whenPressed(new LiftSetHeight(16));
        buttonB.whenPressed(new ArmsOpen());
        buttonA.whenPressed(new ArmsClose());
        leftStickClick.whenPressed(new ResetGyro());
        buttonSEL.whenPressed(new ToggleCompressor());
        rightStickClick.whenPressed(new ToggleGyro());
        
        testButtonA.whenPressed(new ForwardTurn());
        testButtonB.whenPressed(new GrabTurnGo());
        testButtonX.whenPressed(new GrabToteBackup());
        testButtonY.whenPressed(new DriveTurnDegrees(90));
        
    }
    
    public double getStrafe() {
        return stick.getAxis(AxisType.kX);
    }
    
    public double getForwardBackward() {
        return stick.getAxis(AxisType.kY);
    }
    
    public double getTurn() {
        return stick.getRawAxis(4);
    }
    
    public double getLeftTrigger() {
    	return stick.getRawAxis(2);
    }
    
    public double getRightTrigger() {
    	return stick.getRawAxis(3);
    }
    
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

