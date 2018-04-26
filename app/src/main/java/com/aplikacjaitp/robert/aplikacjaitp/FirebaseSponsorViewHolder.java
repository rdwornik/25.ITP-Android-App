package com.aplikacjaitp.robert.aplikacjaitp;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aplikacjaitp.robert.aplikacjaitp.model.Sponsors;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Created by robert on 2/14/18.
 */

public class FirebaseSponsorViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "FirebaseSponsorViewHold";

    private View mView;
    private Context mContext;

    TextView sponsorDescription = null;
    TextView sponsorName = null;
    TextView sponsorType = null;
    ImageView sponsorLogo = null;

    public FirebaseSponsorViewHolder(View itemView) {

        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();

        sponsorDescription = mView.findViewById(R.id.sponsors_browse_description);
        sponsorLogo = mView.findViewById(R.id.sponsors_browse_logo);
        sponsorName = mView.findViewById(R.id.sponsors_browse_name);
        sponsorType = mView.findViewById(R.id.sponsors_browse_type);
    }

    public void bindSponsors (Sponsors sponsors){

        String name = sponsors.getName();
        String description = sponsors.getDescription();
        String type = sponsors.getType();

//        Picasso.with(mContext).load(sponsors.getLogoLink())
//                .error(R.drawable.placeholder)
//                .into(sponsorLogo);

        if(sponsors.getLogoLink() != null) {
            Glide.with(mContext)
                    .load(sponsors.getLogoLink())
                    .asBitmap()
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(R.drawable.placeholder)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            sponsorLogo.setImageBitmap(resource);
                        }
                    });
        }
        else{
            Glide.with(mContext)
                    .load(R.drawable.placeholder)
                    .into(sponsorLogo);
        }

        if(name != null && description != null && type != null) {
            sponsorName.setText(name.toUpperCase());
            sponsorType.setText(type.toUpperCase());
            sponsorDescription.setText(description);
        }else {
            Log.d(TAG, "bindSponsors: nullpointer in list check database for empty place ");
            sponsorName.setText("not found");
            sponsorType.setText("not found");
            sponsorDescription.setText("not found");
        }
    }
}
