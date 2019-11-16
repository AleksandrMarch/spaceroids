package spaceroids.server.networking.packetProcessing.processors;

import spaceroids.protocol.*;
import spaceroids.protocol.packetData.events.toClient.PlayerConnectResponseEvent;
import spaceroids.protocol.packetData.events.toServer.PlayerConnectRequestEvent;
import spaceroids.protocol.packetData.eventsData.EventData;
import spaceroids.server.exceptions.ServerIsFullException;
import spaceroids.server.networking.*;

public class PlayerConnectedProcessor {
  public static void process (EventData eventData, PacketWrapper packet) {
    PlayerConnectRequestEvent event = (PlayerConnectRequestEvent) eventData;
    PacketToSend response = new PacketToSend();
    PlayerConnection connection = null;
    try {
      connection = ConnectionPool.instance.createNewConnection(
          packet.getPacket().getAddress().getHostAddress(),
          event.getPort());
    } catch (ServerIsFullException e) {
      e.printStackTrace(); // todo handle
    }
    ConnectionPool.instance.addConnection(connection);
    response.getEventList().add(new BaseEvent(new PlayerConnectResponseEvent(), 1));
    PacketSender.send(response, connection);
  }

  private static void processConnection() {
    //create connection
    //add new connection
    //
  }
}
