package com.dhinojosac.android.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dhinojosac.android.platzigram.R;
import com.dhinojosac.android.platzigram.model.Picture;
import com.dhinojosac.android.platzigram.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by negro-PC on 04-Feb-17.
 */

public class SearchAdapterRecyclerView extends RecyclerView.Adapter<SearchAdapterRecyclerView.SearchViewHolder>{

    private ArrayList<Picture> pictures;
    private int resource; //layout cardview
    private Activity activity;

    public SearchAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        Picture picture =  pictures.get(position);
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureSearch);

        // add onClickListener
        holder.pictureSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);

                //transition image validation
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.
                            makeSceneTransitionAnimation(activity,view,
                                    activity.getString(R.string.transition_name_picture)).toBundle());
                }else{

                    activity.startActivity(intent);
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{
        private ImageView pictureSearch;

        public SearchViewHolder(View itemView) {
            super(itemView);
            pictureSearch = (ImageView) itemView.findViewById(R.id.searchPicture);
        }
    }
}
