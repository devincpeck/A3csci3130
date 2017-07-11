package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * defines how the detail view for a user-selected business will act
 * created by Juliano Franz, adapted by Devin Peck
 */

public class DetailViewActivity extends Activity {

    private EditText businessNumberField, nameField, primaryBusinessField, addressField, provinceField;
    Contact receivedBusinessInfo;
    String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Contact)getIntent().getSerializableExtra("Business");

        businessNumberField = (EditText) findViewById(R.id.businessNumber);
        nameField = (EditText) findViewById(R.id.name);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.provinceTerritory);

        /**
         * displays business data of user selection.
         */
        if(receivedBusinessInfo != null){
            businessNumberField.setText(receivedBusinessInfo.businessNumber);
            nameField.setText(receivedBusinessInfo.name);
            primaryBusinessField.setText(receivedBusinessInfo.primaryBusiness);
            addressField.setText(receivedBusinessInfo.address);
            provinceField.setText(receivedBusinessInfo.province);
            key = receivedBusinessInfo.uid;
        }
    }

    /**
     * updates the current data for the selected business.
     * @param v
     */

    public void updateBusiness(View v){
        String businessNumber = businessNumberField.getText().toString();
        String name = nameField.getText().toString();
        String primaryBusiness = primaryBusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();

        Contact business = new Contact(key, businessNumber, name, primaryBusiness, address, province);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference().getRoot().child("Businesses").child(key);
        database.setValue(business);
        finish();
    }

    /**
     * removes selected business info from the database.
     * @param v
     */

    public void eraseBusiness(View v)
    {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference().getRoot().child("Businesses").child(key);
        database.removeValue();
        finish();
    }
}
