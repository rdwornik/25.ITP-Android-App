package com.aplikacjaitp.robert.aplikacjaitp;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aplikacjaitp.robert.aplikacjaitp.model.Company;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;


/**
 * Created by robert on 1/30/18.
 */

public class FirebaseCompanyViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "FirebaseCompanyViewHold";
    private View mView;
    private Context mContext;
    ImageView companyLogoImage = null;
    TextView nameTextView = null;

    public FirebaseCompanyViewHolder(View itemView) {

        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        this.companyLogoImage = mView.findViewById(R.id.company_browse_logo);
        this.nameTextView = mView.findViewById(R.id.company_browse_name);
    }

    public void bindCompany (Company company){

        String name = company.getName();

        //        Picasso.with(mContext).load(company.getLogoLink())
        //         .error(R.drawable.placeholder)
        //         .into(companyLogoImage);

    if(company.getLogoLink() != null)
        Glide.with(mContext)
                    .load(company.getLogoLink())
                    .asBitmap()
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(R.drawable.placeholder)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            companyLogoImage.setImageBitmap(resource);
                        }
                    });
    else{
        Glide.with(mContext)
                .load(R.drawable.placeholder)
                .into(companyLogoImage);
    }

    if(name != null)
        nameTextView.setText(name.toUpperCase());
    else
        nameTextView.setText("not found");
    }
}
