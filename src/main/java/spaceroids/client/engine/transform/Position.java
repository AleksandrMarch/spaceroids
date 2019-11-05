package spaceroids.client.engine.transform;

public class Position {
  private float x;
  private float y;

  public void addX(float x) {
    this.x += x;
  }

  public void addY(float y) {
    this.y += y;
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }
}
