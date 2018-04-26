package com.aplikacjaitp.robert.aplikacjaitp;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class CompanyListActivity extends BaseActivity {

    private static final String TAG = "SavedCompanyListActivit";
    private DatabaseReference mFacultiesReference;
    private RecyclerView mRecyclerView;
    private SearchView mSearchView;
    private String faculty = "Wszystkie";
    private String search = "";
    public SharedPreferences savedSearch;
    private Toast t;
    private int day = 3;
    public static final String STATE_FACULTY = "faculty";
    public static final String STATE_DAY = "day";
    public static final String STATE_SEARCH = "search";

    private String searchFaculty;
    private int searchDay;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        activateToolbar();
        isConnected();

        savedSearch = getSharedPreferences(SEARCH_NAME, MODE_PRIVATE);

        getDatabaseRefernces();
        mFacultiesReference = BaseActivity.mFacultiesReference;
        mRecyclerView = findViewById(R.id.all_companies_recycler_view);

        SharedPreferences settings;
        settings = getSharedPreferences(SEARCH_FACULTY_AND_DAY, Context.MODE_PRIVATE);



        searchFaculty = settings.getString(KEY_FACULTY, "Wszystkie");
        searchDay = settings.getInt(KEY_DAY,3);


        if (savedInstanceState != null) {
            faculty = savedInstanceState.getString(STATE_FACULTY);
            day = savedInstanceState.getInt(STATE_DAY);
            search = savedInstanceState.getString(STATE_SEARCH);
        }else {
            day = searchDay;
            faculty = searchFaculty;
        }

         if(day != 3)
                    t = Toast.makeText(CompanyListActivity.this, "Wybrany kierunek: " + faculty +"\n"+ "Dzień: " + day, Toast.LENGTH_LONG);
                else
                    t = Toast.makeText(CompanyListActivity.this, "Wybrany kierunek: " + faculty + "\n" + "Dzień: 1 i 2", Toast.LENGTH_LONG);

                t.show();
        setUpFirebaseCompanyAdapter(faculty, day, search, mFacultiesReference, mRecyclerView, CompanyListActivity.this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_FACULTY, faculty);
        outState.putInt(STATE_DAY, day);
        search = mSearchView.getQuery().toString();
        outState.putString(STATE_SEARCH, search);

    }

    @Override
    protected void onStart() {
        super.onStart();
        setOnStartListener();

    }

    @Override
    protected void onStop() {
        super.onStop();
        removeOnStopListener();
    }



    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        mSearchView = (SearchView) menu.findItem(R.id.action_search).getActionView();


        if (search != null && !search.equals("")) {
            mSearchView.setIconified(false);
            mSearchView.setIconifiedByDefault(false);
            mSearchView.setQuery(search, true);
        } else {
            mSearchView.setIconified(true);
            mSearchView.setIconifiedByDefault(true);
        }



        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());
        mSearchView.setSearchableInfo(searchableInfo);

        int options = mSearchView.getImeOptions();
        mSearchView.setImeOptions(options | EditorInfo.IME_FLAG_NO_EXTRACT_UI);

        wtorek = menu.findItem(R.id.wtorek);
        sroda = menu.findItem(R.id.sroda);


        wszyskie = menu.findItem(R.id.wszystkie);

        kierunek1 = menu.findItem(R.id.kierunek1);
        kierunek2 = menu.findItem(R.id.kierunek2);
        kierunek3 = menu.findItem(R.id.kierunek3);
        kierunek4 = menu.findItem(R.id.kierunek4);
        kierunek5 = menu.findItem(R.id.kierunek5);
        kierunek6 = menu.findItem(R.id.kierunek6);
        kierunek7 = menu.findItem(R.id.kierunek7);
        kierunek8 = menu.findItem(R.id.kierunek8);
        kierunek9 = menu.findItem(R.id.kierunek9);
        kierunek10 = menu.findItem(R.id.kierunek10);
        kierunek11 = menu.findItem(R.id.kierunek11);
        kierunek12 = menu.findItem(R.id.kierunek12);
        kierunek13 = menu.findItem(R.id.kierunek13);
        kierunek14 = menu.findItem(R.id.kierunek14);
        kierunek15 = menu.findItem(R.id.kierunek15);
        kierunek16 = menu.findItem(R.id.kierunek16);
        kierunek17 = menu.findItem(R.id.kierunek17);
        kierunek18 = menu.findItem(R.id.kierunek18);
        kierunek19 = menu.findItem(R.id.kierunek19);
        kierunek20 = menu.findItem(R.id.kierunek20);
        kierunek21 = menu.findItem(R.id.kierunek21);
        kierunek22 = menu.findItem(R.id.kierunek22);
        kierunek23 = menu.findItem(R.id.kierunek23);
        kierunek24 = menu.findItem(R.id.kierunek24);
        kierunek25 = menu.findItem(R.id.kierunek25);
        kierunek26 = menu.findItem(R.id.kierunek26);
        kierunek27 = menu.findItem(R.id.kierunek27);
        kierunek28 = menu.findItem(R.id.kierunek28);
        kierunek29 = menu.findItem(R.id.kierunek29);
        kierunek30 = menu.findItem(R.id.kierunek30);
        kierunek31 = menu.findItem(R.id.kierunek31);



        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                saveData(query);
                saveDayAndFaculty(faculty,day);
                search = query;
                Intent intent = new Intent(CompanyListActivity.this, CompanyListSearchedActivity.class);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search = newText;

                setUpFirebaseCompanyAdapter(faculty, day, search, mFacultiesReference, mRecyclerView, CompanyListActivity.this);
                return true;
            }
        });

        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {

                if(day != 3)
                    t = Toast.makeText(CompanyListActivity.this, "Wybrany kierunek: " + faculty +"\n"+ "Dzień: " + day, Toast.LENGTH_LONG);
                else
                    t = Toast.makeText(CompanyListActivity.this, "Wybrany kierunek: " + faculty + "\n" + "Dzień: 1 i 2", Toast.LENGTH_LONG);

                t.show();

               setUpFirebaseCompanyAdapter(faculty, day, search, mFacultiesReference, mRecyclerView, CompanyListActivity.this);
               setItemsSelectedOnCreateMenu(faculty, day,
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
               return false;
            }
        });

            setItemsSelectedOnCreateMenu(faculty, day,
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

        Log.d(TAG, "Menu: start day " + day);
        Log.d(TAG, "Menu: start searchDay " + searchDay);

        return true;
    }

    private void saveData(String query) {
        SharedPreferences.Editor preferencesEditor = savedSearch.edit();
        preferencesEditor.putString(QUERY_NAME, query);
        preferencesEditor.apply();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        int x = 1;

        switch (id) {

            case R.id.kierunek1:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY1;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek2:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY2;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek3:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY3;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek4:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY4;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek5:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY5;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek6:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY6;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek7:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY7;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek8:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY8;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek9:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY9;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek10:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY10;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek11:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY11;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek12:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY12;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek13:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY13;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek14:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY14;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek15:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY15;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek16:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY16;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek17:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY17;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek18:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY18;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek19:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY19;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek20:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY20;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek21:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY21;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek22:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY22;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek23:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY23;
                  }else {
                    x = 0;
                }
            case R.id.kierunek24:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = FACULTY24;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek25:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY25;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek26:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY26;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek27:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY27;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek28:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY28;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek29:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY29;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek30:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY30;
                 }else {
                    x = 0;
                }
                break;
            case R.id.kierunek31:
                 if (!item.isChecked()) {
                    item.setChecked(true);
                faculty = FACULTY31; }
                else {
                    x = 0;
                }
                break;
            case R.id.wszystkie:
                if (!item.isChecked()) {
                    item.setChecked(true);
                    faculty = "Wszystkie";
                }else{
                    x = 0;
                }
                break;
            case R.id.wtorek:
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
            case R.id.sroda:
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

        if ( x==1 )
        setUpFirebaseCompanyAdapter(faculty, day, search, mFacultiesReference, mRecyclerView, CompanyListActivity.this);

        return true;
    }
    @Override
    public void onItemClick(View view, int position) {
        Log.d(TAG, "onItemClick: starts");
        super.onItemClick(view, position);
        Toast.makeText(CompanyListActivity.this, "Przytrzymaj by wyświetlić", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        super.onItemLongClick(view, position);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveDayAndFaculty(faculty,day);
    }
}