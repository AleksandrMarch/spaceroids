package spaceroids.protocol.packetData.events.toClient;

import spaceroids.protocol.packetData.events.Event;

public class PlayerConnectedEvent implements Event {
  private final int eventId = 0;

  public int getEventId() {
    return eventId;
  }
}
