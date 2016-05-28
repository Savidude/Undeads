package Models;

/**
 * Created by sky on 5/28/2016.
 */
public class Organization {

    private String orgId;
    private String name;
    private String des;
    private String managerName;
    private String contactInfo;
    private String email;

    public Organization(String orgId, String name, String des, String managerName, String contactInfo, String email) {
        this.orgId = orgId;
        this.name = name;
        this.des = des;
        this.managerName = managerName;
        this.contactInfo = contactInfo;
        this.email = email;
    }

    public String getId() {
        return orgId;
    }

    public void setId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
