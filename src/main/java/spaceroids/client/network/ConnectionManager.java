package spaceroids.client.network;

import spaceroids.protocol.PacketToClient;
import spaceroids.protocol.packetData.events.*;
import spaceroids.protocol.packetData.events.toServer.ConnectRequestEvent;

import java.io.IOException;
import java.net.*;

public class ConnectionManager {
  private static ConnectionManager INSTANCE = new ConnectionManager();

  private String ip;
  private int port;

  private ConnectionManager() {}

  public static void connectToServer(String ip, int port) {
    PacketToClient packetToClient = new PacketToClient();
    Event event = new ConnectRequestEvent();
    packetToClient.getEventList().add(event);

    INSTANCE.setIp(ip);
    INSTANCE.setPort(port);
    INSTANCE.sendToServer(packetToClient.toJson());
  }

  private void sendToServer(String dataStr) {
    try{
      byte[] data = dataStr.getBytes();
      InetAddress addr = InetAddress.getByName(ip);
      DatagramPacket pack = new DatagramPacket(data, data.length, addr, port);
      DatagramSocket ds = new DatagramSocket();
      ds.send(pack);
      ds.close();
    }catch(IOException e){
      System.err.println(e);

    }
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
