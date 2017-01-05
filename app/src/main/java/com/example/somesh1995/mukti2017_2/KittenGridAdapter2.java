package com.example.somesh1995.mukti2017_2;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Adapts Views containing kittens to RecyclerView cells
 *
 * @author bherbst
 */
public class KittenGridAdapter2 extends RecyclerView.Adapter<KittenViewHolder2> {
    private final int mSize;
    private final KittenClickListener2 mListener;

    /**
     * Constructor
     * @param size The number of kittens to show
     * @param listener A listener for kitten click events
     */
    public KittenGridAdapter2(int size, KittenClickListener2 listener) {
        mSize = size;
        mListener = listener;
    }

    @Override
    public KittenViewHolder2 onCreateViewHolder(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View cell = inflater.inflate(R.layout.grid_item2, container, false);

        return new KittenViewHolder2(cell);
    }

    @Override
    public void onBindViewHolder(final KittenViewHolder2 viewHolder, final int position) {
        switch (position % 4) {
            case 0:
                viewHolder.image.setImageResource(R.drawable.cc);
                viewHolder.preview_text.setText("Codecracker");
                break;
            case 1:
                viewHolder.image.setImageResource(R.drawable.fp);
                viewHolder.preview_text.setText("Freepl");
                break;
            case 2:
                viewHolder.image.setImageResource(R.drawable.fx);
                viewHolder.preview_text.setText("Freemex");
                break;
            case 3:
                viewHolder.image.setImageResource(R.drawable.othh);
                viewHolder.preview_text.setText("Online Treasure Hunt");
                break;

        }

        // It is important that each shared element in the source screen has a unique transition name.
        // For example, we can't just give all the images in our grid the transition name "kittenImage"
        // because then we would have conflicting transition names.
        // By appending "_image" to the position, we can support having multiple shared elements in each
        // grid cell in the future.
        ViewCompat.setTransitionName(viewHolder.image, String.valueOf(position) + "_image");

        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onKittenClicked(viewHolder, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSize;
    }

}
