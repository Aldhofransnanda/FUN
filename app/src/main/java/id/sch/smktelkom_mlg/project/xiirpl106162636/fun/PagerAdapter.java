package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

/**
 * Created by Muhammad Pandu Widod on 12/11/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                StartFragment tab1 = new StartFragment();
                return tab1;
            case 1:
                OneFragment tab2 = new OneFragment();
                return tab2;
            case 2:
                TwoFragment tab3 = new TwoFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
