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


public class Home6 extends Fragment {


    // Button contactusbutton;
    public Home6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_home6, container, false);//16.75,38.25,26.5

      /*  contactusbutton=(Button)rootView.findViewById(R.id.contactusbutton);
        contactusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ContactUsActivity.class);
                startActivity(intent);
            }
        });*/

        return rootView;
    }
}
