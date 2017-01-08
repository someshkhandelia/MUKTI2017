package com.example.somesh1995.mukti2017_2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Home1 extends Fragment {

    ImageView online_image_button;
    public Home1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_home1, container, false);//16.75,38.25,26.5



        online_image_button=(ImageView)rootView.findViewById(R.id.online_image_button);
        online_image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getActivity(),Online_events.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
