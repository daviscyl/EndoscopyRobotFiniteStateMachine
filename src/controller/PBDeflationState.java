package controller;

public class PBDeflationState extends AbstractState {
  @Override
  public String getName() {
    return "Proximal Balloon Deflation";
  }

  @Override
  protected boolean toNextState() {
    return sensor.ProximalBalloon.deflated();
  }

  @Override
  protected boolean toPrevState() {
    return sensor.ProximalBalloon.anchored();
  }

  @Override
  protected void forwardAction() {
    actuator.ProximalBalloon.deflate();
  }

  @Override
  protected void backwardAction() {
    actuator.ProximalBalloon.inflate();
  }
}
