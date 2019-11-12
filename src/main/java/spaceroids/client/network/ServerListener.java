package spaceroids.client.network;

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

  private class Server extends Thread {
    DatagramSocket ds;

    public Server() {
      try {
        ds = new DatagramSocket(33321);
      } catch (SocketException e) {
        Logger.log(e);
      }
    }

    @Override
    public void run() {
      System.out.println("started server listener");
      while (true) {
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        try {
          ds.receive(packet);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
