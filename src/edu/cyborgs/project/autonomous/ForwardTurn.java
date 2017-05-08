package edu.cyborgs.project.autonomous;

import edu.cyborgs.projects.commands.DelayForSeconds;
import edu.cyborgs.projects.commands.DriveForDistanceTimed;
import edu.cyborgs.projects.commands.DriveTurnDegrees;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ForwardTurn extends CommandGroup {
    
    public ForwardTurn() {
    	addSequential(new DriveForDistanceTimed(9));
    	addSequential(new DelayForSeconds(1));
    	addSequential(new DriveTurnDegrees(90));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
