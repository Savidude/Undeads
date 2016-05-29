package savidude.com.undeads.Tabs.Tab3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import savidude.com.undeads.Controllers.NotificationSubscriberController;
import savidude.com.undeads.Models.Subscription;
import savidude.com.undeads.R;
import savidude.com.undeads.Tabs.Tab2.CustomAdapter_Tab2;

/**
 * Created by FathimaShakoora on 29-May-16.
 */
public class NotificationTab extends Fragment {

    //refresh swipe
    private SwipeRefreshLayout swipeContainer3;
    CustomAdapter_Tab3 adapter;
    private List<Subscription> rowItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.job_tab, container, false);

        final ListView lv = (ListView) view.findViewById(R.id.allJobsListview);
        try {
            rowItems = fetchTimelineAsync(0);
            adapter = new CustomAdapter_Tab3(getActivity(), rowItems);
            lv.setAdapter(adapter);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Lookup the swipe container view
        swipeContainer3 = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainerTab2);
        // Setup refresh listener which triggers new data loading
        swipeContainer3.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    rowItems = fetchTimelineAsync(0);
                    adapter = new CustomAdapter_Tab3(getActivity(), rowItems);
                    lv.setAdapter(adapter);

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                swipeContainer3.setRefreshing(false);
            }
        });
        // Configure the refreshing colors
        swipeContainer3.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        return view;
    }


    public List<Subscription> fetchTimelineAsync(int page) throws ExecutionException, InterruptedException {
        String type = "view";
        NotificationSubscriberController backgroundWorker = new NotificationSubscriberController(this.getContext());
        AsyncTask<String, Void, ArrayList<Subscription>> test = new NotificationSubscriberController (this.getContext()).execute(type);
        ArrayList<Subscription> allJobs = test.get();
        return allJobs;
    }
}
