package savidude.com.undeads.Tabs.Tab1;

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
import savidude.com.undeads.Models.AcceptedJobOffer;
import savidude.com.undeads.R;

// In this case, the fragment displays simple text based on the page
public class OfferStatusTab extends Fragment {

    //refresh swipe
    private SwipeRefreshLayout swipeContainer1;

    CustomAdapter_Tab1 adapter;
    private List<AcceptedJobOffer> rowItems;

    public  final static String SER_KEY = "ser.jobOffer";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.offers_status, container, false);

        final ListView lv = (ListView) view.findViewById(R.id.offerStatusListview);
        try {
            rowItems = fetchTimelineAsync(0);
            adapter = new CustomAdapter_Tab1(getActivity(), rowItems);
            lv.setAdapter(adapter);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Lookup the swipe container view
        swipeContainer1 = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainerTab1);
        // Setup refresh listener which triggers new data loading
        swipeContainer1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                try {
                    rowItems = fetchTimelineAsync(0);
                    adapter = new CustomAdapter_Tab1(getActivity(), rowItems);
                    lv.setAdapter(adapter);

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                swipeContainer1.setRefreshing(false);
            }
        });
        // Configure the refreshing colors
        swipeContainer1.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedItemID = lv.getSelectedItemPosition();
                AcceptedJobOffer jobOffer = rowItems.get(i);
                Intent mIntent = new Intent(getActivity(), tab1_popup.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable(SER_KEY, jobOffer);
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        return view;
    }

    //method called to refresh jobs offer statuses
    public List<AcceptedJobOffer> fetchTimelineAsync(int page) throws ExecutionException, InterruptedException {
        String type = "view";
        AcceptedJobOffersController backgroundWorker = new AcceptedJobOffersController(this.getContext());
        AsyncTask<String, Void, ArrayList<AcceptedJobOffer>> test = new AcceptedJobOffersController(this.getContext()).execute(type);
        ArrayList<AcceptedJobOffer> jobOffers = test.get();
        return jobOffers;
    }
}