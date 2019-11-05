package spaceroids.client.controllers;

import spaceroids.client.models.GameObject;

import java.util.*;

public class GameScene {
  private List<GameObject> gameObjects = new ArrayList<>();
  private SceneRenderer sceneRenderer;

  public GameScene(SceneRenderer sceneRenderer) {
    this.sceneRenderer = sceneRenderer;
  }

  public List<GameObject> getGameObjects() {
    return gameObjects;
  }

  public void addGameObject(GameObject gameObject) {
    gameObjects.add(gameObject);
  }

  public void updateScene() {
    sceneRenderer.renderGameObjects(gameObjects);
  }
}
