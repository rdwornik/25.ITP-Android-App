package com.aplikacjaitp.robert.aplikacjaitp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aplikacjaitp.robert.aplikacjaitp.R;
import com.aplikacjaitp.robert.aplikacjaitp.model.Organizers;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.text.WordUtils;

import java.util.ArrayList;

/**
 * Created by robert on 2/14/18.
 */

public class OrganizersRecyclerAdapter extends RecyclerView.Adapter<OrganizersRecyclerAdapter.OrganizersViewHolder> {

    private ArrayList<Organizers> mOrganizersList;
    private Context mContext;

    public OrganizersRecyclerAdapter(ArrayList<Organizers> organizers, Context mContext) {
        this.mOrganizersList = organizers;
        this.mContext = mContext;
    }

    @Override
    public OrganizersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse_organizers, parent, false);
       return new OrganizersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrganizersViewHolder holder, int position) {         //method to set view to view holder

        if((mOrganizersList == null) || (mOrganizersList.size() == 0)){
            holder.photo.setImageResource(R.drawable.placeholder);
            holder.descritpion.setText(R.string.empty_organizers);
        }else {
            Organizers organizers = mOrganizersList.get(position);

            Picasso.with(mContext).load(organizers.getPhotoLink())
                    .error(R.drawable.placeholder)
                    .into(holder.photo);

            String description = organizers.getDescription();
            String name = organizers.getName().toLowerCase();
            String capitalized = WordUtils.capitalize(name);

            String organizersText = "<b>" + capitalized + "</b>" + "<br>" + description;

            holder.descritpion.setText(Html.fromHtml(organizersText));
        }
    }


    @Override
    public int getItemCount() {
        return ((mOrganizersList != null) && (mOrganizersList.size() !=0) ? mOrganizersList.size() : 1);
    }

    static class OrganizersViewHolder extends RecyclerView.ViewHolder{

        ImageView photo = null;
        TextView descritpion = null;

        public OrganizersViewHolder(View itemView) {
            super(itemView);
            this.photo = itemView.findViewById(R.id.organizers_browse_photo);
            this.descritpion = itemView.findViewById(R.id.organizers_browse_name);
        }
    }
}
