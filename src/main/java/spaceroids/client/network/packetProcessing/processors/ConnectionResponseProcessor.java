package spaceroids.client.network.packetProcessing.processors;

import spaceroids.client.events.EventSystem;
import spaceroids.protocol.packetData.eventsData.EventData;

public class ConnectionResponseProcessor {
  public static void process(EventData eventData) {
    System.out.println("connected to server");
//    System.out.println("got packet from server");
//    PacketToSend packet = new PacketToSend();
//
    EventSystem.instance.connectedToServer();
  }
}
