package actuator;

import static graphics.Animation.robot;

public class ProximalBalloon {
  private static final int increment = 5;

  public static void inflate() {
    robot.incrementPBRadius(increment);
  }

  public static void deflate() {
    robot.incrementPBRadius(-increment);
  }
}
