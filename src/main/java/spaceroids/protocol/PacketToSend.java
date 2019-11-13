package spaceroids.protocol;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import spaceroids.protocol.packetData.events.*;

import java.util.*;

public class PacketToSend {
  @SerializedName("events")
  private List<Event> eventList = new ArrayList<>();

  public void prepare() {
    eventList.forEach(Event::serialize);
  }

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
//    PacketToSend packetToClient = new PacketToSend();
//    Event event = new PlayerConnectRequestEvent();
//    packetToClient.getEventList().add(event);
//    System.out.println(packetToClient.toJson());
//  }
}
