package savidude.com.undeads;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import savidude.com.undeads.Tabs.Tab2.JobTab;
import savidude.com.undeads.Tabs.Tab1.OfferStatusTab;

public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                OfferStatusTab tab1 = new OfferStatusTab();
                return tab1;
            case 1:
                JobTab tab2 = new JobTab();
                return tab2;
            case 2:
                JobTab tab3 = new JobTab();
                return tab3;
            case 3:
                JobTab tab4 = new JobTab();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}