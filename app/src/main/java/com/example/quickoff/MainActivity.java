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
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    private Context mContext;


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


    }

    //对应这里，点击进入对应的fragment
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

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer((GravityCompat.START));
        } else {
            super.onBackPressed();
        }
    }

    public void findProduct(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Product product = dbHandler.findHandler(searchinput.getText().toString());  // not ready
        if (product != null) {
            if(product.getSource() == true) {
                price_amazon.setText(String.valueOf(product.getPrice()));
                product_name_amazon.setText(product.getName());
                source_amazon.setText("Amazon");
            }
            else{
                price_Tmall.setText(String.valueOf(product.getPrice()));
                name_Tmall.setText(product.getName());
                source_Tmall.setText("Tmall");
            }
        } else {
            product_name_amazon.setText("No such product");
            product_name_tmall.setText("No such product");
        }
    }

}
