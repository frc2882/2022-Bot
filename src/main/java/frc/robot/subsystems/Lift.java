// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Lift extends SubsystemBase { 
  //private final DoubleSolenoid m_DoubleSolenoidLeft = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6,7);
  //private final DoubleSolenoid m_DoubleSolenoidRight = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 5,4);
  private final Solenoid m_solenoidL = new Solenoid(PneumaticsModuleType.CTREPCM, 6);
  private final Solenoid m_solenoidR = new Solenoid(PneumaticsModuleType.CTREPCM, 7);
  
  /** Creates a new Lift. */
  public Lift() {}

  public void liftUp() {
    m_solenoidL.set(true);
    m_solenoidR.set(true);
  }

  public void liftDown(){
    m_solenoidL.set(false);
    m_solenoidR.set(false);
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
