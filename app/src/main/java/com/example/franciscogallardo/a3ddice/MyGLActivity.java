package com.example.franciscogallardo.a3ddice;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.Random;

import javax.microedition.khronos.opengles.GL;

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
                myGLRenderer.diceWasThrown = true;

                /*
                * Heads up! :)
                * myGLRenderer.angleDice
                * Sets the degrees the dice will rotate
                * after click.
                * */

                System.out.println(diceThrow);
                switch (diceThrow) {
                    case 1:
                        myGLRenderer.angleDice = 1080;
                        myGLRenderer.speedDice = 15;
                        myGLRenderer.diceNumberSetter(MyGLRenderer.DiceNumber.ONE);
                        break;
                    case 2:
                        myGLRenderer.angleDice = 1080;
                        myGLRenderer.speedDice = 15;
                        myGLRenderer.diceNumberSetter(MyGLRenderer.DiceNumber.TWO);
                        break;
                    case 3:
                        myGLRenderer.angleDice = 1080;
                        myGLRenderer.speedDice = 15;
                        myGLRenderer.diceNumberSetter(MyGLRenderer.DiceNumber.THREE);
                        break;
                    case 4:
                        myGLRenderer.angleDice = 1080;
                        myGLRenderer.speedDice = 15;
                        myGLRenderer.diceNumberSetter(MyGLRenderer.DiceNumber.FOUR);
                        break;
                    case 5:
                        myGLRenderer.angleDice = 1080;
                        myGLRenderer.speedDice = 15;
                        myGLRenderer.diceNumberSetter(MyGLRenderer.DiceNumber.FIVE);
                        break;
                    case 6:
                        myGLRenderer.angleDice = 1080;
                        myGLRenderer.speedDice = 15;
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
