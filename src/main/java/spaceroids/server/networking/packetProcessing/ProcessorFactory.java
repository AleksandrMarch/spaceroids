package spaceroids.server.networking.packetProcessing;

import spaceroids.protocol.EventFactory;
import spaceroids.protocol.exceptions.UnknownEventIdException;
import spaceroids.protocol.packetData.eventsData.EventData;
import spaceroids.protocol.PacketWrapper;
import spaceroids.server.networking.PlayerConnection;
import spaceroids.server.logging.Logger;
import spaceroids.protocol.BaseEvent;
import spaceroids.server.networking.packetProcessing.processors.*;

public class ProcessorFactory {
  public static void process(PacketWrapper packet) {
    for (BaseEvent baseEvent : packet.getEventList()) {
      try {
        processEvent(baseEvent, packet);
      } catch (UnknownEventIdException e) {
        Logger.log(e);
      }
    }
  }

  private static void processEvent(BaseEvent baseEvent, PacketWrapper packet)
      throws UnknownEventIdException {
    int eventId = baseEvent.getEventId();
    EventData eventData;

    try {
     eventData = EventFactory.getEventData(eventId);
    } catch (Exception e) {
      Logger.log(e);
      return;
    }

    switch (eventId) {
      case EventFactory.EVENT_CONNECT_TO_SERVER_REQUEST:
        PlayerConnectedProcessor.process(eventData, packet);
      case EventFactory.EVENT_PLAYER_DISCONNECTED:
        PlayerDisconnectedProcessor.process(eventData);
      case EventFactory.EVENT_PLAYER_INFO:
        PlayerInfoProcessor.process(eventData);
      default: throw new UnknownEventIdException("Event id is not supported by server");
    }
  }
}
