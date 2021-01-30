package graphics;

import java.awt.*;

import javax.swing.*;

public class Robot extends JPanel {
  public static final int ExTubeRadius = 120;
  public static final int MinTractionBalloonRadius = 50;
  public static final int MBRadius = 40;
  public static final int MaxMBLength = 300;
  public static final int MinMBLength = 200;
  public static final int VerticalCenter = ExTubeRadius + 100;
  public static final int ExTubeLength = 1600;

  private int leftDistance;
  private int PBRadius;
  private int DBRadius;
  private int MBLength;

  public Robot() {
    this.setPreferredSize(new Dimension(ExTubeLength, 2 * VerticalCenter));
    this.setOpaque(false);

    this.leftDistance = 100;
    this.setPBRadius(0);
    this.setDBRadius(0);
    this.setMBLength(0);

  }

  public int getPBRadius() {
    return PBRadius;
  }

  public void setPBRadius(int Radius) {
    this.PBRadius = Math.min(ExTubeRadius, Math.max(MinTractionBalloonRadius, Radius));
  }

  public void incrementPBRadius(int increment) {
    this.setPBRadius(getPBRadius() + increment);
  }

  public int getDBRadius() {
    return DBRadius;
  }

  public void setDBRadius(int Radius) {
    this.DBRadius = Math.min(ExTubeRadius, Math.max(MinTractionBalloonRadius, Radius));
  }

  public void incrementDBRadius(int increment) {
    this.setDBRadius(getDBRadius() + increment);
  }

  public int getMBLength() {
    return MBLength;
  }

  public void setMBLength(int length) {
    this.MBLength = Math.min(MaxMBLength, Math.max(MinMBLength, length));
  }

  private void setLeftDistance(int leftDistance) {
    this.leftDistance = Math.min(ExTubeLength - MaxMBLength, Math.max(0, leftDistance));
  }

  public void incrementMBLength(int increment) {
    this.setMBLength(getMBLength() + increment);

    if (!sensor.ProximalBalloon.anchored() && sensor.DistalBalloon.anchored()) {
      this.setLeftDistance(this.leftDistance - increment);
    }
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

    //paint tube wall
    g2d.setPaint(Color.black);
    g2d.setStroke(new BasicStroke(5));
    g2d.drawLine(0, VerticalCenter - ExTubeRadius, ExTubeLength, VerticalCenter - ExTubeRadius);
    g2d.drawLine(0, VerticalCenter + ExTubeRadius, ExTubeLength, VerticalCenter + ExTubeRadius);

    //paint proximal balloon
    g2d.setPaint(Color.blue);
    g2d.fillOval(
            leftDistance,
            VerticalCenter - PBRadius,
            MinMBLength / 2,
            (PBRadius - MBRadius) * 2
    );
    g2d.fillOval(
            leftDistance,
            VerticalCenter - PBRadius + 2 * MBRadius,
            MinMBLength / 2,
            (PBRadius - MBRadius) * 2
    );

    //paint distal balloon
    g2d.fillOval(
            leftDistance + MBLength - MinMBLength / 2,
            VerticalCenter - DBRadius,
            MinMBLength / 2,
            (DBRadius - MBRadius) * 2
    );
    g2d.fillOval(
            leftDistance + MBLength - MinMBLength / 2,
            VerticalCenter - DBRadius + 2 * MBRadius,
            MinMBLength / 2,
            (DBRadius - MBRadius) * 2
    );

    //paint motor balloon
    g2d.setPaint(Color.pink);
    g2d.drawRect(
            leftDistance,
            VerticalCenter - MBRadius,
            MBLength,
            MBRadius * 2
    );
    g2d.fillRect(
            leftDistance,
            VerticalCenter - MBRadius,
            MBLength,
            MBRadius * 2
    );
  }
}
