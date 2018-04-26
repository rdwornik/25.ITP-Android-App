package com.aplikacjaitp.robert.aplikacjaitp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aplikacjaitp.robert.aplikacjaitp.model.Sponsors;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;



public class SponsorActivity extends BaseActivity{

    private DatabaseReference mSponsorReference;
    RecyclerView mRecyclerView;
    Query mFirebaseSponsorQuery;
    FirebaseRecyclerAdapter<Sponsors,FirebaseSponsorViewHolder> mFrirebaseSponsorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);
        activateToolbar();
        isConnected();

        mRecyclerView = findViewById(R.id.sponsor_recycler_view);

        getDatabaseRefernces();         //in every class we try to get refernces to database in case user opens on view and turn off the internet after it
        mSponsorReference = BaseActivity.mSponsorReference;
        setUpFirebaseAdapter();
    }


    void setUpFirebaseAdapter() {

        mFirebaseSponsorQuery = mSponsorReference.orderByChild("position");

        if (mFrirebaseSponsorAdapter == null) {
            mFrirebaseSponsorAdapter = new FirebaseRecyclerAdapter<Sponsors, FirebaseSponsorViewHolder>(
                    Sponsors.class,
                    R.layout.browse_sponsors,
                    FirebaseSponsorViewHolder.class,
                    mFirebaseSponsorQuery) {

                @Override
                protected void populateViewHolder(FirebaseSponsorViewHolder viewHolder, Sponsors model, int position) {
                    viewHolder.bindSponsors(model);
                }
            };

            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(mFrirebaseSponsorAdapter);
        }else {
            mFrirebaseSponsorAdapter.notifyDataSetChanged();
        }
    }
}
