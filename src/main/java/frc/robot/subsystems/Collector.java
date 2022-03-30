// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class Collector extends SubsystemBase { 
  private final VictorSP collectMotor = new VictorSP(0);

  /** Creates a new Collector. */
  public Collector() {}

  public void collect() {
    collectMotor.set(1);
  }

  public void empty() {
    collectMotor.set(-1);
  }

  public void stop() {
    collectMotor.stopMotor();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
