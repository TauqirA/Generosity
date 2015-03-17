package com.example.generosity;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.TextView;

public class Home extends Activity {
	private int height;
	private int width;
	private TextView test;
	private float rateM;
	private float rateH;
	private int coins;
	private float points;
	private int [] numH = new int[6];
	private int [] numM = new int[6];
	private boolean [] achievements = new boolean[6];
	HomePanel hp;


	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		test = (TextView) findViewById(R.id.test);
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		width = size.x; 
		height = size.y;	
		hp = (HomePanel) findViewById(R.id.SurfaceView01);
		if(getIntent().getExtras() != null){
			coins = getIntent().getExtras().getInt("coins");
			points = getIntent().getExtras().getFloat("points");
			rateM =  getIntent().getExtras().getFloat("rateM");
			rateH =  getIntent().getExtras().getFloat("rateH");
			numM = getIntent().getExtras().getIntArray("numM");
			numH = getIntent().getExtras().getIntArray("numH");
			hp.setRateM(rateM);
			hp.setPoints(points);
			hp.setCoins(coins);
			hp.setRateH(rateH);
		}//end if
		else{
			hp.setPoints(points);
			hp.setCoins(coins); 
		}//end else

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	protected void onPause() {
		super.onPause();
	}

	protected void onResume() {
		super.onResume();
	}

	protected void onDestroy() {
		super.onDestroy();
	}
	public boolean onTouchEvent(MotionEvent event) {
		float xP = event.getX();
		float yP = event.getY();
		test.setText(xP + " " + yP + "\n" + rateM);
		Intent switches = new Intent(getApplicationContext(), Heaven.class);
		if(yP > 0 && yP< height/4){
			switches.putExtra("coins", hp.getCoins());
			switches.putExtra("points", hp.getPoints());
			switches.putExtra("rateM", hp.getRateM());
			switches.putExtra("rateH", hp.getRateH());
			switches.putExtra("numH", numH);
			switches.putExtra("numM", numM);

			startActivity(switches);
		}//end if
		Intent switches2 = new Intent(getApplicationContext(), Earth.class);
		if(yP >height-height/4 && yP< height){
			switches2.putExtra("coins", hp.getCoins());
			switches2.putExtra("points", hp.getPoints());
			switches2.putExtra("rateM", hp.getRateM());
			switches2.putExtra("rateH", hp.getRateH());
			switches2.putExtra("numH", numH);
			switches2.putExtra("numM", numM);

			startActivity(switches2);
		}//end if
		Intent switches3 = new Intent(getApplicationContext(), Achievements.class);

		if(xP>3*width/4){
			if(yP>=height/4+ height/20 + height/10 &&yP<=height/4+ height/20+height/15 + + height/10 ){
				switches3.putExtra("coins", hp.getCoins());
				switches3.putExtra("points", hp.getPoints());
				switches3.putExtra("rateM", hp.getRateM());
				switches3.putExtra("rateH", hp.getRateH());
				switches3.putExtra("numH", numH);
				switches3.putExtra("numM", numM);
				startActivity(switches3);
			}


		}
		return true;
	}


}
