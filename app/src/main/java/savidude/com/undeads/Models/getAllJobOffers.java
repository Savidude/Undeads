package savidude.com.undeads.Models;

/**
 * Created by sky on 5/28/2016.
 */
public class getAllJobOffers {

    private String orgName;
    private String startTime;
    private String endTime;
    private int quantity;
    private String jobTitleDescription;

    public getAllJobOffers(String orgName, String startTime, String endTime, int quantity, String jobTitleDescription) {
        this.orgName = orgName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.quantity = quantity;
        this.jobTitleDescription = jobTitleDescription;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getJobTitleDescription() {
        return jobTitleDescription;
    }

    public void setJobTitleDescription(String jobTitleDescription) {
        this.jobTitleDescription = jobTitleDescription;
    }
}
