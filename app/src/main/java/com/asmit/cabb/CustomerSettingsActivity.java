package com.asmit.cabb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerSettingsActivity extends AppCompatActivity {


    private EditText mNameField, mPhoneField;
    private Button mConfirm, mBack;

    private FirebaseAuth mAuth;
    private DatabaseReference mCustomerDatabase;

    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_settings);


        mNameField = (EditText) findViewById(R.id.name);
        mPhoneField = (EditText) findViewById(R.id.phone);


        mConfirm = (Button) findViewById(R.id.confirm);
        mBack = (Button) findViewById(R.id.back);


        mAuth =FirebaseAuth.getInstance();

        userID=mAuth.getCurrentUser().getUid();

        mCustomerDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child("Customers").child(userID);


    }
}
