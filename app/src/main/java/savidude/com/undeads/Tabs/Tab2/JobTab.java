package savidude.com.undeads.Tabs.Tab2;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import savidude.com.undeads.Controllers.AcceptedJobOffersController;
import savidude.com.undeads.Controllers.AvailableJobOffersController;
import savidude.com.undeads.Models.AcceptedJobOffer;
import savidude.com.undeads.Models.getAllJobOffers;
import savidude.com.undeads.R;
import savidude.com.undeads.Tabs.Tab1.tab1_popup;

// In this case, the fragment displays simple text based on the page
public class JobTab extends Fragment {

    //refresh swipe
    private SwipeRefreshLayout swipeContainer2;
    CustomAdapter_Tab2 adapter;
    private List<getAllJobOffers> rowItems;

    public  final static String SER_KEY = "ser.job";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.job_tab, container, false);

        final ListView lv = (ListView) view.findViewById(R.id.allJobsListview);
        try {
            rowItems = fetchTimelineAsync(0);
            adapter = new CustomAdapter_Tab2(getActivity(), rowItems);
            lv.setAdapter(adapter);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Lookup the swipe container view
        swipeContainer2 = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainerTab2);
        // Setup refresh listener which triggers new data loading
        swipeContainer2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    rowItems = fetchTimelineAsync(0);
                    adapter = new CustomAdapter_Tab2(getActivity(), rowItems);
                    lv.setAdapter(adapter);

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                swipeContainer2.setRefreshing(false);
            }
        });
        // Configure the refreshing colors
        swipeContainer2.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedItemID = lv.getSelectedItemPosition();
                getAllJobOffers job = rowItems.get(i);
                Intent mIntent = new Intent(getActivity(), tab2_popup.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable(SER_KEY, job);
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });


        return view;
    }


    //method used to retrieve all jobs
    public List<getAllJobOffers> fetchTimelineAsync(int page) throws ExecutionException, InterruptedException {
        String type = "view";
        AvailableJobOffersController backgroundWorker = new AvailableJobOffersController(this.getContext());
        AsyncTask<String, Void, ArrayList<getAllJobOffers>> test = new AvailableJobOffersController(this.getContext()).execute(type);
        ArrayList<getAllJobOffers> allJobs = test.get();
        return allJobs;
    }
}