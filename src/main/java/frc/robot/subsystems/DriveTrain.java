// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
// import edu.wpi.first.wpilibj.motorcontrol.WPI_VictorSPX;

public class DriveTrain extends SubsystemBase {
  private final WPI_VictorSPX m_leftMotor = new WPI_VictorSPX(3);
  private final WPI_VictorSPX m_leftFollower = new WPI_VictorSPX(4);
  // private final MotorControllerGroup m_leftGroup = new MotorControllerGroup(m_leftBackMotor, m_leftFrontMotor);
//assigns right speed controllers to a group
  private final WPI_VictorSPX m_rightMotor = new WPI_VictorSPX(1);
  private final WPI_VictorSPX m_rightFollower = new WPI_VictorSPX(2);
  // private final MotorControllerGroup m_rightGroup = new MotorControllerGroup(m_rightBackMotor, m_rightFrontMotor);
//instantiates DifferentialDrive with the left and right controller groups
  public final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
//instantiates the Xbox controller on port 0
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    // m_rightGroup.setInverted(true);
    m_leftFollower.follow(m_leftMotor);
    m_rightFollower.follow(m_rightMotor);

    m_rightMotor.setInverted(true);
    m_rightFollower.setInverted(InvertType.FollowMaster);
  }
  
    // BIG HELPFUL LINK FOR THIS THING: https://github.com/Team2470/FRC-2020-robot/tree/develop/src/main/java/frc/robot
  public void driveArcade(double speed, double rotation) {
    m_robotDrive.arcadeDrive(speed, rotation);
  }

  public void driveCurvature(double speed, double rotation, boolean turn) {
    m_robotDrive.curvatureDrive(speed, rotation, turn);
  }

  public void stop() {
    m_robotDrive.stopMotor();
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
