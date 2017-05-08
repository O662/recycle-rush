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
public class GrabToteBackup extends CommandGroup {
    
    public GrabToteBackup() {
    	// start facing tote & driver station
    	// arms full open
    	// aligned with tote (fixed arm to tote edge)

    	// toggle the gyro off
    	addParallel(new ToggleGyro(false));
    	
    	// reset the lift encoder
    	addParallel(new ResetLiftEncoder());
    	
    	// wait until pressure reaches 30 psi
    	addSequential(new DelayUntilPressure(30));
    	
    	// go fwd to tote ~8 in
    	addSequential(new DriveForDistanceTimed(5));
    	
    	// grab tote
    	addSequential(new ArmsClose());
    	addSequential(new DelayForSeconds(0.3));
    	
    	// backup to auto zone
    	addSequential(new DriveForDistanceTimed(-10));
    	
    	// raise ~ 12 in
    	addSequential(new LiftMoveInches(12));
    	addSequential(new DelayForSeconds(0.5));
    	
    	// rotate 90 deg. counterclockwise
    	addSequential(new DriveTurnDegrees(-90));
    	
    	addParallel(new ArmsOpen());
    	addSequential(new DriveForDistanceTimed(-1));
    }
}
