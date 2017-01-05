package com.example.somesh1995.mukti2017_2;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        Bundle args = getArguments();
        int kittenNumber = args.containsKey(ARG_KITTEN_NUMBER) ? args.getInt(ARG_KITTEN_NUMBER) : 1;

        switch (kittenNumber) {
            case 1:
                image.setImageResource(R.drawable.ff);
                text_head.setText("Fantasy Football");
                text_body.setText("Description: ");

                break;
            case 2:
                image.setImageResource(R.drawable.inc);
                text_head.setText("Incanity");
                text_body.setText("Description: ");
                break;
            case 3:
                image.setImageResource(R.drawable.lipi);
                text_head.setText("Lipi");
                text_body.setText("Description: ");
                break;
            case 4:
                image.setImageResource(R.drawable.perplex);
                text_head.setText("Perplexity");
                text_body.setText("Description: ");
                break;
            case 5:
                image.setImageResource(R.drawable.conn);
                text_head.setText("Connectify 2048");
                text_body.setText("Description: ");
                break;
            case 6:
                image.setImageResource(R.drawable.bts);
                text_head.setText("Behind The Scenes");
                text_body.setText("Description: ");
                break;

        }
    }
}
