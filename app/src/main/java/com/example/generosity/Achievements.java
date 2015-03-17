package com.example.generosity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Achievements extends Activity {
	private int height;
	private int width;
	private TextView test;
	private float rateM;
	private float rateH;
	private int coins;
	private float points;
	private int [] numH;
	private int [] numM;
	Button goBack;
	public boolean [] achievements = new boolean[8];
	Button [] ach = new Button[8];
	String[] stuff = {"Earn 1000 Points","Earn 1,000,000 Coins",
			"Earn 99,999,999 Coins","Earn 9,001 Points","Earn 9,999,999 Points",
			"Earn 99,999,999 Points","Invest in Stocks 100 times","Build 100 Mosques",};;
	String[] names = {"Just Keep Clickin'","Who needs the Lottery?",
			"Carlos Slim Jr.","IT'S OVER 9000!","Just Getting Started",
			"Sky's the Limit","No 1929 Crashes Please","Such Generous"};
			
	@SuppressLint("ResourceAsColor")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_achievements);
		Bundle extras = getIntent().getExtras();  
		if(extras != null){
			numH = extras.getIntArray("numH");
			numM = extras.getIntArray("numM");
			coins = extras.getInt("coins");
			rateM = extras.getFloat("rateM");
			rateH = extras.getFloat("rateH");
			points = extras.getFloat("points");
		}//end if 
		else{
			points = 0;
			coins = 0;
			rateM = 0;
			rateH = 0;
		}
		 

		setButtons();
		setAchievements();
		for(int i = 0; i < 8; i ++){
			int q = 0;
			if(achievements[i] == true){
				ach[i].setBackgroundColor(Color.rgb(0,150,0));
				q = 0;
			}
			else{
				ach[i].setBackgroundColor(Color.rgb(150,10,20));
				q = 255;
			}
			ach[i].setTextColor(Color.rgb(q, q, q));
			ach[i].setText(names[i] + "\n" + stuff[i]);
			
			
		}//end for
		goBack = (Button)findViewById(R.id.back3);
		  goBack.setOnClickListener(new View.OnClickListener() {
		   public void onClick(View v) {
		    onBackPressed();
		   }
		  });
	}

	public void setButtons(){
		
		ach[0] = (Button)findViewById(R.id.button1);
		ach[1] = (Button)findViewById(R.id.button2);
		ach[2] = (Button)findViewById(R.id.button3);
		ach[3] = (Button)findViewById(R.id.button4);
		ach[4] = (Button)findViewById(R.id.button5);
		ach[5] = (Button)findViewById(R.id.button6);
		ach[6] = (Button)findViewById(R.id.button7);
		ach[7] = (Button)findViewById(R.id.button8);

		
	}//end setButtons
	
	
	public void onBackPressed() {
		Intent switches = new Intent(getApplicationContext(), Home.class);

		switches.putExtra("numM", numM);
		switches.putExtra("rateM", rateM);
		switches.putExtra("coins", coins);
		switches.putExtra("numH", numH);
		switches.putExtra("points", points);
		switches.putExtra("rateH", rateH);
		startActivity(switches);
		super.onBackPressed();
	}

	public boolean onTouchEvent(MotionEvent event) {
		float xP = event.getX();
		float yP = event.getY();
		Intent switches = new Intent(getApplicationContext(), Home.class);
		if (yP >= 3*height/100 && yP <= 9*height/100) {
			if(xP >=1*width/16 && xP <= width/3 ){
				switches.putExtra("numM", numM);
				switches.putExtra("rateM", rateM);
				switches.putExtra("coins", coins);
				switches.putExtra("numH", numH);
				switches.putExtra("points", points);
				switches.putExtra("rateH", rateH);
				startActivity(switches);
			}//end if
		}// end if
		return true; 
	}

	public void setAchievements(){

		if(points > 1000){
			achievements[0] = true;
		}//end if
		if(coins >= 1000000){//
			achievements[1] = true;
		}//end if
		if(coins >= 99999999){//
			achievements[2] = true;
		}//end if
		if(points >= 1000000){//
			achievements[3] = true;
		}//end if
		if(points >= 9999999){//
			achievements[4] = true;
		}//end if
		if(points >= 99999999){//
			achievements[5] = true;
		}//end if
		if(numM[5] >= 100){//
			achievements[6] = true;
		}//end if
		if(numH[5] >= 100){//
			achievements[7] = true;
		}//end if



	}//end set

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.achievements, menu);
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
}
