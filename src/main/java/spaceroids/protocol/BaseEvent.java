package spaceroids.protocol;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import spaceroids.protocol.exceptions.UnknownEventIdException;
import spaceroids.protocol.packetData.events.Event;
import spaceroids.protocol.packetData.eventsData.EventData;

public class BaseEvent implements Event {
  private int eventId;
  @SerializedName("data")
  private String jsonData;
  private transient EventData dataObject;

  public BaseEvent(EventData eventData, int eventId) {
    this.dataObject = eventData;
    this.eventId = eventId;
  }

  public BaseEvent() {}

  @Override
  public void deserialize() {
    if (jsonData != null) {
      Gson gson = new Gson();
      try {
        dataObject = gson.fromJson(jsonData, EventFactory.getEventData(eventId).getClass());
      } catch (UnknownEventIdException e) { //todo handle exception
        e.printStackTrace();
      }
    }
  }

  @Override
  public void serialize() {
    Gson gson = new Gson();
    jsonData = gson.toJson(dataObject);
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  public String getDataString() {
    return jsonData;
  }

  public void setDataString(String dataString) {
    this.jsonData = dataString;
  }

  public EventData getDataObject() {
    return dataObject;
  }

  public void setDataObject(EventData dataObject) {
    this.dataObject = dataObject;
  }
}
