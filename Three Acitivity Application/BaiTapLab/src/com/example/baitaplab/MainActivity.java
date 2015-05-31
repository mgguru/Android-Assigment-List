package com.example.baitaplab;


import java.io.IOException;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

	DBHelper dbHeplper;
	ListView lvUsers;
	ListAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        dbHeplper = new DBHelper(getApplicationContext());
		try {
			dbHeplper.createDataBase();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lvUsers = (ListView)findViewById(R.id.lvUsers);
 		List<String> listUsers = dbHeplper.getAllUsers();
		
		if(listUsers != null){
			adapter = new ArrayAdapter<String>(getApplicationContext(),
					android.R.layout.simple_list_item_1, android.R.id.text1,
					listUsers);
			lvUsers.setAdapter(adapter);
		}
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
