package spaceroids.client.models;

import spaceroids.client.controls.KeyboardControls;
import spaceroids.client.engine.renderers.*;
import spaceroids.client.engine.transform.Transform;


public class Player extends GameObject {
  private float speed = 10f;
  private float rotationSpeed = 10f;
  private Renderer renderer;
  private KeyboardControls controls;

  public Player() {
    controls = KeyboardControls.INSTANCE;
    renderer = new PolygonRenderer();
    setTransform(new Transform());

    getTransform().getPosition().addX(100);
    getTransform().getPosition().addY(100);
  }

  @Override
  public void update() {
    processControls();
  }

  @Override
  public Renderer getRenderer() {
    return renderer;
  }

  private void processControls() {
    float currentAngle = (float) getTransform().getRotation().getRotate().getAngle();
    float newAngle = currentAngle + rotationSpeed * controls.getXAxis();
    float move = speed * controls.getYAxis();
    float x = (float) Math.sin(newAngle) * move;
    float y = (float) Math.cos(newAngle) * move;
//    System.out.println(newAngle);
    System.out.println(x);
    getTransform().getPosition().addX(x);
    getTransform().getPosition().addY(y);
    getTransform().getRotation().setAngle(newAngle);
  }
}
