package spaceroids.protocol.packetData.events.toClient;

import spaceroids.protocol.packetData.eventsData.EventData;

public class PlayerConnectResponseEvent implements EventData {
  private int serverId;

  public int getServerId() {
    return serverId;
  }

  public void setServerId(int serverId) {
    this.serverId = serverId;
  }
}
