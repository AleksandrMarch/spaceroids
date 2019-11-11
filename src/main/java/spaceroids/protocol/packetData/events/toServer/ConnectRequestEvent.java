package spaceroids.protocol.packetData.events.toServer;

import spaceroids.protocol.packetData.events.Event;

public class ConnectRequestEvent implements Event {
  private final int eventId = 0;

  public int getEventId() {
    return eventId;
  }
}
