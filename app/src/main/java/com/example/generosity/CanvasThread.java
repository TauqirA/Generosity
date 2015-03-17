package com.example.generosity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class CanvasThread extends Thread {
	private SurfaceHolder _surfaceHolder;
    private HomePanel _panel;
    private boolean _run = false;

    public CanvasThread(SurfaceHolder surfaceHolder, HomePanel panel) {
        _surfaceHolder = surfaceHolder;
        _panel = panel;
    }
 
    public void setRunning(boolean run) {
        _run = run;
    }
    
  
    @SuppressLint({ "WrongCall", "NewApi" })
	public void run() {
        Canvas c;
        while (_run) {
            c = null;
            try {
                c = _surfaceHolder.lockCanvas(null);
                synchronized (_surfaceHolder) {
                	if(!_run){
                        break;
                	}
                    _panel.onDraw(c);

                }
            } finally {
                // do this in a finally so that if an exception is thrown
                // during the above, we don't leave the Surface in an
                // inconsistent state
                if (c != null) {
                    _surfaceHolder.unlockCanvasAndPost(c);
                }
            }
        }
        
    }
    

	
}
