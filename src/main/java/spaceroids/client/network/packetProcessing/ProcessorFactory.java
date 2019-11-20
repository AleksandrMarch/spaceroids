package spaceroids.client.network.packetProcessing;

import spaceroids.client.network.packetProcessing.processors.*;
import spaceroids.protocol.*;
import spaceroids.protocol.exceptions.UnknownEventIdException;
import spaceroids.protocol.packetData.eventsData.EventData;
import spaceroids.server.logging.Logger; //todo dont use server classes

public class ProcessorFactory {
  public static void process(PacketWrapper packet) {
    for (BaseEvent baseEvent : packet.getEventList()) {
      try {
        processEvent(baseEvent);
      } catch (UnknownEventIdException e) {
        Logger.log(e);
      }
    }
  }

  private static void processEvent(BaseEvent baseEvent) throws UnknownEventIdException {
    int eventId = baseEvent.getEventId();
    EventData eventData;

    try {
      eventData = EventFactory.getEventData(eventId);
    } catch (Exception e) {
      Logger.log(e);
      return;
    }

    switch (eventId) {
      case EventFactory.EVENT_CONNECT_TO_SERVER_RESPONSE:
        ConnectionResponseProcessor.process(eventData);
      case EventFactory.EVENT_PLAYER_CONNECTED:
        PlayerConnectedProcessor.process(eventData);
      default: throw new UnknownEventIdException("Event id is not supported by client");
    }
  }
}
