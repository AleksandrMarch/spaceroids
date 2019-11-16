package spaceroids.server.networking;

import spaceroids.server.exceptions.ServerIsFullException;

import java.util.*;

public class ConnectionPool {
  public static ConnectionPool instance = new ConnectionPool();

  private static final int MAX_PLAYERS = 100;
  private Map<Integer, PlayerConnection> connectionMap = new HashMap<>();

  private ConnectionPool() {}

  public void addConnection(PlayerConnection connection) {
    connectionMap.put(connection.getId(), connection);
  }

  public void removeConnection(int id) {
    connectionMap.remove(id);
  }

  public PlayerConnection createNewConnection(String ip, int port) throws ServerIsFullException {
    return new PlayerConnection(getFreeId(), port, ip);
  }

  private int getFreeId() throws ServerIsFullException {
    for (int i = 0; i < MAX_PLAYERS; i++) {
      if (!connectionMap.containsKey(i)) return i;
    }
    throw new ServerIsFullException();
  }
}
