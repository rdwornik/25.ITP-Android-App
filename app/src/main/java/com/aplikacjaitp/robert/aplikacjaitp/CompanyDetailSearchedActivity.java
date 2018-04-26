package com.aplikacjaitp.robert.aplikacjaitp;

import android.os.Bundle;
import android.support.v4.app.NavUtils;

public class CompanyDetailSearchedActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail_searched);

        activateToolbar();
        setDetailView(CompanyDetailSearchedActivity.this);
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
