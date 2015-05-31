package com.example.abc;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.adapter.DmmAdapter;
import com.example.entity.CauHoi;
import com.example.entity.Khoa;

public class DmmActivity extends Activity {
	ListView lv;
	ProgressDialog PD;
	List<CauHoi> listCauhoi = new ArrayList<CauHoi>();
	List<Integer> listMaHoi = new ArrayList<Integer>();
	Khoa khoa;
	CauHoi cauhoi;
	DmmAdapter adapter ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hoidap_cauhoi);

		Intent intent = getIntent();
		Bundle b = intent.getExtras();
		khoa = b.getParcelable("pass_khoa");

		lv = (ListView) this.findViewById(R.id.lvCauhoi);
		adapter = new DmmAdapter(DmmActivity.this, listCauhoi);
		lv.setAdapter(adapter);		
		Toast.makeText(getApplicationContext(),
				"Thông tin xem: " + khoa.getMaKhoa(), Toast.LENGTH_LONG).show();

		getCauHoifromMaKhoa();
		// String[] value={"1","2","3","4","5","6"};		
     	adapter.notifyDataSetChanged();
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(DmmActivity.this, DmmmActivity.class);
				Bundle b = new Bundle();
				b.putInt("pass_MaHoi", listMaHoi.get(position));
				intent.putExtras(b);
				startActivity(intent);
			}

		});

	}

	private void getCauHoifromMaKhoa() {
		// TODO Auto-generated method stub

		PD = new ProgressDialog(this);
		PD.setMessage("Loading.....");
		PD.setCancelable(false);
		PD.show();
		String url = "http://169.254.189.95:8080/android/cauhoi.php?MaKhoa="
				+ khoa.getMaKhoa();
		JsonObjectRequest jreq = new JsonObjectRequest(Method.GET, url, null,
				new Response.Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						try {
							int success = response.getInt("success");
							if (success == 1) {
								JSONArray ja = response.getJSONArray("cau_hoi");
								for (int i = 0; i < ja.length(); i++) {
									JSONObject jobj = ja.getJSONObject(i);
									CauHoi item = new CauHoi();
									item.setMaHoi(jobj.getInt("MaHoi"));
									listMaHoi.add(jobj.getInt("MaHoi"));
									item.setTenBenhNhan(jobj
											.getString("TenBenhNhan"));
									item.setCauHoi(jobj.getString("CauHoi"));
									item.setNgayGui(jobj.getString("NgayGui"));
									listCauhoi.add(item);
								}
								PD.dismiss();
//								DmmAdapter adapter = new DmmAdapter(DmmActivity.this, listCauhoi);
//								lv.setAdapter(adapter);
								Toast.makeText(getApplicationContext(),
										"hoh hoh hoh hoh finish",
										Toast.LENGTH_LONG).show();
								
							} // if ends

						} catch (JSONException e) {
							e.printStackTrace();
						}
						adapter.notifyDataSetChanged();

						
					}
					
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						PD.dismiss();
						Toast.makeText(
								getApplicationContext(),
								"failed to take some thing  "
										+ error.getMessage(), Toast.LENGTH_LONG)
								.show();
					}
				});
		

		// Adding request to request queue
		MyApplication.getInstance().addToReqQueue(jreq);
		

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
