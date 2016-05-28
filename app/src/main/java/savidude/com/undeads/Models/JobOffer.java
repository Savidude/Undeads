package savidude.com.undeads.Models;

/**
 * Created by sky on 5/28/2016.
 */
public class JobOffer {

    private int jobOfferId;
    private int orgId;
    private int jobId;
    private String startTime;
    private String endTime;
    private String addedTime;


    public JobOffer(int jobOfferId, int orgId, int jobId, String startTime, String endTime, String addedTime) {
        this.jobOfferId = jobOfferId;
        this.orgId = orgId;
        this.jobId = jobId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.addedTime = addedTime;
    }

    public int getJobOfferId() {
        return jobOfferId;
    }

    public void setJobOfferId(int jobOfferId) {
        this.jobOfferId = jobOfferId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
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

    public String getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(String addedTime) {
        this.addedTime = addedTime;
    }
}
