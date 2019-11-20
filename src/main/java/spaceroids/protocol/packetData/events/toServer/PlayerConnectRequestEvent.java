package spaceroids.protocol.packetData.events.toServer;

import spaceroids.client.network.ServerListener;
import spaceroids.protocol.packetData.eventsData.EventData;

public class PlayerConnectRequestEvent implements EventData {
  private int port = ServerListener.getLocalPort();

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
