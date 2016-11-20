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
            case 3:
                ThreeFragment tab4 = new ThreeFragment();
                return tab4;
            case 4:
                FourFragment tab5 = new FourFragment();
                return tab5;
            case 5:
                FiveFragment tab6 = new FiveFragment();
                return tab6;
            case 6:
                SixFragment tab7 = new SixFragment();
                return tab7;
            case 7:
                SevenFragment tab8 = new SevenFragment();
                return tab8;
            case 8:
                EightFragment tab9 = new EightFragment();
                return tab9;
            case 9:
                NineFragment tab10 = new NineFragment();
                return tab10;
            case 10:
                TenFragment tab11 = new TenFragment();
                return tab11;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
