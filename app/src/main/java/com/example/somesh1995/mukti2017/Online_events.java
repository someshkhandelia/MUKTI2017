package com.example.somesh1995.mukti2017;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Demonstrates a "card-flip" animation using custom fragment transactions ({@link
 * android.app.FragmentTransaction#setCustomAnimations(int, int)}).
 *
 * <p>This sample shows an "info" action bar button that shows the back of a "card", rotating the
 * front of the card out and the back of the card in. The reverse animation is played when the user
 * presses the system Back button or the "photo" action bar button.</p>
 */
public class Online_events extends Activity
        implements FragmentManager.OnBackStackChangedListener {
    /**
     * A handler object, used for deferring UI operations.
     */
    private Handler mHandler = new Handler();

    LinearLayout f1;
    LinearLayout f2;
    LinearLayout f3;
    LinearLayout f4;

   // Button b1;


    /**
     * Whether or not we're showing the back of the card (otherwise showing the front).
     */
    private boolean mShowingBack1 = false;
    private boolean mShowingBack2 = false;
    private boolean mShowingBack3 = false;
    private boolean mShowingBack4 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_events);


      /*  b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Hackathon.class);
                startActivity(intent);
            }
        });*/

        if (savedInstanceState == null) {
            // If there is no saved instance state, add a fragment representing the
            // front of the card to this activity. If there is saved instance state,
            // this fragment will have already been added to the activity.
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.onel1, new Card1FrontFragment())
                    .commit();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.onel2, new Card2FrontFragment())
                    .commit();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.onel3, new Card3FrontFragment())
                    .commit();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.onel4, new Card4FrontFragment())
                    .commit();
        } else {
            mShowingBack1 = (getFragmentManager().getBackStackEntryCount() > 0);
            mShowingBack2 = (getFragmentManager().getBackStackEntryCount() > 0);
            mShowingBack3 = (getFragmentManager().getBackStackEntryCount() > 0);
            mShowingBack4 = (getFragmentManager().getBackStackEntryCount() > 0);
        }


        getFragmentManager().addOnBackStackChangedListener(this);



        //////////////////////////Initialising the different layouts///////////////////////////

        f1=(LinearLayout)findViewById(R.id.onel1);
        f2=(LinearLayout)findViewById(R.id.onel2);
        f3=(LinearLayout)findViewById(R.id.onel3);
        f4=(LinearLayout)findViewById(R.id.onel4);



        ////////////////////////////Setting the different on-click listeners//////////////////////////////////////



        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myfunc1();

            }
        });

        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myfunc2();
            }
        });

        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myfunc3();
            }
        });

        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myfunc4();
            }
        });

        /////////////////////////////////////////////////////////////////////////////


    }

    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }




    public void flipCard1() {

        //checking for others

        /*if(mShowingBack2){
            flipCard2();
        }
        if(mShowingBack3){
            flipCard3();
        }
        if(mShowingBack4){
            flipCard4();
        }*/



        if (mShowingBack1) {
            getFragmentManager().popBackStack();
            return;
        }



        // Flip to the back.

        mShowingBack1 = true;

        // Create and commit a new fragment transaction that adds the fragment for the back of
        // the card, uses custom animations, and is part of the fragment manager's back stack.

        getFragmentManager()
                .beginTransaction()

                // Replace the default fragment animations with animator resources representing
                // rotations when switching to the back of the card, as well as animator
                // resources representing rotations when flipping back to the front (e.g. when
                // the system Back button is pressed).
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)

                // Replace any fragments currently in the container view with a fragment
                // representing the next page (indicated by the just-incremented currentPage
                // variable).
                .replace(R.id.onel1, new Card1BackFragment())

                // Add this transaction to the back stack, allowing users to press Back
                // to get to the front of the card.
                .addToBackStack(null)

                // Commit the transaction.
                .commit();

        // Defer an invalidation of the options menu (on modern devices, the action bar). This
        // can't be done immediately because the transaction may not yet be committed. Commits
        // are asynchronous in that they are posted to the main thread's message loop.
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                invalidateOptionsMenu();
            }
        });
    }


    public void flipCard2() {

        //checking for others

        /*if(mShowingBack1){
            flipCard1();
        }
        if(mShowingBack3){
            flipCard3();
        }
        if(mShowingBack4){
            flipCard4();
        }*/


        if (mShowingBack2) {
            getFragmentManager().popBackStack();
            return;
        }

        // Flip to the back.

        mShowingBack2 = true;

        // Create and commit a new fragment transaction that adds the fragment for the back of
        // the card, uses custom animations, and is part of the fragment manager's back stack.

        getFragmentManager()
                .beginTransaction()

                // Replace the default fragment animations with animator resources representing
                // rotations when switching to the back of the card, as well as animator
                // resources representing rotations when flipping back to the front (e.g. when
                // the system Back button is pressed).
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)

                // Replace any fragments currently in the container view with a fragment
                // representing the next page (indicated by the just-incremented currentPage
                // variable).
                .replace(R.id.onel2, new Card2BackFragment())

                // Add this transaction to the back stack, allowing users to press Back
                // to get to the front of the card.
                .addToBackStack(null)

                // Commit the transaction.
                .commit();

        // Defer an invalidation of the options menu (on modern devices, the action bar). This
        // can't be done immediately because the transaction may not yet be committed. Commits
        // are asynchronous in that they are posted to the main thread's message loop.
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                invalidateOptionsMenu();
            }
        });
    }

    public void flipCard3() {

        //checking for others

      /*  if(mShowingBack2){
            flipCard2();
        }
        if(mShowingBack1){
            flipCard1();
        }
        if(mShowingBack4){
            flipCard4();
        }*/



        if (mShowingBack3) {
            getFragmentManager().popBackStack();
            return;
        }

        // Flip to the back.

        mShowingBack3 = true;

        // Create and commit a new fragment transaction that adds the fragment for the back of
        // the card, uses custom animations, and is part of the fragment manager's back stack.

        getFragmentManager()
                .beginTransaction()

                // Replace the default fragment animations with animator resources representing
                // rotations when switching to the back of the card, as well as animator
                // resources representing rotations when flipping back to the front (e.g. when
                // the system Back button is pressed).
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)

                // Replace any fragments currently in the container view with a fragment
                // representing the next page (indicated by the just-incremented currentPage
                // variable).
                .replace(R.id.onel3, new Card3BackFragment())

                // Add this transaction to the back stack, allowing users to press Back
                // to get to the front of the card.
                .addToBackStack(null)

                // Commit the transaction.
                .commit();

        // Defer an invalidation of the options menu (on modern devices, the action bar). This
        // can't be done immediately because the transaction may not yet be committed. Commits
        // are asynchronous in that they are posted to the main thread's message loop.
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                invalidateOptionsMenu();
            }
        });
    }

    public void flipCard4() {

        //checking for others

       /* if(mShowingBack2){
            flipCard2();
        }
        if(mShowingBack3){
            flipCard3();
        }
        if(mShowingBack1){
            flipCard1();
        }*/



        if (mShowingBack4) {
            getFragmentManager().popBackStack();
            return;
        }

        // Flip to the back.

        mShowingBack4 = true;

        // Create and commit a new fragment transaction that adds the fragment for the back of
        // the card, uses custom animations, and is part of the fragment manager's back stack.

        getFragmentManager()
                .beginTransaction()

                // Replace the default fragment animations with animator resources representing
                // rotations when switching to the back of the card, as well as animator
                // resources representing rotations when flipping back to the front (e.g. when
                // the system Back button is pressed).
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)

                // Replace any fragments currently in the container view with a fragment
                // representing the next page (indicated by the just-incremented currentPage
                // variable).
                .replace(R.id.onel4, new Card4BackFragment())

                // Add this transaction to the back stack, allowing users to press Back
                // to get to the front of the card.
                .addToBackStack(null)

                // Commit the transaction.
                .commit();

        // Defer an invalidation of the options menu (on modern devices, the action bar). This
        // can't be done immediately because the transaction may not yet be committed. Commits
        // are asynchronous in that they are posted to the main thread's message loop.
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                invalidateOptionsMenu();
            }
        });
    }



    @Override
    public void onBackStackChanged() {
        mShowingBack1 = (getFragmentManager().getBackStackEntryCount() > 0);
        mShowingBack2 = (getFragmentManager().getBackStackEntryCount() > 0);
        mShowingBack3 = (getFragmentManager().getBackStackEntryCount() > 0);
        mShowingBack4 = (getFragmentManager().getBackStackEntryCount() > 0);

        // When the back stack changes, invalidate the options menu (action bar).
        invalidateOptionsMenu();
    }

   /////////////////////////////////////////////////////////////////////////////////////////



    public void myfunc1(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                flipCard1();
            }
        }, 100);
    }


    public void myfunc2(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                flipCard2();
            }
        }, 100);
    }


    public void myfunc3(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                flipCard3();
            }
        }, 100);
    }


    public void myfunc4(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                flipCard4();
            }
        }, 100);
    }


    /////////////////////////////////////////////////////////////////////////////////////////

    /**
     * A fragment representing the front of the card 1.
     */
    public static class Card1FrontFragment extends Fragment {
        public Card1FrontFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card1_front, container, false);
        }

    }
    /**
     * A fragment representing the front of the card 2.
     */
    public static class Card2FrontFragment extends Fragment {
        public Card2FrontFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card2_front, container, false);
        }

    }
    /**
     * A fragment representing the front of the card 3.
     */
    public static class Card3FrontFragment extends Fragment {
        public Card3FrontFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card3_front, container, false);
        }

    }
    /**
     * A fragment representing the front of the card 4.
     */
    public static class Card4FrontFragment extends Fragment {
        public Card4FrontFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card4_front, container, false);
        }

    }

    /**
     * A fragment representing the back of the card 1.
     */
    public static class Card1BackFragment extends Fragment {
        public Card1BackFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card1_back, container, false);
        }
    }
    /**
     * A fragment representing the back of the card 2.
     */
    public static class Card2BackFragment extends Fragment {
        public Card2BackFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card2_back, container, false);
        }
    }
    /**
     * A fragment representing the back of the card 3.
     */
    public static class Card3BackFragment extends Fragment {
        public Card3BackFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card3_back, container, false);
        }
    }
    /**
     * A fragment representing the back of the card 4.
     */
    public static class Card4BackFragment extends Fragment {
        public Card4BackFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card4_back, container, false);
        }
    }
}
