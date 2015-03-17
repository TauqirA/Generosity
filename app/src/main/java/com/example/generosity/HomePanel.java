package com.example.generosity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

@SuppressLint("NewApi")
public class HomePanel extends SurfaceView implements SurfaceHolder.Callback {
	private SurfaceHolder holder;
	private CanvasThread canvasThread;
	private int coins;
	private float points;
	private int counter;
	private float rateM;
	private float rateH;
	private float actualrateH;
	long start = SystemClock.uptimeMillis();
	Bitmap achi;

	Bitmap coinClick;
	Bitmap coinClicked;
	Bitmap bg;
	boolean pressed;
	public HomePanel(Context context, AttributeSet attrs) {
		super(context, attrs);
		getHolder().addCallback(this);
		canvasThread = new CanvasThread(getHolder(), this);
		setFocusable(true);
		pressed = false;
		counter =0;
		achi =BitmapFactory.decodeResource(getResources(), R.drawable.achi);
		bg=BitmapFactory.decodeResource(getResources(), R.drawable.homescreen);
		coinClick=BitmapFactory.decodeResource(getResources(), R.drawable.coin);
		coinClicked = BitmapFactory.decodeResource(getResources(), R.drawable.coinpressed);
		//coins += rateM*5;
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {

	}
	public void setRateM(float rm){
		rateM = rm;
	}//end setRate
	public float getRateM(){
		return rateM;
	}//end getCoins
	
	
	public int getCoins(){
		return coins;
	}//end getCoins
	public void setCoins(int c){
		coins = c;
	}//end setCoins
	
	
	public float getPoints(){
		return points;
	}//end getCoins
	public void setPoints(float p){
		points = p;
	}//end setCoins
	
	
	
	public void setRateH(float rh){
		rateH = rh;
		actualrateH = rh;
	}//end setRate
	public float getRateH(){
		return rateH;
	}//end getCoins
	

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		if(!canvasThread.isAlive()){
			canvasThread.setRunning(true);
			canvasThread.start();

		}
		
	}
	public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth){
		int width = bm.getWidth();
		int height = bm.getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// create a matrix for the manipulation
		Matrix matrix = new Matrix();
		// resize the bit map
		matrix.postScale(scaleWidth, scaleHeight);
		// recreate the new Bitmap
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
		return resizedBitmap;
	}
	
	/***********************/
	public void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		if(counter <100){
		coinClick = getResizedBitmap(coinClick,getHeight()/3,getWidth()/2 );
		coinClicked = getResizedBitmap(coinClicked,getHeight()/3,getWidth()/2 );
		bg = getResizedBitmap(bg,getHeight(),getWidth() );
		achi = getResizedBitmap(achi,getHeight()/15,getWidth()/4 );

		}//end if
		
		canvas.drawColor(Color.LTGRAY);
		paint.setColor(Color.BLUE);
		canvas.drawRect(0, 0, getWidth(), getHeight()/4, paint);
		paint.setColor(Color.GREEN);
		canvas.drawRect(0, getHeight()-getHeight()/4, getWidth(),getHeight(), paint);
	 
		
		canvas.drawBitmap(bg, 0,0, paint);
		canvas.drawBitmap(achi, 3*getWidth()/4, getHeight()/4+ getHeight()/20, paint);
		if(pressed){
			canvas.drawBitmap(coinClicked, getWidth()/4, getHeight()/3, paint);
			if(counter%5==0)
				pressed = false;
		}
		else{ 
		canvas.drawBitmap(coinClick, getWidth()/4, getHeight()/3, paint);
		}
		if(rateM > 0&&counter%2==0){//this was changed
			coins += (int)(rateM);
		}
		if(rateH > 0&&counter%2==0 /*&& SystemClock.uptimeMillis()/start > 0*/){//this was changed
			points += (actualrateH); 
			actualrateH = (float) (rateH*(Math.pow(.9, .05* (SystemClock.uptimeMillis()-start)/1000)));
		}
		counter++;
		paint.setColor(Color.WHITE);
		paint.setTextSize(getWidth()/8);
		float widthCoins = paint.measureText(""+coins);
		canvas.drawText(""+coins, getWidth()/2 - widthCoins/2,7*getHeight()/8, paint);
		paint.setColor(Color.BLACK);
		float widthPoints = paint.measureText(""+(int)Math.floor(points));
		canvas.drawText(""+(int)Math.floor(points), getWidth()/2 - widthPoints/2,getHeight()/8, paint);

		

	}
	/******************************/
	public boolean onTouchEvent(MotionEvent event) {
		float xP = event.getX();
		float yP = event.getY();
		if(xP>getWidth()/2-getWidth()/4&&xP<getWidth()/2+getWidth()/4)
			if(yP>getHeight()/2-getWidth()/4&&yP<getHeight()/2+getWidth()/4){
		coins++;
		pressed = true;
		start = SystemClock.uptimeMillis();

		}
		
		return false;
	}
/*********************/
	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		//if(canvasThread != null){
			boolean retry = true;
			canvasThread.setRunning(false);
			while (retry) {
				try {
					canvasThread.join();
					retry = false;
				} catch (InterruptedException e) {
					// we will try it again and again...
				}
			}
	//	}//end if
	}
/*********************************************/
}
