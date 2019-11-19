package spaceroids.protocol.packetData.events.toServer;

import spaceroids.protocol.packetData.eventsData.EventData;

public class PlayerConnectRequestEvent implements EventData {
  private int port = 44321;

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
