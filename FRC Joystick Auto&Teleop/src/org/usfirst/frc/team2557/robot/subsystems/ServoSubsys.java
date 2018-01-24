package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ServoSubsys extends Subsystem {
	static OI oi;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void servoOne() {
    		RobotMap.servo.set(30);
    }
    public void stop() {
    	RobotMap.servo.set(0);
    }
}

