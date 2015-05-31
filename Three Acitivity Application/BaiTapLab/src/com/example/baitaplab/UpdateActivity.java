package com.example.baitaplab;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends Activity {

	EditText edtMSSV, edtHoTen, edtDiem;
	Button btnGet, btnUp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update);
		
		edtMSSV = (EditText) findViewById(R.id.edtMSSV);
		edtHoTen= (EditText) findViewById(R.id.edtHoTen);
		edtDiem = (EditText) findViewById(R.id.edtDiem);

		btnGet = (Button) findViewById(R.id.btnGet);
		btnUp = (Button) findViewById(R.id.btnUp);
		final DBHelper db = new DBHelper(this);

		btnGet.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (edtMSSV.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(),
							"Ban chua nhap MSSV", Toast.LENGTH_SHORT)
							.show();
					edtMSSV.requestFocus();
					return;
				}

				Student s = db.getStudentByID(edtMSSV.getText().toString());
				if (s != null) {
					edtHoTen.setText(s.getHoTen());
					edtDiem.setText(String.valueOf(s.getDiem()));
					//edtMSSV.setEnabled(false);
					//btnGet.setEnabled(false);
				} else {
					Toast.makeText(getApplicationContext(),
							"Khong ton tai MSSV nay", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
		btnUp.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (edtHoTen.getText().toString().equals("")){
					Toast.makeText(getApplicationContext(),
							"Chua nhap ten...", Toast.LENGTH_SHORT).show();
					edtHoTen.requestFocus();
					return;
				}else if (edtDiem.getText().toString().equals("")){
					Toast.makeText(getApplicationContext(),
							"Chua nhap diem...", Toast.LENGTH_SHORT).show();
					edtDiem.requestFocus();
					return;
				}
				
				Student s = new Student();
				s.setMSSV(edtMSSV.getText().toString());
				s.setHoTen(edtHoTen.getText().toString());
				s.setDiem(Integer.parseInt(edtDiem.getText().toString()));
				if (db.update(s)!=0){
					Toast.makeText(getApplicationContext(),
							"Cập nhật thành công...", Toast.LENGTH_SHORT).show();
					
				}else{
					Toast.makeText(getApplicationContext(),
							"Cập nhật thất bại...", Toast.LENGTH_SHORT).show();
				}
				
				
			}
		});
	}
}
