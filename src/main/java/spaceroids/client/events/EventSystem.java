package spaceroids.client.events;

import spaceroids.client.ui.Launcher;

public class EventSystem {
  public static EventSystem instance = new EventSystem();

  private Launcher launcher;

  private EventSystem() {}

  public void connectedToServer() {
    launcher.startGame();
  }

  public void setLauncher(Launcher launcher) {
    this.launcher = launcher;
  }

  public static void playerConnected() {

  }
}
