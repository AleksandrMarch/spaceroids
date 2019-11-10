package spaceroids.client.ui.controllers.menu;

import javafx.fxml.*;
import javafx.scene.control.Button;
import spaceroids.client.ui.*;

public class MainMenuController {
  @FXML
  private Button createServerButton;
  @FXML
  private Button connectButton;

  @FXML
  private void createServer() {
   new ModalWindow(FxmlEnum.CREATE_SERVER.getPath());
  }

  @FXML void connect() {
    new ModalWindow(FxmlEnum.CONNECT_TO_SERVER.getPath());
  }
}
