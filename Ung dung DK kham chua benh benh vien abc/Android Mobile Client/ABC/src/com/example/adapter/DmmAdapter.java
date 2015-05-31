package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.abc.DmmActivity;
import com.example.abc.R;
import com.example.entity.CauHoi;

public class DmmAdapter extends BaseAdapter {

	private DmmActivity context;
	private List<CauHoi> items;
	LayoutInflater inflater;
	
	public DmmAdapter (DmmActivity context, List<CauHoi> items){
		this.context = context;
		this.items = items;
        inflater = (LayoutInflater) this.context.
        		getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	
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
            convertView = inflater.inflate(R.layout.item_hoidap_cauhoi, null);            
            TextView txtNgayGui =(TextView) convertView.findViewById(R.id.txtNgayGui);
            //tv.setText("Ngày gửi: 12/21/2014");
            TextView txtCauHoi =(TextView) convertView.findViewById(R.id.txtCauHoi);
            //tv1.setText("Câu hỏi: Bác sĩ, dạo này em sao sao ấy...");
            TextView txtNguoiHoi =(TextView) convertView.findViewById(R.id.txtNguoiHoi);
            //tv2.setText("Người gủi: Em bé");
            CauHoi hoi = items.get(position);
            
            txtNgayGui.setText(hoi.getNgayGui());
            txtCauHoi.setText(hoi.getCauHoi());
            txtNguoiHoi.setText(hoi.getTenBenhNhan());            
            
        }
		
		return convertView;
	}
}
