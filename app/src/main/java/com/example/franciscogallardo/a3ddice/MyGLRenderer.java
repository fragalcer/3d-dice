package com.example.franciscogallardo.a3ddice;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by franciscogallardo on 17/8/17.
 */

public class MyGLRenderer implements GLSurfaceView.Renderer {

    private Dice dice;
    float angleDice = 0;     // initial rotation degree for the dice.
    int speedDice = 0;  //rotational speed for dice.
    boolean diceWasThrown = false;
    private DiceNumber diceNumber;
    enum DiceNumber {ONE, TWO, THREE, FOUR, FIVE, SIX}

    MyGLRenderer(Context context) {
        dice = new Dice(context);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glDisable(GL10.GL_DITHER);

        dice.loadTexture(gl);
        gl.glEnable(GL10.GL_TEXTURE_2D);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0) height = 1;
        float aspect = (float) width / height;

        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        GLU.gluPerspective(gl, 45, aspect, 0.1f, 100.f);

        gl.glScalef(.5f, .5f, 1f);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -6.0f);

        if (diceWasThrown) {
            gl.glRotatef(angleDice, 0.15f, 1.0f, 0.3f);

            switch (this.diceNumber) {
                case ONE:
                    if (angleDice == 0) {
                        diceWasThrown = false;
                        break;
                    }
                    angleDice -= speedDice;
                    break;

                case TWO:
                    if (angleDice == 90) {
                        diceWasThrown = false;
                        break;
                    }
                    angleDice -= speedDice;
                    break;

                case THREE:
                    if (angleDice == 180) {
                        diceWasThrown = false;
                        break;
                    }
                    angleDice -= speedDice;
                    break;

                case FOUR:
                    if (angleDice == 0) {
                        diceWasThrown = false;
                        break;
                    }
                    angleDice -= speedDice;
                    break;

                case FIVE:
                    if (angleDice == 270) {
                        diceWasThrown = false;
                        break;
                    }
                    angleDice -= speedDice;
                    break;

                case SIX:
                    if (angleDice == 180) {
                        diceWasThrown = false;
                        break;
                    }
                    angleDice -= speedDice;
                    break;
            }
        } else {
            gl.glRotatef(angleDice, 0.15f, 1.0f, 0.3f);
        }
        dice.draw(gl);
    }

    void diceNumberSetter(DiceNumber theDiceNumber) {

        this.diceNumber = theDiceNumber;

    }

}
