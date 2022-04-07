package BE;

public class EventCoord {
    private int id;
    private int eventID;
    private int coordinatorID;

    public EventCoord(int coordinatorID, int eventID){
        this.coordinatorID = coordinatorID;
        this.eventID = eventID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getCoordinatorID() {
        return coordinatorID;
    }

    public void setCoordinatorID(int coordinatorID) {
        this.coordinatorID = coordinatorID;
    }
}
