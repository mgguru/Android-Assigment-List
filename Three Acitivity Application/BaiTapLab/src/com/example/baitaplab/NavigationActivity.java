package com.example.baitaplab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NavigationActivity extends Activity {

	
	 Button btnDisplay;
	 Button btnAdd;
	 Button btnUpdate;
	 DBHelper dbHeplper;
	 ListView lv;
	 ArrayAdapter<String> adapter;
	 public static ArrayList<String> list= new ArrayList<String>();
	 final Context context = this;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.navigation);       
	        //this.Reload();
	        
	        btnAdd = (Button) findViewById(R.id.btnAdd);
	        btnAdd.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					LayoutInflater layoutInflater = LayoutInflater.from(context);
					View promptView = layoutInflater.inflate(R.layout.add,null);
					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
					alertDialogBuilder.setView(promptView);
					
					final EditText edtInput = (EditText) promptView.findViewById(R.id.edtInput);
					
					alertDialogBuilder
					.setCancelable(false)
					.setPositiveButton("OK", 
							new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub										
									if (edtInput.getText().toString().trim().length() > 0){									
										list.add(edtInput.getText().toString());
										String input = list.get(list.size()-1);
										String[] output = input.split(",");									
										Student std = new Student();
										std.setMSSV(output[0]);
										std.setHoTen(output[1]);
										std.setDiem(Integer.parseInt(output[2]));
										dbHeplper.insert(std);
										adapter.notifyDataSetChanged();									
										Toast.makeText(getApplicationContext(), "Sinh viên "+output[0] + " đã được thêm", Toast.LENGTH_SHORT).show();
									}
									else
									{
										dialog.cancel();
									}
								}
							})
					.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
								dialog.cancel();	
								}
							});
					
					AlertDialog alertDialog = alertDialogBuilder.create();
					alertDialog.show();
				}
			});
	        
	        btnUpdate = (Button) findViewById(R.id.btnEdit);
	        btnUpdate.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(NavigationActivity.this, UpdateActivity.class);
					startActivity(intent);
				}
				
				
			});
	        
	        btnDisplay = (Button) findViewById(R.id.btnDisplay);
	        btnDisplay.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Reload();
				}
				
				
			});
	        
	        
	       
	       
	       lv = (ListView) findViewById(R.id.lvList);					
	       lv.setOnItemLongClickListener(new AdapterView
	    	        .OnItemLongClickListener() {
	    	        @Override
	    	        public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	    	        			
	    	        			    	        			
	    	        			String input = list.get(arg2);
	    	        			String[] output = input.split(",");
	    	        			if (dbHeplper.delete(output[0])!=0){
	    	        				Toast.makeText(getApplicationContext(), "Sinh viên "+output[0] + " đã bị xóa", Toast.LENGTH_SHORT).show();
	    	        			}
	    	        			list.remove(arg2);//xóa phần tử thứ arg2	
	    	        			adapter.notifyDataSetChanged();
	    	        			return false;
	    	        }
	    	        });
	      
	        
	    }
	 
	 
	 public void Reload(){
		 if (list.size() > 0){
			 list.clear();
			 this.Reload();
		 }else{
			dbHeplper = new DBHelper(getApplicationContext());
			
			try {
				dbHeplper.createDataBase();
			} catch (IOException e) {
				e.printStackTrace();
			}	        
			
	         list = dbHeplper.getAllUsers();
			 lv = (ListView) findViewById(R.id.lvList);	
			 adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
			 lv.setAdapter(adapter);	
		 }
		
	 }
}
