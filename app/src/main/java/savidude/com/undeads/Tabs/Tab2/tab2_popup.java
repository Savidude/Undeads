package savidude.com.undeads.Tabs.Tab2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import savidude.com.undeads.Models.getAllJobOffers;
import savidude.com.undeads.R;
import savidude.com.undeads.Tabs.Tab1.OfferStatusTab;

public class tab2_popup extends AppCompatActivity {

    TextView jobDescription;
    TextView organizationName;
    TextView startTime;
    TextView endTime;
    TextView quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2_popup);

        getAllJobOffers job = (getAllJobOffers)getIntent().getSerializableExtra(JobTab.SER_KEY);


        jobDescription = (TextView) findViewById(R.id.jobDescriptionTextViewT2);
        organizationName = (TextView) findViewById(R.id.organizationNameTextViewT2);
        startTime = (TextView) findViewById(R.id.startTimeTextViewT2);
        endTime = (TextView) findViewById(R.id.endTimeTextViewT2);
        quantity = (TextView) findViewById(R.id.quantityTextViewT2);

        jobDescription.setText(job.getJobTitleDescription());
        organizationName.setText(job.getOrgName());
        startTime.setText(job.getStartTime());
        endTime.setText(job.getEndTime());
        quantity.setText(String.valueOf(job.getQuantity()));

        String[] startDateTimeSplit = job.getStartTime().split(":");
        String[] startTimeSplit = startDateTimeSplit[1].split("-");
        String finalStartDateTime = startDateTimeSplit[0] + "     " + new StringBuilder().append(startTimeSplit[0]).append(":").append(startTimeSplit[1]);
        startTime.setText(finalStartDateTime);

        String[] endDateTimeSplit = job.getEndTime().split(":");
        String[] endTimeSplit = endDateTimeSplit[1].split("-");
        String finalEndDateTime = endDateTimeSplit[0] + "     " + new StringBuilder().append(endTimeSplit[0]).append(":").append(endTimeSplit[1]);
        endTime.setText(finalEndDateTime);
    }
}
