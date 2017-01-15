package com.example.somesh1995.mukti2017_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
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
public class DetailsFragment2 extends android.support.v4.app.Fragment {
    private static final String ARG_KITTEN_NUMBER = "argKittenNumber";

    /**
     * Create a new DetailsFragment
     * @param kittenNumber The number (between 1 and 6) of the kitten to display
     */
    public static DetailsFragment2 newInstance(@IntRange(from = 1, to = 6) int kittenNumber) {
        Bundle args = new Bundle();
        args.putInt(ARG_KITTEN_NUMBER, kittenNumber);

        DetailsFragment2 fragment = new DetailsFragment2();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_fragment2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView text_head=(TextView) view.findViewById(R.id.text_head);
        TextView text_body=(TextView) view.findViewById(R.id.text_body);
        TextView text_link=(TextView) view.findViewById(R.id.text_link);
        Button call_button=(Button) view.findViewById(R.id.call_button);
        TextView text_rules=(TextView) view.findViewById(R.id.text_rules);

        Bundle args = getArguments();
        int kittenNumber = args.containsKey(ARG_KITTEN_NUMBER) ? args.getInt(ARG_KITTEN_NUMBER) : 1;

        switch (kittenNumber) {
            case 1:
                image.setImageResource(R.drawable.cc);
                text_head.setText("Codecracker");
                text_body.setText("It is the flagship event where partcipation involves people from 50 countries across the world.This is an online coding competition organised by GNU/Linux Users' Group during MUKTI");
                text_link.setText("codecracker.in");
               // text_link.setMovementMethod(LinkMovementMethod.getInstance());
                call_button.setText("Contact Neetesh");

                text_rules.setText("There will be a set of coding questions and the participant solving the most number of questions will be the winner" +
                        "Challenge is on Keep Coding!");

                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+918670864497";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });

                break;
            case 2:
                image.setImageResource(R.drawable.fp);
                text_head.setText("Freepl");
                text_body.setText("This is the time to prove yourself as a selecter. So bring out the superselecter in you and build the best team on the cricketing circuit will bring you the victory irrespective of foreign and domestic players");
                text_link.setText("freepl.mkti.in");
               // text_link.setMovementMethod(LinkMovementMethod.getInstance());
                call_button.setText("Contact Adarsh");
                text_rules.setText("Select 11 players with a captain and form a team of a current match. The player with maximum points will be declared as the winner");

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
            case 3:
                image.setImageResource(R.drawable.fx);
                text_head.setText("Freemex");
                text_body.setText("The name says it all free as in free of cost in FOSS. This is an unique type of online trading which allows you to buy and sell stocks");
                text_link.setText("freemex.mkti.in");
                call_button.setText("Contact Bishakh");
                text_rules.setText("Player has to buy and sell stocks using the knowledge and status of current stocks.Player with maximum amount of points and stocks will be the winner");

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
                image.setImageResource(R.drawable.othh);
                text_head.setText("Online Treasure Hunt");
                text_body.setText("The exhilaration is back! Gear up as we take you for an exciting quest for “treasure” during MUKTI.\n" +
                        "\n" +
                        "Come with us, and unravel the secret treasure hidden somewhere in the world of Free and Open Source Software (FOSS).");
                text_link.setText("oth.mkti.in");
                call_button.setText("Contact Aman");
                text_rules.setText("Connect the pictures, look for clues in the page source and remember,Google Is Your Friend!\n" +
                        "\n" +
                        "\n" +
                        "The hunt is on!");

                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+917063698944";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });
                break;

            case 5:
                image.setImageResource(R.drawable.df);
                text_head.setText("Digital Fortress");
                text_body.setText("Welcome to the fortress where each floor has different clues for you which lead you to the staircase for the next one.\n\nExplore the Sherlock in you and analyse the breathtaking world through maps to find your clues ");
                text_link.setText("digitalfortress.mkti.in");
                call_button.setText("Contact Arka");

                text_rules.setText("1. Each round has two kinds of questions: Hints Question and Round Question\n2. Solving a hints question gives you a latitude and longitude position\n3. Solving all the hints questions will give you a pattern on the map\n4.Zoom in and get details of that location, decode it to solve the Round question,and proceed to the next round.");

                call_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentcall = new Intent();
                        intentcall.setAction(Intent.ACTION_DIAL);
                        String phonenumber="+918906700509";
                        intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                        startActivity(intentcall);
                    }
                });
                break;
            case 6:
                image.setImageResource(R.drawable.inter);
                text_head.setText("Interficio");
                text_body.setText("This MUKTI you will find murder meets mayhem and the intrigue begins!\nDo murders excite you? Do clues trigger your brain to a hyperactive mode?\n\nIf yes,you are left with the task of deciphering between the facts and falsehoods that plague this paradise in order to make a lyncher pay for his crime.");

                call_button.setText("Contact Ananya");

                text_rules.setText(" All answers are to be typed in lowercase characters. For phrases, use underscore in between the words (i.e., instead of spaces). For more than one word, (suppose you have to give 5 names), use '/' in between each word, and all words should be arranged lexicographically.");

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

        }
    }
}
