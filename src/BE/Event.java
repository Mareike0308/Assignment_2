package BE;

import javafx.scene.image.Image;

public class Event {

    private String eventName;
    private String eventDate;
    private String eventPlace;
    private String eventStartEnding;
    private String eventInfo;
    private Image eventImg;
    private int eventId;

    public Event (String eventName, String eventDate, String eventPlace, String eventStartEnding, String eventInfo,int eventId) {
        this.eventName = eventName ;
        this.eventDate = eventDate ;
        this.eventPlace = eventPlace ;
        this.eventStartEnding = eventStartEnding ;
        this.eventInfo = eventInfo ;
        this.eventImg = eventImg;
        this.eventId = eventId ;
    }

    public String getEventName() {return eventName;}
    public void setEventName(String eventName) {this.eventName = eventName;}
    public String getEventDate() {return eventDate;}
    public void setEventDate(String eventDate) {this.eventDate = eventDate;}
    public String getEventPlace() {return eventPlace;}
    public void setEventPlace(String eventPlace) {this.eventPlace = eventPlace;}
    public String getEventStartEnding() {return eventStartEnding;}
    public void setEventStartEnding(String eventStartEnding) {this.eventStartEnding = eventStartEnding;}
    public String getEventInfo() {return eventInfo;}
    public void setEventInfo(String eventInfo) {this.eventInfo = eventInfo;}
    public int getEventId() {return eventId;}
    public void setEventId(int eventId) {this.eventId = eventId;}
    public Image getEventImg() {return eventImg;}
    public void setEventImg(Image eventImg) {this.eventImg = eventImg;}
}
