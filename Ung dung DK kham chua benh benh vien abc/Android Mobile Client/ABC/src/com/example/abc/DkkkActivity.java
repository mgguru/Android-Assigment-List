package com.example.abc;
import java.util.Calendar;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.abc.MyApplication;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class DkkkActivity extends Activity{

	TextView txtThongbao;
	 String TenNguoiDK ;
     String SoDienThoai;
     String NgayKham;
     String MaKhoa;
     String TenKhoa;
     String today;
     int STT;
     ProgressDialog PD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky_nhansokhambenh);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             TenNguoiDK = extras.getString("pass_TenNguoiDK");
             SoDienThoai = extras.getString("pass_SoDienThoai");
             NgayKham = extras.getString("pass_NgayKham");
             TenKhoa = extras.getString("pass_TenKhoa");
        }
        getSTTfromSoDienThoai();     
    }


    private void getSTTfromSoDienThoai() {
		// TODO Auto-generated method stub
    	PD = new ProgressDialog(this);
        PD.setMessage("Loading.....");
        PD.setCancelable(false);
        String url = "http://169.254.189.95:8080/android/sokhambenh.php?SoDienThoai="+SoDienThoai;
        JsonObjectRequest jreq = new JsonObjectRequest(Method.GET, url, null,
				new Response.Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						try {
							int success = response.getInt("success");
							if (success == 1) {
								JSONArray ja = response.getJSONArray("Sokhambenh");
								for (int i = 0; i < ja.length(); i++) {
									JSONObject jobj = ja.getJSONObject(i);
									STT= jobj.getInt("STT");
								} 
								PD.dismiss();
								Toast.makeText(getApplicationContext(),
										"STT la: " + STT,Toast.LENGTH_LONG).show();
								getToday();
								String strThongbao= "Số khám bệnh của bạn là XYZT: " + STT + ". Ngày khám là " + NgayKham + " " + " Chuyên khoa là " + TenKhoa + " " + "Hôm nay là ngày "+today+" "+ ". Khi đến ngày khám bệnh, hệ thống sẽ tự gửi tin nhắn thông báo cho bạn";
							    txtThongbao = (TextView) findViewById(R.id.txtThongbao);
							    txtThongbao.setText(strThongbao);
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
								"failed to take STT  " + error.getMessage() , Toast.LENGTH_LONG).show();
					}
				});

		// Adding request to request queue
		MyApplication.getInstance().addToReqQueue(jreq);
		
	}


	protected void getToday() {
		// TODO Auto-generated method stub
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		today= (month + 1)+ "-" +day +"-"+year;
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
