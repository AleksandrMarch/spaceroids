package spaceroids.client.engine.transform;

import javafx.scene.transform.Rotate;

public class Rotation {
  private Rotate rotate = new Rotate();

  public Rotate getRotate() {
    return rotate;
  }

  public void setRotate(Rotate rotate) {
    this.rotate = rotate;
  }

  public float getAngle() {
    return (float) rotate.getAngle();
  }

  public void setAngle(float angle) {
    int multiply = Math.abs((int) angle / 360);
    if (angle >= 360) {
      angle -= 360 * multiply;
    }
    if (angle <= -360) {
      angle += 360 * multiply;
    }
    rotate.setAngle(angle);
  }
}
