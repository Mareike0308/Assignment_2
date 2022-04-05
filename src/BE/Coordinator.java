package BE;

public class Coordinator {

    private String coordinatorName;
    private String coordinatorEmail;
    private String coordinatorPassword;
    private int coordinatorId;

    public Coordinator (String coordinatorName, String coordinatorEmail, String coordinatorPassword, int coordinatorId) {
        this.coordinatorName = coordinatorName ;
        this.coordinatorEmail = coordinatorEmail;
        this.coordinatorPassword = coordinatorPassword;
        this.coordinatorId = coordinatorId;
    }

    public String getCoordinatorName() {return coordinatorName;}
    public void setCoordinatorName(String coordinatorName) {this.coordinatorName = coordinatorName;}
    public String getCoordinatorEmail() {return coordinatorEmail;}
    public void setCoordinatorEmail(String coordinatorEmail) {this.coordinatorEmail = coordinatorEmail;}
    public String getCoordinatorPassword() {return coordinatorPassword;}
    public void setCoordinatorPassword(String coordinatorPassword) {this.coordinatorPassword = coordinatorPassword;}
    public int getCoordinatorId() {return coordinatorId;}
    public void setCoordinatorId(int coordinatorId) {this.coordinatorId = coordinatorId;}

}
