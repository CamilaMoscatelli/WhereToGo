package com.example.grupo8webir.WhereToGo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

// Tab imports
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.grupo8webir.WhereToGo.R;
import com.example.grupo8webir.WhereToGo.model.Event;
import com.example.grupo8webir.WhereToGo.utils.EventsHolder;
import com.google.android.gms.games.event.Events;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        /*
        Assigning view variables to their respective view in xml
        by findViewByID method
         */
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        /*
        Creating Adapter and setting that adapter to the viewPager
        setSupportActionBar method takes the toolbar and sets it as
        the default action bar thus making the toolbar work like a normal
        action bar.
         */
        EventsHolder eventsHolder = EventsHolder.getInstance();
        ArrayList<Event> musicEvents = eventsHolder.musicEvents;
        ArrayList<Event> moviesEvents = eventsHolder.moviesEvents;
        ArrayList<Event> theatreEvents = eventsHolder.theatreEvents;

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), moviesEvents, musicEvents, theatreEvents);
        viewPager.setAdapter(viewPagerAdapter);
        setSupportActionBar(toolbar);

        /*
        TabLayout.newTab() method creates a tab view, Now a Tab view is not the view
        which is below the tabs, its the tab itself.
         */
        final TabLayout.Tab cine = tabLayout.newTab();
        final TabLayout.Tab teatro = tabLayout.newTab();
        final TabLayout.Tab musica = tabLayout.newTab();

        /*
        Setting Title text for our tabs respectively
         */
        cine.setText("Cine");
        teatro.setText("Teatro");
        musica.setText("Música");

        /*
        Adding the tab view to our tablelyout at appropriate positions
        As I want home at first position I am passing home and 0 as argument to
        the tablelyout and like wise for other tabs as well
         */
        tabLayout.addTab(cine, 0);
        tabLayout.addTab(teatro, 1);
        tabLayout.addTab(musica, 2);

        /*
        TabTextColor sets the color for the title of the tabs, passing a ColorStateList here makes
        tab change colors in different situations such as selected, active, inactive etc

        TabIndicatorColor sets the color for the indicator below the tabs
         */
        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.drawable.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));

        /*
        Adding a onPageChangeListener to the viewPager
        1st we add the PageChangeListener and pass a TabLayoutPageChangeListener so that Tabs Selection
        changes when a viewpager page changes.
         */
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //TODO
        /*
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        //TODO
                        //ask for data and reload table
                        break;
                    case 1:
                        //TODO
                        break;
                    case 2:
                        //TODO
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        */

        //TODO
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something you want
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
