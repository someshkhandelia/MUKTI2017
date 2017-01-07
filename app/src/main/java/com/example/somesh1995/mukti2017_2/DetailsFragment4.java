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
public class DetailsFragment4 extends android.support.v4.app.Fragment {
    private static final String ARG_KITTEN_NUMBER = "argKittenNumber";

    /**
     * Create a new DetailsFragment
     * @param kittenNumber The number (between 1 and 6) of the kitten to display
     */
    public static DetailsFragment4 newInstance(@IntRange(from = 1, to = 6) int kittenNumber) {
        Bundle args = new Bundle();
        args.putInt(ARG_KITTEN_NUMBER, kittenNumber);

        DetailsFragment4 fragment = new DetailsFragment4();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_fragment4, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView text_head=(TextView) view.findViewById(R.id.text_head);
        TextView text_body=(TextView) view.findViewById(R.id.text_body);
        TextView text_rules=(TextView) view.findViewById(R.id.text_rules);
        Button call_button=(Button) view.findViewById(R.id.call_button);

        Bundle args = getArguments();
        int kittenNumber = args.containsKey(ARG_KITTEN_NUMBER) ? args.getInt(ARG_KITTEN_NUMBER) : 1;

        switch (kittenNumber) {
            case 1:
                image.setImageResource(R.drawable.ff);
                text_head.setText("Fantasy Football");
                text_body.setText("Ever Thought of making your dream xv Ever Thought of bringing players from different league together \n\n GLUG brings you the chance to make your squad of your fantasies and win prizes while having fun");

                call_button.setText("Contact Avirup");
                text_rules.setText("Round 1 consists of pen and paper round comprising questions from football\n\n Round 2 will be an bidding round where each group has to make a team of 15");

                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+919800784681";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });

                break;
            case 2:
                image.setImageResource(R.drawable.inc);
                text_head.setText("Incanity");
                text_body.setText("Break the misconception which you have in your minds that it is an event dedicated solely to coders.\n" +
                        "To give an enjoyable experience and supplement your knowledge is the crux behind this event");

                call_button.setText("Contact Sudeshna");
                text_rules.setText("1. The event will be conducted in two rounds, and the participants should participate in groups of\n" +
                        "three.\n2. Languages to be used: C, C++, Java\n");

                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+919932032090";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });
                break;
            case 3:
                image.setImageResource(R.drawable.lipi);
                text_head.setText("Lipi");
                text_body.setText("Do you know your language well? Using technical words  frequently? Then try to know the meaning of these words in your very own language. Come and try our event LIPI where all you need to do is to translate strings from ENGLISH into a medium of your choice.");

                call_button.setText("Contact Drishti");
                text_rules.setText("");

                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+918820508067";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });
                break;
            case 4:
                image.setImageResource(R.drawable.perplex);
                text_head.setText("Perplexity");
                text_body.setText("Brain stormed by the monotony of academics? Here is your chance to prove that you can be more than just an engineer.\nBreak the common place paradigm and experience the refreshing tour into your intellect with our event PERPLEXITY");

                call_button.setText("Contact Sneh");
                text_rules.setText("1. Teams should consist of no more than three members.\n2. Scores of first round shall be carried forward to the subsequent rounds.\n3. Team with highest score in second round becomes the winner.");


                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+917063698947";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });
                break;
            case 5:
                image.setImageResource(R.drawable.conn);
                text_head.setText("Connectify 2048");
                text_body.setText("Love solving puzzles? \n\nCome and play the game of connecting the several pieces and forming the big picture which leads you to the answer!");

                call_button.setText("Contact Ananya");
                text_rules.setText("1.You will be given several image clues. You have to connect them together and think of the answer which the image clues together represent.\n" +
                        "2.Teams of 3 or less can participate.\n" +
                        "3.Based on your performance, top few teams will be qualifying for the next round.");

                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+917063495554";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });
                break;
            case 6:
                image.setImageResource(R.drawable.bts);
                text_head.setText("Behind The Scenes");
                text_body.setText("Don't you hate it when the things you are passionate about fetch you no accolades? Well, this is an event where your genius in sports, music, movies, games and alike will help you unravel the biggest mystery of what lies behind the scenes ");

                call_button.setText("Contact Avirup");
                text_rules.setText("Teams of two shall answer questions to get their inputs and deduce what happened behind the scenes to the input to obtain the respective outputs.");

                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+919800784681";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });
                break;

        }
    }
}
