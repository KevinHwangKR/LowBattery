/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static WPI_TalonSRX FRdrive;
	public static WPI_TalonSRX FLdrive;
	public static WPI_TalonSRX BRdrive;
	public static WPI_TalonSRX BLdrive;
	public static DifferentialDrive robotDrive;
	public static MecanumDrive mecanum;
	public static SpeedControllerGroup left;
	public static SpeedControllerGroup right;
	
	public static DoubleSolenoid DBsol;
	public static Servo servo;
	public static void servoInit() {
		servo = new Servo(1);
	}
	
	public static void init() {
		FRdrive = new WPI_TalonSRX(3);
		FLdrive = new WPI_TalonSRX(1);
		BRdrive = new WPI_TalonSRX(4);
		BLdrive = new WPI_TalonSRX(2);
		
		left = new SpeedControllerGroup(FLdrive, BLdrive);
		right = new SpeedControllerGroup(FRdrive, BRdrive);
		robotDrive = new DifferentialDrive(left, right);
		mecanum = new MecanumDrive(FLdrive, BLdrive, FRdrive, BRdrive);
		
		robotDrive.setSafetyEnabled(false);
		DBsol = new DoubleSolenoid(1, 0, 1);
	}
}