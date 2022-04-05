package BE;

public class Admin {


    private String adminEmail;
    private String adminPassword;
    private int adminId;

    public Admin (String adminEmail, String adminPassword, int adminId) {
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminId = adminId;
    }

    public String getAdminEmail() {return adminEmail;}
    public void setAdminEmail(String adminEmail) {this.adminEmail = adminEmail;}
    public String getAdminPassword() {return adminPassword;}
    public void setAdminPassword(String adminPassword) {this.adminPassword = adminPassword;}
    public int getAdminId() {return adminId;}
    public void setAdminId(int adminId) {this.adminId = adminId;}

}
