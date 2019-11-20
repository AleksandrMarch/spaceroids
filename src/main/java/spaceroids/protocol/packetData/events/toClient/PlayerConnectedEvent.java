package spaceroids.protocol.packetData.events.toClient;

import spaceroids.protocol.packetData.eventsData.EventData;

public class PlayerConnectedEvent implements EventData {
  private int serverId;
  private int x;
  private int y;
  private int angle;

  public PlayerConnectedEvent(int serverId, int x, int y, int angle) {
    this.serverId = serverId;
    this.x = x;
    this.y = y;
    this.angle = angle;
  }

  public int getServerId() {
    return serverId;
  }

  public void setServerId(int serverId) {
    this.serverId = serverId;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getAngle() {
    return angle;
  }

  public void setAngle(int angle) {
    this.angle = angle;
  }
}
