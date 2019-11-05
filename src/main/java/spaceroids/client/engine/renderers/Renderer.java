package spaceroids.client.engine.renderers;

import javafx.scene.canvas.GraphicsContext;
import spaceroids.client.models.GameObject;

public interface Renderer {
  public void Render(GraphicsContext gc, GameObject gameObject);
}
