package spaceroids.server.game;

import java.util.*;

public class Scene {
  private static Scene scene = new Scene();
  private static List<GameObject> gameObjectList = new ArrayList<>();

  private Scene() {}

  public void addGameObject(GameObject gameObject) {
    gameObjectList.add(gameObject);
  }
}
