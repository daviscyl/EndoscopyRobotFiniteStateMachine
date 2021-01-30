package sensor;

import graphics.Robot;

import static graphics.Animation.robot;

public class ProximalBalloon {
  public static int getRadius() {
    return robot.getPBRadius();
  }

  public static boolean anchored() {
    return robot.getPBRadius() >= Robot.ExTubeRadius;
  }

  public static boolean deflated() {
    return robot.getPBRadius() <= Robot.MinTractionBalloonRadius;
  }
}
