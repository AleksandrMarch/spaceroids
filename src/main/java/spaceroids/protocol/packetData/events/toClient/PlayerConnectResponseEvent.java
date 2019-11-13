package spaceroids.protocol.packetData.events.toClient;

import spaceroids.protocol.packetData.events.Event;
import spaceroids.protocol.packetData.eventsData.EventData;

public class PlayerConnectResponseEvent implements EventData {
  private final int eventId = 0;

  public int getEventId() {
    return eventId;
  }
}
