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
        startTime.setText(jobOffer.getStartTime());
        endTime.setText(jobOffer.getEndTime());
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
