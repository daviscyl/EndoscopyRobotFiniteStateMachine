package controller;

public class PBInflationState extends AbstractState {
  @Override
  public String getName() {
    return "Proximal Balloon Inflation";
  }

  @Override
  protected boolean toNextState() {
    return sensor.ProximalBalloon.anchored();
  }

  @Override
  protected boolean toPrevState() {
    return sensor.ProximalBalloon.deflated();
  }

  @Override
  protected void forwardAction() {
    actuator.ProximalBalloon.inflate();
  }

  @Override
  protected void backwardAction() {
    actuator.ProximalBalloon.deflate();
  }
}
