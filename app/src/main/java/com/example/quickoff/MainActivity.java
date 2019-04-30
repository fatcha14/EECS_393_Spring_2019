package com.example.quickoff;

import android.content.Context;
import android.media.ExifInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    private Context mContext;

    private List<Product> inputlist;


    /**
     * 三个fragment对应的tags
     *
     */
    public final String TAG_HOME = "home";
    public final String TAG_PREFERRED_LIST = "home";
    public final String TAG_CONTACT_US = "home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment(), TAG_HOME).commit();
            navigationView.setCheckedItem(R.id.home_button);
        }
         initCsv();
        updataDB();
    }

    public void updataDB(){
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        for(int i = 0; i < inputlist.size(); i++){
            dbHandler.addHandler(inputlist.get(i));
        }
    }
    // navigate to the corresponding fragment
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home_button:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment(), TAG_HOME).commit();
                break;
            case R.id.preferred_list_button:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PreferredListFragment(), TAG_PREFERRED_LIST).commit();
                break;
            case R.id.contact_us_button:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactUsFragment(), TAG_CONTACT_US).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // define what fragment that back button can go to
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer((GravityCompat.START));
        } else {
            super.onBackPressed();
        }
    }

    // initialize the data stored in the CSV from the web scraping
    public void initCsv() {
        InputStream inputStream = getResources().openRawResource(R.raw.results);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        inputlist = new ArrayList<>();
        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                // split by ','


                String[] tokens = line.split(",");

                // read data
                Product resultsSample = new Product();
                resultsSample.setName(tokens[0]);
                resultsSample.setPrice(tokens[1]);
                resultsSample.setDescription(tokens[2]);
                if(tokens[3].equals(("Amazon"))){
                    resultsSample.setSource(true);
                }
                else {
                    resultsSample.setSource(false);
                }
                inputlist.add(resultsSample);

                Log.d("MyActivity", "Just Created" + resultsSample.getName());
            }
        }
        catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }
    }

}
