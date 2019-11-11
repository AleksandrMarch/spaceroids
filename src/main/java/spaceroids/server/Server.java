package spaceroids.server;

import spaceroids.server.logging.Logger;
import spaceroids.server.packetProcessing.ProcessorFactory;

import java.io.IOException;
import java.net.*;

public class Server {
  private static Server server;
  private static ServerThread serverThread;

  private Server(int port) {
    try {
      serverThread = new ServerThread(port);
      serverThread.start();
    } catch (SocketException e) {
      e.printStackTrace();
    }
  }

  public static void startServer(int port) {
    server = new Server(port);
  }

  public static void stopServer() {
    serverThread.stopThread();
  }

  private class ServerThread extends Thread {
    private boolean running = true;
    private DatagramSocket ds;

    private ServerThread(int port) throws SocketException {
      ds = new DatagramSocket(port);
    }

    @Override
    public void run() {
      System.out.println("Server started");
      ProcessorFactory processor = new ProcessorFactory();
      while (running) {
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        try {
          ds.receive(packet);
          ProcessorFactory.process(PacketWrapper.wrap(packet));
        } catch (IOException e) {
          Logger.log(e);
        }
      }
    }

    private void stopThread() {
      running = false;
    }
  }
}
