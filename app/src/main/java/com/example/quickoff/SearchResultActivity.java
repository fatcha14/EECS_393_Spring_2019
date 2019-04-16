package com.example.quickoff;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SearchResultActivity extends AppCompatActivity {

    private Button add_btn_amazon;
    private Button getAdd_btn_tmall;
    private String product_name;
    private String company;
    private String source;
    private Double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);



        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search Result");

        set_table_amazon();

        add_btn_amazon = (Button) findViewById(R.id.add_btn_amaozn);
        getAdd_btn_tmall = (Button) findViewById(R.id.add_btn_tmall);


        add_btn_amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_table_amazon();
                PreferredListFragment.preferredList.add(new Product(true, product_name, price));
            }
        });

        getAdd_btn_tmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_table_tmall();
                PreferredListFragment.preferredList.add(new Product(false, product_name, price));
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
        price = Double.parseDouble(tmp_price_1);
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
        price = Double.parseDouble(tmp_price_1);
    }

    /*
    A method to initialize the amazon table
     */
    private void set_table_amazon() {
        Intent intent = getIntent();
        String message[] = intent.getStringArrayExtra("iPhone XS 64GB");
        TextView tv_product_name = findViewById(R.id.product_name_amazon);
        TextView tv_storage = findViewById(R.id.storage_amazon);
        tv_product_name.setText(message[0]);
        tv_storage.setText(message[1]);
    }

}
