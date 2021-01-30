package graphics;

import java.awt.*;

import javax.swing.*;

public class Animation extends JFrame {
  public static final Robot robot = new Robot();

  public Animation() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Robotic Endoscopy Animation");

    this.add(robot, BorderLayout.NORTH);
    this.add(new Controls(robot), BorderLayout.SOUTH);
    this.pack();

    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
}
