package spaceroids.protocol;

public class Connection {
  private String ip;
  private int port;
  private int connectionId;

  public Connection(String ip, int port) {
    this.ip = ip;
    this.port = port;
  }

  public Connection(String ip, int port, int connectionId) {
    this.ip = ip;
    this.port = port;
    this.connectionId = connectionId;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public int getConnectionId() {
    return connectionId;
  }

  public void setConnectionId(int connectionId) {
    this.connectionId = connectionId;
  }
}
