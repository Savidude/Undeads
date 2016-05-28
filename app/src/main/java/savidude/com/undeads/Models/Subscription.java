package savidude.com.undeads.Models;

/**
 * Created by FathimaShakoora on 29-May-16.
 */
public class Subscription {

    String Last_Updated_Date;
    String Organization_Name;
    String Job_Offer_Added_Time;
    String Start_Tme;
    String End_Time;
    int Quantity;
    String Job_Title_Description;

    public Subscription(String job_Title_Description, int quantity, String last_Updated_Date,
                        String organization_Name, String job_Offer_Added_Time, String start_Tme, String end_Time) {

        Job_Title_Description = job_Title_Description;
        Quantity = quantity;
        Last_Updated_Date = last_Updated_Date;
        Organization_Name = organization_Name;
        Job_Offer_Added_Time = job_Offer_Added_Time;
        Start_Tme = start_Tme;
        End_Time = end_Time;
    }

    public Subscription() {}

    public String getJob_Title_Description() {return Job_Title_Description;}

    public void setJob_Title_Description(String job_Title_Description) {Job_Title_Description = job_Title_Description;}

    public int getQuantity() {return Quantity;}

    public void setQuantity(int quantity) {Quantity = quantity;}

    public String getEnd_Time() {return End_Time;}

    public void setEnd_Time(String end_Time) {End_Time = end_Time;}

    public String getStart_Tme() {return Start_Tme;}

    public void setStart_Tme(String start_Tme) {Start_Tme = start_Tme;}

    public String getJob_Offer_Added_Time() {return Job_Offer_Added_Time;}

    public void setJob_Offer_Added_Time(String job_Offer_Added_Time) {Job_Offer_Added_Time = job_Offer_Added_Time;}

    public String getOrganization_Name() {return Organization_Name;}

    public void setOrganization_Name(String organization_Name) {Organization_Name = organization_Name;}

    public String getLast_Updated_Date() { return Last_Updated_Date;}

    public void setLast_Updated_Date(String last_Updated_Date) { Last_Updated_Date = last_Updated_Date;}
}
