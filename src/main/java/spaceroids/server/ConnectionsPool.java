package spaceroids.server;

import java.util.*;

public class ConnectionsPool {
  private static final int MAX_PLAYERS = 100;

  private Map<Integer, PlayerConnection> connectionMap = new HashMap<>();

  public void addConnection(PlayerConnection connection) {
    connectionMap.put(connection.getId(), connection);
  }

  public void removeConnection(int id) {
    connectionMap.remove(id);
  }

  public int getFreeId() {
    for (int i = 0; i < MAX_PLAYERS; i++) {
      if (!connectionMap.keySet().contains(i)) return i;
    }
    return 0; //todo exception
  }
}
