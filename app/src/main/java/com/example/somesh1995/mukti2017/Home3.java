package com.example.somesh1995.mukti2017;

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


public class Home3 extends Fragment {

    ImageButton workshops_image_button;

    public Home3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_home3, container, false);//16.75,38.25,26.5

       workshops_image_button=(ImageButton)rootView.findViewById(R.id.workshops_image_button);
        workshops_image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Workshops.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
