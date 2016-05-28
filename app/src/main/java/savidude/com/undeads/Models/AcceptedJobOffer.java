package savidude.com.undeads.Models;

/**
 * Created by sky on 5/28/2016.
 */


public class AcceptedJobOffer {

    private String organizationName;
    private String startTime;
    private String endTime;
    private String quantity;
    private String nic;
    private int pending;
    private String jobDescription;

    public AcceptedJobOffer(){

    }

    public AcceptedJobOffer(String jobDescription, String organizationName, String startTime, String quantity, String endTime, int pending) {
        this.jobDescription = jobDescription;
        this.organizationName = organizationName;
        this.startTime = startTime;
        this.quantity = quantity;
        this.endTime = endTime;
        this.pending = pending;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }
}

