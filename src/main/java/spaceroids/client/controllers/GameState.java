package spaceroids.client.controllers;

import spaceroids.client.models.GameObject;

public class GameState extends Thread{
  private GameScene gameScene;

  public GameState(GameScene gameScene) {
    this.gameScene = gameScene;
  }

  @Override
  public void run() {
    while(true) {
      try {
//        Thread.sleep(16);
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      updateGameObjects();
    }
  }

  private void updateGameObjects() {
    for(GameObject gameObject: gameScene.getGameObjects()) {
      gameObject.update();
      gameScene.updateScene();
    }
  }
}
