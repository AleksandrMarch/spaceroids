package spaceroids.server;

import java.io.IOException;
import java.net.*;

public class Server {
  private static Server server;

  private Server(int port) {
    try {
      ServerThread serverThread = new ServerThread(port);
      serverThread.run();
    } catch (SocketException e) {
      e.printStackTrace();
    }
  }

  public static void startServer(int port) {
    server = new Server(port);
  }

  public static void stopServer() {

  }

  private class ServerThread extends Thread {
    private boolean running = true;
    private DatagramSocket ds;

    public ServerThread(int port) throws SocketException {
      ds = new DatagramSocket(port);
    }

    @Override
    public void run() {
      System.out.println("Server started");
      while (running) {
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        try {
          ds.receive(packet);
          System.out.println(packet);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    public void stopThread() {
      running = false;
    }
  }
}
