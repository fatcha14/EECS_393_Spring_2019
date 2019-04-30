package com.example.quickoff;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;

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
            "S10 128GB", "S10 512GB",
            "S10+ 128GB", "S10+ 512GB",
            "S10e 128GB", "S10e 256GB",
            "Mi9 128GB", "Mi9 256GB"
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

        findProduct();

        // add selected amazon product to the preferred list
        add_btn_amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_table_amazon();
                PreferredListFragment.preferredList.add(new Product(true, product_name, price));
                Toast.makeText(SearchResultActivity.this, "Add Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        // add selected tmall product to the preferred list
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
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Intent intent = getIntent();
        String message[] = new String[3];
        boolean not_null = false;
        for (int i = 0; i < intent_dictionary.length; i++) {
            if (intent.getStringArrayExtra(intent_dictionary[i]) != null) {
                message = intent.getStringArrayExtra(intent_dictionary[i]);
                not_null = true;
            }
        }
        if (not_null) {
            StringBuilder sb = new StringBuilder();
            sb.append(message[0]);
            sb.append(" ");
            sb.append(message[1]);
            String search_query = sb.toString();
            Product amazon_product = dbHandler.findAmazonHandler(search_query);
            TextView tv_product_name = findViewById(R.id.product_name_amazon);
            TextView tv_storage = findViewById(R.id.storage_amazon);
            TextView tv_company = findViewById(R.id.company_amazon);
            TextView tv_price = findViewById(R.id.price_amazon);
            tv_product_name.setText(message[0]);
            tv_storage.setText(message[1]);
            tv_company.setText(message[2]);
            tv_price.setText(String.valueOf(amazon_product.getPrice()));
        }
    }

    /*
    A method to initialize the tmall table
    */
    private void set_table_tmall() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Intent intent = getIntent();
        String message[] = new String[3];
        boolean not_null = false;
        // check if the received intents match with intent dictionary to avoid retrieving
        // null object in the later search
        for (int i = 0; i < intent_dictionary.length; i++) {
            if (intent.getStringArrayExtra(intent_dictionary[i]) != null) {
                message = intent.getStringArrayExtra(intent_dictionary[i]);
                not_null = true;
            }
        }
        if (not_null) {
            StringBuilder sb = new StringBuilder();
            sb.append(message[0]);
            sb.append(" ");
            sb.append(message[1]);
            String search_query = sb.toString();
            Product tmall_product = dbHandler.findTmallHandler(search_query);
            TextView tv_product_name = findViewById(R.id.product_name_tmall);
            TextView tv_storage = findViewById(R.id.storage_tmall);
            TextView tv_company = findViewById(R.id.company_tmall);
            TextView tv_price = findViewById(R.id.price_tmall);
            tv_product_name.setText(message[0]);
            tv_storage.setText(message[1]);
            tv_company.setText(message[2]);
            tv_price.setText(String.valueOf(tmall_product.getPrice()));
        }
    }

    /*
    Search for the product by the input received from frontend
     */
    public void findProduct() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        Intent intent = getIntent();
        if (intent.getStringExtra("Field_Input") != null) {
            String message = intent.getStringExtra("Field_Input");

            // setup for the table, retrive the references of UI elements for further use
            Product amazon_product = dbHandler.findAmazonHandler(message);  // not ready

            TextView name_amazon = (TextView) this.findViewById(R.id.product_name_amazon);
            TextView price_amazon = (TextView) this.findViewById(R.id.price_amazon);
            TextView company_amazon = (TextView) this.findViewById(R.id.company_amazon);
            TextView source_amazon = (TextView) this.findViewById(R.id.source_amazon);
            TextView storage_amazon = (TextView) this.findViewById(R.id.storage_amazon);

            Product tmall_product = dbHandler.findTmallHandler(message);  // not ready

            TextView name_tmall = (TextView) this.findViewById(R.id.product_name_tmall);
            TextView price_tmall = (TextView) this.findViewById(R.id.price_tmall);
            TextView company_tmall = (TextView) this.findViewById(R.id.company_tmall);
            TextView source_tmall = (TextView) this.findViewById(R.id.source_tmall);
            TextView storage_tmall = (TextView) this.findViewById(R.id.storage_tmall);

            // while these two products objects are not null, get the attributes from them
            // and set them for display
            if (amazon_product == null && tmall_product == null) {
                Toast.makeText(this, "No Product Found", Toast.LENGTH_SHORT).show();
            }

            else if  (amazon_product == null) {
                Toast.makeText(this, "No Product Found in Amazon", Toast.LENGTH_SHORT).show();
            }
            else if (tmall_product == null) {
                Toast.makeText(this, "No Product Found in Tmall", Toast.LENGTH_SHORT).show();
            }
            else {
                name_amazon.setText(message);
                price_amazon.setText(String.valueOf(amazon_product.getPrice()));
                company_amazon.setText(amazon_product.getDescription());
                source_amazon.setText("Amazon");
                storage_amazon.setText(findStorage(amazon_product.getName()));


                name_tmall.setText(message);
                price_tmall.setText(String.valueOf(tmall_product.getPrice()));
                company_tmall.setText(tmall_product.getDescription());
                source_tmall.setText("Tmall");
                storage_tmall.setText(findStorage(tmall_product.getName()));
            }
        }
    }

    // a method to parse the phone name to retrieve the storage
    public String findStorage(String input){
        int index = 0;
        int[] number = new int[3];
        boolean rem = false;
        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i) == 'G') {
                index = i;
            }
            else if(input.charAt(i) == 'B' && i == index + 1){
                break;
            }
        }

        number[2] = Character.getNumericValue(input.charAt(index-1));
        number[1] = Character.getNumericValue(input.charAt(index-2));
        char check = input.charAt(index - 3);
        if(check == ' ' || check == '(' || check ==  '+'){
            number[0] =  0;
        }
        else{
            number[0] = Character.getNumericValue(check);
        }
        String result = Arrays.toString(number);
        result = result.replaceAll(", ", "").replace("[", "").replace("]", "");
        return  result;
    }


}
