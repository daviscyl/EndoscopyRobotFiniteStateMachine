package controller;

import actuator.DistalBalloon;

public class DBInflationState extends AbstractState {
  @Override
  public String getName() {
    return "Distal Balloon Inflation";
  }

  @Override
  protected boolean toNextState() {
    return sensor.DistalBalloon.anchored();
  }

  @Override
  protected boolean toPrevState() {
    return sensor.DistalBalloon.deflated();
  }

  @Override
  protected void forwardAction() {
    DistalBalloon.inflate();
  }

  @Override
  protected void backwardAction() {
    DistalBalloon.deflate();
  }
}
