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
    PacketToSend packetToSend = new PacketToSend();
    Connection connection = null;
    try {
      connection = ConnectionPool.instance.createNewConnection(
          packet.getPacket().getAddress().getHostAddress(),
          event.getPort());
    } catch (ServerIsFullException e) {
      e.printStackTrace(); // todo handle
    }
    ConnectionPool.instance.addConnection(connection);
    PlayerConnectResponseEvent responseEvent = new PlayerConnectResponseEvent();
    responseEvent.setServerId(connection.getConnectionId());
    packetToSend.getEventList().add(new BaseEvent(responseEvent, 1));;
    UDPSender.sendPacket(packetToSend, connection);
  }

  private static void processConnection() {
    //create connection
    //add new connection
    //
  }
}
