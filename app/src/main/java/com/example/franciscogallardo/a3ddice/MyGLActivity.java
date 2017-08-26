package com.example.franciscogallardo.a3ddice;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.Random;

/**
 * Created by franciscogallardo on 17/8/17.
 */

public class MyGLActivity extends Activity {

    private GLSurfaceView glView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glView = new GLSurfaceView(this);
        final MyGLRenderer myGLRenderer = new MyGLRenderer(this);
        glView.setRenderer(myGLRenderer);

        this.setContentView(glView);


        glView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int diceThrow = random.nextInt(6) + 1;

                /*
                * Heads up! :)
                * myGLRenderer.angleDice
                * Sets the degrees the dice will rotate
                * after click.
                * */

                myGLRenderer.angleDice = 1080;
                myGLRenderer.speedDice = 5;
                myGLRenderer.fixX = 15;
                myGLRenderer.fixY = 100;
                myGLRenderer.fixZ = 30;

                System.out.println(diceThrow);
                switch (diceThrow) {
//                switch (4) {
                    case 1:
                        myGLRenderer.diceNumberSetter(MyGLRenderer.DiceNumber.ONE);
                        break;
                    case 2:
                        myGLRenderer.diceNumberSetter(MyGLRenderer.DiceNumber.TWO);
                        break;

                    case 3:
                        myGLRenderer.diceNumberSetter(MyGLRenderer.DiceNumber.THREE);
                        break;

                    case 4:
                        myGLRenderer.diceNumberSetter(MyGLRenderer.DiceNumber.FOUR);
                        myGLRenderer.fix4 = 0;
                        break;

                    case 5:
                        myGLRenderer.diceNumberSetter(MyGLRenderer.DiceNumber.FIVE);
                        break;
                    case 6:
                        myGLRenderer.diceNumberSetter(MyGLRenderer.DiceNumber.SIX);
                        break;
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        glView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glView.onResume();
    }
}
