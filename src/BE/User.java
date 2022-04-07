package BE;

public class User {

    private String userName;
    private String userEmail;
    private String userTicket;
    private int userPhoneNumber;
    private int userAmountOfTickets;
    private int userId;


    public User (String userName, String userEmail, int userPhoneNumber, int userAmountOfTickets, String userTicket, int userId) {
        this.userName = userName ;
        this.userEmail = userEmail ;
        this.userTicket = userTicket ;
        this.userPhoneNumber = userPhoneNumber ;
        this.userAmountOfTickets = userAmountOfTickets ;
        this.userId = userId ;
    }

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getUserEmail() {return userEmail;}
    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}
    public String getUserTicket() {return userTicket;}
    public void setUserTicket(String userTicket) {this.userTicket = userTicket;}
    public int getUserPhoneNumber() {return userPhoneNumber;}
    public void setUserPhoneNumber(int userPhoneNumber) {this.userPhoneNumber = userPhoneNumber;}
    public int getUserAmountOfTickets() {return userAmountOfTickets;}
    public void setUserAmountOfTickets(int userAmountOfTickets) {this.userAmountOfTickets = userAmountOfTickets;}
    public int getUserId() {return userId;}
    public void setUserId(int userId) {this.userId = userId;}
}
