package com.example.somesh1995.mukti2017_2;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Displays a grid of pictures
 *
 * @author bherbst
 */
public class GridFragment3 extends Fragment implements KittenClickListener3 {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grid3, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(new KittenGridAdapter3(3, this));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
    }

    @Override
    public void onKittenClicked(KittenViewHolder3 holder, int position) {
        int kittenNumber = (position % 3) + 1;

        DetailsFragment3 kittenDetails = DetailsFragment3.newInstance(kittenNumber);

        // Note that we need the API version check here because the actual transition classes (e.g. Fade)
        // are not in the support library and are only available in API 21+. The methods we are calling on the Fragment
        // ARE available in the support library (though they don't do anything on API < 21)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            kittenDetails.setSharedElementEnterTransition(new DetailsTransition3());
            kittenDetails.setEnterTransition(new Fade());
            setExitTransition(new Fade());
            kittenDetails.setSharedElementReturnTransition(new DetailsTransition3());
        }

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addSharedElement(holder.image, "kittenImage")
                .replace(R.id.container, kittenDetails)
                .addToBackStack(null)
                .commit();
    }
}
