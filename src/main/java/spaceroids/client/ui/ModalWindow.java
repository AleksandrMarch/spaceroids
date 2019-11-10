package spaceroids.client.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

import java.net.URL;

public class ModalWindow {
  public ModalWindow(String fxmlPath) {
    Stage createServerStage = new Stage();
    createServerStage.initModality(Modality.APPLICATION_MODAL);
    Parent root;
    URL url = getClass().getClassLoader().getResource(fxmlPath);
    if (url == null) {
      showErrorModal(String.format("%s not found", fxmlPath));
      return;
    }
    try {
      root = FXMLLoader.load(url);
    } catch (Exception e) {
      showErrorModal(e.getMessage());
      e.printStackTrace();
      return;
    }
    Scene scene = new Scene(root);
    createServerStage.setScene(scene);
    createServerStage.show();
  }

  public static void showErrorModal(String msg) {

  }
}
