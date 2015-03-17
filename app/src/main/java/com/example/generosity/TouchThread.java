package com.example.generosity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class TouchThread extends Thread{

	boolean running;
	boolean paused = false;
	boolean drawSomething = false;
	
	float touchX = 0;
	float touchY = 0;
	
	int height;
	int width;
	
	SurfaceHolder holder;
	
	
	
	public TouchThread(SurfaceHolder holder, Context context) {
		this.holder = holder;
	}
	
	public void setIsRunning(boolean running) {
		this.running = running;
	}
	
	public void setPaused(boolean paused) {
		this.paused = paused;
	}
	
	public void setDimensions(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	public void setDrawSomething(float touchX, float touchY) {
		drawSomething = true;
		this.touchX = touchX;
		this.touchY = touchY;
	}
	
	public void run() {
	
		
		long lastTime = SystemClock.uptimeMillis();
		while(running) {
			Canvas canvas = null;
			
			try{
				
				canvas = holder.lockCanvas(null);
				canvas.drawColor(Color.BLACK);
				Paint p = new Paint();
				
				p.setColor(Color.WHITE);
				canvas.drawRect(0, 0, width, height/6, p);
				if(touchX > 0 && touchX < height/6){
				}
				
				
			}
			catch(Exception e) {
				
			}
			if(canvas != null) {
				holder.unlockCanvasAndPost(canvas);
			}
		}
	}
	
}
