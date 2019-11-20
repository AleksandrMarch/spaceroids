package spaceroids.client.ui;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.stage.Stage;
import spaceroids.client.controllers.*;
import spaceroids.client.controls.KeyboardControls;
import spaceroids.client.events.EventSystem;
import spaceroids.client.models.*;

public class Launcher extends Application {
  private Stage primaryStage;
  private Canvas canvas;
  private Group group;

  public static void launchGame() {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    this.primaryStage = primaryStage;
    EventSystem.instance.setLauncher(this); //todo remove instance word
    openMenu(primaryStage);
  }

  public void startGame() {
    createGameScene(primaryStage);
    initGame();
  }

  private void openMenu(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/menu.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void initGame() {
    KeyboardControls.INSTANCE.setTargetNode(group);
    SceneRenderer sceneRenderer = new SceneRenderer(canvas);
    GameScene gameScene = new GameScene(sceneRenderer);
    Player player = new Player();
    gameScene.addGameObject(player);
    GameThread gameState = new GameThread(gameScene);
    gameState.start();
    Platform.runLater(() -> group.requestFocus());
  }

  private void createGameScene(Stage primaryStage) {
    group = new Group();
    canvas = new Canvas(300, 300);
    group.getChildren().add(canvas);
    primaryStage.getScene().setRoot(group);
  }
}
