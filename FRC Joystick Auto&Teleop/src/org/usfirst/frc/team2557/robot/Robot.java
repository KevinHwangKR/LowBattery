package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2557.robot.commands.MovementBackwardCommand;
import org.usfirst.frc.team2557.robot.commands.ExampleCommand;
import org.usfirst.frc.team2557.robot.commands.ServoCommand;
import org.usfirst.frc.team2557.robot.commands.MovementForwardCommand;
import org.usfirst.frc.team2557.robot.commands.DBSForwardCommand;
import org.usfirst.frc.team2557.robot.commands.DBSBackwardCommand;
import org.usfirst.frc.team2557.robot.subsystems.DoubleSolenoidSubsys;
import org.usfirst.frc.team2557.robot.subsystems.MovementSubsys;
import org.usfirst.frc.team2557.robot.subsystems.ServoSubsys;

public class Robot extends TimedRobot {
	public static ServoSubsys servoSubsys;
	public static MovementSubsys movementSubsys;
	public static DoubleSolenoidSubsys dbsSubsys;
	public static OI oi;
	Command autonomousCommand;
	Command ComA;
	Command MovementForwardCommand;
	Command MovementBackwardCommand;
	Command DBSForwardCommand;
	Command DBSBackwardCommand;	
	
	public static Timer timer;
	boolean stop = false;
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	
	public void robotInit() {
		RobotMap.init();
		
		servoSubsys = new ServoSubsys();
		movementSubsys = new MovementSubsys();
		dbsSubsys = new DoubleSolenoidSubsys();
		ComA = new ServoCommand();
		MovementBackwardCommand = new MovementBackwardCommand();
		MovementForwardCommand = new MovementForwardCommand();
		DBSForwardCommand = new DBSForwardCommand();
		DBSBackwardCommand = new DBSBackwardCommand();

		oi = new OI();
		oi.joyStickInit();
		m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
	}
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
