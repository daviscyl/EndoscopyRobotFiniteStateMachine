package actuator;

import static graphics.Animation.robot;

public class MotorBalloon {
  private static final int increment = 5;

  public static void expand() {
    robot.incrementMBLength(increment);
  }

  public static void contract() {
    robot.incrementMBLength(-increment);
  }
}
