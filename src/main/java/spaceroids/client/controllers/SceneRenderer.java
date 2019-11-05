package spaceroids.client.controllers;

import javafx.scene.canvas.*;
import spaceroids.client.models.GameObject;

import java.util.List;

public class SceneRenderer {
  private Canvas canvas;

  public SceneRenderer(Canvas canvas) {
    this.canvas = canvas;
  }

  public void renderGameObjects(List<GameObject> gameObjects) {
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.clearRect(0, 0, 300, 300);
    for(GameObject gameObject : gameObjects) {
      gameObject.getRenderer().Render(gc, gameObject);
    }
  }
}
