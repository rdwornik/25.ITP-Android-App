package com.aplikacjaitp.robert.aplikacjaitp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aplikacjaitp.robert.aplikacjaitp.model.Company;
import com.aplikacjaitp.robert.aplikacjaitp.utils.Constants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.apache.commons.lang3.text.WordUtils;

import java.util.ArrayList;

/**
 * Created by robert on 1/30/18.
 */

public class BaseActivity extends AppCompatActivity implements RecyclerItemClickListener.OnRecyclerClickListener  {
    private static final String TAG = "BaseActivity";

    static final String COMPANY_TRANSFER = "COMPANY_TRANSFER";
    static final String SEARCH_NAME = "SEARCH_NAME";
    static final String SEARCH_FACULTY_AND_DAY = "SEARCH_FACULTY_AND_DAY";
    static final String QUERY_NAME= "QUERY_NAME";
    static final String KEY_FACULTY= "KEY_FACULTY";
    static final String KEY_DAY = "KEY_DAY";

    static final String FACULTY1 =  "Administracja";
    static final String FACULTY2 =  "Architektura";
    static final String FACULTY3 =  "Automatyka i robotyka";
    static final String FACULTY4 =  "Biotechnologia";
    static final String FACULTY5 =  "Budownictwo";
    static final String FACULTY6 =  "Ekonomia";
    static final String FACULTY7 =  "Elektronika";
    static final String FACULTY8 =  "Elektrotechnika";
    static final String FACULTY9 =  "Energetyka";
    static final String FACULTY10 =  "Fizyka techniczna";
    static final String FACULTY11 =  "Fotonika";
    static final String FACULTY12 =  "Geodezja i kartografia";
    static final String FACULTY13 =  "Geoinformatyka";
    static final String FACULTY14 =  "Gospodarka przestrzenna";
    static final String FACULTY15 =  "Informatyka";
    static final String FACULTY16 =  "Inżynieria biomedyczna";
    static final String FACULTY17 =  "Inyżnieria chemiczna i procesowa";
    static final String FACULTY18 =  "Inżynieria materiałowa";
    static final String FACULTY19 =  "Inżynieria pojazdów elektrycznych i hybrydowych";
    static final String FACULTY20 = "Inżynieria środowiska";
    static final String FACULTY21 =  "Lotnictwo i Kosmonautyka";
    static final String FACULTY22 =  "Matematyka";
    static final String FACULTY23 =  "Mechanika i budowa maszyn";
    static final String FACULTY24 =  "Mechatronika";
    static final String FACULTY25 =  "Ochrona środowiska";
    static final String FACULTY26 =  "Papiernictwo i Politgrafia";
    static final String FACULTY27 =  "Technologia Chemiczna";
    static final String FACULTY28 =  "Telekomunikacja";
    static final String FACULTY29 =  "Transport";
    static final String FACULTY30 =  "Zarządzanie";
    static final String FACULTY31 =  "Zarządanie i inzynieria produkcji";


    FirebaseRecyclerAdapter<Company,FirebaseCompanyViewHolder> mFrirebaseAdapter;
    Query firebaseSearchQuery;
    ChildEventListener mCompanyListener;
    ArrayList<Company> companyArrayList;

    public static DatabaseReference mFacultiesReference;
    public static DatabaseReference mOrganizersReference;
    public static DatabaseReference mWorkshopReference;
    public static DatabaseReference mSponsorReference;

    private DatabaseReference connectedRef;
    private Application application;


    void activateToolbar() {                            //allows to go back to previous context by arrow showed on toolbar
        Log.d(TAG, "activateToolbar: starts");
        ActionBar actionBar = getSupportActionBar();
        if(actionBar == null) {
            Toolbar toolbar =  findViewById(R.id.toolbar);

            if(toolbar != null) {
                setSupportActionBar(toolbar);
                actionBar = getSupportActionBar();
            }
        }
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    void setOnStartListener(){

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Log.d(TAG, "onChildAdded: " + dataSnapshot.getValue(Company.class).getName());
                companyArrayList.add(dataSnapshot.getValue(Company.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        firebaseSearchQuery.addChildEventListener(childEventListener);
        mCompanyListener = childEventListener;
    }

    void removeOnStopListener(){
        if(mCompanyListener != null){
            firebaseSearchQuery.removeEventListener(mCompanyListener);
        }
    }

    void setUpFirebaseCompanyAdapter(String itemSelected, int day, String companyName, DatabaseReference mFacultiesRefernce, final RecyclerView mRecyclerView, Context ctx){

        switch (day) {
            case 1:
                firebaseSearchQuery = mFacultiesRefernce.child(itemSelected).orderByChild("day1").startAt(companyName.toLowerCase()).endAt(companyName.toLowerCase() + "\uf8ff");
                break;
            case 2:
                firebaseSearchQuery = mFacultiesRefernce.child(itemSelected).orderByChild("day2").startAt(companyName.toLowerCase()).endAt(companyName.toLowerCase() + "\uf8ff");

                break;
            case 3:
                firebaseSearchQuery = mFacultiesRefernce.child(itemSelected).orderByChild("name").startAt(companyName.toLowerCase()).endAt(companyName.toLowerCase() + "\uf8ff");
                break;
            default:
                firebaseSearchQuery = mFacultiesRefernce.child(itemSelected).orderByChild("name").startAt(companyName.toLowerCase()).endAt(companyName.toLowerCase() + "\uf8ff");
                break;
        }

        companyArrayList = new ArrayList<>();

            mFrirebaseAdapter = new FirebaseRecyclerAdapter<Company, FirebaseCompanyViewHolder>(
                    Company.class,
                    R.layout.browse_companies,
                    FirebaseCompanyViewHolder.class,
                    firebaseSearchQuery) {

                @Override
                protected void populateViewHolder(FirebaseCompanyViewHolder viewHolder, final Company model, int position) {
                    viewHolder.bindCompany(model);
                }

            };

            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(ctx));
            mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(ctx, mRecyclerView, this));
            mRecyclerView.setAdapter(mFrirebaseAdapter);

    }

    void setItemsSelectedOnCreateMenu(String kierunek, int day,
                                      MenuItem wszyskie,
                                      MenuItem wtorek,
                                      MenuItem sroda,
                                      MenuItem kierunek1,
                                      MenuItem kierunek2,
                                      MenuItem kierunek3,
                                      MenuItem kierunek4,
                                      MenuItem kierunek5,
                                      MenuItem kierunek6,
                                      MenuItem kierunek7,
                                      MenuItem kierunek8,
                                      MenuItem kierunek9,
                                      MenuItem kierunek10,
                                      MenuItem kierunek11,
                                      MenuItem kierunek12,
                                      MenuItem kierunek13,
                                      MenuItem kierunek14,
                                      MenuItem kierunek15,
                                      MenuItem kierunek16,
                                      MenuItem kierunek17,
                                      MenuItem kierunek18,
                                      MenuItem kierunek19,
                                      MenuItem kierunek20,
                                      MenuItem kierunek21,
                                      MenuItem kierunek22,
                                      MenuItem kierunek23,
                                      MenuItem kierunek24,
                                      MenuItem kierunek25,
                                      MenuItem kierunek26,
                                      MenuItem kierunek27,
                                      MenuItem kierunek28,
                                      MenuItem kierunek29,
                                      MenuItem kierunek30,
                                      MenuItem kierunek31
                                      ){

        switch (kierunek) {

            case FACULTY1:
                kierunek1.setChecked(true);
                break;
            case FACULTY2:
                kierunek2.setChecked(true);
                break;
            case FACULTY3:
                kierunek3.setChecked(true);
                break;
            case FACULTY4:
                kierunek4.setChecked(true);
                break;
            case FACULTY5:
                kierunek5.setChecked(true);
                break;
            case FACULTY6:
                kierunek6.setChecked(true);
                break;
            case FACULTY7:
                kierunek7.setChecked(true);
                break;
            case FACULTY8:
                kierunek8.setChecked(true);
                break;
            case FACULTY9:
                kierunek9.setChecked(true);
                break;
            case FACULTY10:
                kierunek10.setChecked(true);
                break;
            case FACULTY11:
                kierunek11.setChecked(true);
                break;
            case FACULTY12:
                kierunek12.setChecked(true);
                break;
            case FACULTY13:
                kierunek13.setChecked(true);
                break;
            case FACULTY14:
                kierunek14.setChecked(true);
                break;
            case FACULTY15:
                kierunek15.setChecked(true);
                break;
            case FACULTY16:
                kierunek16.setChecked(true);
                break;
            case FACULTY17:
                kierunek17.setChecked(true);
                break;
            case FACULTY18:
                kierunek18.setChecked(true);
                break;
            case FACULTY19:
                kierunek19.setChecked(true);
                break;
            case FACULTY20:
                kierunek20.setChecked(true);
                break;
            case FACULTY21:
                kierunek21.setChecked(true);
                break;
            case FACULTY22:
                kierunek22.setChecked(true);
                break;
            case FACULTY23:
                kierunek23.setChecked(true);
                break;
            case FACULTY24:
                kierunek24.setChecked(true);
                break;
            case FACULTY25:
                kierunek25.setChecked(true);
                break;
            case FACULTY26:
                kierunek26.setChecked(true);
                break;
            case FACULTY27:
                kierunek27.setChecked(true);
                break;
            case FACULTY28:
                kierunek28.setChecked(true);
                break;
            case FACULTY29:
                kierunek29.setChecked(true);
                break;
            case FACULTY30:
                kierunek30.setChecked(true);
                break;
            case FACULTY31:
                kierunek31.setChecked(true);
                break;
            case "Wszystkie":
                wszyskie.setChecked(true);
                break;
        }
        switch (day){
            case 0:
                if(wtorek.isChecked())
                    wtorek.setChecked(false);
                if(sroda.isChecked())
                    sroda.setChecked(false);
                break;
            case 1:
                if(!wtorek.isChecked())
                    wtorek.setChecked(true);
                if(sroda.isChecked())
                    sroda.setChecked(false);
                break;
            case 2:
                if(wtorek.isChecked())
                    wtorek.setChecked(false);
                if(!sroda.isChecked())
                    sroda.setChecked(true);
                break;
            case 3:
                if(!wtorek.isChecked())
                    wtorek.setChecked(true);
                if(!sroda.isChecked())
                    sroda.setChecked(true);
                break;
        }
    }


     void getDatabaseRefernces(){

        mFacultiesReference = FirebaseDatabase.getInstance().getReference(Constants.FACULTIES);
        mFacultiesReference.keepSynced(true);

        mOrganizersReference = FirebaseDatabase.getInstance().getReference(Constants.ORGANIZERS);
        mOrganizersReference.keepSynced(true);

        mWorkshopReference = FirebaseDatabase.getInstance().getReference(Constants.WORKSHOPS);
        mWorkshopReference.keepSynced(true);

        mSponsorReference = FirebaseDatabase.getInstance().getReference(Constants.SPONSORS);
        mSponsorReference.keepSynced(true);
    }

     void dataProcessingAlert() {
        AlertDialog.Builder a_builder = new AlertDialog.Builder(BaseActivity.this);
        a_builder.setMessage("W celu załadowania danych prosimy o jednorazowe podłączenie do internetu")
                .setCancelable(false)
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.setTitle("Info");
        alert.show();
    }

    void setDetailView(Activity activity){
        Intent intent = getIntent();
        Company company = (Company) intent.getSerializableExtra(COMPANY_TRANSFER);

        if(company != null) {

            Resources resources = getResources();

            String companyName = company.getName();
            String capitalized = WordUtils.capitalizeFully(companyName);

            TextView name = findViewById(R.id.company_detail_name);
            String text = resources.getString(R.string.company_name,capitalized);
            name.setText(text.toUpperCase());

            TextView day = findViewById(R.id.company_detail_day);
            day.setText(Html.fromHtml("<b>"+"Dzień: " + "</b>" +company.getDay()));

            switch (company.getDay()) {
                case "a":
                    day.setText(Html.fromHtml("<b>"+"Dzień:" + "</b> 1"));
                    break;
                case "c":
                    day.setText(Html.fromHtml("<b>"+"Dzień:" + "</b> 2"));
                    break;
                case "b":
                    day.setText(Html.fromHtml("<b>"+"Dzień: " + "</b> 1 i 2" ));
                    break;
            }
            Log.d(TAG, "setDetailView: " + company.getDescription());
            TextView stundNumber = findViewById(R.id.company_detail_stundNumber);
            stundNumber.setText(Html.fromHtml("<b>"+"Numer Stoiska: " + "</b>" +company.getStandNumber()));

            TextView description = findViewById(R.id.company_detail_description);
            description.setText(Html.fromHtml("<b>"+"Opis: " + "</b>" + company.getDescription()));
            TextView faculties = findViewById(R.id.company_detail_faculties);
            faculties.setText(Html.fromHtml("<b>"+"Kierunki: " + "</b>" +company.getFaculties()));


            final ImageView logoImage = findViewById(R.id.company_detail_logo);

//            Picasso.with(activity).load(company.getLogoLink())
//                    .error(R.drawable.placeholder)
//                    .into(logoImage);

            Glide.with(activity)
                    .load(company.getLogoLink())
                    .asBitmap()
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(R.drawable.placeholder)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            logoImage.setImageBitmap(resource);
                        }
                    });
        }

    }

    void saveDayAndFaculty(String faculty, int day){
        SharedPreferences settings;
        settings = getSharedPreferences(SEARCH_FACULTY_AND_DAY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(KEY_FACULTY, faculty);
        editor.putInt(KEY_DAY, day);
        editor.commit();
    }

     void isConnected(){

         connectedRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://aplikacjaitp.firebaseio.com/.info/connected");
         application = new Application();

         getDatabaseRefernces();

         connectedRef.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 boolean connected = dataSnapshot.getValue(Boolean.class);
                 if (connected) {

                 } else {
                     Log.d(TAG, "onDataChange on MainActivity: not connected");
                     dataProcessingAlert();
                 }
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {

             }
         });
    }
    @Override
    public void onItemLongClick(View view, int position) {
        Log.d(TAG, "onItemLongClick: starts");
        Intent intent = new Intent(this, CompanyDetailActivity.class);
        intent.putExtra(COMPANY_TRANSFER, mFrirebaseAdapter.getItem(position));
        startActivity(intent);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d(TAG, "onItemClick: starts");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mFrirebaseAdapter !=null)
            mFrirebaseAdapter.cleanup();
    }
}
