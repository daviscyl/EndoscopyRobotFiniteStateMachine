package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import graphics.Animation;

public abstract class AbstractState implements ActionListener {
  private AbstractState prevState;
  private AbstractState nextState;
  private Timer resetTimer;
  private Timer anchorTimer;

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == resetTimer) {
      this.resetAction();
    } else if (e.getSource() == anchorTimer) {
      this.anchorAction();
    }
  }

  protected void setPrevState(AbstractState prevState) {
    this.prevState = prevState;
  }

  protected void setNextState(AbstractState nextState) {
    this.nextState = nextState;
  }

  public void handleForwardButton() {
    this.forwardAction();
    if (toNextState()) {
      FiniteStateMachine.currentState = nextState;
    }
  }

  public void handleBackwardButton() {
    this.backwardAction();
    if (toPrevState()) {
      FiniteStateMachine.currentState = prevState;
    }
  }

  public void handleResetButton() {
    resetTimer = new Timer(20, this);
    resetTimer.start();
    FiniteStateMachine.currentState = FiniteStateMachine.initialState;
  }

  public void handleAnchorButton() {
    anchorTimer = new Timer(20, this);
    anchorTimer.start();
    FiniteStateMachine.currentState = FiniteStateMachine.anchorsState;
  }

  protected void resetAction() {
    if (!sensor.ProximalBalloon.deflated() || !sensor.MotorBalloon.fullyContracted() || !sensor.DistalBalloon.deflated()) {
      actuator.ProximalBalloon.deflate();
      actuator.MotorBalloon.contract();
      actuator.DistalBalloon.deflate();
      Animation.robot.repaint();
    } else {
      resetTimer.stop();
    }
  }

  protected void anchorAction() {
    if (!sensor.ProximalBalloon.anchored() || !sensor.DistalBalloon.anchored()) {
      actuator.ProximalBalloon.inflate();
      actuator.DistalBalloon.inflate();
      Animation.robot.repaint();
    } else {
      anchorTimer.stop();
    }
  }

  public abstract String getName();

  protected abstract boolean toNextState();

  protected abstract boolean toPrevState();

  protected abstract void forwardAction();

  protected abstract void backwardAction();
}
