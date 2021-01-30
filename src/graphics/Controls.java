package graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import command.CommandHandler;
import controller.FiniteStateMachine;

public class Controls extends JPanel implements ActionListener {
  private final JButton backwardButton;
  private final JButton forwardButton;
  private final JButton resetButton;
  private final  JButton anchorButton;
  private final JLabel currentStateLabel;
  private final Robot robot;

  public Controls(Robot robot) {
    this.robot = robot;
    JPanel buttonsPanel = new JPanel();
    backwardButton = new JButton("Backward");
    resetButton = new JButton("Reset");
    forwardButton = new JButton("Forward");
    anchorButton = new JButton("Anchor");

    backwardButton.addActionListener(this);
    resetButton.addActionListener(this);
    forwardButton.addActionListener(this);
    anchorButton.addActionListener(this);

    backwardButton.setFocusable(false);
    resetButton.setFocusable(false);
    forwardButton.setFocusable(false);
    anchorButton.setFocusable(false);

    buttonsPanel.add(backwardButton);
    buttonsPanel.add(resetButton);
    buttonsPanel.add(forwardButton);
    buttonsPanel.add(anchorButton);
    this.add(buttonsPanel, BorderLayout.CENTER);

    this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "backwardAction");
    this.getActionMap().put("backwardAction", new BackwardAction());
    this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "forwardAction");
    this.getActionMap().put("forwardAction", new ForwardAction());

    FiniteStateMachine.initStates();

    currentStateLabel = new JLabel();
    refreshStateLabel();
    this.add(currentStateLabel);
  }

  private void refreshStateLabel() {
    this.currentStateLabel.setText("Current State: " + FiniteStateMachine.currentState.getName());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JButton source = (JButton) e.getSource();
    if (source == backwardButton) {
      CommandHandler.handleBackwardAction();
    } else if (source == resetButton) {
      CommandHandler.handleResetAction();
    } else if (source == forwardButton) {
      CommandHandler.handleForwardAction();
    } else if (source == anchorButton) {
      CommandHandler.handleAnchorAction();
    }
    refreshStateLabel();
    robot.repaint();
  }

  private class ForwardAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
      CommandHandler.handleForwardAction();
      refreshStateLabel();
      robot.repaint();
    }
  }

  public class BackwardAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
      CommandHandler.handleBackwardAction();
      refreshStateLabel();
      robot.repaint();
    }
  }
}
