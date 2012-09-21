package com.uark.capstone.FindIt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity 
{

    private OnClickListener btnFindItListener = new OnClickListener() {
    
    	public void onClick(View arg0){
    		
    		Intent myIntent = new Intent(MainActivity.this, MapViewActivity.class);
    		MainActivity.this.startActivity(myIntent);
    	}
    
    };
    
    private OnClickListener rbNearbyListener = new OnClickListener(){

		public void onClick(View v) {
			
			EditText tbLocation = (EditText) findViewById(R.id.tbLocation);
			tbLocation.setEnabled(false);
			
		}
    	
    };
    
    private OnClickListener rbSomewhereElseListener = new OnClickListener(){

		public void onClick(View v) {
			
			EditText tbLocation = (EditText) findViewById(R.id.tbLocation);
			tbLocation.setEnabled(true);
			
		}
    	
    };

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RadioButton rbNearby = (RadioButton) findViewById(R.id.rbNearby);
        RadioButton rbSomewhereElse = (RadioButton)findViewById(R.id.rbSomewhereElse);
        
        EditText tbLocation = (EditText) findViewById(R.id.tbLocation);
        Button btnFindIt = (Button) findViewById(R.id.btSearchActivity);
        
        
        rbNearby.setOnClickListener(rbNearbyListener);
        rbSomewhereElse.setOnClickListener(rbSomewhereElseListener);
        
        btnFindIt.setOnClickListener(btnFindItListener );
        
        rbNearby.setChecked(true);
        tbLocation.setEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
   
    
}
