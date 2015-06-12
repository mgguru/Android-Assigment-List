package com.example.abc;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class LkActivity extends Activity  {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lichkham_bacsi);
//        Button btnTimkiem = (Button) findViewById(R.id.btnTimkiem);
//        btnTimkiem.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent intent = new Intent(LkActivity.this,
//                        ThongTinLichKhamActivity.class);
//                startActivity(intent);
//			}
//		});        
//        Spinner spnChuyenkhoa = (Spinner) findViewById(R.id.spnChuyenkhoa);
//        ArrayAdapter<CharSequence> adapterKhoa = ArrayAdapter.createFromResource(
//                this, R.array.ds_khoa, R.layout.spinner_item);
//        spnChuyenkhoa.setAdapter(adapterKhoa);
//        spnChuyenkhoa.setOnItemSelectedListener(new KhoaSelectedListener());
//        
//        Spinner spnLichkham = (Spinner) findViewById(R.id.spnLichkham);
//        ArrayAdapter<CharSequence> adapterLichkham = ArrayAdapter.createFromResource(
//                this, R.array.ds_lichkham, R.layout.spinner_item);
//        spnLichkham.setAdapter(adapterLichkham);
//        spnLichkham.setOnItemSelectedListener(new LichkhamSelectedListener());
        
        /*Spinner spnGioitinh = (Spinner) findViewById(R.id.spnGioitinh);
        ArrayAdapter<CharSequence> adapterGioitinh = ArrayAdapter.createFromResource(
                this, R.array.ds_gioitinh, R.layout.spinner_item);
        spnGioitinh.setAdapter(adapterGioitinh);
        spnGioitinh.setOnItemSelectedListener(new GioitinhSelectedListener());
        
        Spinner spnBangcap = (Spinner) findViewById(R.id.spnBangcap);
        ArrayAdapter<CharSequence> adapterBangcap = ArrayAdapter.createFromResource(
                this, R.array.ds_bangcap, R.layout.spinner_item);
        spnBangcap.setAdapter(adapterBangcap);
        spnBangcap.setOnItemSelectedListener(new BangcapSelectedListener());*/
        
        
    }
	
//	private class KhoaSelectedListener implements OnItemSelectedListener {
//   	 
//        public void onItemSelected(AdapterView<?> parent,
//            View view, int pos, long id) {
//          Toast.makeText(parent.getContext(), "Item is " +
//              parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
//        }
//     
//        public void onNothingSelected(AdapterView parent) {
//          // Do nothing.
//        }
//    }
//	
//	private class BangcapSelectedListener implements OnItemSelectedListener {
//	   	 
//        public void onItemSelected(AdapterView<?> parent,
//            View view, int pos, long id) {
//          Toast.makeText(parent.getContext(), "Item is " +
//              parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
//        }
//     
//        public void onNothingSelected(AdapterView parent) {
//          // Do nothing.
//        }
//    }
//	
//	private class LichkhamSelectedListener implements OnItemSelectedListener {
//	   	 
//        public void onItemSelected(AdapterView<?> parent,
//            View view, int pos, long id) {
//          Toast.makeText(parent.getContext(), "Item is " +
//              parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
//        }
//     
//        public void onNothingSelected(AdapterView parent) {
//          // Do nothing.
//        }
//    }
//	
//	private class GioitinhSelectedListener implements OnItemSelectedListener {
//	   	 
//        public void onItemSelected(AdapterView<?> parent,
//            View view, int pos, long id) {
//          Toast.makeText(parent.getContext(), "Item is " +
//              parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
//        }
//     
//        public void onNothingSelected(AdapterView parent) {
//          // Do nothing.
//        }
//    }



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
