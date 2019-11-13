package spaceroids.protocol;

import spaceroids.protocol.exceptions.UnknownEventIdException;
import spaceroids.protocol.packetData.events.Event;
import spaceroids.protocol.packetData.events.toClient.PlayerConnectResponseEvent;
import spaceroids.protocol.packetData.events.toServer.PlayerConnectRequestEvent;
import spaceroids.protocol.packetData.eventsData.*;

public class EventFactory {
  public static final int EVENT_CONNECT_TO_SERVER_REQUEST = 0;
  public static final int EVENT_CONNECT_TO_SERVER_RESPONSE = 1;
  public static final int EVENT_PLAYER_CONNECTED = 2;
  public static final int EVENT_PLAYER_DISCONNECTED = 3;
  public static final int EVENT_PLAYER_INFO = 4;
  public static final int EVENT_GAME_OBJECT_SPAWN = 5;

  public static EventData getEventData(int eventId) throws UnknownEventIdException {
    switch (eventId) {
      case EVENT_CONNECT_TO_SERVER_REQUEST:
        return new PlayerConnectRequestEvent();
      case EVENT_CONNECT_TO_SERVER_RESPONSE:
        return new PlayerConnectResponseEvent();
      default: throw new UnknownEventIdException("Event id is not supported by EventFactory");
    }
  }
}
