package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.MovementForwardCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MovementSubsys extends Subsystem {
	
	public MovementSubsys() {
		
	}

    public void initDefaultCommand() {
    	//setDefaultCommand(new MovementForwardCommand());
    }
    
    public void forward() {
    	RobotMap.robotDrive.arcadeDrive(0.5, 0);   	
    }
    
    public void backward() {
    	RobotMap.robotDrive.arcadeDrive(-0.5, 0);
    }
    
    public void left() {
    }
    
    public void stop() {
    	RobotMap.robotDrive.arcadeDrive(0, 0);
    }
    
    public void rawr() {
    	RobotMap.mecanum.driveCartesian(
    			OI.joystickA.getRawAxis(0)*0.4, 
    			OI.joystickA.getRawAxis(1)*0.4, 
    			OI.joystickA.getRawAxis(4)*0.4);
    }
}

