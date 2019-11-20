package spaceroids.client.network.packetProcessing.processors;

import spaceroids.client.events.EventSystem;
import spaceroids.protocol.packetData.eventsData.EventData;

public class PlayerConnectedProcessor {
  public static void process(EventData eventData) {
    System.out.println("player connected to server");
    
  }
}
