package spaceroids.client.ui.controllers.menu;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import spaceroids.client.network.ConnectionManager;
import spaceroids.client.utils.Validators;
import spaceroids.server.Server;

public class CreateServerController {
  @FXML
  private Button createServerButton;
  @FXML
  private Button cancelButton;
  @FXML
  private TextField portTextField;

  @FXML
  private void createServer() {
    String portString = portTextField.getText();
    if (!Validators.validatePort(portString)) {
      return;
    }
    int port = Integer.parseInt(portString);
    Server.startServer(port);
    ConnectionManager.connectToServer("127.0.0.1", port);
  }

  @FXML
  private void cancel() {
    portTextField.getScene().getWindow().hide();
  }
}
