package com.example.abc;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DmmmmActivity extends Activity {

	Spinner spnChuyenkhoa;
	Button btnGuicauhoi;
	EditText edtHoten, edtSodienthoai, edtEmail, edtCauhoi;
	String TenBenhNhan, SoDienThoai, Email, CauHoi, NgayGui, MaKhoa;
	String url = "http://169.254.189.95:8080/android/guicauhoi.php";
	ProgressDialog PD;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guicauhoi);

		spnChuyenkhoa = (Spinner) findViewById(R.id.spnChuyenkhoa);
		ArrayAdapter<CharSequence> adapterKhoa = ArrayAdapter
				.createFromResource(this, R.array.ds_khoa,
						R.layout.spinner_item);
		spnChuyenkhoa.setAdapter(adapterKhoa);
		spnChuyenkhoa.setOnItemSelectedListener(new KhoaSelectedListener());

		PD = new ProgressDialog(this);
		PD.setMessage("Loading.....");
		PD.setCancelable(false);

		edtHoten = (EditText) findViewById(R.id.edtHoten);
		edtSodienthoai = (EditText) findViewById(R.id.edtSodienthoai);
		edtEmail = (EditText) findViewById(R.id.edtEmail);
		edtCauhoi = (EditText) findViewById(R.id.editText1);

		btnGuicauhoi = (Button) findViewById(R.id.btnGuicauhoi);
		btnGuicauhoi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "It just clicked!",
						Toast.LENGTH_LONG).show();
				PD.show();
				TenBenhNhan = edtHoten.getText().toString();
				SoDienThoai = edtSodienthoai.getText().toString();
				Email = edtEmail.getText().toString();
				CauHoi = edtCauhoi.getText().toString();
				NgayGui = "5-28-2015";

				StringRequest postRequest = new StringRequest(
						Request.Method.POST, url,
						new Response.Listener<String>() {
							@Override
							public void onResponse(String response) {
								PD.dismiss();
								edtHoten.setText("");
								Toast.makeText(getApplicationContext(),
										"Question Inserted Successfully",
										Toast.LENGTH_SHORT).show();
								/*Intent intent = new Intent(DkActivity.this,
										DkkActivity.class);
								intent.putExtra("pass_TenNguoiDK", TenNguoiDK);
								intent.putExtra("pass_SoDienThoai", SoDienThoai);
								intent.putExtra("pass_NgayKham", NgayKham);
								intent.putExtra("pass_MaKhoa", MaKhoa);
								intent.putExtra("pass_TenKhoa", TenKhoa);
								startActivity(intent);*/

							}
						}, new Response.ErrorListener() {
							@Override
							public void onErrorResponse(VolleyError error) {
								PD.dismiss();
								Toast.makeText(
										getApplicationContext(),
										"failed to insert question "
												+ error.getMessage(),
										Toast.LENGTH_SHORT).show();
							}
						}) {
					@Override
					protected Map<String, String> getParams() {
						Map<String, String> params = new HashMap<String, String>();
						
//						  params.put("TenNguoiDK", TenNguoiDK);
//						  params.put("SoDienThoai", SoDienThoai);
//						  params.put("NgayKham", NgayKham);
//						  params.put("MaKhoa", MaKhoa);						  
						  params.put("TenBenhNhan", TenBenhNhan);
						  params.put("SoDienThoai", SoDienThoai);
						  params.put("Email", Email);
						  params.put("MaKhoa", MaKhoa);
						  params.put("CauHoi", CauHoi);
						  params.put("NgayGui", NgayGui);
						return params;
					}
				};
				MyApplication.getInstance().addToReqQueue(postRequest);
			}
		});
	}

	private class KhoaSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			Toast.makeText(parent.getContext(),
					"Item is " + parent.getItemAtPosition(pos).toString(),
					Toast.LENGTH_LONG).show();
			
			String TenKhoa = parent.getItemAtPosition(pos).toString();
			if (TenKhoa.equals("Thần kinh")) {
				MaKhoa = "K01";
			} else if (TenKhoa.equals("Tim mạch")) {
				MaKhoa = "K02";
			} else if (TenKhoa.equals("Răng - hàm - mặt")) {
				MaKhoa = "K03";
			} else if (TenKhoa.equals("Da liễu")) {
				MaKhoa = "K04";
			} else {
				MaKhoa = "K05";
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub

		}
	}
}
