package spaceroids.client.engine.transform;

public class Transform {
  private Position position;
  private Rotation rotation;

  public Transform() {
    position = new Position();
    rotation = new Rotation();
  }

  public Position getPosition() {
    return position;
  }

  public Rotation getRotation() {
    return rotation;
  }
}
