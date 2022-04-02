// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;

/** An example command that uses an example subsystem. */
public class ManualDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain m_subsystem;
  private final XboxController m_controller;

  /**
   * Creates a new ManualDrive.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ManualDrive(DriveTrain subsystem, XboxController controller) {
    m_subsystem = subsystem;
    m_controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.m_robotDrive.arcadeDrive(m_controller.getLeftY()*-1, m_controller.getRightX()*.9);
    // m_subsystem.driveArcade(m_controller.getLeftY()*-1, m_controller.getRightX());
    // m_subsystem.driveCurvature(m_controller.getLeftY()*-1, m_controller.getRightX(), m_controller.getLeftStickButton());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
