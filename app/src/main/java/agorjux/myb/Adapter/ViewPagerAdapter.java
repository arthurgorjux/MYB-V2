package agorjux.myb.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agorjux on 16/09/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    private static final String TAG = ViewPagerAdapter.class.getCanonicalName();

    private final FragmentManager mFragmentManager;

    private FragmentTransaction mCurTransaction;

    private Fragment mCurrentPrimaryItem = null;

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
        mFragmentManager = manager;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (mCurTransaction == null) {
            throw new IllegalArgumentException("current transaction must not be null");
        }
        mCurTransaction.detach((Fragment) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (mCurTransaction == null) {
            throw new IllegalArgumentException("current transaction must not be null");
        }
        String fragmentTag = makeFragmentName(container.getId(), position);
        Fragment fragment = (Fragment) mFragmentManager.findFragmentByTag(fragmentTag);
        if (fragment != null) {
            mCurTransaction.attach(fragment);
            Log.d(TAG, "Attaching existing fragment " + fragment + " at position " + position);
        } else {
            fragment = getItem(position);
            mCurTransaction.add(container.getId(), fragment, fragmentTag);
            Log.d(TAG, "Attaching new fragment " + fragment + " at position " + position);
        }

        if (fragment != mCurrentPrimaryItem) {
            fragment.setMenuVisibility(false);
        }

        return fragment;
    }

    private String makeFragmentName(int viewId, int position) {
        if (viewId <= 0)
            throw new IllegalArgumentException("viewId " + viewId);
        return "tabpageradptr:" + getPageTitle(position) + ":" + viewId + ":" + position;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        Fragment fragment = (Fragment) object;
        if (fragment != mCurrentPrimaryItem) {
            Log.d(TAG, "set Primary item " + position + " to " + fragment);
            if (mCurrentPrimaryItem != null) {
                mCurrentPrimaryItem.setMenuVisibility(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
            }
            mCurrentPrimaryItem = fragment;
        }
    }

    @Override
    public void startUpdate(ViewGroup container) {
        super.startUpdate(container);
        if (mCurTransaction != null) {
            throw new IllegalArgumentException("current transaction must not be null");
        }
        mCurTransaction = mFragmentManager.beginTransaction();
        Log.d(TAG, "FragmentTransaction started");
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        if (mCurTransaction != null) {
            mCurTransaction.commit();
            mCurTransaction = null;
            Log.d(TAG, "FragmentTransaction committed");
        } else {
            throw new IllegalArgumentException("current transaction must not be null");
        }
    }


    @Override
    public boolean isViewFromObject(View view, Object fragment) {
        return ((Fragment) fragment).getView() == view;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null; //mFragmentTitleList.get(position);
    }
}
