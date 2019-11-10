package spaceroids.client.network;

public class ConnectionManager {
  private static ConnectionManager INSTANCE;

  private ConnectionManager() {}

  public static ConnectionManager connectToServer(String ip, int port) {
    return new ConnectionManager();
  }
}
