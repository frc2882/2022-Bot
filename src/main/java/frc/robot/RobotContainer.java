// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.XboxTrigger;

import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ManualDrive;
import frc.robot.commands.ManualShoot;
import frc.robot.commands.Shoot;
import frc.robot.commands.ShootLow;
// import frc.robot.commands.AutoDrive;
import frc.robot.commands.AutoShoot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.StartEndCommand;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@ link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final DriveTrain m_DriveTrain = new DriveTrain();
  private final Lift m_Lift = new Lift();
  private final Shooter m_Shooter = new Shooter();
  private final Collector m_Collector = new Collector();

  private final Shoot m_shoot = new Shoot(m_Shooter, m_Collector);
  private final ShootLow m_shootLow = new ShootLow(m_Shooter, m_Collector);  
  private final AutoShoot m_auto = new AutoShoot(m_DriveTrain, m_Shooter, m_Collector);
  // public final AutoDrive m_autoDrive = new AutoDrive(m_DriveTrain);

  public static final XboxController m_driverController = new XboxController(0);
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Sets default commands
    m_DriveTrain.setDefaultCommand(new ManualDrive(m_DriveTrain, m_driverController));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    XboxTrigger shooterTrigger = new XboxTrigger(m_driverController);
    shooterTrigger.whileActiveOnce(new ManualShoot(m_Shooter, m_driverController));

    JoystickButton collectButton = new JoystickButton(m_driverController, XboxController.Button.kLeftBumper.value);
    collectButton.whenHeld(new StartEndCommand(() -> m_Collector.collect(), () -> m_Collector.stop(), m_Collector));

    JoystickButton emptyButton = new JoystickButton(m_driverController, XboxController.Button.kY.value);
    emptyButton.whenHeld(new StartEndCommand(() -> m_Collector.empty(), () -> m_Collector.stop(), m_Collector));

    JoystickButton liftButton = new JoystickButton(m_driverController, XboxController.Button.kRightBumper.value);
    liftButton.whenHeld(new StartEndCommand(() -> m_Lift.liftUp(), () -> m_Lift.liftDown(), m_Lift));

    JoystickButton shootButton = new JoystickButton(m_driverController, XboxController.Button.kB.value); 
    shootButton.whenPressed(m_shoot);

    JoystickButton shootLowButton = new JoystickButton(m_driverController, XboxController.Button.kA.value);
    // shootLowButton.whenPressed(m_shootLow);
  }
//karl wheezer, my beloved
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An Autonomous will run in autonomous
    return m_auto;
  }
}