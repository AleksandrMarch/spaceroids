package spaceroids.client.network;

import spaceroids.client.network.packetProcessing.ProcessorFactory;
import spaceroids.protocol.PacketWrapper;
import spaceroids.protocol.utils.SocketUtils;
import spaceroids.server.logging.Logger;

import java.io.IOException;
import java.net.*;

public class ServerListener {
  private static ServerListener instance;
  private static Server server;

  private ServerListener() {
    server = new Server();
    server.start();
  }

  public static void startServerListener() {
    instance = new ServerListener();
  }

  public static ServerListener getInstance() {
    return instance;
  }

  public static int getLocalPort() {
    return ServerListener.getInstance().getServer().getSocket().getLocalPort();
  }

  public Server getServer() {
    return server;
  }

  private static class Server extends Thread {
    private DatagramSocket ds;

    private Server() {
      try {
        ds = new DatagramSocket(SocketUtils.getFreePort());
      } catch (SocketException e) {
        Logger.log(e);
      }
    }

    @Override
    public void run() {
      System.out.println("started server listener on port " + ds.getLocalPort());
      while (true) {
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        try {
          ds.receive(packet);
          ProcessorFactory.process(PacketWrapper.wrap(packet));
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    private DatagramSocket getSocket() {
      return ds;
    }
  }
}
