package spaceroids.protocol;

import java.io.IOException;
import java.net.*;

public class UDPSender {
  public static void sendPacket(PacketToSend packet, Connection connection) {
    try{
      packet.prepare();
      byte[] data = packet.toJson().getBytes();
      InetAddress addr = InetAddress.getByName(connection.getIp());
      DatagramPacket pack = new DatagramPacket(data, data.length, addr, connection.getPort());
      DatagramSocket ds = new DatagramSocket(); //todo dont create a new socket every time
      ds.send(pack);
      ds.close();
      System.out.println("sent packet" + connection.getIp() + " " + connection.getPort());
    }catch(IOException e){
      System.err.println(e);
    }
  }
}
