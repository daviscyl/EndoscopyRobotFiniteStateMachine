package controller;

import actuator.DistalBalloon;

public class DBDeflationState extends AbstractState {
  @Override
  public String getName() {
    return "Distal Balloon Deflation";
  }

  @Override
  protected boolean toNextState() {
    return sensor.DistalBalloon.deflated();
  }

  @Override
  protected boolean toPrevState() {
    return sensor.DistalBalloon.anchored();
  }

  @Override
  protected void forwardAction() {
    DistalBalloon.deflate();
  }

  @Override
  protected void backwardAction() {
    DistalBalloon.inflate();
  }
}
