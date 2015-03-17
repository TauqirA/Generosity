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
import android.widget.Toast;

public class Heaven extends Activity {
	int coins;
	int width;
	float points;
	int height;
	float rateM;
	float rateH;
	private int[] numH = new int[6];
	private int[] numM = new int[6];
	int [] costs = {100,1000,5000,10000,50000,1000000};
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	Button b6;
	Button goBack;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();  
		rateM = 0;
		rateH = 0;
		if (extras != null) {
			numH = extras.getIntArray("numH");
			numM = extras.getIntArray("numM");

			coins = extras.getInt("coins");
			rateM = extras.getFloat("rateM");
			rateH = extras.getFloat("rateH");
			points = extras.getFloat("points");
		}// end if
		setContentView(R.layout.activity_heaven);
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		getActionBar().setTitle("Heaven: "+coins);   
		width = size.x;
		height = size.y;
		goBack = (Button)findViewById(R.id.back1);
		goBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				onBackPressed();
			}
		});
		b1 = (Button) findViewById(R.id.button7);
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(coins >= (int) (costs[0]*(1+numH[0]/2.0))){
					
					rateH+= 1;
					coins-= (int) (costs[0]*(1+numH[0]/2.0));
					numH[0]+=1;
					
					Toast q = Toast.makeText(getApplicationContext(),
							"Thank you for Donating", 50); 
					q.show();
					b1.setText("Give to Homeless $"+(int) (costs[0]*(1+numH[0]/2.0))+"\n Own:"+numH[0]);
					getActionBar().setTitle("Heaven: "+coins);  
					

				}//end if
			}
		});
		b2 = (Button) findViewById(R.id.button8);
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(coins >= (int)costs[1]*(1+numH[1]/2.0)){
					
					rateH+= 5.5;
					coins-= (int) (costs[1]*(1+numH[1]/2.0));
					numH[1]+=1;
					
					Toast q = Toast.makeText(getApplicationContext(),
							"Thank you for Donating", 50); 
					q.show();
					b2.setText("Pay Zaakat  $"+(int)costs[1]*(1+numH[1]/2.0)+"\n Own:"+numH[1]);
					getActionBar().setTitle("Heaven: "+coins);   
					


				}//end if
			}
		});
		b3 = (Button) findViewById(R.id.button9);
		b3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(coins >= (int)costs[2]*(1+numH[2]/2.0)){
					

					rateH+= 15.5;
					coins-= (int) (costs[2]*(1+numH[2]/2.0));
					numH[2]+=1;
					
					Toast q = Toast.makeText(getApplicationContext(),
							"Thank you for Donating", 50); 
					q.show();
					b3.setText("Donate to Charity $"+(int)costs[2]*(1+numH[2]/2.0)+"\n Own:"+numH[2]);
					getActionBar().setTitle("Heaven: "+coins); 
					

				}//end if

			}
		});
		b4 = (Button) findViewById(R.id.button10);
		b4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(coins >= (int)costs[3]*(1+numH[3]/2.0)){
					
					rateH+= 20;
					coins-= (int) (costs[3]*(1+numH[3]/2.0));
					numH[3]+=1;
					
					
					Toast q = Toast.makeText(getApplicationContext(),
							"Thank you for Donating", 50); 
					q.show();
					b4.setText("Donate to Mosque $"+(int)costs[3]*(1+numH[3]/2.0)+"\n Own:"+numH[3]);
					getActionBar().setTitle("Heaven: "+coins);   
					


				}//end if

			}
		});
		b5 = (Button) findViewById(R.id.button11);
		b5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(coins >= (int)costs[4]*(1+numH[4]/2.0)){
					
					rateH+= 22.5;
					coins-= (int) (costs[4]*(1+numH[4]/2.0));
					numH[4]+=1;
					
					Toast q = Toast.makeText(getApplicationContext(),
							"Thank you for Donating", 50); 
					q.show();
					b5.setText("Help Natural Disaster Victims $"+(int)costs[4]*(1+numH[4]/2.0)+"\n Own:"+numH[4]);
					getActionBar().setTitle("Heaven: "+coins); 
					


				}//end if

			}
		});
		b6 = (Button) findViewById(R.id.button12);
		b6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {    
				if(coins >= (int)costs[5]*(1+numH[5]/2.0)){
					
					rateH+= 50;
					coins-= (int) (costs[5]*(1+numH[5]/2.0));
					numH[5]+=1;
					
					Toast q = Toast.makeText(getApplicationContext(),
							"Thank you for Donating", 50); 
					q.show();
					b6.setText("Build a Mosque $"+(int)costs[5]*(1+numH[5]/2.0)+"\n Own:"+numH[5]);
					getActionBar().setTitle("Heaven: "+coins);  
					

				}//end if

			}
		});
		 

		b1.setBackgroundColor(Color.rgb(135, 206, 235));
		b2.setBackgroundColor(Color.rgb(119, 181, 254));
		b3.setBackgroundColor(Color.rgb(135, 206, 235));
		b4.setBackgroundColor(Color.rgb(119, 181, 254));
		b5.setBackgroundColor(Color.rgb(135, 206, 235));
		b6.setBackgroundColor(Color.rgb(119, 181, 254));
		b1.setText("Give to Homeless $"+(int)costs[0]*(1+numH[0]/2.0)+"\n Own:"+numH[0]);
		b2.setText("Pay Zaakat  $"+(int)costs[1]*(1+numH[1]/2.0)+"\n Own:"+numH[1]);
		b3.setText("Donate to Charity $"+(int)costs[2]*(1+numH[2]/2.0)+"\n Own:"+numH[2]);
		b4.setText("Donate to Mosque $"+(int)costs[3]*(1+numH[3]/2.0)+"\n Own:"+numH[3]);
		b5.setText("Help Natural Disaster Victims $"+(int)costs[4]*(1+numH[4]/2.0)+"\n Own:"+numH[4]);
		b6.setText("Build a Mosque $"+(int)costs[5]*(1+numH[5]/2.0)+"\n Own:"+numH[5]);
		int color = 0xff000080;
		b1.setTextColor(color);
		b2.setTextColor(color);
		b3.setTextColor(color);
		b4.setTextColor(color);
		b5.setTextColor(color);
		b6.setTextColor(color);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.heaven, menu);
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
		Intent switches = new Intent(getApplicationContext(), Home.class);
		if (yP > 0 && yP < height / 7) {
			switches.putExtra("rateM", rateM);
			switches.putExtra("coins", coins);
			switches.putExtra("points", points);
			switches.putExtra("rateH", rateH);
			switches.putExtra("numH", numH);
			switches.putExtra("numM", numM);
			startActivity(switches);
		}// end if
		return true;
	}

	public void onBackPressed() {
		Intent switches = new Intent(getApplicationContext(), Home.class);

		switches.putExtra("rateM", rateM);
		switches.putExtra("coins", coins);
		switches.putExtra("points", points);
		switches.putExtra("rateH", rateH);
		switches.putExtra("numH", numH);
		switches.putExtra("numM", numM);

		startActivity(switches);
		super.onBackPressed();
	}
}
