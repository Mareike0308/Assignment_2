package BE;

public class EventUser {

    private int id;
    private int eventID;
    private int userID;

    public EventUser(int userID, int eventID){
        this.userID = userID;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int coordinatorID) {
        this.userID = coordinatorID;
    }
}



