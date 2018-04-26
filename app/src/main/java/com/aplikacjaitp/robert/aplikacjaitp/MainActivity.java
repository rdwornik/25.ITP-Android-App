package com.aplikacjaitp.robert.aplikacjaitp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    Button mCatalogButton;
    Button mOrganizersButton;
    Button mSponsorsButton;
    Button mWorkshopButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "onCreate: starts");

        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mCatalogButton = findViewById(R.id.button_catalog);
        mCatalogButton.setOnClickListener(this);

        mOrganizersButton = findViewById(R.id.button_organizers);
        mOrganizersButton.setOnClickListener(this);

        mSponsorsButton = findViewById(R.id.button_sponsors);
        mSponsorsButton.setOnClickListener(this);

        mWorkshopButton = findViewById(R.id.button_workshop);
        mWorkshopButton.setOnClickListener(this);

        getDatabaseRefernces();


        Log.d(TAG, "onCreate: ends");
    }


    @Override
    public void onClick(View v) {

        Log.d(TAG, "onClick: starts");

        if (v == mCatalogButton) {
            Intent intent = new Intent(MainActivity.this, CompanyListActivity.class);
            startActivity(intent);
        }else if(v==mOrganizersButton){
            Intent intent = new Intent(MainActivity.this, OrganizersActivity.class);
            startActivity(intent);
        }else if (v==mSponsorsButton){
            Intent intent = new Intent(MainActivity.this, SponsorActivity.class);
            startActivity(intent);
        }else if (v==mWorkshopButton){
            Intent intent = new Intent(MainActivity.this, WorkshopActivity.class);
            startActivity(intent);
        }

        Log.d(TAG, "onClick: ends");
    }

}
