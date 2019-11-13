package spaceroids.server.packetProcessing.processors;

import spaceroids.protocol.*;
import spaceroids.protocol.packetData.events.toClient.PlayerConnectResponseEvent;
import spaceroids.protocol.packetData.events.toServer.PlayerConnectRequestEvent;
import spaceroids.protocol.packetData.eventsData.EventData;
import spaceroids.server.*;

public class PlayerConnectedProcessor {
  public static void process (EventData eventData, PlayerConnection connection) {
    PlayerConnectRequestEvent event = (PlayerConnectRequestEvent) eventData;
    PacketToSend packet = new PacketToSend();
    connection.setPort(event.getPort());
    packet.getEventList().add(new BaseEvent(new PlayerConnectResponseEvent(), 1));
    PacketSender.send(packet, connection);
  }
}
