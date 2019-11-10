package spaceroids.client.protocol;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import spaceroids.client.protocol.packetData.events.*;

import java.util.*;

public class PacketToClient {
  @SerializedName("events")
  private List<Event> eventList = new ArrayList<>();

  public String toJson() {
    Gson gson = new Gson();
    return gson.toJson(this);
  }

  public List<Event> getEventList() {
    return eventList;
  }

  public void setEventList(List<Event> eventList) {
    this.eventList = eventList;
  }

//  public static void main(String[] args) {
//    PacketToClient packetToClient = new PacketToClient();
//    Event event = new ConnectEvent();
//    packetToClient.getEventList().add(event);
//    System.out.println(packetToClient.toJson());
//  }
}
