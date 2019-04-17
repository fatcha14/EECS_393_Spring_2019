package com.example.quickoff;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SearchResultActivity extends AppCompatActivity {

    private Button add_btn_amazon;
    private Button getAdd_btn_tmall;
    private String product_name;
    private String company;
    private String source;
    private String price;
    // a dictionary to match with the intent sent by different activities
    String[] intent_dictionary =  {
            "iPhone XS 64GB", "iPhone XS 256GB", "iPhone XS 512GB",
            "iPhone XS MAX 64GB", "iPhone XS MAX 256GB", "iPhone XS 512GB",
            "iPhone XR 64GB", "iPhone XR 128GB", "iPhone XR 256GB",
            "S10 128GB", "S10 256GB", "S10 512GB",
            "S10+ 128GB", "S10+ 256GB", "S10+ 512GB", "S10+ 1TB",
            "S10e 64GB", "S10e 128GB", "S10e 256GB"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);



        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search Result");

        set_table_amazon();
        set_table_tmall();

        add_btn_amazon = (Button) findViewById(R.id.add_btn_amaozn);
        getAdd_btn_tmall = (Button) findViewById(R.id.add_btn_tmall);


        add_btn_amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_table_amazon();
                PreferredListFragment.preferredList.add(new Product(true, product_name, price));
                Toast.makeText(SearchResultActivity.this, "Add Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        getAdd_btn_tmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_table_tmall();
                PreferredListFragment.preferredList.add(new Product(false, product_name, price));
                Toast.makeText(SearchResultActivity.this, "Add Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /*
    A method used to get the contents displayed on the amazon table
     */
    public void get_table_amazon() {
        TextView tmp_product_name = (TextView) findViewById(R.id.product_name_amazon);
        product_name = tmp_product_name.getText().toString();

        TextView tmp_company = (TextView) findViewById(R.id.company_amazon);
        company = tmp_company.getText().toString();

        TextView tmp_source = (TextView) findViewById(R.id.source_amazon);
        source = tmp_source.getText().toString();

        TextView tmp_price = (TextView) findViewById(R.id.price_amazon);
        String tmp_price_1 = tmp_price.getText().toString();
        tmp_price_1 = tmp_price_1.replaceAll("[^\\d.]", "");
        price = tmp_price_1;
    }

    /*
    A method used to get the contents displayed on the tmall table
     */
    public void get_table_tmall() {
        TextView tmp_product_name = (TextView) findViewById(R.id.product_name_tmall);
        product_name = tmp_product_name.getText().toString();

        TextView tmp_company = (TextView) findViewById(R.id.company_tmall);
        company = tmp_company.getText().toString();

        TextView tmp_source = (TextView) findViewById(R.id.source_tmall);
        source = tmp_source.getText().toString();

        TextView tmp_price = (TextView) findViewById(R.id.price_tmall);
        String tmp_price_1 = tmp_price.getText().toString();
        tmp_price_1 = tmp_price_1.replaceAll("[^\\d.]", "");
        price = tmp_price_1;
    }

    /*
    A method to initialize the amazon table
     */
    private void set_table_amazon() {
        Intent intent = getIntent();
        String message[] = new String[3];
        for (int i = 0; i < intent_dictionary.length; i++) {
            if (intent.getStringArrayExtra(intent_dictionary[i]) != null) {
                message = intent.getStringArrayExtra(intent_dictionary[i]);
            }
        }
        TextView tv_product_name = findViewById(R.id.product_name_amazon);
        TextView tv_storage = findViewById(R.id.storage_amazon);
        TextView tv_company = findViewById(R.id.company_amazon);
        tv_product_name.setText(message[0]);
        tv_storage.setText(message[1]);
        tv_company.setText(message[2]);
    }

    private void set_table_tmall() {
        Intent intent = getIntent();
        String message[] = new String[3];
        for (int i = 0; i < intent_dictionary.length; i++) {
            if (intent.getStringArrayExtra(intent_dictionary[i]) != null) {
                message = intent.getStringArrayExtra(intent_dictionary[i]);
            }
        }
        TextView tv_product_name = findViewById(R.id.product_name_tmall);
        TextView tv_storage = findViewById(R.id.storage_tmall);
        TextView tv_company = findViewById(R.id.company_tmall);
        tv_product_name.setText(message[0]);
        tv_storage.setText(message[1]);
        tv_company.setText(message[2]);
    }

}
