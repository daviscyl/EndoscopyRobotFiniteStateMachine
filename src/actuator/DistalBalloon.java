package actuator;

import static graphics.Animation.robot;

public class DistalBalloon {
  private static final int increment = 5;

  public static void inflate() {
    robot.incrementDBRadius(increment);
  }

  public static void deflate() {
    robot.incrementDBRadius(-increment);
  }
}
