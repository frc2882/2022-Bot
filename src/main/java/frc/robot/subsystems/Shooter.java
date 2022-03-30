// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import edu.wpi.first.wpilibj.motorcontrol.CANSparkMax;

public class Shooter extends SubsystemBase {
  private final CANSparkMax m_frontMotor = new CANSparkMax(5, MotorType.kBrushless);
  private final CANSparkMax m_backMotor = new CANSparkMax(6, MotorType.kBrushless);

  /** Creates a new Shooter. */
  public Shooter() {
    m_frontMotor.setInverted(true);
    m_backMotor.setInverted(true);
  }

  public void fire(double frontspeed, double backSpeed) {
    m_frontMotor.set(frontspeed);
    m_backMotor.set(backSpeed);
  }

  public void stop() {
    m_frontMotor.stopMotor();
    m_backMotor.stopMotor();
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
