package Models;

/**
 * Created by sky on 5/28/2016.
 */
public class JobTitle {

    private int jobTitleId;
    private int orgId;
    private String des;

    public JobTitle(int jobTitleId, int orgId, String des) {
        this.jobTitleId = jobTitleId;
        this.orgId = orgId;
        this.des = des;
    }

    public int getJobTitleId() {
        return jobTitleId;
    }

    public void setJobTitleId(int jobTitleId) {
        this.jobTitleId = jobTitleId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
