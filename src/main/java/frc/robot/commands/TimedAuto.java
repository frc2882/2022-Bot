// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;

public class TimedAuto extends CommandBase {

  private final Timer autoTimer = new Timer();
  
  private final Shooter m_shootSub;
  private final Collector m_collectSub;
  private final DriveTrain m_driveSub;

  /** Creates a new TimedAuto. */
  public TimedAuto(Shooter shootSub, Collector collectSub, DriveTrain driveSub) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shootSub = shootSub;
    m_collectSub = collectSub;
    m_driveSub = driveSub;
    addRequirements(shootSub, collectSub, driveSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    autoTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(autoTimer.get() > 1 && autoTimer.get() < 3.5) {
      new Shoot(m_shootSub, m_collectSub);
    }
    if(autoTimer.get() > 4 && autoTimer.get() < 6) {
      new AutoDrive(m_driveSub);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
