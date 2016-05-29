package savidude.com.undeads.Tabs.Tab3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import savidude.com.undeads.Models.Subscription;
import savidude.com.undeads.Models.getAllJobOffers;
import savidude.com.undeads.R;

/**
 * Created by FathimaShakoora on 29-May-16.
 */
public class CustomAdapter_Tab3 extends BaseAdapter {
    Context context;
    List<Subscription> rowItem;

    public CustomAdapter_Tab3(Context context, List<Subscription> rowItem) {
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
            convertView = mInflater.inflate(R.layout.custom_listview_tab2, null);
        }

        TextView org_name = (TextView) convertView.findViewById(R.id.org_name);
        TextView job_desc = (TextView) convertView.findViewById(R.id.job_desc);
        TextView working_time = (TextView) convertView.findViewById(R.id.working_time);

        Subscription row_pos = rowItem.get(position);

        org_name.setText(row_pos.getOrganization_Name());
        job_desc.setText(row_pos.getJob_Title_Description());

        String work_Time_Start = row_pos.getStart_Tme();
        String work_Time_End = row_pos.getEnd_Time();

        String[] holdStart = work_Time_Start.split(":");
        String[] holdEnd = work_Time_End.split(":");

        working_time.setText(holdStart[0]+"\t\t\t"+holdStart[1]+" - "+holdEnd[1]);

        return convertView;

    }
}
