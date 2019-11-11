package spaceroids.protocol;

import spaceroids.protocol.exceptions.UnknownEventIdException;
import spaceroids.protocol.packetData.events.Event;
import spaceroids.protocol.packetData.eventsData.*;

public class EventFactory {
  public static final int EVENT_CONNECT_TO_SERVER = 0;
  public static final int EVENT_PLAYER_CONNECTED = 1;
  public static final int EVENT_PLAYER_DISCONNECTED = 2;
  public static final int EVENT_PLAYER_INFO = 3;
  public static final int EVENT_GAME_OBJECT_SPAWN = 4;

  public static EventData getEventData(int eventId) throws UnknownEventIdException {
    switch (eventId) {
      case EVENT_CONNECT_TO_SERVER:
        return new PlayerConnected();
      default: throw new UnknownEventIdException("Event id is not supported by EventFactory");
    }
  }
}
