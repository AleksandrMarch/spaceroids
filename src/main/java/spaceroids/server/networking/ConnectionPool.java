package spaceroids.server.networking;

import spaceroids.protocol.Connection;
import spaceroids.server.exceptions.ServerIsFullException;

import java.util.*;

public class ConnectionPool {
  public static ConnectionPool instance = new ConnectionPool();

  private static final int MAX_PLAYERS = 100;
  private Map<Integer, Connection> connectionMap = new HashMap<>();

  private ConnectionPool() {}

  public void addConnection(Connection connection) {
    connectionMap.put(connection.getConnectionId(), connection);
  }

  public void removeConnection(int id) {
    connectionMap.remove(id);
  }

  public Connection createNewConnection(String ip, int port) throws ServerIsFullException {
    return new Connection(ip, port, getFreeId());
  }

  private int getFreeId() throws ServerIsFullException {
    for (int i = 0; i < MAX_PLAYERS; i++) {
      if (!connectionMap.containsKey(i)) return i;
    }
    throw new ServerIsFullException();
  }
}
