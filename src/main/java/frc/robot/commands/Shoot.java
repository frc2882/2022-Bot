// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class Shoot extends SequentialCommandGroup {
  public Shoot(Shooter m_shoot, Collector m_collect) {
    addCommands(
      new RunCommand(() -> m_shoot.fire(0,1)).withTimeout(2),
      new ParallelCommandGroup(
        new RunCommand(() -> m_collect.collect()),
        new RunCommand(() -> m_shoot.fire(1, 1))
      ).withTimeout(1),
      new ParallelCommandGroup(
        new InstantCommand(() -> m_collect.stop()),
        new InstantCommand(() -> m_shoot.stop())
      )
    );
  }
}