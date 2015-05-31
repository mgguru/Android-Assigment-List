package com.example.abc;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnTuvan = (Button) findViewById(R.id.button1);
        btnTuvan.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent intent = new Intent(MainActivity.this,
	                        DmActivity.class);
	                startActivity(intent);
				
			}
		});
        
        Button btnLichkham = (Button) findViewById(R.id.button2);
        btnLichkham.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    Intent intent = new Intent(MainActivity.this,
                        LkActivity.class);
                startActivity(intent);
			}
		});
        
        Button btnDangkykham = (Button) findViewById(R.id.button3);
        btnDangkykham.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent intent = new Intent(MainActivity.this,
	                        DkActivity.class);
	                startActivity(intent);
				
			}
		});
        
        Button btnTimbacsi = (Button) findViewById(R.id.button4);
        btnTimbacsi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent intent = new Intent(MainActivity.this,
	                        TkActivity.class);
	                startActivity(intent);
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
