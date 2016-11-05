package agorjux.myb;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import agorjux.myb.Fragments.ConfigurationFragment;
import agorjux.myb.Fragments.CreateEventFragment;
import agorjux.myb.Fragments.EventFragment;
import agorjux.myb.Fragments.ListFragment;
import agorjux.myb.Adapter.ViewPagerAdapter;


/**
 * Created by agorjux on 16/09/16.
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);



        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new EventFragment(), getResources().getString(R.string.event_tab_title));
        adapter.addFragment(new ListFragment(), getResources().getString(R.string.list_tab_title));
        adapter.addFragment(new ConfigurationFragment(), getResources().getString(R.string.configuration_tab_title));
        adapter.addFragment(new CreateEventFragment(), getResources().getString(R.string.create_event_title));
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons(){
        //set icons
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_search_white_18dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_event_white_18dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_account_circle_white_18dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_add_white_18dp);
    }
}
