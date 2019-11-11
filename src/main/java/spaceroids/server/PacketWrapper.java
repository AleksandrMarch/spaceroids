package spaceroids.server;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import spaceroids.server.packet.BaseEvent;

import java.net.DatagramPacket;
import java.util.List;

public class PacketWrapper {
  private DatagramPacket packet;
  @SerializedName("events")
  private List<BaseEvent> eventList;

  public static PacketWrapper wrap(DatagramPacket packet) {
    System.out.println(new String(packet.getData(), packet.getOffset(), packet.getLength()));
    Gson gson = new Gson();
    return gson.fromJson(
        new String(packet.getData(), packet.getOffset(), packet.getLength()),
        PacketWrapper.class
    );
  }

  public List<BaseEvent> getEventList() {
    return eventList;
  }

  public void setEventList(List<BaseEvent> eventList) {
    this.eventList = eventList;
  }

  public DatagramPacket getPacket() {
    return packet;
  }

  public void setPacket(DatagramPacket packet) {
    this.packet = packet;
  }
}
