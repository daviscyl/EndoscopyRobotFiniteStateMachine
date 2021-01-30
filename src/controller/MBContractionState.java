package controller;

public class MBContractionState extends AbstractState {
  @Override
  public String getName() {
    return "Motor Balloon Contraction";
  }

  @Override
  protected boolean toNextState() {
    return sensor.MotorBalloon.fullyContracted();
  }

  @Override
  protected boolean toPrevState() {
    return sensor.MotorBalloon.fullyExtended();
  }

  @Override
  protected void forwardAction() {
    actuator.MotorBalloon.contract();
  }

  @Override
  protected void backwardAction() {
    actuator.MotorBalloon.expand();
  }
}
