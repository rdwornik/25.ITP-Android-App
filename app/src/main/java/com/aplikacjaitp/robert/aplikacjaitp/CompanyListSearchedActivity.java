package com.aplikacjaitp.robert.aplikacjaitp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class CompanyListSearchedActivity extends BaseActivity {
    private static final String TAG = "CompanyListSearchedActi";

    private DatabaseReference mFacultiesReference;
    private RecyclerView mRecyclerView;
    SharedPreferences sharedPreferences;
    private String queryResult;
    private String faculty = "Wszystkie";
    private int day = 3;
    public static final String STATE_FACULTY = "faculty";
    public static final String STATE_DAY = "day";


    MenuItem wtorek;
    MenuItem sroda;
    MenuItem wszyskie;

    MenuItem kierunek1;
    MenuItem kierunek2;
    MenuItem kierunek3;
    MenuItem kierunek4;
    MenuItem kierunek5;
    MenuItem kierunek6;
    MenuItem kierunek7;
    MenuItem kierunek8;
    MenuItem kierunek9;
    MenuItem kierunek10;
    MenuItem kierunek11;
    MenuItem kierunek12;
    MenuItem kierunek13;
    MenuItem kierunek14;
    MenuItem kierunek15;
    MenuItem kierunek16;
    MenuItem kierunek17;
    MenuItem kierunek18;
    MenuItem kierunek19;
    MenuItem kierunek20;
    MenuItem kierunek21;
    MenuItem kierunek22;
    MenuItem kierunek23;
    MenuItem kierunek24;
    MenuItem kierunek25;
    MenuItem kierunek26;
    MenuItem kierunek27;
    MenuItem kierunek28;
    MenuItem kierunek29;
    MenuItem kierunek30;
    MenuItem kierunek31;


    Toast t;

    private String searchFaculty;
    private int searchDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list_searched);



        sharedPreferences = getSharedPreferences(SEARCH_NAME, MODE_PRIVATE);
        queryResult = sharedPreferences.getString(QUERY_NAME, "");

        ActionBar actionBar = getSupportActionBar();
        if(actionBar == null) {
            Toolbar toolbar =  findViewById(R.id.toolbarsearched);

            if(toolbar != null) {
                setSupportActionBar(toolbar);
                actionBar = getSupportActionBar();
            }
        }
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Wyszukane firmy: " + queryResult.toUpperCase());
        }


        mRecyclerView = findViewById(R.id.company_searched_recycler_view);
        mFacultiesReference = MainActivity.mFacultiesReference;



        SharedPreferences settings;
        settings = getSharedPreferences(SEARCH_FACULTY_AND_DAY, Context.MODE_PRIVATE);

        searchFaculty = settings.getString(KEY_FACULTY, "Wszystkie");
        searchDay = settings.getInt(KEY_DAY,3);



        if (savedInstanceState != null){
            faculty = savedInstanceState.getString(STATE_FACULTY);
            day = savedInstanceState.getInt(STATE_DAY);
        }else {
            day = searchDay;
            faculty = searchFaculty;
        }

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,mRecyclerView,this));

         if(day != 3)
                    t = Toast.makeText(CompanyListSearchedActivity.this, "Wybrany kierunek: " + faculty +"\n"+ "Dzień: " + day, Toast.LENGTH_LONG);
                else
                    t = Toast.makeText(CompanyListSearchedActivity.this, "Wybrany kierunek: " + faculty + "\n" + "Dzień: 1 i 2", Toast.LENGTH_LONG);

                t.show();

        setUpFirebaseCompanyAdapter(faculty, day, queryResult, mFacultiesReference, mRecyclerView, CompanyListSearchedActivity.this);

    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_FACULTY, faculty);
        outState.putInt(STATE_DAY,day);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        wtorek = menu.findItem(R.id.search_wtorek);
        sroda = menu.findItem(R.id.search_sroda);
        wszyskie = menu.findItem(R.id.search_wszystkie);


        kierunek1 = menu.findItem(R.id.search_kierunek1);
        kierunek2 = menu.findItem(R.id.search_kierunek2);
        kierunek3 = menu.findItem(R.id.search_kierunek3);
        kierunek4 = menu.findItem(R.id.search_kierunek4);
        kierunek5 = menu.findItem(R.id.search_kierunek5);
        kierunek6 = menu.findItem(R.id.search_kierunek6);
        kierunek7 = menu.findItem(R.id.search_kierunek7);
        kierunek8 = menu.findItem(R.id.search_kierunek8);
        kierunek9 = menu.findItem(R.id.search_kierunek9);
        kierunek10 = menu.findItem(R.id.search_kierunek10);
        kierunek11 = menu.findItem(R.id.search_kierunek11);
        kierunek12 = menu.findItem(R.id.search_kierunek12);
        kierunek13 = menu.findItem(R.id.search_kierunek13);
        kierunek14 = menu.findItem(R.id.search_kierunek14);
        kierunek15 = menu.findItem(R.id.search_kierunek15);
        kierunek16 = menu.findItem(R.id.search_kierunek16);
        kierunek17 = menu.findItem(R.id.search_kierunek17);
        kierunek18 = menu.findItem(R.id.search_kierunek18);
        kierunek19 = menu.findItem(R.id.search_kierunek19);
        kierunek20 = menu.findItem(R.id.search_kierunek20);
        kierunek21 = menu.findItem(R.id.search_kierunek21);
        kierunek22 = menu.findItem(R.id.search_kierunek22);
        kierunek23 = menu.findItem(R.id.search_kierunek23);
        kierunek24 = menu.findItem(R.id.search_kierunek24);
        kierunek25 = menu.findItem(R.id.search_kierunek25);
        kierunek26 = menu.findItem(R.id.search_kierunek26);
        kierunek27 = menu.findItem(R.id.search_kierunek27);
        kierunek28 = menu.findItem(R.id.search_kierunek28);
        kierunek29 = menu.findItem(R.id.search_kierunek29);
        kierunek30 = menu.findItem(R.id.search_kierunek30);
        kierunek31 = menu.findItem(R.id.search_kierunek31);


        setItemsSelectedOnCreateMenu(faculty,day,
                wszyskie,
                wtorek,
                sroda,
                kierunek1,
                kierunek2,
                kierunek3,
                kierunek4,
                kierunek5,
                kierunek6,
                kierunek7,
                kierunek8,
                kierunek9,
                kierunek10,
                kierunek11,
                kierunek12,
                kierunek13,
                kierunek14,
                kierunek15,
                kierunek16,
                kierunek17,
                kierunek18,
                kierunek19,
                kierunek20,
                kierunek21,
                kierunek22,
                kierunek23,
                kierunek24,
                kierunek25,
                kierunek26,
                kierunek27,
                kierunek28,
                kierunek29,
                kierunek30,
                kierunek31);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        int x =1;

        switch (id){
            case R.id.search_kierunek1:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY1;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek2:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY2;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek3:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY3;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek4:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY4;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek5:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY5;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek6:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY6;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek7:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY7;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek8:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY8;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek9:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY9;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek10:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY10;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek11:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY11;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek12:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY12;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek13:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY13;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek14:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY14;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek15:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY15;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek16:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY16;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek17:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY17;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek18:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY18;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek19:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY19;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek20:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY20;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek21:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY21;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek22:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY22;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek23:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY23;
                }else {
                    x = 0;
                }
            case R.id.search_kierunek24:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY24;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek25:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY25;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek26:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY26;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek27:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY27;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek28:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY28;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek29:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY29;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek30:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY30;
                }else {
                    x = 0;
                }
                break;
            case R.id.search_kierunek31:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY31; }
                else {
                    x = 0;
                }
                break;
            case R.id.search_wszystkie:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = "Wszystkie";
                }else{
                    x = 0;
                }
                break;
            case R.id.search_wtorek:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    day = 3;
                } else {
                    if (!sroda.isChecked()) {
                        day = 1;
                    }
                    else {
                        item.setChecked(false);
                        day = 2;
                    }
                }
                break;
            case R.id.search_sroda:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    day = 3;
                } else {
                    if (!wtorek.isChecked()) {
                        day = 2;
                    }
                    else {
                        item.setChecked(false);
                        day = 1;
                    }
                }
                break;
            default:
                return super.onOptionsItemSelected(item);

        }

        if (x == 1)
        setUpFirebaseCompanyAdapter(faculty, day,queryResult,mFacultiesReference,mRecyclerView, CompanyListSearchedActivity.this);
        return true;
    }

    @Override
    public void onItemClick(View view, int position) {
        super.onItemClick(view, position);
        Toast.makeText(CompanyListSearchedActivity.this, "Przytrzymaj by wyświetlić", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onItemLongClick(View view, int position) {
        Intent intent = new Intent(this, CompanyDetailSearchedActivity.class);
        intent.putExtra(COMPANY_TRANSFER, mFrirebaseAdapter.getItem(position));
        startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveDayAndFaculty(faculty,day);
    }
}