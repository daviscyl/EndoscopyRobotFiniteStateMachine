package controller;

import actuator.DistalBalloon;

public class InitialState extends AbstractState {

  @Override
  public String getName() {
    return "Initial State";
  }

  @Override
  protected boolean toNextState() {
    return sensor.ProximalBalloon.anchored();
  }

  @Override
  protected boolean toPrevState() {
    return sensor.DistalBalloon.anchored();
  }

  @Override
  public void forwardAction() {
    if (sensor.DistalBalloon.deflated()) {
      actuator.ProximalBalloon.inflate();
    } else {
      DistalBalloon.deflate();
    }
  }

  @Override
  public void backwardAction() {
    if (sensor.ProximalBalloon.deflated()) {
      DistalBalloon.inflate();
    } else {
      actuator.ProximalBalloon.deflate();
    }
  }
}
