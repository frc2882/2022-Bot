package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class XboxTrigger extends Trigger {

  private final XboxController m_controller;

  public XboxTrigger(XboxController controller) {
    m_controller = controller;
  }

  @Override
  public boolean get() {
    return m_controller.getLeftTriggerAxis() > 0.1 || m_controller.getRightTriggerAxis() > 0.1;
  }

}