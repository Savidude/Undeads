package savidude.com.undeads.Tabs.Tab1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import savidude.com.undeads.Models.AcceptedJobOffer;
import savidude.com.undeads.R;

public class tab1_popup extends AppCompatActivity {

    TextView jobDescription;
    TextView organizationName;
    TextView startTime;
    TextView endTime;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab1_popup);

        AcceptedJobOffer jobOffer = (AcceptedJobOffer)getIntent().getSerializableExtra(OfferStatusTab.SER_KEY);


        jobDescription = (TextView) findViewById(R.id.jobDescriptionTextView);
        organizationName = (TextView) findViewById(R.id.organizationNameTextView);
        startTime = (TextView) findViewById(R.id.startTimeTextView);
        endTime = (TextView) findViewById(R.id.endTimeTextView);
        status = (TextView) findViewById(R.id.statusTextView);

        jobDescription.setText(jobOffer.getJobDescription());
        organizationName.setText(jobOffer.getOrganizationName());

        String[] startDateTimeSplit = jobOffer.getStartTime().split(":");
        String[] startTimeSplit = startDateTimeSplit[1].split("-");
        String finalStartDateTime = startDateTimeSplit[0] + "     " + new StringBuilder().append(startTimeSplit[0]).append(":").append(startTimeSplit[1]);
        startTime.setText(finalStartDateTime);

        String[] endDateTimeSplit = jobOffer.getEndTime().split(":");
        String[] endTimeSplit = endDateTimeSplit[1].split("-");
        String finalEndDateTime = endDateTimeSplit[0] + "     " + new StringBuilder().append(endTimeSplit[0]).append(":").append(endTimeSplit[1]);
        endTime.setText(finalEndDateTime);

        int statusCode = jobOffer.getPending();
        String statusText;
        switch (statusCode) {
            case 0:
                statusText = "Pending";
                status.setText(statusText);
                status.setTextColor(Color.DKGRAY);
                break;
            case 1:
                statusText = "Rejected";
                status.setText(statusText);
                status.setTextColor(Color.RED);
                break;
            case 2:
                statusText = "Accepted";
                status.setText(statusText);
                status.setTextColor(Color.GREEN);
                break;
            default:
                statusText = null;
                break;
        }
    }
}
