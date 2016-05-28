package savidude.com.undeads.Tabs.Tab1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import savidude.com.undeads.Models.AcceptedJobOffer;
import savidude.com.undeads.R;
import savidude.com.undeads.Tabs.Tab1.CustomAdapter_Tab1;

// In this case, the fragment displays simple text based on the page
public class OfferStatusTab extends Fragment {

    //refresh swipe
    private SwipeRefreshLayout swipeContainer1;

    CustomAdapter_Tab1 adapter;
    private List<AcceptedJobOffer> rowItems;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.offers_status, container, false);

        // Lookup the swipe container view
        swipeContainer1 = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainerTab1);
        // Setup refresh listener which triggers new data loading
        swipeContainer1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                fetchTimelineAsync(0);
            }
        });
        // Configure the refreshing colors
        swipeContainer1.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        ListView lv = (ListView) view.findViewById(R.id.offerStatusListview);
        rowItems = new ArrayList<AcceptedJobOffer>();
        //rowItems.add(0, new AcceptedJobOffer(0, "0", "963220790V", 1));
        adapter = new CustomAdapter_Tab1(getActivity(), rowItems);
        lv.setAdapter(adapter);
        //lv.setOnItemClickListener(this);
        return view;
    }

    //method called to refresh jobs offer statuses
    public void fetchTimelineAsync(int page) {
        // Send the network request to fetch the updated data
        // `client` here is an instance of Android Async HTTP
//        client.getHomeTimeline(0, new JsonHttpResponseHandler() {
//            public void onSuccess(JSONArray json) {
//                // Remember to CLEAR OUT old items before appending in the new ones
//                adapter.clear();
//                // ...the data has come back, add new items to your adapter...
//                adapter.addAll(...);
//                // Now we call setRefreshing(false) to signal refresh has finished
//                swipeContainer.setRefreshing(false);
//            }
//
//            public void onFailure(Throwable e) {
//                Log.d("DEBUG", "Fetch timeline error: " + e.toString());
//            }
//        });
    }
}