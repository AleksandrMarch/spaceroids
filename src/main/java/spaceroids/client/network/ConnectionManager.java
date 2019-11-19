package spaceroids.client.network;

import spaceroids.protocol.*;
import spaceroids.protocol.packetData.events.*;
import spaceroids.protocol.packetData.events.toServer.PlayerConnectRequestEvent;

import java.io.IOException;
import java.net.*;

public class ConnectionManager {
  private static ConnectionManager INSTANCE = new ConnectionManager();

  private Connection connection;

  private ConnectionManager() {}

  public static void connectToServer(String ip, int port) {
    PacketToSend packet = new PacketToSend();
    Event event = new BaseEvent(new PlayerConnectRequestEvent(), 0);
    packet.getEventList().add(event);

    INSTANCE.setConnection(new Connection(ip, port));
    UDPSender.sendPacket(packet, INSTANCE.getConnection());
  }

  public Connection getConnection() {
    return connection;
  }

  public void setConnection(Connection connection) {
    this.connection = connection;
  }
}
