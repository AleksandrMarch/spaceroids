package spaceroids.client.models;

import spaceroids.client.engine.renderers.Renderer;
import spaceroids.client.engine.transform.Transform;

public abstract class GameObject {
  private Transform transform;

  abstract public void update();
  abstract public Renderer getRenderer();

  public Transform getTransform() {
    return transform;
  }

  public void setTransform(Transform transform) {
    this.transform = transform;
  }
}
