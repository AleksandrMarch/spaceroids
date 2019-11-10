package spaceroids.client.ui.controllers.menu;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ConnectToServerController {
  @FXML
  private Button connectButton;
  @FXML
  private Button cancelButton;
  @FXML
  private TextField ipTextField;
  @FXML
  private TextField portTextField;

  @FXML
  private void connect() {

  }

  @FXML
  private void cancel() {
    portTextField.getScene().getWindow().hide();
  }
}
