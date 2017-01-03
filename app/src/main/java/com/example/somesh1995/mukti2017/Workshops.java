package com.example.somesh1995.mukti2017;



import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Workshops extends FragmentActivity {
    // Hold a reference to the current animator,
    // so that it can be canceled mid-way.
    private Animator mCurrentAnimator1;
    private Animator mCurrentAnimator2;
    private Animator mCurrentAnimator3;
    private Animator mCurrentAnimator4;

    // The system "short" animation time duration, in milliseconds. This
    // duration is ideal for subtle animations or animations that occur
    // very frequently.
    private int mShortAnimationDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops);

        // Hook up clicks on the thumbnail views.

        final View thumb1View = findViewById(R.id.thumb_button_1);
        thumb1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb1(thumb1View, R.drawable.ethic);
            }
        });

        final View thumb2View = findViewById(R.id.thumb_button_2);
        thumb2View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb2(thumb2View, R.drawable.android);
            }
        });

        final View thumb3View = findViewById(R.id.thumb_button_3);
        thumb3View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb3(thumb3View, R.drawable.webdev);
            }
        });

        final View thumb4View = findViewById(R.id.thumb_button_4);
        thumb4View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb4(thumb4View, R.drawable.hackme);
            }
        });

        // Retrieve and cache the system's default "short" animation time.
        mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_mediumAnimTime);
    }
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private void zoomImageFromThumb1(final View thumbView, int imageResId) {
        // If there's an animation in progress, cancel it
        // immediately and proceed with this one.
        if (mCurrentAnimator1 != null) {
            mCurrentAnimator1.cancel();
        }

        // Load the high-resolution "zoomed-in" image.
        final ImageView expandedImageView = (ImageView) findViewById(
                R.id.expanded_image);
        final TextView expText = (TextView) findViewById(R.id.mytext);
        final LinearLayout mylayout=(LinearLayout) findViewById(R.id.mylayout);
        //final ScrollView myscrollview=(ScrollView) findViewById(R.id.myscrollview);
        final ScrollView mylayout11=(ScrollView) findViewById(R.id.mylayout11);
        final LinearLayout mainlayout=(LinearLayout) findViewById(R.id.mainlayout);


        // Calculate the starting and ending bounds for the zoomed-in image.
        // This step involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        // The start bounds are the global visible rectangle of the thumbnail,
        // and the final bounds are the global visible rectangle of the container
        // view. Also set the container view's offset as the origin for the
        // bounds, since that's the origin for the positioning animation
        // properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds);
        findViewById(R.id.container)
                .getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        // Adjust the start bounds to be the same aspect ratio as the final
        // bounds using the "center crop" technique. This prevents undesirable
        // stretching during the animation. Also calculate the start scaling
        // factor (the end scaling factor is always 1.0).
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation
        // begins, it will position the zoomed-in view in the place of the
        // thumbnail.
        thumbView.setAlpha(0f);
      //  myscrollview.setVisibility(View.GONE);
        expandedImageView.setVisibility(View.VISIBLE);
        expText.setVisibility(View.VISIBLE);
        mylayout.setVisibility(View.VISIBLE);
        mylayout11.setVisibility(View.VISIBLE);
        mainlayout.setVisibility(View.GONE);

        // Set the pivot point for SCALE_X and SCALE_Y transformations
        // to the top-left corner of the zoomed-in view (the default
        // is the center of the view).
        expandedImageView.setPivotX(0f);
        expandedImageView.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and
        // scale properties (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set = new AnimatorSet();
        set
                .play(ObjectAnimator.ofFloat(expandedImageView, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X,
                        startScale, 1f)).with(ObjectAnimator.ofFloat(expandedImageView,
                View.SCALE_Y, startScale, 1f));
        set.setDuration(mShortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentAnimator1 = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimator1 = null;
            }
        });
        set.start();
        mCurrentAnimator1 = set;

        // Upon clicking the zoomed-in image, it should zoom back down
        // to the original bounds and show the thumbnail instead of
        // the expanded image.
        final float startScaleFinal = startScale;
        expandedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentAnimator1 != null) {
                    mCurrentAnimator1.cancel();
                }

                // Animate the four positioning/sizing properties in parallel,
                // back to their original values.
                AnimatorSet set = new AnimatorSet();
                set.play(ObjectAnimator
                        .ofFloat(expandedImageView, View.X, startBounds.left))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.Y,startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_Y, startScaleFinal));
                set.setDuration(mShortAnimationDuration);
                set.setInterpolator(new DecelerateInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                      //  myscrollview.setVisibility(View.VISIBLE);
                        expandedImageView.setVisibility(View.GONE);
                        expText.setVisibility(View.GONE);
                        mylayout.setVisibility(View.GONE);
                        mylayout11.setVisibility(View.GONE);
                        mainlayout.setVisibility(View.VISIBLE);
                        mCurrentAnimator1 = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                      //  myscrollview.setVisibility(View.VISIBLE);
                        expandedImageView.setVisibility(View.GONE);
                        expText.setVisibility(View.GONE);
                        mylayout.setVisibility(View.GONE);
                        mylayout11.setVisibility(View.GONE);
                        mainlayout.setVisibility(View.VISIBLE);
                        mCurrentAnimator1 = null;
                    }
                });
                set.start();
                mCurrentAnimator1 = set;
            }
        });
    }
    private void zoomImageFromThumb2(final View thumbView, int imageResId) {
        // If there's an animation in progress, cancel it
        // immediately and proceed with this one.
        if (mCurrentAnimator2 != null) {
            mCurrentAnimator2.cancel();
        }

        // Load the high-resolution "zoomed-in" image.
        final ImageView expandedImageView2 = (ImageView) findViewById(
                R.id.expanded_image2);
        final TextView expText2 = (TextView) findViewById(R.id.mytext2);
        final LinearLayout mylayout2=(LinearLayout) findViewById(R.id.mylayout2);
       // final ScrollView myscrollview2=(ScrollView) findViewById(R.id.myscrollview2);
        final ScrollView mylayout22=(ScrollView) findViewById(R.id.mylayout22);
        final LinearLayout mainlayout=(LinearLayout) findViewById(R.id.mainlayout);



        // Calculate the starting and ending bounds for the zoomed-in image.
        // This step involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        // The start bounds are the global visible rectangle of the thumbnail,
        // and the final bounds are the global visible rectangle of the container
        // view. Also set the container view's offset as the origin for the
        // bounds, since that's the origin for the positioning animation
        // properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds);
        findViewById(R.id.container)
                .getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        // Adjust the start bounds to be the same aspect ratio as the final
        // bounds using the "center crop" technique. This prevents undesirable
        // stretching during the animation. Also calculate the start scaling
        // factor (the end scaling factor is always 1.0).
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation
        // begins, it will position the zoomed-in view in the place of the
        // thumbnail.
        thumbView.setAlpha(0f);
        //  myscrollview.setVisibility(View.GONE);
        expandedImageView2.setVisibility(View.VISIBLE);
        expText2.setVisibility(View.VISIBLE);
        mylayout2.setVisibility(View.VISIBLE);
        mylayout22.setVisibility(View.VISIBLE);
        mainlayout.setVisibility(View.GONE);

        // Set the pivot point for SCALE_X and SCALE_Y transformations
        // to the top-left corner of the zoomed-in view (the default
        // is the center of the view).
        expandedImageView2.setPivotX(0f);
        expandedImageView2.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and
        // scale properties (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set2 = new AnimatorSet();
        set2
                .play(ObjectAnimator.ofFloat(expandedImageView2, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView2, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView2, View.SCALE_X,
                        startScale, 1f)).with(ObjectAnimator.ofFloat(expandedImageView2,
                View.SCALE_Y, startScale, 1f));
        set2.setDuration(mShortAnimationDuration);
        set2.setInterpolator(new DecelerateInterpolator());
        set2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentAnimator2 = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimator2 = null;
            }
        });
        set2.start();
        mCurrentAnimator2 = set2;

        // Upon clicking the zoomed-in image, it should zoom back down
        // to the original bounds and show the thumbnail instead of
        // the expanded image.
        final float startScaleFinal = startScale;
        expandedImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentAnimator2 != null) {
                    mCurrentAnimator2.cancel();
                }

                // Animate the four positioning/sizing properties in parallel,
                // back to their original values.
                AnimatorSet set2 = new AnimatorSet();
                set2.play(ObjectAnimator
                        .ofFloat(expandedImageView2, View.X, startBounds.left))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView2,
                                        View.Y,startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView2,
                                        View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView2,
                                        View.SCALE_Y, startScaleFinal));
                set2.setDuration(mShortAnimationDuration);
                set2.setInterpolator(new DecelerateInterpolator());
                set2.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                        //  myscrollview.setVisibility(View.VISIBLE);
                        expandedImageView2.setVisibility(View.GONE);
                        expText2.setVisibility(View.GONE);
                        mylayout2.setVisibility(View.GONE);
                        mylayout22.setVisibility(View.GONE);
                        mainlayout.setVisibility(View.VISIBLE);
                        mCurrentAnimator2 = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        //  myscrollview.setVisibility(View.VISIBLE);
                        expandedImageView2.setVisibility(View.GONE);
                        expText2.setVisibility(View.GONE);
                        mylayout2.setVisibility(View.GONE);
                        mylayout22.setVisibility(View.GONE);
                        mainlayout.setVisibility(View.VISIBLE);
                        mCurrentAnimator2 = null;
                    }
                });
                set2.start();
                mCurrentAnimator2 = set2;
            }
        });
    }
    private void zoomImageFromThumb3(final View thumbView, int imageResId) {
        // If there's an animation in progress, cancel it
        // immediately and proceed with this one.
        if (mCurrentAnimator3 != null) {
            mCurrentAnimator3.cancel();
        }

        // Load the high-resolution "zoomed-in" image.
        final ImageView expandedImageView3 = (ImageView) findViewById(
                R.id.expanded_image3);
        final TextView expText3 = (TextView) findViewById(R.id.mytext3);
        final LinearLayout mylayout3=(LinearLayout) findViewById(R.id.mylayout3);
       // final ScrollView myscrollview3=(ScrollView) findViewById(R.id.myscrollview3);
        final ScrollView mylayout33=(ScrollView) findViewById(R.id.mylayout33);
        final LinearLayout mainlayout=(LinearLayout) findViewById(R.id.mainlayout);


        // Calculate the starting and ending bounds for the zoomed-in image.
        // This step involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        // The start bounds are the global visible rectangle of the thumbnail,
        // and the final bounds are the global visible rectangle of the container
        // view. Also set the container view's offset as the origin for the
        // bounds, since that's the origin for the positioning animation
        // properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds);
        findViewById(R.id.container)
                .getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        // Adjust the start bounds to be the same aspect ratio as the final
        // bounds using the "center crop" technique. This prevents undesirable
        // stretching during the animation. Also calculate the start scaling
        // factor (the end scaling factor is always 1.0).
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation
        // begins, it will position the zoomed-in view in the place of the
        // thumbnail.
        thumbView.setAlpha(0f);
        //  myscrollview.setVisibility(View.GONE);
        expandedImageView3.setVisibility(View.VISIBLE);
        expText3.setVisibility(View.VISIBLE);
        mylayout3.setVisibility(View.VISIBLE);
        mylayout33.setVisibility(View.VISIBLE);
        mainlayout.setVisibility(View.GONE);

        // Set the pivot point for SCALE_X and SCALE_Y transformations
        // to the top-left corner of the zoomed-in view (the default
        // is the center of the view).
        expandedImageView3.setPivotX(0f);
        expandedImageView3.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and
        // scale properties (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set3 = new AnimatorSet();
        set3
                .play(ObjectAnimator.ofFloat(expandedImageView3, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView3, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView3, View.SCALE_X,
                        startScale, 1f)).with(ObjectAnimator.ofFloat(expandedImageView3,
                View.SCALE_Y, startScale, 1f));
        set3.setDuration(mShortAnimationDuration);
        set3.setInterpolator(new DecelerateInterpolator());
        set3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentAnimator3 = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimator3 = null;
            }
        });
        set3.start();
        mCurrentAnimator3 = set3;

        // Upon clicking the zoomed-in image, it should zoom back down
        // to the original bounds and show the thumbnail instead of
        // the expanded image.
        final float startScaleFinal = startScale;
        expandedImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentAnimator3 != null) {
                    mCurrentAnimator3.cancel();
                }

                // Animate the four positioning/sizing properties in parallel,
                // back to their original values.
                AnimatorSet set3 = new AnimatorSet();
                set3.play(ObjectAnimator
                        .ofFloat(expandedImageView3, View.X, startBounds.left))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView3,
                                        View.Y,startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView3,
                                        View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView3,
                                        View.SCALE_Y, startScaleFinal));
                set3.setDuration(mShortAnimationDuration);
                set3.setInterpolator(new DecelerateInterpolator());
                set3.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                        //  myscrollview.setVisibility(View.VISIBLE);
                        expandedImageView3.setVisibility(View.GONE);
                        expText3.setVisibility(View.GONE);
                        mylayout3.setVisibility(View.GONE);
                        mylayout33.setVisibility(View.GONE);
                        mainlayout.setVisibility(View.VISIBLE);
                        mCurrentAnimator3 = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        //  myscrollview.setVisibility(View.VISIBLE);
                        expandedImageView3.setVisibility(View.GONE);
                        expText3.setVisibility(View.GONE);
                        mylayout3.setVisibility(View.GONE);
                        mylayout33.setVisibility(View.GONE);
                        mainlayout.setVisibility(View.VISIBLE);
                        mCurrentAnimator3 = null;
                    }
                });
                set3.start();
                mCurrentAnimator3 = set3;
            }
        });
    }
    private void zoomImageFromThumb4(final View thumbView, int imageResId) {
        // If there's an animation in progress, cancel it
        // immediately and proceed with this one.
        if (mCurrentAnimator4 != null) {
            mCurrentAnimator4.cancel();
        }

        // Load the high-resolution "zoomed-in" image.
        final ImageView expandedImageView4 = (ImageView) findViewById(
                R.id.expanded_image4);
        final TextView expText4 = (TextView) findViewById(R.id.mytext4);
        final LinearLayout mylayout4=(LinearLayout) findViewById(R.id.mylayout4);
        //final ScrollView myscrollview4=(ScrollView) findViewById(R.id.myscrollview4);
        final ScrollView mylayout44=(ScrollView) findViewById(R.id.mylayout44);
        final LinearLayout mainlayout=(LinearLayout) findViewById(R.id.mainlayout);


        // Calculate the starting and ending bounds for the zoomed-in image.
        // This step involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        // The start bounds are the global visible rectangle of the thumbnail,
        // and the final bounds are the global visible rectangle of the container
        // view. Also set the container view's offset as the origin for the
        // bounds, since that's the origin for the positioning animation
        // properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds);
        findViewById(R.id.container)
                .getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        // Adjust the start bounds to be the same aspect ratio as the final
        // bounds using the "center crop" technique. This prevents undesirable
        // stretching during the animation. Also calculate the start scaling
        // factor (the end scaling factor is always 1.0).
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation
        // begins, it will position the zoomed-in view in the place of the
        // thumbnail.
        thumbView.setAlpha(0f);
        //  myscrollview.setVisibility(View.GONE);
        expandedImageView4.setVisibility(View.VISIBLE);
        expText4.setVisibility(View.VISIBLE);
        mylayout4.setVisibility(View.VISIBLE);
        mylayout44.setVisibility(View.VISIBLE);
        mainlayout.setVisibility(View.GONE);

        // Set the pivot point for SCALE_X and SCALE_Y transformations
        // to the top-left corner of the zoomed-in view (the default
        // is the center of the view).
        expandedImageView4.setPivotX(0f);
        expandedImageView4.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and
        // scale properties (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set4 = new AnimatorSet();
        set4
                .play(ObjectAnimator.ofFloat(expandedImageView4, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView4, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView4, View.SCALE_X,
                        startScale, 1f)).with(ObjectAnimator.ofFloat(expandedImageView4,
                View.SCALE_Y, startScale, 1f));
        set4.setDuration(mShortAnimationDuration);
        set4.setInterpolator(new DecelerateInterpolator());
        set4.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentAnimator4 = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimator4 = null;
            }
        });
        set4.start();
        mCurrentAnimator4 = set4;

        // Upon clicking the zoomed-in image, it should zoom back down
        // to the original bounds and show the thumbnail instead of
        // the expanded image.
        final float startScaleFinal = startScale;
        expandedImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentAnimator4 != null) {
                    mCurrentAnimator4.cancel();
                }

                // Animate the four positioning/sizing properties in parallel,
                // back to their original values.
                AnimatorSet set4 = new AnimatorSet();
                set4.play(ObjectAnimator
                        .ofFloat(expandedImageView4, View.X, startBounds.left))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView4,
                                        View.Y,startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView4,
                                        View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView4,
                                        View.SCALE_Y, startScaleFinal));
                set4.setDuration(mShortAnimationDuration);
                set4.setInterpolator(new DecelerateInterpolator());
                set4.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                        //  myscrollview.setVisibility(View.VISIBLE);
                        expandedImageView4.setVisibility(View.GONE);
                        expText4.setVisibility(View.GONE);
                        mylayout4.setVisibility(View.GONE);
                        mylayout44.setVisibility(View.GONE);
                        mainlayout.setVisibility(View.VISIBLE);
                        mCurrentAnimator4 = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        //  myscrollview.setVisibility(View.VISIBLE);
                        expandedImageView4.setVisibility(View.GONE);
                        expText4.setVisibility(View.GONE);
                        mylayout4.setVisibility(View.GONE);
                        mylayout44.setVisibility(View.GONE);
                        mainlayout.setVisibility(View.VISIBLE);
                        mCurrentAnimator4 = null;
                    }
                });
                set4.start();
                mCurrentAnimator4 = set4;
            }
        });
    }
}




