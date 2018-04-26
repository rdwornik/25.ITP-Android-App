package com.aplikacjaitp.robert.aplikacjaitp;

import android.os.Bundle;
import android.support.v4.app.NavUtils;

public class CompanyDetailActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail);

        activateToolbar();
        setDetailView(CompanyDetailActivity.this);

        }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        NavUtils.navigateUpFromSameTask(this);
    }
}
