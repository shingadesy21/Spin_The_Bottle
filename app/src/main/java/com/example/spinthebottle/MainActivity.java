package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Random random=new Random();
    private int lastDir;
    private boolean spinning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.bottle);
//imageView.setImageResource(0);
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!spinning) {
                    int newDir = random.nextInt(3000);
                    float pivotx = imageView.getWidth() / 2;
                    float pivoty = imageView.getHeight() / 2;
                    Animation animation = new RotateAnimation(lastDir, newDir, pivotx, pivoty);
                    animation.setDuration(2000);
                    animation.setFillAfter(true);
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            spinning=true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            spinning=false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    lastDir = newDir;
                    imageView.startAnimation(animation);
                }
            }
        });
    }
}
