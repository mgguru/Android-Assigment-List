package com.example.abc;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.adapter.NothingSelectedSpinnerAdapter;

public class DkActivity extends Activity {

	TextView txtNgaykhambenh;
	int year, month, day;
	Button btn, btnReset;
	static final int DATE_DIALOG_ID = 999;
	String url = "http://169.254.189.95:8080/android/dangky.php";
	String TenNguoiDK, SoDienThoai, NgayKham, MaKhoa, TenKhoa;
	EditText edtHoten, edtSodienthoai;
	Spinner spnChuyenkhoa;
	ProgressDialog PD;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dangky_dienthongtin);
		/*
		 * Button btnDangky = (Button) findViewById(R.id.btnDangky);
		 * btnDangky.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { // TODO Auto-generated method
		 * stub
		 * 
		 * } });
		 */
		setCurrentDateOnView();
		addListenerOnButton();

		// btn = (Button) findViewById(R.id.btnNgaykhambenh);
		// btn.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// Toast.makeText(getApplicationContext(),
		// "Button here was just clicked",
		// Toast.LENGTH_LONG).show();
		// }
		// });

		spnChuyenkhoa = (Spinner) findViewById(R.id.spnChuyenkhoa);
		ArrayAdapter<CharSequence> adapterKhoa = ArrayAdapter
				.createFromResource(this, R.array.ds_khoa,
						R.layout.spinner_item);
		// spnChuyenkhoa.setAdapter(adapterKhoa);
		// adapterKhoa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// spnChuyenkhoa.setPrompt("Select your favorite Planet!");
		spnChuyenkhoa.setAdapter(new NothingSelectedSpinnerAdapter(adapterKhoa,
				R.layout.spinner_khoa_no_select,
				// R.layout.contact_spinner_nothing_selected_dropdown, //
				// Optional
				DkActivity.this));
		spnChuyenkhoa.setOnItemSelectedListener(new KhoaSelectedListener());
		//spnChuyenkhoa.setSelection(1);

		/*
		 * Spinner spnBacsi = (Spinner) findViewById(R.id.spnBacsi);
		 * ArrayAdapter<CharSequence> adapterBacsi =
		 * ArrayAdapter.createFromResource( this, R.array.ds_bacsi,
		 * R.layout.spinner_item);
		 * 
		 * spnBacsi.setAdapter(adapterBacsi);
		 * spnBacsi.setOnItemSelectedListener(new BacsiSelectedListener());
		 */

		PD = new ProgressDialog(this);
		PD.setMessage("Loading.....");
		PD.setCancelable(false);

		edtHoten = (EditText) findViewById(R.id.edtHoten);
		edtSodienthoai = (EditText) findViewById(R.id.edtSodienthoai);
		
		
		btnReset = (Button) findViewById(R.id.btnLamlai);
		btnReset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				edtHoten.setText("");
				edtSodienthoai.setText("");
				txtNgaykhambenh.setText("");
				spnChuyenkhoa.setSelection(0);

			}
		});
		btn = (Button) findViewById(R.id.btnDangky);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				PD.show();
				TenNguoiDK = edtHoten.getText().toString();
				SoDienThoai = edtSodienthoai.getText().toString();
				NgayKham = txtNgaykhambenh.getText().toString();

				Toast.makeText(
						getApplicationContext(),
						"Thông tin đăng ký: " + TenNguoiDK + "  " + SoDienThoai
								+ "  " + NgayKham + "  " + MaKhoa,
						Toast.LENGTH_LONG).show();

				StringRequest postRequest = new StringRequest(
						Request.Method.POST, url,
						new Response.Listener<String>() {
							@Override
							public void onResponse(String response) {
								PD.dismiss();
								edtHoten.setText("");
								Toast.makeText(getApplicationContext(),
										"Data Inserted Successfully",
										Toast.LENGTH_SHORT).show();

								Intent intent = new Intent(DkActivity.this,
										DkkActivity.class);
								intent.putExtra("pass_TenNguoiDK", TenNguoiDK);
								intent.putExtra("pass_SoDienThoai", SoDienThoai);
								intent.putExtra("pass_NgayKham", NgayKham);
								intent.putExtra("pass_MaKhoa", MaKhoa);
								intent.putExtra("pass_TenKhoa", TenKhoa);
								startActivity(intent);

							}
						}, new Response.ErrorListener() {
							@Override
							public void onErrorResponse(VolleyError error) {
								PD.dismiss();
								Toast.makeText(
										getApplicationContext(),
										"failed to insert  "
												+ error.getMessage(),
										Toast.LENGTH_SHORT).show();
							}
						}) {
					@Override
					protected Map<String, String> getParams() {
						Map<String, String> params = new HashMap<String, String>();
						params.put("TenNguoiDK", TenNguoiDK);
						params.put("SoDienThoai", SoDienThoai);
						params.put("NgayKham", NgayKham);
						params.put("MaKhoa", MaKhoa);

						return params;
					}
				};
				MyApplication.getInstance().addToReqQueue(postRequest);

			}
		});

	}

	private void addListenerOnButton() {
		// TODO Auto-generated method stub
		btn = (Button) findViewById(R.id.btnNgaykhambenh);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID);
			}

		});

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			// set date picker as current date
			return new DatePickerDialog(this, datePickerListener, year, month,
					day);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;

			txtNgaykhambenh.setText(new StringBuilder().append(month + 1)
					.append("-").append(day).append("-").append(year)
					.append(" "));

		}
	};

	private void setCurrentDateOnView() {
		// TODO Auto-generated method stub
		txtNgaykhambenh = (TextView) findViewById(R.id.txtNgaykhambenh);
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		txtNgaykhambenh.setText(new StringBuilder().append(month + 1)
				.append("-").append(day).append("-").append(year).append(" "));
	}

	private class BacsiSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			Toast.makeText(parent.getContext(),
					"Item is " + parent.getItemAtPosition(pos).toString(),
					Toast.LENGTH_LONG).show();
		}

		public void onNothingSelected(AdapterView parent) {
			// Do nothing.
		}
	}

	private class KhoaSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			// Toast.makeText(parent.getContext(),
			// "Item is " + parent.getItemAtPosition(pos).toString(),
			// Toast.LENGTH_LONG).show();
			if (pos == 0) {

			} else {
				TenKhoa = parent.getItemAtPosition(pos).toString();
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

		}

		public void onNothingSelected(AdapterView parent) {
			// Do nothing.
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
