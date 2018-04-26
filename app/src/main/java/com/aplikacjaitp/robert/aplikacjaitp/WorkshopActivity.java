package com.aplikacjaitp.robert.aplikacjaitp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aplikacjaitp.robert.aplikacjaitp.adapters.WorkshopRecyclerAdapter;
import com.aplikacjaitp.robert.aplikacjaitp.model.Workshop;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class WorkshopActivity extends BaseActivity {

    private DatabaseReference mWorkshopReference;
    RecyclerView mRecyclerViewDay1;
    RecyclerView mRecyclerViewDay2;
    TextView day1;
    TextView day2;
    Query firebaseWorkshopQuery;
    ArrayList<Workshop> workshopArrayListDay1;
    ArrayList<Workshop> workshopArrayListDay2;

    Button mButtonWorkshopSignIn;

    private static final String TAG = "WorkshopActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops);

        activateToolbar();
        workshopButtonClicked();        //checks if there is internet connection otherwise you can't sign for workshop and gives allert to user
        isConnected();

        mRecyclerViewDay1 = findViewById(R.id.workshop_rv_day1);
        mRecyclerViewDay2 = findViewById(R.id.workshop_rv_day2);

        day1 =findViewById(R.id.workshop_day1);
        day2 =findViewById(R.id.workshop_day2);

        day1.setText(R.string.workshop_day1);
        day2.setText(R.string.workshop_day2);

        getDatabaseRefernces();
        mWorkshopReference = BaseActivity.mWorkshopReference;
        setUpFirebaseWorkshopAdapter();

    }
    private void setUpFirebaseWorkshopAdapter(){

        firebaseWorkshopQuery = mWorkshopReference.orderByChild("name");

        workshopArrayListDay1 = new ArrayList<>();
        workshopArrayListDay2 = new ArrayList<>();

        firebaseWorkshopQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Workshop workshop = dataSnapshot.getValue(Workshop.class);

                if (workshop != null) {
                    int day = workshop.getDay();

                    if (day == 1) {
                        workshopArrayListDay1.add(workshop);
                    } else {
                        workshopArrayListDay2.add(workshop);
                    }

                    WorkshopRecyclerAdapter workshopRecyclerAdapterDay1 = new WorkshopRecyclerAdapter(workshopArrayListDay1, WorkshopActivity.this);
                    WorkshopRecyclerAdapter workshopRecyclerAdapterDay2 = new WorkshopRecyclerAdapter(workshopArrayListDay2, WorkshopActivity.this);


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getApplicationContext());

                    linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                    linearLayoutManager.setAutoMeasureEnabled(true);
                    linearLayoutManager2.setAutoMeasureEnabled(true);

                    mRecyclerViewDay1.setLayoutManager(linearLayoutManager);
                    mRecyclerViewDay2.setLayoutManager(linearLayoutManager2);


                    mRecyclerViewDay1.setAdapter(workshopRecyclerAdapterDay1);
                    mRecyclerViewDay2.setAdapter(workshopRecyclerAdapterDay2);

                    mRecyclerViewDay1.setHasFixedSize(true);
                    mRecyclerViewDay2.setHasFixedSize(true);
                }

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
        });

    }
    private boolean isNetworkAvailable() {

		ConnectivityManager connectivityManager = (ConnectivityManager) this
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager
				.getActiveNetworkInfo();
		return activeNetworkInfo != null;
	}
	private void workshopButtonClicked(){
			mButtonWorkshopSignIn =  findViewById(R.id.button_workshop_signIn);
			mButtonWorkshopSignIn.setVisibility(View.VISIBLE);

			mButtonWorkshopSignIn.setOnClickListener(new View.OnClickListener() {
				public void onClick(View arg0) {
					if (!isNetworkAvailable()) {
						AlertDialog.Builder builder = new AlertDialog.Builder(
								WorkshopActivity.this);
						builder.setMessage("Wymagane połączenie z internetem")
								.setCancelable(false)
								.setPositiveButton("OK",
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog, int id) {
                                                Intent intent = new Intent(
                                                        WorkshopActivity.this,
                                                        WorkshopActivity.class);
                                                startActivity(intent);

											}

										});
						AlertDialog alert = builder.create();
						alert.show();

					} else {
						Intent intent = new Intent(Intent.ACTION_VIEW, Uri
								.parse("https://evenea.pl/organizator?id=271862"));
						startActivity(intent);
					}

				}
			});
    }
}
