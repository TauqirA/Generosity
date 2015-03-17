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

public class Earth extends Activity {
 int coins;
 int width;
 int height;
 float rateM;
 private int[] numM = new int[6];
 float rateH;
 private int[] numH = new int[6];
 int [] costs = {10,100,500,5000,10000,15000}; float points;
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
  if (extras != null) {
   numM = extras.getIntArray("numM");
   coins = extras.getInt("coins");
   rateM = extras.getFloat("rateM");
   numH = extras.getIntArray("numH");
   points = extras.getFloat("points");
   rateH = extras.getFloat("rateH");
  }// end if
  setContentView(R.layout.activity_earth);
  Display display = getWindowManager().getDefaultDisplay();
  Point size = new Point();
  display.getSize(size);
  getActionBar().setTitle("Earth: "+coins);   
  width = size.x;
  height = size.y;
  b1 = (Button) findViewById(R.id.button1);
  goBack = (Button)findViewById(R.id.back2);
  goBack.setOnClickListener(new View.OnClickListener() {
   public void onClick(View v) {
    onBackPressed();
   }
  });
  b1.setOnClickListener(new View.OnClickListener() {
   public void onClick(View v) {
    if (coins >= (int)costs[0]*(1+numM[0]/2.0)) {
      

     rateM += 1;
     coins -= (int)costs[0]*(1+numM[0]/2.0);
     numM[0] += 1;
     Toast t = Toast.makeText(getApplicationContext(),
       "Bought Dollar Store", 50); 
     b1.setText("Dollar Store $"+(int)costs[0]*(1+numM[0]/2.0)+"\n Own:"+numM[0]);
      
     t.show();
     getActionBar().setTitle("Earth: "+coins);   

    }
   }
  });
  b2 = (Button) findViewById(R.id.button2);
  b2.setOnClickListener(new View.OnClickListener() {
   public void onClick(View v) {
    if (coins >= (int)costs[1]*(1+numM[1]/2.0)) {
      

     rateM += 1;
     coins -= (int)costs[1]*(1+numM[1]/2.0);
     numM[1] += 1;
     Toast t = Toast.makeText(getApplicationContext(),
       "Bought Shoe Shop", 50);
     b2.setText("Shoe Shop $"+(int)costs[1]*(1+numM[1]/2.0)+"\n Own:"+numM[1]);
      

     t.show();
     getActionBar().setTitle("Earth: "+coins);   

    }
   }
  });
  b3 = (Button) findViewById(R.id.button3);
  b3.setOnClickListener(new View.OnClickListener() {
   public void onClick(View v) {
    if (coins >= (int)costs[2]*(1+numM[2]/2.0)) {
      

     rateM += 5.5;
     coins -= (int)costs[2]*(1+numM[2]/2.0);
     numM[2] += 1;
     
     Toast t = Toast.makeText(getApplicationContext(),
       "Bought Pizza Franchise", 50);
     b3.setText("Pizza Franchise $"+(int)costs[2]*(1+numM[2]/2.0)+"\n Own:"+numM[2]);
      

     t.show();
     getActionBar().setTitle("Earth: "+coins);   

    }
   }
  });
  b4 = (Button) findViewById(R.id.button4);
  b4.setOnClickListener(new View.OnClickListener() {
   public void onClick(View v) {
    if (coins >= (int)costs[3]*(1+numM[3]/2.0)) {
      

     rateM += 20.5;
     coins -= (int)costs[3]*(1+numM[3]/2.0);
     numM[3] += 1;
     
     Toast t = Toast.makeText(getApplicationContext(),
       "Bought Hospital", 50);
     b4.setText("Hospital $"+(int)costs[3]*(1+numM[3]/2.0)+"\n Own:"+numM[3]); 

     t.show();
     getActionBar().setTitle("Earth: "+coins);   

    }
   }
  });
  b5 = (Button) findViewById(R.id.button5);
  b5.setOnClickListener(new View.OnClickListener() {
   public void onClick(View v) {
    if (coins >= (int)costs[4]*(1+numM[4]/2.0)) {

     rateM += 50.5;
     coins -= (int)costs[4]*(1+numM[4]/2.0);
     numM[4] += 1;
     
     Toast t = Toast.makeText(getApplicationContext(),
       "Bought Bank", 50);
     b5.setText("Bank $"+(int)costs[4]*(1+numM[4]/2.0)+"\n Own:"+numM[4]);
     t.show();
     getActionBar().setTitle("Earth: "+coins);   

    }
   }
  });
  b6 = (Button) findViewById(R.id.button6);
  b6.setOnClickListener(new View.OnClickListener() {
   public void onClick(View v) {    
    if (coins >= (int)costs[5]*(1+numM[5]/2.0)) {

     rateM += 100;
     coins -= (int)costs[5]*(1+numM[5]/2.0);
     numM[5] += 1;
     
     Toast t = Toast.makeText(getApplicationContext(),
       "Bought Stock Market", 50);
     b6.setText("Stock Market $"+(int)costs[5]*(1+numM[5]/2.0)+"\n Own:"+numM[5]);
     t.show();
     getActionBar().setTitle("Earth: "+coins);   


    }
   }
  });
   ;
  b1.setBackgroundColor(Color.rgb(150,22,11));
  b2.setBackgroundColor(Color.rgb(174,137,118));
  b3.setBackgroundColor(Color.rgb(150,22,11));
  b4.setBackgroundColor(Color.rgb(174,137,118));
  b5.setBackgroundColor(Color.rgb(150,22,11));
  b6.setBackgroundColor(Color.rgb(174,137,118));
  b1.setText("Dollar Store $"+(int)costs[0]*(1+numM[0]/2.0)+"\n Own:"+numM[0]);
  b2.setText("Shoe Shop $"+(int)costs[1]*(1+numM[1]/2.0)+"\n Own:"+numM[1]);
  b3.setText("Pizza Franchise $"+(int)costs[2]*(1+numM[2]/2.0)+"\n Own:"+numM[2]);
  b4.setText("Hospital $"+(int)costs[3]*(1+numM[3]/2.0)+"\n Own:"+numM[3]);
  b5.setText("Bank $"+(int)costs[4]*(1+numM[4]/2.0)+"\n Own:"+numM[4]);
  b6.setText("Stock Market $"+(int)costs[5]*(1+numM[5]/2.0)+"\n Own:"+numM[5]);
  int color = 0xffffcccc;
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
  getMenuInflater().inflate(R.menu.earth, menu);
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
   switches.putExtra("numM", numM);
   switches.putExtra("rateM", rateM);
   switches.putExtra("coins", coins);
   switches.putExtra("numH", numH);
   switches.putExtra("points", points);
   switches.putExtra("rateH", rateH);
   startActivity(switches);
  }// end if
  return true; 
 }

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

}