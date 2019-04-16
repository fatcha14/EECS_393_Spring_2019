package com.example.quickoff;

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

    private void get_table_amazon() {
        TextView tmp_product_name = (TextView) findViewById(R.id.product_name_amazon);
        product_name = tmp_product_name.getText().toString();

        TextView tmp_company = (TextView) findViewById(R.id.company_amazon);
        company = tmp_company.getText().toString();

        TextView tmp_source = (TextView) findViewById(R.id.source_amazon);
        source = tmp_source.getText().toString();

        TextView tmp_price = (TextView) findViewById(R.id.price_amazon);
        String tmp_price_1 = tmp_price.getText().toString();
        tmp_price_1.replaceAll("[^\\d.]", "");
        price = Double.parseDouble(tmp_price_1);
    }

    private void get_table_tmall() {
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

}
