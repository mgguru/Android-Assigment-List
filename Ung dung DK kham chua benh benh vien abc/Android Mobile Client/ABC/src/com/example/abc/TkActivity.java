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
import android.os.Parcel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.adapter.NothingSelectedSpinnerAdapter;
import com.example.adapter.TkAdapter;
import com.example.entity.BacSi;
import com.example.entity.CauHoi;

public class TkActivity extends Activity {

	GridView gv;
	ProgressDialog pDialog;
	List<BacSi> listBacsi = new ArrayList<BacSi>();
	EditText edtHoten;
	TkAdapter adapter;
	String strKeyup= " ";
	String strKhoa = " ";
	BacSi bacsi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timkiem_bacsi);
		createSpinner();
		gv = (GridView) findViewById(R.id.gvBacsi);

		pDialog = new ProgressDialog(this);
		pDialog.setMessage("Loading...");
		pDialog.show();
		getListBacSi();
		adapter = new TkAdapter(TkActivity.this, listBacsi);
		gv.setAdapter(adapter);	
		gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						" Đây là: " + parent.getItemAtPosition(position),
						Toast.LENGTH_LONG).show();

				for (int i = 0; i < listBacsi.size() - 1; i++) {
					if (listBacsi.get(i).getMaBS()
							.equals(parent.getItemAtPosition(position))) {
						String MaBS = listBacsi.get(i).getMaBS();
						String TenBS = listBacsi.get(i).getTenBS();
						int GioiTinh = listBacsi.get(i).getGioiTinh();
						String TTCN = listBacsi.get(i).getThongTinCaNhan();
						String HinhAnh = listBacsi.get(i).getHinhAnh();
						String MaKhoa = listBacsi.get(i).getMaKhoa();
						bacsi = new BacSi(MaBS, TenBS, GioiTinh, TTCN,
								HinhAnh, MaKhoa);

					}
				
				}
				
				Intent intent = new Intent(TkActivity.this,
                        ThongTinBacSiActivity.class);
				Bundle b = new Bundle();
				b.putParcelable("pass_bacsi", bacsi);
				intent.putExtras(b);
                startActivity(intent);	
			}
		});

		edtHoten = (EditText) findViewById(R.id.edtHoten);
		TextWatcher txtWatcher = new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				  if (filterLongEnough()) {
					  strKeyup = edtHoten.getText().toString();		
					  getListBacSi();
		            }
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
			
			private boolean filterLongEnough() {
	            return edtHoten.getText().toString().trim().length() >= 0;
	        }
		};
		edtHoten.addTextChangedListener(txtWatcher);
		// String[] value = getResources().getStringArray(R.array.ds_bacsi);
		// TkGridAdapter adapter = new TkGridAdapter(TkActivity.this, value);
		// gv = (GridView) this.findViewById(R.id.gvBacsi);
		// gv.setAdapter(adapter);
		// gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		//
		// @Override
		// public void onItemClick(AdapterView<?> parent, View view,
		// int position, long id) {
		// Intent intent = new Intent(TkActivity.this,
		// ThongTinBacSiActivity.class);
		// startActivity(intent);
		//
		// }
		//
		// });
	}

	private void getListBacSi() {
		//String url = "http://169.254.189.95:8080/android/dsbacsi.php?Hoten="+strKeyup+"&Khoa="+strKhoa;
		String url = "http://192.168.56.1:8080/android/dsbacsi.php?Hoten="+strKeyup+"&Khoa="+strKhoa;
		JsonObjectRequest jreq = new JsonObjectRequest(Method.GET, url, null,
				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						listBacsi.clear();
						try {
							int success = response.getInt("success");
							if (success == 1) {
								JSONArray ja = response.getJSONArray("dsBacsi");
								for (int i = 0; i < ja.length(); i++) {
									JSONObject jobj = ja.getJSONObject(i);
									String MaBS = jobj.getString("MaBS");
									String TenBS = jobj.getString("TenBS");
									int GioiTinh = jobj.getInt("GioiTinh");
									String TTCN = jobj.getString("TTCN");
									String HinhAnh = jobj.getString("HinhAnh");
									String MaKhoa = jobj.getString("MaKhoa");
									BacSi item = new BacSi(MaBS, TenBS,
											GioiTinh, TTCN, HinhAnh, MaKhoa);
									listBacsi.add(item);
								}
								pDialog.dismiss();
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
						pDialog.dismiss();
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

	private void createSpinner() {
		// TODO Auto-generated method stub
		Spinner spnChuyenkhoa = (Spinner) findViewById(R.id.spnChuyenkhoa);
		ArrayAdapter<CharSequence> adapterKhoa = ArrayAdapter
				.createFromResource(this, R.array.ds_khoa,
						R.layout.spinner_item);
		//spnChuyenkhoa.setAdapter(adapterKhoa);
		spnChuyenkhoa.setAdapter(new NothingSelectedSpinnerAdapter(adapterKhoa,
				R.layout.spinner_khoa_no_select,
				// R.layout.contact_spinner_nothing_selected_dropdown, //
				// Optional
				this));
		spnChuyenkhoa.setOnItemSelectedListener(new KhoaSelectedListener());

//		Spinner spnLichkham = (Spinner) findViewById(R.id.spnLichkham);
//		ArrayAdapter<CharSequence> adapterLichkham = ArrayAdapter
//				.createFromResource(this, R.array.ds_lichkham,
//						R.layout.spinner_item);
//		spnLichkham.setAdapter(adapterLichkham);
//		spnLichkham.setOnItemSelectedListener(new LichkhamSelectedListener());
	}

	private class KhoaSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			//Toast.makeText(parent.getContext(),
				//	"Item is " + parent.getItemAtPosition(pos).toString(),
					//Toast.LENGTH_LONG).show();	
			//strKhoa = parent.getItemAtPosition(pos).toString();
			if(pos==0){
				
			}else{
				String TenKhoa = parent.getItemAtPosition(pos).toString();
				if (TenKhoa.equals("Thần kinh")) {
					strKhoa = "Than";
				} else if (TenKhoa.equals("Tim mạch")) {
					strKhoa = "Tim";
				} else if (TenKhoa.equals("Răng - hàm - mặt")) {
					strKhoa = "Rang";
				} else if (TenKhoa.equals("Da liễu")) {
					strKhoa = "Da";
				} else if (TenKhoa.equals("Chỉnh hình")){
					strKhoa = "Chinh";
				}else {
					strKhoa = " ";
				}
				getListBacSi();
			}
			
			
		}

		public void onNothingSelected(AdapterView parent) {
			// Do nothing.
			strKhoa = " ";
		}
	}

//	private class LichkhamSelectedListener implements OnItemSelectedListener {
//
//		public void onItemSelected(AdapterView<?> parent, View view, int pos,
//				long id) {
//			Toast.makeText(parent.getContext(),
//					"Item is " + parent.getItemAtPosition(pos).toString(),
//					Toast.LENGTH_LONG).show();
//		}
//
//		public void onNothingSelected(AdapterView parent) {
//			// Do nothing.
//		}
//	}

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
