package com.example.somesh1995.mukti2017_2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ViewHolder for kitten cells in our grid
 *
 * @author bherbst
 */
public class KittenViewHolder2 extends RecyclerView.ViewHolder {
    ImageView image;
    TextView preview_text;

    public KittenViewHolder2(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.image);
        preview_text=(TextView) itemView.findViewById(R.id.preview_text);
    }
}
