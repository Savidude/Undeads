package savidude.com.undeads.Tabs.Tab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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
    }
}
