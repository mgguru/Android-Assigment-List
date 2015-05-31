package com.example.abc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.DmAdapter;
import com.example.entity.Khoa;

public class DmActivity extends Activity {

	ListView lv;
	Khoa khoa;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.danhmuc_thacmac);
		String[] value = { "THẦN KINH", "TIM MẠCH", "RĂNG - HÀM - MẶT",
				"DA LIỄU", "CHỈNH HÌNH" };
		DmAdapter adapter = new DmAdapter(DmActivity.this, value);
		lv = (ListView) this.findViewById(R.id.lvDanhmuc);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// khoa= new Khoa();
				if (position == 0) {
					khoa = new Khoa("K01", "");
				} else if (position == 1) {
					khoa = new Khoa("K02", "");
				} else if (position == 2) {
					khoa = new Khoa("K03", "");
				} else if (position == 3) {
					khoa = new Khoa("K04", "");
				} else {
					khoa = new Khoa("K05", "");
				}
				Intent intent = new Intent(DmActivity.this, DmmActivity.class);
				Bundle b = new Bundle();
				b.putParcelable("pass_khoa", khoa);
				intent.putExtras(b);
				startActivity(intent);
			}

		});

		btn = (Button) findViewById(R.id.btnGuicauhoi);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "It's already click",
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(DmActivity.this, DmmmmActivity.class);
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
