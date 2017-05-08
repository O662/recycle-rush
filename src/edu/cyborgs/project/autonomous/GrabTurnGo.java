package edu.cyborgs.project.autonomous;

import edu.cyborgs.projects.commands.ArmsClose;
import edu.cyborgs.projects.commands.ArmsOpen;
import edu.cyborgs.projects.commands.DelayForSeconds;
import edu.cyborgs.projects.commands.DriveForDistanceTimed;
import edu.cyborgs.projects.commands.DriveTurnDegrees;
import edu.cyborgs.projects.commands.LiftDoNothing;
import edu.cyborgs.projects.commands.LiftMoveInches;
import edu.cyborgs.projects.commands.ResetLiftEncoder;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GrabTurnGo extends CommandGroup {
    
    public GrabTurnGo() {
    	addSequential(new ResetLiftEncoder());
    	addSequential(new ArmsClose());
    	addSequential(new DelayForSeconds(0.3));
    	addSequential(new LiftMoveInches(4));
    	addSequential(new LiftDoNothing());
    	addSequential(new DriveForDistanceTimed(-1));
    	addSequential(new DelayForSeconds(1));
    	addSequential(new DriveTurnDegrees(180));
    	addSequential(new DriveForDistanceTimed(12));
    	addSequential(new DelayForSeconds(1));
    	addSequential(new DriveTurnDegrees(-90));
    	addSequential(new LiftMoveInches(-4));
    	addSequential(new LiftDoNothing());
    	addParallel(new ArmsOpen());
    	addSequential(new DriveForDistanceTimed(-1));
    }
}
