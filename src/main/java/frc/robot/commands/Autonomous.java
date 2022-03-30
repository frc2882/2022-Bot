// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Timer;

public class Autonomous extends SequentialCommandGroup {
  private Timer autoTimer = new Timer();

  public Autonomous(DriveTrain m_drive, Shooter m_shooter, Collector m_collect) {
    autoTimer.start();
    addCommands(
      new RunCommand(() -> m_shooter.fire(0,1)).withTimeout(2),
      new ParallelCommandGroup(
        new RunCommand(() -> m_shooter.fire(1, 1)),
        new RunCommand(() -> m_collect.collect())
      ).withTimeout(1),
      new ParallelCommandGroup(
        new InstantCommand(() -> m_shooter.stop()),
        new InstantCommand(() -> m_collect.stop())
      ),
      new WaitCommand(0.5),
      new AutoDrive(m_drive).withTimeout(3)
    );
  }
}