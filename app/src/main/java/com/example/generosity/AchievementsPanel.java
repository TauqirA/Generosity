/*package com.example.generosity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class AchievementsPanel extends SurfaceView implements SurfaceHolder.Callback {
	private SurfaceHolder holder;
	private AchievementsThread at;
	public boolean [] achievements = new boolean[8];
	String[] stuff = {"Earn 1000 Points","Earn 1,000,000 Coins",
			"Earn 99,999,999 Coins","Earn 9,001 Points","Earn 9,999,999 Points",
			"Earn 99,999,999 Points","Invest in Stocks 100 times","Build 100 Mosques",};;
	String[] names = {"Just Keep Clickin'","Who needs the Lottery?",
			"Carlos Slim Jr.","IT'S OVER 9000!","Just Getting Started",
			"Sky's the Limit","No 1929 Crashes Please","Such Generous"};
			
	
	
	public AchievementsPanel(Context context, AttributeSet attrs) {
		super(context, attrs);
		getHolder().addCallback(this);
		at = new AchievementsThread(getHolder(), this);
		setFocusable(true);
		// TODO Auto-generated constructor stub
	}

	
public void setAchievementPanel(boolean [] a){
	for(int i = 0; i < 8; i++){
		achievements[i] = a[i];
		
	}//end for
	
}//setter
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		if(!at.isAlive()){
			at.setRunning(true);
			at.start();

		}
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		//if(canvasThread != null){
			boolean retry = true;
			at.setRunning(false);
			while (retry) {
				try {
					at.join();
					retry = false;
				} catch (InterruptedException e) {
					// we will try it again and again...
				}
			}
	//	}//end if
	}

	public void onDraw(Canvas c){
		c.drawColor(Color.BLACK);
		Paint p = new Paint();
		
		p.setColor(Color.rgb(0,100,150));
		c.drawRect(1*getWidth()/16,3*getHeight()/100,getWidth()/3, 9*getHeight()/100,p);
		p.setColor(Color.rgb(255,155,150));
		c.drawText("Go Back", (float)1.6* getWidth()/16, 7*getHeight()/100, p);
				
		p.setColor(Color.rgb(0,150,0));
		
		for(int i = 0; i < 8; i ++){
			int q = 0;
			if(achievements[i] == true){
				p.setColor(Color.rgb(0,150,0));
				q = 0;
			}
			else{
				p.setColor(Color.rgb(150,10,20));
				q = 255;
			}
			
			c.drawRect(getWidth()/16, ((12+i*11)*getHeight()/100),15*getWidth()/16, (22+i*11)*getHeight()/100,p);
			p.setColor(Color.rgb(q,q,q));
			p.setTextSize(getHeight()/35);
			c.drawText(stuff[i], 2*getWidth()/16,((21+i*11)*getHeight()/100),p);
			
			p.setColor(Color.rgb(q, q, q));
			p.setTextSize(getHeight()/25);
			c.drawText(names[i],(float)1.8*getWidth()/16,((16+i*11)*getHeight()/100),p);
		}//end for
	

	
	}//end onDraw
	
	
	
	
}*/
