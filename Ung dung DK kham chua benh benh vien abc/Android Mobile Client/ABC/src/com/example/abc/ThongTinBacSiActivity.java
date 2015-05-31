package com.example.abc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.entity.BacSi;

public class ThongTinBacSiActivity extends Activity {

	BacSi bacsi;
	TextView txtTenbacsi;
	TextView txtChuyenkhoa;
	TextView txtGioitinh;
	TextView txtTTCN;
	NetworkImageView imgBacsi;
	ImageLoader imageLoader = MyApplication.getInstance().getImageLoader();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thongtin_bacsi);

		Intent intent = getIntent();
		Bundle b = intent.getExtras();
		bacsi = b.getParcelable("pass_bacsi");

		if (imageLoader == null)
			imageLoader = MyApplication.getInstance().getImageLoader();
		imgBacsi = (NetworkImageView) findViewById(R.id.imgBacsi);
		txtTenbacsi = (TextView) findViewById(R.id.txtTenbacsi);
		txtChuyenkhoa = (TextView) findViewById(R.id.txtChuyenkhoa);
		txtGioitinh = (TextView) findViewById(R.id.txtGioitinh);
		txtTTCN = (TextView) findViewById(R.id.txtThongtincanhan);
		
		imgBacsi.setImageUrl(bacsi.getHinhAnh(), imageLoader);
		txtTenbacsi.setText(bacsi.getTenBS());
		txtChuyenkhoa.setText(bacsi.getMaKhoa());
		if (bacsi.getGioiTinh()==1){
			txtGioitinh.setText("Nam");
		}else{
			txtGioitinh.setText("Nữ");
		}		
		txtTTCN.setText(bacsi.getThongTinCaNhan());

		// Toast.makeText(getApplicationContext(),
		// "Thông tin xem: " + bacsi.getMaKhoa(), Toast.LENGTH_LONG).show();

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
