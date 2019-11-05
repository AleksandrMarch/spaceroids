package spaceroids.client.controls;

import javafx.scene.Node;

public class KeyboardControls {
  public static KeyboardControls INSTANCE = new KeyboardControls();

  private Node targetNode;
  private int x;
  private int y;

  private final String FORWARD_KEY = "W";
  private final String BACK_KEY = "S";
  private final String RIGHT_KEY = "D";
  private final String LEFT_KEY = "A";

  private KeyboardControls() { }

  public void setTargetNode(Node targetNode) {
    this.targetNode = targetNode;
    setEvents();
  }

  public int getXAxis() {
    return x;
  }

  public int getYAxis() {
    return y;
  }

  private void setEvents() {
    targetNode.setOnKeyPressed(event -> {
      String keyString = event.getCode().getName();
      switch (keyString) {
        case FORWARD_KEY:
          y = 1;
          break;
        case BACK_KEY:
          y = -1;
          break;
        case RIGHT_KEY:
          x = 1;
          break;
        case LEFT_KEY:
          x = -1;
          break;
      }
    });
    targetNode.setOnKeyReleased(event -> {
      String keyString = event.getCode().getName();
      switch (keyString) {
        case FORWARD_KEY:
          y = 0;
          break;
        case BACK_KEY:
          y = -0;
          break;
        case RIGHT_KEY:
          x = 0;
          break;
        case LEFT_KEY:
          x = -0;
          break;
      }
    });
  }
}
