/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;

import org.usfirst.frc.team2557.robot.commands.DBSBackwardCommand;
import org.usfirst.frc.team2557.robot.commands.DBSForwardCommand;
import org.usfirst.frc.team2557.robot.commands.MovementBackwardCommand;
import org.usfirst.frc.team2557.robot.commands.ServoCommand;
import org.usfirst.frc.team2557.robot.commands.MovementForwardCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI {
	public static Joystick joystickA;
//	public static Joystick joystickB;
//	public static Joystick joystickC;
	public static JoystickButton Movementforward;
	public static JoystickButton Movementbackward;
	public static JoystickButton DBSforward;
	public static JoystickButton DBSbackward;
	
	public static void joyStickInit() {
		joystickA = new Joystick(0);
		Movementforward = new JoystickButton(joystickA, 4);
		Movementbackward = new JoystickButton(joystickA, 1);
		DBSforward = new JoystickButton(joystickA, 2);
		DBSbackward = new JoystickButton(joystickA, 3);
		
		Movementforward.whileHeld(new MovementForwardCommand());
		Movementbackward.whileHeld(new MovementBackwardCommand());
		DBSforward.whenPressed(new DBSForwardCommand());
		DBSbackward.whenPressed(new DBSBackwardCommand());
		
	}
}
