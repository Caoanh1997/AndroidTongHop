package com.example.caoan.androidtonghop;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TestAnimation extends AppCompatActivity {

    private Button bt1,bt2,bt3;
    private ImageView imageView;
    private Animation animation;
    private boolean clicked = false;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_animation);

        //overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);

        imageView = findViewById(R.id.iv);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        linearLayout = findViewById(R.id.ll);
        LayoutTransition l = new LayoutTransition();
        l.enableTransitionType(LayoutTransition.CHANGING);
        linearLayout.setLayoutTransition(l);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.addView(new Button(TestAnimation.this));
            }
        });

        //overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

        final ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(
                this, R.animator.value_animator_ex);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float progress = (float) animation.getAnimatedValue();
                imageView.setTranslationY(progress);
            }
        });
        //valueAnimator.start();

        final ObjectAnimator textViewAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this,
                R.animator.object_animator_ex);
        textViewAnimator.setTarget(imageView);
        //textViewAnimator.start();
        ObjectAnimator translate = ObjectAnimator.ofFloat(imageView,"translationY",500f);
        translate.setDuration(2000);

        ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView,"rotation",360f);
        rotation.setDuration(2000);

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translate,rotation);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if (!clicked) {
                    bt2.animate().translationX(400).withLayer();
                    clicked = true;
                } else {
                    bt2.animate().translationX(0).withLayer();
                    clicked = false;
                }*/
                //extViewAnimator.start();
                animatorSet.start();
            }
        });

        animation = new AnimationUtils().loadAnimation(getApplicationContext(),R.anim.move);
        //imageView.setAnimation(animation);
        //animation.setAnimationListener((Animation.AnimationListener) this);// bo
        //imageView.startAnimation(animation);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.startAnimation(animation);
                //valueAnimator.start();
            }
        });
    }
}
