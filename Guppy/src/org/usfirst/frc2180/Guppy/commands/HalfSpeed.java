package org.usfirst.frc2180.Guppy.commands;

import org.usfirst.frc2180.Guppy.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class HalfSpeed extends Command {
	
	public HalfSpeed() {
		
	}
	
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		RobotMap.shooterCANTalon.set(0.5);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
