package hust.hungnq.bigfive;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        numOfTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //Tra ve fragment duoc nguoi dung vuot den (position)
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new ScanFragment();
            case 2:
                return new UserFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
