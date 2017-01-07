package com.example.somesh1995.mukti2017_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Display details for a given kitten
 *
 * @author bherbst
 */
public class DetailsFragment3 extends android.support.v4.app.Fragment {
    private static final String ARG_KITTEN_NUMBER = "argKittenNumber";

    /**
     * Create a new DetailsFragment
     * @param kittenNumber The number (between 1 and 4) of the kitten to display
     */
    public static DetailsFragment3 newInstance(@IntRange(from = 1, to = 4) int kittenNumber) {
        Bundle args = new Bundle();
        args.putInt(ARG_KITTEN_NUMBER, kittenNumber);

        DetailsFragment3 fragment = new DetailsFragment3();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_fragment3, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView text_head=(TextView) view.findViewById(R.id.text_head);
        TextView text_body=(TextView) view.findViewById(R.id.text_body);
        Button call_button=(Button) view.findViewById(R.id.call_button);

        Bundle args = getArguments();
        int kittenNumber = args.containsKey(ARG_KITTEN_NUMBER) ? args.getInt(ARG_KITTEN_NUMBER) : 1;

        switch (kittenNumber) {
            case 1:
                image.setImageResource(R.drawable.ethic);
                text_head.setText("Ethical Hacking");
                text_body.setText("Description: ");

                call_button.setText("Contact Surya");

                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+919614826204";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });

                break;
            case 2:
                image.setImageResource(R.drawable.android);
                text_head.setText("Android App Development");
                text_body.setText("One of the most interesting fields in the IT industry today is Android App Development.\n It is in great demand in the market,and an android can be found in almost every pair of hands.\n Creation always makes the creator happy, no matter how trivial or grand it be. And more so, if others can utilise the creation too. Imagine creating an Android app all by yourself, launching it, and being able to use it, not just you, but everyone around you! Wouldn’t it be amazing?? We the GNU Linux Users’ Group would help you learn to create an Android App, right from scratch. Come join us with fully charged laptops. \n\n\nVenue: D.M.Sen Auditorium \nTime: 5.45pm-8pm(Tuesdays)");

                call_button.setText("Contact Somesh");

                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+919674642046";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });
                break;
            case 3:
                image.setImageResource(R.drawable.webdev);
                text_head.setText("Web Development");
                text_body.setText("For the present generation, internet has become the second oxygen and surfing through various websites the new form of breathing!!\n Even you can make your own website! We, the GNU Linux Users’ Group would help you develop your own website, both front and back end, right from the basics. It would not only be exciting but would add a lot to your personal development (and CV too!).\n Come join us with fully charged laptops and no other prerequisites.\n\n\n Venue: D.M.Sen Auditorium  \nTime: 5.45pm-7.45pm(Thursdays)");

                call_button.setText("Contact Bishakh");

                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+919474649114";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });
                break;
            case 4:
                image.setImageResource(R.drawable.hackme);
                text_head.setText("Hack.Me");
                text_body.setText("A little bit of fuel can add a lot of flame to the fire. Similarly a little bit of innovation can add a lot of advancement to a technology.\n We, the GNU Linux Users’ Group are organising hackathon sessions to encourage budding minds to create something new. You’ll get to modify on a piece of code and craft your ideas into a working prototype in a single session.\n Come join us with fully charged laptops and a heart full of enthusiasm!\n\n\nVenue: D.M.Sen Auditorium \nTime: 2pm-6pm(Saturdays)");

                call_button.setText("Contact Adarsh");


                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+917076316399";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });
                break;

        }
    }
}
