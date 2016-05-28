package savidude.com.undeads.Models;

/**
 * Created by sky on 5/28/2016.
 */
public class Job {

    private int jobId;
    private int jobTitleId;
    private String startTime;
    private String endTime;
    private int quantity;

    public Job(int jobId, int jobTitleId, String startTime, String endTime, int quantity) {
        this.jobId = jobId;
        this.jobTitleId = jobTitleId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.quantity = quantity;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getJobTitleId() {
        return jobTitleId;
    }

    public void setJobTitleId(int jobTitleId) {
        this.jobTitleId = jobTitleId;
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
}
