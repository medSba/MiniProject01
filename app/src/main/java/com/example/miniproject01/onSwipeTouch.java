package com.example.miniproject01;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

import java.lang.reflect.Constructor;

public abstract class onSwipeTouch implements View.OnTouchListener{
    private final int THRESHOLD=200;
    private Context context;
    GestureDetector gestureDetector;
    public onSwipeTouch(Context context) {
        this.context = context;
        gestureDetector=new GestureDetector(context,new GestureListenner());
    }

class GestureListenner extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX()-e2.getX()>THRESHOLD)
                swipeLeft();
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    protected abstract void swipeLeft();

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
