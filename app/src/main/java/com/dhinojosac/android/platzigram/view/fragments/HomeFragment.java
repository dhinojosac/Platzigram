package com.dhinojosac.android.platzigram.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhinojosac.android.platzigram.R;
import com.dhinojosac.android.platzigram.adapter.PictureAdapterRecyclerView;
import com.dhinojosac.android.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar("Home", false, view);
        RecyclerView pictureRecyclerView = (RecyclerView) view.findViewById(R.id.pictureRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        pictureRecyclerView.setLayoutManager(manager);

        PictureAdapterRecyclerView  pictureAdapter= new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_picture,getActivity());

        pictureRecyclerView.setAdapter(pictureAdapter);

        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures =  new ArrayList<>();
        pictures.add(new Picture("http://ichef.bbci.co.uk/naturelibrary/images/ic/credit/640x395/m/mo/mountain/mountain_1.jpg","Diego Hinojosa","2 días","3"));
        pictures.add(new Picture("https://www.citrusmilo.com/acadiaguide/gorhammountain01.jpg","Perico Palotes","5 días","5"));
        pictures.add(new Picture("https://www.citrusmilo.com/acadiaguide/littlehunter01.jpg","Aquiles Baeza","1 días","2"));
        pictures.add(new Picture("https://www.citrusmilo.com/acadiaguide/carriage01.jpg","Elver Galarga","2 días","1"));
        pictures.add(new Picture("https://www.citrusmilo.com/acadiaguide/gorhammountain01.jpg","Elva Yaina","5 días","5"));

        return pictures;
    }

    public void showToolbar(String title, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
