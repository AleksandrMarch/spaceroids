package spaceroids.protocol;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import spaceroids.server.PlayerConnection;

import java.net.DatagramPacket;
import java.util.List;

public class PacketWrapper {
  private DatagramPacket packet;
  @SerializedName("events")
  private List<BaseEvent> eventList;
  private PlayerConnection connection;

  public static PacketWrapper wrap(DatagramPacket packet) {
    System.out.println(new String(packet.getData(), packet.getOffset(), packet.getLength()));
    Gson gson = new Gson();
    PacketWrapper wrapper = gson.fromJson(
        new String(packet.getData(), packet.getOffset(), packet.getLength()),
        PacketWrapper.class
    );
    PlayerConnection connection = new PlayerConnection();
    connection.setIp(packet.getAddress().getHostAddress());
    connection.setPort(packet.getPort());
    wrapper.setConnection(connection);
    return wrapper;
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

  public PlayerConnection getConnection() {
    return connection;
  }

  public void setConnection(PlayerConnection connection) {
    this.connection = connection;
  }
}
