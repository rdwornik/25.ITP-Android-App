package com.aplikacjaitp.robert.aplikacjaitp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.aplikacjaitp.robert.aplikacjaitp.adapters.OrganizersRecyclerAdapter;
import com.aplikacjaitp.robert.aplikacjaitp.model.Organizers;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class OrganizersActivity extends BaseActivity {

    private static final String TAG = "OrganizersActivity";
    OrganizersRecyclerAdapter organizersRecyclerAdapter;
    private DatabaseReference mOrganizersReference;
    RecyclerView mRecyclerView;
    TextView bestDescription;
    Query firebaseOrganizersQuery;
    ArrayList<Organizers> organizersArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizers);

        activateToolbar();

        mRecyclerView = findViewById(R.id.organizers_recycler_view);
        bestDescription = findViewById(R.id.organizers_best_description);
        bestDescription.setText(R.string.best_description);


        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setAutoMeasureEnabled(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(OrganizersActivity.this));
        mRecyclerView.setLayoutManager(linearLayoutManager);

        isConnected();          //checks if data was loaded from database otherwise alert will be shown with request to turn on internet

        mOrganizersReference = BaseActivity.mOrganizersReference;

        setUpFirebaseAdapter();     //setting adapter in this case view the recycler view with data

    }


    private void setUpFirebaseAdapter() {

        firebaseOrganizersQuery = mOrganizersReference.orderByChild("name");

        organizersArrayList = new ArrayList<>();

        firebaseOrganizersQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d(TAG, "onChildAdded: " + dataSnapshot.getValue(Organizers.class));
                Organizers organizers = dataSnapshot.getValue(Organizers.class);
                organizersArrayList.add(organizers);

                if (organizersRecyclerAdapter == null)
                    organizersRecyclerAdapter = new OrganizersRecyclerAdapter(organizersArrayList, OrganizersActivity.this);
                else
                    organizersRecyclerAdapter.notifyDataSetChanged();


                mRecyclerView.setAdapter(organizersRecyclerAdapter);

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


}