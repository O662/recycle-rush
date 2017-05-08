package edu.cyborgs.project.autonomous;

import edu.cyborgs.projects.commands.ArmsClose;
import edu.cyborgs.projects.commands.DelayForSeconds;
import edu.cyborgs.projects.commands.DriveTurnDegrees;
import edu.cyborgs.projects.commands.LiftRaise;
import edu.cyborgs.projects.commands.LiftSetHeight;
import edu.cyborgs.projects.commands.ResetLiftEncoder;
import edu.cyborgs.projects.commands.ToggleGyro;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class GrabTurnStay extends CommandGroup {
    
    public  GrabTurnStay() {

    	// toggle the gyro off
    	addParallel(new ToggleGyro(false));
    	
    	// reset the lift encoder
    	addSequential(new ResetLiftEncoder()); 
    	
    	// Raise Arms
    	addSequential(new LiftSetHeight(12));

    	// grab container
    	addSequential(new ArmsClose());
    	
    	// addSequential(new DelayForSeconds(0.5));
    	// addSequential(new LiftRaise(0.3));
    	addSequential(new DelayForSeconds(0.2));    	
    	addSequential(new DriveTurnDegrees(180));
    }
}