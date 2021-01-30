package sensor;

import graphics.Robot;

import static graphics.Animation.robot;

public class MotorBalloon {
  public static int getLength() {
    return robot.getMBLength();
  }

  public static boolean fullyExtended() {
    return robot.getMBLength() >= Robot.MaxMBLength;
  }

  public static boolean fullyContracted() {
    return robot.getMBLength() <= Robot.MinMBLength;
  }
}
