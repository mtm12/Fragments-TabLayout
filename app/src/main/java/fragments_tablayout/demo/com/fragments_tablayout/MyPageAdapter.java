package fragments_tablayout.demo.com.fragments_tablayout;

//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;

//import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.app.CustomFragmentPagerAdapterv4;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ViewGroup;
import java.util.List;

import static fragments_tablayout.demo.com.fragments_tablayout.MainActivity.fm;
import static fragments_tablayout.demo.com.fragments_tablayout.MainActivity.fragmentsList;
import static fragments_tablayout.demo.com.fragments_tablayout.MainActivity.tabTitles;

/**
 * Created by marct_000 on 8/29/2017.
 */

public class MyPageAdapter extends CustomFragmentPagerAdapterv4 {

    //public FragmentManager fm = getFragmentManager();
    public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);

        Log.d("TabLayout", "Fragment count from MyPageAdapter: " + fragments.size());
    }
    @Override
    public Fragment getItem(int position) {

        return fragmentsList.get(position);

    }

    @Override
    public int getCount() {

        return fragmentsList.size();

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position).toString();
    }

    @Override
    public int getItemPosition(Object object) {
        int index = fragmentsList.indexOf(object);
        Fragment fragment = (Fragment) object;

            if(index == -1){

                Log.d("Tablayout2", "Fragment " + index + " Object class: " + fragment.getClass() + " index: " + index);
                return POSITION_NONE;
                //return index;
                //return POSITION_UNCHANGED;
            }
            else {
                Log.d("Tablayout2", "Fragment " + index + " class: " + fragmentsList.get(index).getClass() + " Object class: " + fragment.getClass() + " index: " + index);
                return index;
                //return MyPageAdapter.POSITION_UNCHANGED;

            }
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        Log.d("TabLayout", "destroyItem: " + position);
//        super.destroyItem(container, position, object);
//        FragmentManager manager = ((Fragment)object).getFragmentManager();
//        FragmentTransaction trans = manager.beginTransaction();
//        trans.remove((Fragment)object);
//        trans.commit();
//
//    }

}
