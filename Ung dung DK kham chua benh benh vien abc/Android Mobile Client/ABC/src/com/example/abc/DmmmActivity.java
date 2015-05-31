package com.example.abc;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.adapter.DmmAdapter;
import com.example.adapter.DmmmAdapter;
import com.example.entity.CauHoi;
import com.example.entity.CauTraLoi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DmmmActivity extends Activity {
	ProgressDialog PD;
	List<CauTraLoi>  listCautraloi = new ArrayList<CauTraLoi>();
	CauTraLoi item = new CauTraLoi();
	int MaHoi=0;	
	//String[] MaHoi;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hoidap_traloi);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        MaHoi = b.getInt("pass_MaHoi");
        Toast.makeText(getApplicationContext(),
				"hoh hoh hoh hoh successful " + MaHoi  ,Toast.LENGTH_LONG).show();
        //MaHoi=1;
        getCauTraLoifromMaHoi();        
       
        
        
//        DmmmAdapter adapter = new DmmmAdapter(DmmmActivity.this, listCautraloi);
//        lv = (ListView) this.findViewById(R.id.lvCauhoi);
//        lv.setAdapter(adapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {		
//				cauhoi = new CauHoi();					
//               
//				Intent intent = new Intent(DmmActivity.this,
//                        DmmmActivity.class);
//				Bundle b = new Bundle();
//				b.putParcelable("pass_MaHoi", khoa);
//				intent.putExtras(b);
//				startActivity(intent);
//			}        	
//		});
       
  }
private void getCauTraLoifromMaHoi() {
		// TODO Auto-generated method stub

 	PD = new ProgressDialog(this);
	PD.setMessage("Loading.....");
	PD.setCancelable(false);		
	PD.show();
	String url = "http://169.254.189.95:8080/android/caudap.php?MaHoi="+MaHoi;
	  JsonObjectRequest jreq = new JsonObjectRequest(Method.GET, url, null,
				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						try {
							int success = response.getInt("success");
							if (success == 1) {
								JSONArray ja = response.getJSONArray("cau_dap");
								for (int i = 0; i < ja.length(); i++) {
									JSONObject jobj = ja.getJSONObject(i);
									//CauTraLoi item = new CauTraLoi();
									item.setMaHoi(jobj.getInt("MaHoi"));
									item.setTenBenhNhan(jobj.getString("TenBenhNhan"));
									item.setCauHoi(jobj.getString("CauHoi"));
									item.setNgayGui(jobj.getString("NgayGui"));	
									item.setCauTraLoi(jobj.getString("CauTraLoi"));
									item.setTenBS(jobj.getString("TenBS"));
									//listCautraloi.add(item);
								} 
								PD.dismiss();		
								 TextView txtNgayGui =(TextView) findViewById(R.id.txtNgayGui);
							        TextView txtCauHoi =(TextView) findViewById(R.id.txtCauHoi);
							        TextView txtNguoiHoi =(TextView) findViewById(R.id.txtNguoiHoi);
							        TextView txtNguoiTraLoi =(TextView) findViewById(R.id.txtNguoiTraLoi);
							        TextView txtCauTraloi =(TextView) findViewById(R.id.txtCauTraloi);        
							        txtNgayGui.setText(item.getNgayGui());
							        txtCauHoi.setText(item.getCauHoi());
							        txtNguoiHoi.setText(item.getTenBenhNhan());
							        txtNguoiTraLoi.setText(item.getTenBS());
							        txtCauTraloi.setText(item.getCauTraLoi());
								Toast.makeText(getApplicationContext(),
										"hoh hoh hoh hoh successful "  ,Toast.LENGTH_LONG).show();
							} // if ends

						} catch (JSONException e) {
							e.printStackTrace();
						}

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						PD.dismiss();
						Toast.makeText(getApplicationContext(),
								"failed to take some thing  " + error.getMessage() , Toast.LENGTH_LONG).show();
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
