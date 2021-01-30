package controller;

import graphics.Robot;

public class AnchorState extends AbstractState {
  @Override
  public String getName() {
    return "Anchoring State";
  }

  private boolean forwardExpandMB() {
    return sensor.MotorBalloon.getLength() < (Robot.MaxMBLength + Robot.MinMBLength) / 2;
  }

  @Override
  protected boolean toNextState() {
    if (forwardExpandMB() && sensor.ProximalBalloon.anchored() && sensor.DistalBalloon.deflated()) {
      this.setNextState(FiniteStateMachine.mBExpansionState);
      return true;
    }

    if (!forwardExpandMB() && sensor.ProximalBalloon.deflated() && sensor.DistalBalloon.anchored()) {
      this.setNextState(FiniteStateMachine.mBContractionsState);
      return true;
    }

    return false;
  }

  @Override
  protected boolean toPrevState() {
    if (forwardExpandMB() && sensor.ProximalBalloon.deflated() && sensor.DistalBalloon.anchored()) {
      this.setPrevState(FiniteStateMachine.mBContractionsState);
      return true;
    }

    if (!forwardExpandMB() && sensor.ProximalBalloon.anchored() && sensor.DistalBalloon.deflated()) {
      this.setPrevState(FiniteStateMachine.mBExpansionState);
      return true;
    }

    return false;
  }

  @Override
  protected void forwardAction() {
    if (forwardExpandMB()) {
      actuator.ProximalBalloon.inflate();
      actuator.DistalBalloon.deflate();
    } else {
      actuator.ProximalBalloon.deflate();
      actuator.DistalBalloon.inflate();
    }
  }

  @Override
  protected void backwardAction() {
    if (forwardExpandMB()) {
      actuator.ProximalBalloon.deflate();
      actuator.DistalBalloon.inflate();
    } else {
      actuator.ProximalBalloon.inflate();
      actuator.DistalBalloon.deflate();
    }
  }

}
