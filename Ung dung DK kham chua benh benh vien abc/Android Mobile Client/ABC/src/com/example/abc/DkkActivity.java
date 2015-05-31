package com.example.abc;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.abc.MyApplication;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DkkActivity extends Activity{

	TextView txtThongbao;
	  String TenNguoiDK ;
      String SoDienThoai;
      String NgayKham;
      String MaKhoa;
      String TenKhoa;
      ProgressDialog PD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky_xacnhanthongtin);
        PD = new ProgressDialog(this);
        PD.setMessage("please wait.....");
        PD.setCancelable(false);
        
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             TenNguoiDK = extras.getString("pass_TenNguoiDK");
             SoDienThoai = extras.getString("pass_SoDienThoai");
             NgayKham = extras.getString("pass_NgayKham");
             TenKhoa = extras.getString("pass_TenKhoa");
            
        	Toast.makeText(getApplicationContext(),
					"Data: " + TenNguoiDK + " " + SoDienThoai + " " + NgayKham + " " + TenKhoa,
					Toast.LENGTH_LONG).show();
        }
        
        
        Button btnDongy = (Button) findViewById(R.id.btnDongy);
        btnDongy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				PD.show();
				String url = "http://169.254.189.95:8080/android/xacnhan.php?SoDienThoai="+SoDienThoai;
				JsonObjectRequest update_request = new JsonObjectRequest(url,
						null, new Response.Listener<JSONObject>() {
							@Override
							public void onResponse(JSONObject response) {
								try {
									int success = response.getInt("success");
									if (success == 1) {
										PD.dismiss();
										Toast.makeText(getApplicationContext(),
												"Updated Successfully",
												Toast.LENGTH_SHORT).show();			
													Intent intent = new Intent(DkkActivity.this,
							                        DkkkActivity.class);
											intent.putExtra("pass_TenNguoiDK", TenNguoiDK);
											intent.putExtra("pass_SoDienThoai", SoDienThoai);
											intent.putExtra("pass_NgayKham", NgayKham);
											intent.putExtra("pass_MaKhoa", MaKhoa);
											intent.putExtra("pass_TenKhoa",TenKhoa);				
							                startActivity(intent);
									} else {
										PD.dismiss();
										Toast.makeText(getApplicationContext(),
												"failed to update "+SoDienThoai, Toast.LENGTH_LONG)
												.show();
									}

								} catch (JSONException e) {
									e.printStackTrace();
								}

							}
						}, new Response.ErrorListener() {

							@Override
							public void onErrorResponse(VolleyError error) {
								PD.dismiss();
								Toast.makeText(getApplicationContext(),
										"failed to update  "+SoDienThoai +" "+ error.getMessage() , Toast.LENGTH_LONG).show();
							}
						});

				// Adding request to request queue
				MyApplication.getInstance().addToReqQueue(update_request);
				
				/*Intent intent = new Intent(DkkActivity.this,
                        DkkkActivity.class);
				intent.putExtra("pass_TenNguoiDK", TenNguoiDK);
				intent.putExtra("pass_SoDienThoai", SoDienThoai);
				intent.putExtra("pass_NgayKham", NgayKham);
				intent.putExtra("pass_MaKhoa", MaKhoa);
				intent.putExtra("pass_TenKhoa",TenKhoa);				
                startActivity(intent);*/
			}
		});
        
        String strThongbao= "Bạn hãy gửi tin nhắn theo cú pháp  DKKB XX YY và " +
        		"gửi đến số 0110 để xác nhận đăng ký.\n " +
        		"Sau khi hoàn thành, hệ thống sẽ trừ 10000 VNĐ vào số điện thoại của bạn, " +
        		"đồng thời sẽ cấp cho bạn số phiếu khám bệnh";
        String strThongtindangky = " Thông tin cá nhân của bạn: \n" + TenNguoiDK +  " " + SoDienThoai + " " + NgayKham + " " + TenKhoa;
        String strThongbaokiemtra = "\n \n \n Bạn hãy kiểm tra thông tin của bạn, nếu đúng thì nhấn đồng ý để tiếp tục nhận số khám bệnh \n Nếu bạn thấy thông tin sai, hãy bấm hủy để quay về bước đăng ký thông tin...\n";
        
        txtThongbao = (TextView) findViewById(R.id.txtThongbao);
        txtThongbao.setText(strThongbao + "\n \n \n" + "Thông tin của bạn là: " + strThongtindangky + "\n" + strThongbaokiemtra);
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
