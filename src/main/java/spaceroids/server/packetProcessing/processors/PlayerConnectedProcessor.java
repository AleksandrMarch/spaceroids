package spaceroids.server.packetProcessing.processors;

import spaceroids.protocol.PacketToSend;
import spaceroids.protocol.packetData.events.toClient.PlayerConnectedEvent;
import spaceroids.protocol.packetData.eventsData.EventData;
import spaceroids.server.*;

public class PlayerConnectedProcessor {
  public static void process (EventData eventData, PlayerConnection connection) {
    PacketToSend packet = new PacketToSend();
    packet.getEventList().add(new PlayerConnectedEvent());
    PacketSender.send(packet, connection);
  }
}
