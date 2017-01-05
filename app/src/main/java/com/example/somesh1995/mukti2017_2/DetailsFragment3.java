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

        Bundle args = getArguments();
        int kittenNumber = args.containsKey(ARG_KITTEN_NUMBER) ? args.getInt(ARG_KITTEN_NUMBER) : 1;

        switch (kittenNumber) {
            case 1:
                image.setImageResource(R.drawable.ethic);
                text_head.setText("Ethical Hacking");
                text_body.setText("Description: ");

                break;
            case 2:
                image.setImageResource(R.drawable.android);
                text_head.setText("Android App Development");
                text_body.setText("Description: ");
                break;
            case 3:
                image.setImageResource(R.drawable.webdev);
                text_head.setText("Web Development");
                text_body.setText("Description: ");
                break;
            case 4:
                image.setImageResource(R.drawable.hackme);
                text_head.setText("Hack.Me");
                text_body.setText("Description: ");
                break;

        }
    }
}
