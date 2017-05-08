package edu.cyborgs.project.autonomous;

import edu.cyborgs.projects.commands.ArmsClose;
import edu.cyborgs.projects.commands.ArmsOpen;
import edu.cyborgs.projects.commands.DelayForSeconds;
import edu.cyborgs.projects.commands.DelayUntilPressure;
import edu.cyborgs.projects.commands.DriveForDistanceTimed;
import edu.cyborgs.projects.commands.DriveTurnDegrees;
import edu.cyborgs.projects.commands.LiftMoveInches;
import edu.cyborgs.projects.commands.ResetLiftEncoder;
import edu.cyborgs.projects.commands.ToggleGyro;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GrabContainerBackup extends CommandGroup {
    
    public  GrabContainerBackup() {
    	// toggle the gyro off
    	addParallel(new ToggleGyro(false));
    	
    	// reset the lift encoder
    	addParallel(new ResetLiftEncoder());
    	
    	// wait until pressure reaches 30 psi
    	addSequential(new DelayUntilPressure(30));
    	
    	// grab container
    	addSequential(new ArmsClose());
    	addSequential(new DelayForSeconds(0.3));
    	
    	// raise container 4 inches
    	addSequential(new LiftMoveInches(8));
    	
    	// backup to auto zone
    	addSequential(new DriveForDistanceTimed(-10));
    	addSequential(new DelayForSeconds(0.5));
    	
    	// rotate 90 deg. counterclockwise
    	addSequential(new DriveTurnDegrees(-90));
    	addSequential(new DelayForSeconds(0.5));

    	// lower 4 inches
    	addSequential(new LiftMoveInches(-3));
    	
    	addParallel(new ArmsOpen());
    	addSequential(new DriveForDistanceTimed(-1));
    }
}
