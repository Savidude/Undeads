package Models;

/**
 * Created by sky on 5/28/2016.
 */
public class AcceptedJoboffers {

    private int acceptedJobOfferId;
    private String jobOfferId;
    private String nic;
    private int pending;

    public AcceptedJoboffers(int acceptedJobOfferId, String jobOfferId, String nic, int pending) {
        this.acceptedJobOfferId = acceptedJobOfferId;
        this.jobOfferId = jobOfferId;
        this.nic = nic;
        this.pending = pending;
    }

    public int getAcceptedJobOfferId() {
        return acceptedJobOfferId;
    }

    public void setAcceptedJobOfferId(int acceptedJobOfferId) {
        this.acceptedJobOfferId = acceptedJobOfferId;
    }

    public String getJobOfferId() {
        return jobOfferId;
    }

    public void setJobOfferId(String jobOfferId) {
        this.jobOfferId = jobOfferId;
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
