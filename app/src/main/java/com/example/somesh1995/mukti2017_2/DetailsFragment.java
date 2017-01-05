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
public class DetailsFragment extends android.support.v4.app.Fragment {
    private static final String ARG_KITTEN_NUMBER = "argKittenNumber";

    /**
     * Create a new DetailsFragment
     * @param kittenNumber The number (between 1 and 4) of the kitten to display
     */
    public static DetailsFragment newInstance(@IntRange(from = 1, to = 4) int kittenNumber) {
        Bundle args = new Bundle();
        args.putInt(ARG_KITTEN_NUMBER, kittenNumber);

        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_fragment, container, false);
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
                image.setImageResource(R.drawable.surya);
                text_head.setText("President");
                text_body.setText("Surya Kant Singh\nPh no.: \nEmail id: ");

                break;
            case 2:
                image.setImageResource(R.drawable.drishti);
                text_head.setText("Treasurer");
                text_body.setText("Drishti Agarwal\nPh no.: \nEmail id: ");
                break;
            case 3:
                image.setImageResource(R.drawable.arpit);
                text_head.setText("Convenor");
                text_body.setText("Arpit Singh\nPh no.: \nEmail id: ");
                break;
            case 4:
                image.setImageResource(R.drawable.neetesh);
                text_head.setText("General Secretary");
                text_body.setText("Neetesh Kumar\nPh no.: \nEmail id: ");
                break;

        }
    }
}
