package com.example.texturedemo.gles;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;


import com.example.texturedemo.data.CameraView;
import com.example.texturedemo.data.Color;
import com.example.texturedemo.data.Cube;
import com.example.texturedemo.data.HelloTriangel2;
import com.example.texturedemo.data.Lamp;
import com.example.texturedemo.data.LearnTexture;
import com.example.texturedemo.data.Lighting;
import com.example.texturedemo.data.Picture;
import com.example.texturedemo.data.Square;
import com.example.texturedemo.data.Transform;
import com.example.texturedemo.data.Triangle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by wenzhe on 8/26/16.
 */

public class MyRender implements GLSurfaceView.Renderer {

    private Context mContext;

    public MyRender(Context context) {
        mContext = context;
    }

    private Triangle mTriangle;
    private Square square;
    private Picture picture;
    private HelloTriangel2 triangel2;
    private LearnTexture texture;
    private Transform transform;
    private Cube cube;
    private CameraView cameraView;
    private Color color;
    private Lamp lamp;
    private Lighting lighting;

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES30.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        //mTriangle = new Triangle();
        //square = new Square();
        //picture = new Picture(mContext);
        //triangel2 = new HelloTriangel2(mContext);
        //texture = new LearnTexture(mContext);
        //transform = new Transform(mContext);
        //cube = new Cube(mContext);
        //cameraView = new CameraView(mContext);
        //color = new Color(mContext);
        lighting = new Lighting(mContext);
        lamp = new Lamp(mContext);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {
        GLES30.glViewport(0, (i1 - i) / 2, i, i);
        GLES30.glEnable(GLES30.GL_DEPTH_TEST);
        GLES30.glEnable(GLES30.GL_BLEND);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT|GLES30.GL_DEPTH_BUFFER_BIT);
        lighting.draw();
        lamp.draw();
    }


    public void release() {
        lamp.release();
        lighting.release();
    }
}
