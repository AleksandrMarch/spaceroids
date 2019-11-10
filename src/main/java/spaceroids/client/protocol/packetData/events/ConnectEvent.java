package spaceroids.client.protocol.packetData.events;

public class ConnectEvent implements Event {
  private final int eventId = 0;

  public int getEventId() {
    return eventId;
  }
}
