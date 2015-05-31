package com.example.adapter;

import java.util.List;

import com.example.abc.DmmActivity;
import com.example.abc.DmmmActivity;
import com.example.abc.R;
import com.example.entity.CauHoi;
import com.example.entity.CauTraLoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DmmmAdapter extends BaseAdapter {
	
	private DmmmActivity context;
	private List<CauTraLoi> items;
	LayoutInflater inflater;
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
            convertView = inflater.inflate(R.layout.hoidap_traloi, null);            
            TextView txtNgayGui =(TextView) convertView.findViewById(R.id.txtNgayGui);
            TextView txtCauHoi =(TextView) convertView.findViewById(R.id.txtCauHoi);
            TextView txtNguoiHoi =(TextView) convertView.findViewById(R.id.txtNguoiHoi);
            TextView txtNguoiTraLoi =(TextView) convertView.findViewById(R.id.txtNguoiTraLoi);
            TextView txtCauTraloi =(TextView) convertView.findViewById(R.id.txtCauTraloi);
            
            CauTraLoi traloi = items.get(position);
            
            txtNgayGui.setText(traloi.getNgayGui());
            txtCauHoi.setText(traloi.getCauHoi());
            txtNguoiHoi.setText(traloi.getTenBenhNhan());
            txtNguoiTraLoi.setText(traloi.getTenBS());
            txtCauTraloi.setText(traloi.getCauTraLoi());
            
        }
		
		return convertView;
	}

}
