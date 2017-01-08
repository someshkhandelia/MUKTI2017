package com.example.somesh1995.mukti2017_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Home4 extends Fragment {


    ImageView hackathon_image_button;
    public Home4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_home4, container, false);//16.75,38.25,26.5

        hackathon_image_button=(ImageView)rootView.findViewById(R.id.hackathon_image_button);
        hackathon_image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Hackathon.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
