package spaceroids.server;

import spaceroids.protocol.PacketToSend;

import java.io.IOException;
import java.net.*;

public class PacketSender {
  public static void send(PacketToSend packet, PlayerConnection connection) {
    try{
      byte[] data = packet.toJson().getBytes();
      InetAddress addr = InetAddress.getByName(connection.getIp());
      DatagramPacket pack = new DatagramPacket(data, data.length, addr, connection.getPort());
      DatagramSocket ds = new DatagramSocket(); //todo dont create a new socket every time
      ds.send(pack);
      ds.close();
      System.out.println("sent connect packet from server " + connection.getIp() + " " + connection.getPort());
    }catch(IOException e){
      System.err.println(e);
    }
  }
}
