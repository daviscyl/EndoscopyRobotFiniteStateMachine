package controller;


public class MBExpansionState extends AbstractState {
  @Override
  public String getName() {
    return "Motor Balloon Expansion";
  }

  @Override
  protected boolean toNextState() {
    return sensor.MotorBalloon.fullyExtended();
  }

  @Override
  protected boolean toPrevState() {
    return sensor.MotorBalloon.fullyContracted();
  }

  @Override
  protected void forwardAction() {
    actuator.MotorBalloon.expand();
  }

  @Override
  protected void backwardAction() {
    actuator.MotorBalloon.contract();
  }
}
