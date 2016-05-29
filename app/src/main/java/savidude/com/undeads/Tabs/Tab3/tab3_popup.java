package savidude.com.undeads.Tabs.Tab3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import savidude.com.undeads.Controllers.AvailableJobOffersController;
import savidude.com.undeads.Controllers.NotificationSubscriberController;
import savidude.com.undeads.Models.Subscription;
import savidude.com.undeads.Models.getAllJobOffers;
import savidude.com.undeads.R;
import savidude.com.undeads.Tabs.Tab2.JobTab;

public class tab3_popup extends AppCompatActivity {

    TextView jobDescription;
    TextView organizationName;
    TextView startTime;
    TextView endTime;
    TextView quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3_popup);

        Subscription job = (Subscription) getIntent().getSerializableExtra(NotificationTab.SER_KEY);


        jobDescription = (TextView) findViewById(R.id.jobDescriptionTextViewT3);
        organizationName = (TextView) findViewById(R.id.organizationNameTextViewT3);
        startTime = (TextView) findViewById(R.id.startTimeTextViewT3);
        endTime = (TextView) findViewById(R.id.endTimeTextViewT3);
        quantity = (TextView) findViewById(R.id.quantityTextViewT3);

        jobDescription.setText(job.getJob_Title_Description());
        organizationName.setText(job.getOrganization_Name());
        quantity.setText(String.valueOf(job.getQuantity()));

        String[] startDateTimeSplit = job.getStart_Tme().split(":");
        String[] startTimeSplit = startDateTimeSplit[1].split("-");
        String finalStartDateTime = startDateTimeSplit[0] + "     " + new StringBuilder().append(startTimeSplit[0]).append(":").append(startTimeSplit[1]);
        startTime.setText(finalStartDateTime);

        String[] endDateTimeSplit = job.getEnd_Time().split(":");
        String[] endTimeSplit = endDateTimeSplit[1].split("-");
        String finalEndDateTime = endDateTimeSplit[0] + "     " + new StringBuilder().append(endTimeSplit[0]).append(":").append(endTimeSplit[1]);
        endTime.setText(finalEndDateTime);
    }

    public void acceptSubsciptionJob(View view) {
        String type = "create";
        new NotificationSubscriberController(view.getContext()).execute(type);
    }
}