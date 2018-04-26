package com.aplikacjaitp.robert.aplikacjaitp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aplikacjaitp.robert.aplikacjaitp.R;
import com.aplikacjaitp.robert.aplikacjaitp.model.Workshop;

import java.util.ArrayList;

/**
 * Created by robert on 2/14/18.
 */

public class WorkshopRecyclerAdapter extends RecyclerView.Adapter<WorkshopRecyclerAdapter.FirebaseWorkshopViewHolder> {

    private static final String TAG = "WorkshopRecyclerAdapter";
    private ArrayList<Workshop> mWorkshopList;
    private Context mContext;

    public WorkshopRecyclerAdapter(ArrayList<Workshop> mWorkshopList, Context mContext) {
        this.mWorkshopList = mWorkshopList;
        this.mContext = mContext;
    }

    @Override
    public FirebaseWorkshopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse_workshops, parent, false);
        return new FirebaseWorkshopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FirebaseWorkshopViewHolder holder, int position) {

        if((mWorkshopList == null) || (mWorkshopList.size() == 0)){
            holder.workshopDescription.setText(R.string.empty_workshops);
            holder.workshopTime.setText(" ");
        }else {
            Workshop workshop = mWorkshopList.get(position);
            String description = workshop.getDescription();
            String name = workshop.getName();
            String time = workshop.getTime();
            String room = workshop.getRoom();

            String capitalized = name.toUpperCase();

            String workshopText = "<b>" + capitalized + "</b>" + "<br>" + description;
            String workshopTime = "Godzina:" + "<b>" + time + "</b>" + "<br>" + "Sala nr: " + "<br>" + "<b>" + room + "</b>";


            holder.workshopDescription.setText(Html.fromHtml(workshopText));
            holder.workshopTime.setText(Html.fromHtml(workshopTime));
        }

    }

      @Override
    public int getItemCount() {
        return ((mWorkshopList != null) && (mWorkshopList.size() !=0) ? mWorkshopList.size() : 1);
    }

    static class FirebaseWorkshopViewHolder extends RecyclerView.ViewHolder {

        TextView workshopDescription = null;
        TextView workshopTime = null;

        public FirebaseWorkshopViewHolder(View itemView) {
            super(itemView);
            this.workshopDescription = itemView.findViewById(R.id.workshop_browse_description);
            this.workshopTime = itemView.findViewById(R.id.workshop_browse_time);

        }
    }
}
