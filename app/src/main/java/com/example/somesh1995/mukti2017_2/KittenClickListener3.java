package com.example.somesh1995.mukti2017_2;

/**
 * Listener for kitten click events in the grid of kittens
 *
 * @author bherbst
 */
public interface KittenClickListener3 {
    /**
     * Called when a kitten is clicked
     * @param holder The ViewHolder for the clicked kitten
     * @param position The position in the grid of the kitten that was clicked
     */
    void onKittenClicked(KittenViewHolder3 holder, int position);
}
