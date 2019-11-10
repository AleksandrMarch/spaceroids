package spaceroids.client.ui;

public enum FxmlEnum {
  MAIN_MENU("fxml/menu.fxml"),
  CREATE_SERVER("fxml/createServerWindow.fxml"),
  CONNECT_TO_SERVER("fxml/connectWindow.fxml");

  private String path;

  FxmlEnum(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }
}
