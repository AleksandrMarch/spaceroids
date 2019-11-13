package spaceroids.protocol.packetData.events;

public interface Event {
  public void deserialize();
  public void serialize();
}
