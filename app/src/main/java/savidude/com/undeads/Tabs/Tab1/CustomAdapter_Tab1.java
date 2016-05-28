package savidude.com.undeads.Tabs.Tab1;

/**
 * Created by Imaadh Rizni on 5/28/2016.
 */

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import savidude.com.undeads.Models.AcceptedJobOffer;
import savidude.com.undeads.R;


public class CustomAdapter_Tab1 extends BaseAdapter {

    Context context;
    List<AcceptedJobOffer> rowItem;

    public CustomAdapter_Tab1(Context context, List<AcceptedJobOffer> rowItem) {
        this.context = context;
        this.rowItem = rowItem;

    }

    @Override
    public int getCount() {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_listview_tab1, null);
        }

        TextView job_desc = (TextView) convertView.findViewById(R.id.job_desc);
        TextView job_status = (TextView) convertView.findViewById(R.id.pending);

        AcceptedJobOffer row_pos = rowItem.get(position);

        job_desc.setText(row_pos.getJobDescription());
        int statusCode = row_pos.getPending();

        String statusText;
        switch (statusCode) {
            case 0:
                statusText = "Pending";
                job_status.setText(statusText);
                job_status.setTextColor(Color.DKGRAY);
                break;
            case 1:
                statusText = "Rejected";
                job_status.setText(statusText);
                job_status.setTextColor(Color.RED);
                break;
            case 2:
                statusText = "Accepted";
                job_status.setText(statusText);
                job_status.setTextColor(Color.GREEN);
                break;
            default:
                statusText = null;
                break;
        }
        return convertView;

    }

}