package command;

import controller.FiniteStateMachine;

public class CommandHandler {
  public static void handleForwardAction() {
    FiniteStateMachine.currentState.handleForwardButton();
  }

  public static void handleBackwardAction() {
    FiniteStateMachine.currentState.handleBackwardButton();
  }

  public static void handleResetAction() {
    FiniteStateMachine.currentState.handleResetButton();
  }

  public static void handleAnchorAction() {
    FiniteStateMachine.currentState.handleAnchorButton();
  }
}
