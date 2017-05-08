package edu.cyborgs.projects.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.cyborgs.projects.OI;
import edu.cyborgs.projects.subsystems.LiftSystem;
import edu.cyborgs.projects.subsystems.ArmsSystem;
import edu.cyborgs.projects.subsystems.MechDriveSystem;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command
{
    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static MechDriveSystem mechDriveSystem = new MechDriveSystem();
    public static LiftSystem liftSystem = new LiftSystem();
    public static ArmsSystem armSystem = new ArmsSystem();
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        //
        SmartDashboard.putData(mechDriveSystem);
        SmartDashboard.putData(liftSystem);
        SmartDashboard.putData(armSystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
