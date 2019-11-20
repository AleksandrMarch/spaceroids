package spaceroids.protocol.utils;

import java.net.*;

public class SocketUtils {
  public static int getFreePort() {
    int portFrom = 1024;
    int portTo = 65535;
    int freePort = 0;
    for (int port = portFrom; port < portTo; port++) {
      try {
        DatagramSocket ds = new DatagramSocket(port);
        ds.close();
        freePort = port;
        break;
      } catch (SocketException e) {
        e.printStackTrace();
      }
    }
    return freePort;
  }
}
