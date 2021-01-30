package sensor;

import graphics.Robot;

import static graphics.Animation.robot;

public class DistalBalloon {
  public static int getRadius() {
    return robot.getDBRadius();
  }

  public static boolean anchored() {
    return robot.getDBRadius() >= Robot.ExTubeRadius;
  }

  public static boolean deflated() {
    return robot.getDBRadius() <= Robot.MinTractionBalloonRadius;
  }
}
